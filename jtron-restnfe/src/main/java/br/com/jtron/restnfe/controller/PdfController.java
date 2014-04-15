package br.com.jtron.restnfe.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextOutputDevice;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.ITextUserAgent;
import org.xhtmlrenderer.resource.XMLResource;
import org.xml.sax.InputSource;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.jtron.restnfe.dao.NFeDAO;
import br.com.jtron.restnfe.dto.Destinatario;
import br.com.jtron.restnfe.dto.Emitente;
import br.com.jtron.restnfe.dto.Imposto;
import br.com.jtron.restnfe.dto.NFe;
import br.com.jtron.restnfe.dto.Produto;
import br.com.jtron.restnfe.entidade.envio.TNFe;
import br.com.jtron.restnfe.entidade.envio.TNFe.InfNFe.Det;
import br.com.jtron.restnfe.util.XmlUtil;

import com.lowagie.text.DocumentException;

@Resource
public class PdfController {

	private final Result result;
	private final HttpServletResponse response;
	
	public PdfController(Result result,HttpServletResponse response) {
		this.result = result;
		this.response = response;
	}
	
	@Path("/htmlPDF")
	public void htmlPDF(){
		
	}
	
	
	@Path("/nfe/pdf/{chave}")
	public void pdf(String chave){
		
		try {
						 
        	OutputStream out = response.getOutputStream();        	
        	        	
        	//String contexto = PropertiesHelper.getInstance().getKey("contexto");
        	String contexto = "http://localhost:8080/jtron-restnfe";
        	
        	String url = contexto+"/nfe/online/"+chave;        	
        	
	        if (url.indexOf("://") == -1) {
	            // maybe it's a file
	            File f = new File(url);
	            if (f.exists()) {
	                url = f.toURI().toURL().toString();
	            }
	        }	        			        

            ITextRenderer renderer = new ITextRenderer();
            ResourceLoaderUserAgent callback = new ResourceLoaderUserAgent(renderer.getOutputDevice());
            callback.setSharedContext(renderer.getSharedContext());
            renderer.getSharedContext ().setUserAgentCallback(callback);

            //InputStream is = new InputSource(url).getByteStream();            
            //Tidy tidy = new Tidy();
            //tidy.parseDOM(is, null);
                                     
            Document doc = XMLResource.load(new InputSource(url)).getDocument();

            renderer.setDocument(doc, url);
            renderer.layout();
            renderer.createPDF(out);
            
        } catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		
	}
	
	
	private static class ResourceLoaderUserAgent extends ITextUserAgent
    {
        public ResourceLoaderUserAgent(ITextOutputDevice outputDevice) {
            super(outputDevice);
        }

        protected InputStream resolveAndOpenStream(String uri) {
            InputStream is = super.resolveAndOpenStream(uri);
            System.out.println("IN resolveAndOpenStream() " + uri);
            return is;
        }
    }
	
	
	/**
	 * 
	 * NFe web online em HTML
	 * 
	 * @GET
	 * @param chave
	 */
	@Path("/nfe/online/{chave}")
	public void online(String chave){	
		
		NFeDAO nFeDAO = new NFeDAO();
		
		try {
			TNFe tNfe = XmlUtil.lerDownload(nFeDAO.obterXmlPorChave(chave));
			
			NFe nfe = new NFe();			
			nfe.setChave(tNfe.getInfNFe().getId());
			nfe.setSerie(tNfe.getInfNFe().getIde().getSerie());
			nfe.setNumeracao(tNfe.getInfNFe().getIde().getNNF());
			nfe.setDataEmissao(tNfe.getInfNFe().getIde().getDEmi());
			nfe.setNatureza(tNfe.getInfNFe().getIde().getNatOp());
			
			Destinatario destinatario = new Destinatario();
			destinatario.setCnpj(tNfe.getInfNFe().getDest().getCNPJ());
			destinatario.setCpf(tNfe.getInfNFe().getDest().getCPF());
			destinatario.setBairro(tNfe.getInfNFe().getDest().getEnderDest().getXBairro());
			destinatario.setCidade(tNfe.getInfNFe().getDest().getEnderDest().getXMun()) ;
			destinatario.setCep(tNfe.getInfNFe().getDest().getEnderDest().getCEP());
			destinatario.setEndereco(tNfe.getInfNFe().getDest().getEnderDest().getXLgr() +" "+tNfe.getInfNFe().getDest().getEnderDest().getNro());
			destinatario.setEstado(tNfe.getInfNFe().getDest().getEnderDest().getUF().value());
			destinatario.setNome(tNfe.getInfNFe().getDest().xNome);
			destinatario.setInscricao(tNfe.getInfNFe().getDest().getIE());
			nfe.setDestinatario(destinatario);
			
			Emitente emitente = new Emitente();
			emitente.setCnpj(tNfe.getInfNFe().getEmit().getCNPJ());
			emitente.setCpf(tNfe.getInfNFe().getEmit().getCPF());
			emitente.setBairro(tNfe.getInfNFe().getEmit().getEnderEmit().getXBairro());
			emitente.setCidade(tNfe.getInfNFe().getEmit().getEnderEmit().getXMun()) ;
			emitente.setCep(tNfe.getInfNFe().getEmit().getEnderEmit().getCEP());
			emitente.setEndereco(tNfe.getInfNFe().getEmit().getEnderEmit().getXLgr() +" "+tNfe.getInfNFe().getDest().getEnderDest().getNro());
			emitente.setEstado(tNfe.getInfNFe().getEmit().getEnderEmit().getUF().value());
			emitente.setNome(tNfe.getInfNFe().getEmit().xNome);
			emitente.setInscricao(tNfe.getInfNFe().getEmit().getIE());
			
			Imposto imposto = new Imposto();
			imposto.setBaseICMS(tNfe.getInfNFe().getTotal().getICMSTot().getVBC());
			imposto.setBaseST(tNfe.getInfNFe().getTotal().getICMSTot().getVBCST());
			imposto.setDesconto(tNfe.getInfNFe().getTotal().getICMSTot().getVDesc());
			imposto.setFrete(tNfe.getInfNFe().getTotal().getICMSTot().getVFrete());
			imposto.setIpi(tNfe.getInfNFe().getTotal().getICMSTot().getVIPI());
			imposto.setOutros(tNfe.getInfNFe().getTotal().getICMSTot().getVOutro());
			imposto.setSeguro(tNfe.getInfNFe().getTotal().getICMSTot().getVSeg());
			imposto.setSubICMS(tNfe.getInfNFe().getTotal().getICMSTot().getVST());
			imposto.setValorICMS(tNfe.getInfNFe().getTotal().getICMSTot().getVICMS());
			imposto.setValorProdutos(tNfe.getInfNFe().getTotal().getICMSTot().getVProd());
			imposto.setValorTotal(tNfe.getInfNFe().getTotal().getICMSTot().getVNF());
			nfe.setImposto(imposto);		
			
			nfe.setEmitente(emitente);			
			
								
			List<Produto> prods = new ArrayList<Produto>();
			 for(Det det : tNfe.getInfNFe().getDet()){					
				Produto prod = new Produto();
				prod.setDescricao(det.getProd().getXProd());
				prod.setCodigo(det.getProd().getCProd());
				prod.setQuantiade(Integer.valueOf(det.getProd().getQCom().replace(".0000", "")));
				
				prod.setCfop(det.getProd().getCFOP());
				
				prod.setNcm(det.getProd().getNCM());
				prod.setQuant(det.getProd().getQTrib());
				prod.setTotal(det.getProd().getVProd());
				prod.setUn(det.getProd().getUCom());
				prod.setVlrUnit(det.getProd().getVUnCom());
				
				prods.add(prod);				
			}				
			 nfe.setProdutos(prods);
			 						
			 result.include("nfe",nfe);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}		
	
}

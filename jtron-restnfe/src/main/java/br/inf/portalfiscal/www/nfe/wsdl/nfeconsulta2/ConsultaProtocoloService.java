package br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axis2.AxisFault;

import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.NfeConsulta2Stub.NfeCabecMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.NfeConsulta2Stub.NfeCabecMsgE;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.NfeConsulta2Stub.NfeConsultaNF2Result;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.NfeConsulta2Stub.NfeDadosMsg;


public class ConsultaProtocoloService {
	
   public static String consultaProtocolo(String chave, String ambiente, String url) {  
         
   try{ 	   	    	    	   
                    
       
            //"https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx"
	    NfeConsulta2Stub stub = new NfeConsulta2Stub(url);  
	    NfeCabecMsgE av = new NfeConsulta2Stub.NfeCabecMsgE();
        
	    StringBuilder xml = new StringBuilder();  
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")  
            .append("<consSitNFe versao=\"2.01\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")  
            .append("<tpAmb>").append(ambiente).append("</tpAmb>")  
            .append("<xServ>CONSULTAR</xServ>")  
            .append("<chNFe>")  
            .append(chave)  
            .append("</chNFe>")  
            .append("</consSitNFe>");     

        OMElement ome = AXIOMUtil.stringToOM(xml.toString().replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", ""));
        NfeDadosMsg dadosMsg = new NfeConsulta2Stub.NfeDadosMsg();
        dadosMsg.setExtraElement(ome);
        
        NfeCabecMsgE nfeCabecMsgE = new NfeConsulta2Stub.NfeCabecMsgE();        
        NfeCabecMsg nfeCabecMsg = new NfeConsulta2Stub.NfeCabecMsg();        
        nfeCabecMsg.setCUF(chave.substring(0,2));
        nfeCabecMsg.setVersaoDados("2.01");                
        nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
                
        av.setNfeCabecMsg(nfeCabecMsg);           
        
        NfeConsultaNF2Result result = stub.nfeConsultaNF2(dadosMsg, nfeCabecMsgE);        
                       
	    return result.getExtraElement().toString();
	    
      
       } catch (AxisFault e) {  
           e.printStackTrace();  
       } catch (RemoteException e) {  
           e.printStackTrace();  
      } catch (XMLStreamException e) {	
    	  e.printStackTrace();
      }  
   
   	  return null;
      
    }  
	

}

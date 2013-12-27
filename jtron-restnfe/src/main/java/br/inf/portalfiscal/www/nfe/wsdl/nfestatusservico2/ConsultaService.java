package br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;

public class ConsultaService {
	
   public static String consulta(String chave, String ambiente,String url) throws Exception {  
         
            String estado = chave.substring(0, 2);
            
            NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url);
       	    
            NfeStatusServico2Stub.NfeCabecMsgE av 
                    = new NfeStatusServico2Stub.NfeCabecMsgE();	               
            NfeStatusServico2Stub.NfeCabecMsg cabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();            
            cabecMsg.setCUF(estado);
            cabecMsg.setVersaoDados("2.00");
            av.setNfeCabecMsg(cabecMsg);
        
	    StringBuilder xml = new StringBuilder();  
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")  
            .append("<consStatServ versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"  )  
            .append("<tpAmb>").append(ambiente).append("</tpAmb>")  
            .append("<cUF>").append(estado).append("</cUF>")  
            .append("<xServ>STATUS</xServ>")              
            .append("</consStatServ>");                           

            OMElement ome = 
                    AXIOMUtil.stringToOM(xml.toString().
                    replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", ""));
                                
            NfeStatusServico2Stub.NfeDadosMsg dadosMsg 
                    = new NfeStatusServico2Stub.NfeDadosMsg();            
            
            dadosMsg.setExtraElement(ome);
            
            return stub.nfeStatusServicoNF2(dadosMsg, av).getExtraElement().toString();                               
      
    }  
   
   

}

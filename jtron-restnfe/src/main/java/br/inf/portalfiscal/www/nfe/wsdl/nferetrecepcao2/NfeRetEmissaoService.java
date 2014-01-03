package br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axis2.AxisFault;

public class NfeRetEmissaoService {

	
	public String obterRetornoEmissao(String protocolo,String url,String ambiente,String codEstado){
		
				
		try {
			NfeRetRecepcao2Stub stub = new NfeRetRecepcao2Stub(url);
					
			NfeRetRecepcao2Stub.NfeDadosMsg nfeDadosMsg = new NfeRetRecepcao2Stub.NfeDadosMsg();
			
			 StringBuilder xml = new StringBuilder();  
			 
			 xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")  
             .append("<consReciNFe versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")  
             .append("<tpAmb>"+ambiente+"</tpAmb>")  
             .append("<nRec>")  
             .append(protocolo)  
             .append("</nRec>")  
             .append("</consReciNFe>");              
			 OMElement ome = AXIOMUtil.stringToOM(xml.toString()); 
			 nfeDadosMsg.setExtraElement(ome);
						
			 NfeRetRecepcao2Stub.NfeCabecMsg cabecMsg = new NfeRetRecepcao2Stub.NfeCabecMsg();
			 cabecMsg.setCUF(codEstado);
			 cabecMsg.setVersaoDados("2.00");  
			 
			NfeRetRecepcao2Stub.NfeCabecMsgE cabecMsgE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
			
			cabecMsgE.setNfeCabecMsg(cabecMsg);
						
			return stub.nfeRetRecepcao2(nfeDadosMsg, cabecMsgE).getExtraElement().toString();    			
									
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

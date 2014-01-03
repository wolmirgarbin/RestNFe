package br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2;

import java.rmi.RemoteException;
import java.util.Iterator;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axis2.AxisFault;

public class NFeEmissaoService {
	
	
	public String emissao(String xml,String uf,String url){
						
		try {
			
			NfeRecepcao2Stub stub = new NfeRecepcao2Stub(url);
				        
	        OMElement ome = AXIOMUtil.stringToOM(xml.toString().replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" ", ""));  	        	        	        
	        Iterator<?> children = ome.getChildrenWithLocalName("NFe");    
	        while (children.hasNext()) {  
	            OMElement omElement = (OMElement) children.next();    
	            if ((omElement != null) && ("NFe".equals(omElement.getLocalName()))) {    
	                omElement.addAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe", null);    
	            }  
	        }
	        NfeRecepcao2Stub.NfeDadosMsg nfeDadosMsg = new NfeRecepcao2Stub.NfeDadosMsg();			
			nfeDadosMsg.setExtraElement(ome);	        
			
			NfeRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new NfeRecepcao2Stub.NfeCabecMsg();
			nfeCabecMsg.setCUF(uf);
			nfeCabecMsg.setVersaoDados("2.00");			
			NfeRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeRecepcao2Stub.NfeCabecMsgE();
			nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);
			
						
			NfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(nfeDadosMsg, nfeCabecMsgE);						
			
			return result.localExtraElement.toString();
			
			
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

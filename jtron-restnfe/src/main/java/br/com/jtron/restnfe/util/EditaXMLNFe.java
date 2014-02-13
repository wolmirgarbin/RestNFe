package br.com.jtron.restnfe.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class EditaXMLNFe {
	
	
	public static String alteraXML(String xml,String chave,String dv,String nf,String numeroNota,String ambiente,String numeroSerie) {
		 
		   String finalstring = null;
		
		   try {
			//String filepath = "C:\\NFE-Instaquadros3.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new InputSource(new StringReader(xml.replaceAll("\"", "'"))));//docBuilder.parse(filepath);
	 
	 
			Node infNFe = doc.getElementsByTagName("infNFe").item(0);	 	
			NamedNodeMap attr = infNFe.getAttributes();
			Node nodeAttr = attr.getNamedItem("Id");
			nodeAttr.setTextContent(chave);
			
			Node cDV = doc.getElementsByTagName("cDV").item(0);
			cDV.setTextContent(dv);
			
			Node cNF = doc.getElementsByTagName("cNF").item(0);
			cNF.setTextContent(nf);
			
			Node nNF = doc.getElementsByTagName("nNF").item(0);
			nNF.setTextContent(numeroNota);
			
			Node serie = doc.getElementsByTagName("serie").item(0);
			serie.setTextContent(numeroSerie);
			
			
			
			/**
			 * validar o tipo de ambiente para emissao da nota 1= producao 2= homologacao	
			 */
			if("2".equals(ambiente)){
				
			Node tpAmb = doc.getElementsByTagName("tpAmb").item(0);
			tpAmb.setTextContent(String.valueOf("2"));	
				
			NodeList list = infNFe.getChildNodes();					
				for (int i = 0; i < list.getLength(); i++) {				 
	               Node node = list.item(i);       
	               if("dest".equals(node.getNodeName())){
	            	   NodeList list2 = node.getChildNodes(); 
	            	   for (int i2 = 0 ; i2<  list2.getLength(); i2++){
	            		   
	            		   Node node2 = list2.item(i2);
	            		   if("xNome".equals(node2.getNodeName())){
	            			   node2.setTextContent("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
	            		   }
	            		   
	            	   }
	               }
				}          		  
			}else{
				
				Node tpAmb = doc.getElementsByTagName("tpAmb").item(0);
				tpAmb.setTextContent(String.valueOf("1"));
				
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
	        StringWriter writer = new StringWriter();
	        StreamResult result = new StreamResult(writer);
	        
	        transformer.transform(source, result);
	        
	        StringBuffer sb = writer.getBuffer(); 
	        finalstring = sb.toString();
	 
	        System.out.println(finalstring);
			System.out.println("Done");
						
	 
		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
		   
		   return finalstring;
		   
		}
	

}

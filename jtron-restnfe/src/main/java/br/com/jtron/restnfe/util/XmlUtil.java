package br.com.jtron.restnfe.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import br.com.jtron.restnfe.entidade.envio.TNFe;

public class XmlUtil {
	
	
	/**
	 * 
	 * LAYOUT : yyyy-MM-dd'T'hh:mm:ss-hh:mm
	 * 
     * Retorna a Data atual formatada para XML 
     * @return String
     */
    public static String getLocalDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss-hh:mm");															
		return String.valueOf(dateFormat.format(new Date()));		
	}
    
    /**
	 * 
	 * LAYOUT : yyyy-MM-dd'T'hh:mm:00-02:00
	 *  
	 * 
     * Retorna a Data atual formatada para XML 
     * @return String
     */
    public static String getLocalDateLimit(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:00-02:00");
                Calendar cal = Calendar.getInstance();
                //cal.add(Calendar.MINUTE, -10);
		return String.valueOf(dateFormat.format(cal.getTime()));		
	}
    
    
    public static String getAAMM(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
		return String.valueOf(dateFormat.format(new Date()));		
	}
    
    public static String getAAAAMMDD(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return String.valueOf(dateFormat.format(new Date()));		
	}
    
    public static String getHHMMSS(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM:ss");
		return String.valueOf(dateFormat.format(new Date()));		
	}    
        
    public static String prettyFormat(String input, int indent) {
	    try {
	        Source xmlInput = new StreamSource(new StringReader(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", indent);
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e); // simple exception handling, please review it
	    }
    }
        
    public static String prettyFormat(String input) {
	    try {
	        Source xmlInput = new StreamSource(new StringReader(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e); // simple exception handling, please review it
	    }
    }
    
    public static String lerPotocoloEnvioLoto(String xml){		
		final Pattern pattern = Pattern.compile("<nRec>(.+?)</nRec>");
		final Matcher matcher = pattern.matcher(xml);
		matcher.find();
		return matcher.group(1);										
	}
    
    public static String lerCDV(String xml){		
		final Pattern pattern = Pattern.compile("<ncDV>(.+?)</cDV>");
		final Matcher matcher = pattern.matcher(xml);
		matcher.find();
		return matcher.group(1);										
	}        
    
    
    public static TNFe lerDownload(String xml) throws Exception {  		
        TNFe nfe = null;		       	        	       
            if(xml!=null){                
                JAXBContext context;
                Unmarshaller unmarshaller;                       
                Matcher m = Pattern.compile("(?s)(?=<NFe).*?>.*?(?<=</NFe>)").matcher(xml);
                while(m.find()){            	                
                    String strNFe = m.group(0);            	            	
                    strNFe = strNFe.replace("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");            	            	
                    context = JAXBContext.newInstance(TNFe.class);    
                    unmarshaller = context.createUnmarshaller();                            
                    nfe = (TNFe) unmarshaller.unmarshal(new StringReader(strNFe));                            
                }         
            }            
        return nfe;
    }  
	
		
	public static Integer lerStatusProcessamento(String xml){
				
		if(xml.indexOf("<protNFe versao=\"2.00\">")>=1){
			xml = xml.substring(xml.indexOf("<protNFe versao=\"2.00\">"));
		}						
		final Pattern pattern = Pattern.compile("<cStat>(.+?)</cStat>");
		final Matcher matcher = pattern.matcher(xml);
		matcher.find();
		return Integer.valueOf(matcher.group(1));						  
	}
                  

}

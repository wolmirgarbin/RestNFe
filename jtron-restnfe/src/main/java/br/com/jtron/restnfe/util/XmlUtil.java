package br.com.jtron.restnfe.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.transform.OutputKeys;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

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
           
    public static void main(String args[]){
    	
    	//String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><idLote>33</idLote><NFe><infNFe Id=\"NFe33120909028690000161550010000000030499167714\" versao=\"2.00\"><ide><cUF>33</cUF><cNF>89424836</cNF><natOp>5405-VENDA PROD/SERV  D.ESTADO</natOp><indPag>1</indPag><mod>55</mod><serie>1</serie><nNF>3</nNF><dEmi>2012-09-03</dEmi><dSaiEnt>2012-09-03</dSaiEnt><tpNF>1</tpNF><cMunFG>3304557</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><procEmi>0</procEmi><verProc>1</verProc></ide><emit><CNPJ>99999999999999</CNPJ><xNome>AAAAAAA AAAAAAAAA A AAAAAAAA LTDA ME.</xNome><xFant>AAAAAAA AAAAAAAAA A AAAAAAAA LTDA ME.</xFant><enderEmit><xLgr>RUA AAAAAA AAAAAAA</xLgr><nro>99</nro><xBairro>AAAAAAAAA</xBairro><cMun>3304557</cMun><xMun>Rio de Janeiro</xMun><UF>RJ</UF><CEP>20020080</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>9999999999</fone></enderEmit><IE>999999999</IE><CRT>1</CRT></emit><dest><CNPJ>99999999999999</CNPJ><xNome>AAAAAAAA AAAAAA A AAAAAAA LTDA</xNome><enderDest><xLgr>RUA AAA AAAAA - AAAAAA 99</xLgr><nro>999</nro><xBairro>AAAAAA AAA AAAAAAA</xBairro><cMun>3550308</cMun><xMun>SÃ£o Paulo</xMun><UF>SP</UF><CEP>12345678</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>999999999</fone></enderDest><IE>999999999</IE></dest><det nItem="1"><prod><cProd>201</cProd><cEAN/><xProd>AAAAAAA AA AAAAA AA AAAAAAAA AA AAAAA</xProd><NCM>99</NCM><CFOP>5933</CFOP><uCom>Un</uCom><qCom>1.0000</qCom><vUnCom>10.0000</vUnCom><vProd>10.00</vProd><cEANTrib/><uTrib>Un</uTrib><qTrib>1.0000</qTrib><vUnTrib>10.0000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMSSN102><orig>0</orig><CSOSN>400</CSOSN></ICMSSN102></ICMS><PIS><PISNT><CST>07</CST></PISNT></PIS><COFINS><COFINSNT><CST>07</CST></COFINSNT></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vBCST>0.00</vBCST><vST>0.00</vST><vProd>10.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>10.00</vNF></ICMSTot></total><transp><modFrete>1</modFrete></transp><infAdic><infCpl>Docto emitido por ME ou EPP optante pelo Simples Nacional Nao gera direito a Credito Fiscal de ICMS e de ISS. SEM VALOR FISCAL</infCpl></infAdic></infNFe><Signature xmlns="http://www.w3.org/2000/09/xmldsig#"><SignedInfo><CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/><SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/><Reference URI="#NFe33120909028690000161550010000000030499167714"><Transforms><Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/><Transform Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/></Transforms><DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1"/><DigestValue>vgMpTQDJPJSbQ3zRtVNQ2tjFKQY=</DigestValue></Reference></SignedInfo><SignatureValue>BwkFni0kzsdcRQya95OB/ecpGRS2Q+YbuTufSK6bF2q4EO89TfjCS3c2kZ0mld/njg/s4KIf8eN4pJWI0DQgs0mnm7cI6borAgij/U0pNxr21xy29r5TFU0Ci98wcCoCoda1u7WF4R8VtDiwgrPgn3t4O1ATZxKItkLQr+S1aTfgct6fPsoZk2JT7M43CxmqpUwbDJNQiL2ASqAn9samU4GVaDwSreeVr99mesyiMnJQgcSgeTB1CVqfl9Ri4rN5m7bxeC2d9Das4aX7mj8sGyKWIUZyTJJhQhdrSI7Hw5IJVxnrAy4cGpuz858RF21Uvzryfdgk/WhL13sYhn26Xw==</SignatureValue><KeyInfo><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe><retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>SVRS20100210155347</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>33</cUF><dhRecbto>2012-09-03T14:48:43</dhRecbto><infRec><nRec>333000017949289</nRec><tMed>1</tMed></infRec></retEnviNFe>";
    	
    	//System.out.print(prettyFormat(xml, 0));
    	
    	
    }
        

}

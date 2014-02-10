package br.com.jtron.restnfe.cert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
  

/**
 * 
 * @author jose.pereira
 * 
 * TODO REFATORAR
 *
 */
public class AssinadorA1 {  
		
    private static final String NFE = "NFe";  
    //private static final String MFE = "evento";    
  
    private PrivateKey privateKey;  
    private KeyInfo keyInfo;  
  
    public static String assinar(String xmlEnviNFe,String certificado,String senha) {
    	
    	String xmlEnviNFeAssinado = null;
    	
        try {  
            String caminhoDoCertificadoDoCliente = certificado;  
            String senhaDoCertificadoDoCliente = senha;  
            AssinadorA1 assinarXMLsCertfificadoA1 = new AssinadorA1();  
  
            /** 
             * Assinando o XML de Lote da NF-e 
             * fileEnviNFe = Caminho do Arquivo XML (EnviNFe) gerado; 
             */    
            xmlEnviNFeAssinado = assinarXMLsCertfificadoA1.assinaEnviNFe(  
                    xmlEnviNFe, caminhoDoCertificadoDoCliente, senhaDoCertificadoDoCliente);
            
                      
            info("XML EnviNFe Assinado: " + xmlEnviNFeAssinado);  
 
  
        } catch (Exception e) {  
            error("| " + e.toString());  
        }  
        
        return xmlEnviNFeAssinado;
    }
    
    
    
    
/* public static String assinarMDe(String xmlEnviNFe) {
    	
    	String xmlEnviNFeAssinado = null;
    	
        try {  
            String caminhoDoCertificadoDoCliente = "C:/Apps/a1/certificado_000001003541493.pfx";  
            String senhaDoCertificadoDoCliente = "gkosistlog2012a1";  
            AssinadorA1 assinarXMLsCertfificadoA1 = new AssinadorA1();  
  
            *//** 
             * Assinando o XML de Lote da NF-e 
             * fileEnviNFe = Caminho do Arquivo XML (EnviNFe) gerado; 
             *//*    
            xmlEnviNFeAssinado = assinarXMLsCertfificadoA1.assinaEnvi (  
                    xmlEnviNFe, caminhoDoCertificadoDoCliente, senhaDoCertificadoDoCliente);
            
                      
            info("XML EnviNFe Assinado: " + xmlEnviNFeAssinado);  
 
  
        } catch (Exception e) {  
            error("| " + e.toString());  
        }  
        
        return xmlEnviNFeAssinado;
    }  */
    
    
  
    public String assinaEnviNFe(String xml, String certificado, String senha)  
            throws Exception {  
        Document document = documentFactory(xml);  
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");  
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);  
        loadCertificates(certificado, senha, signatureFactory);  
  
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName(NFE).getLength(); i++) {  
            assinarNFe(signatureFactory, transformList, privateKey, keyInfo, document, i);  
        }  
  
        return outputXML(document);  
    }
    
    
   /* public String assinaEnviMDe(String xml, String certificado, String senha)  
            throws Exception {  
        Document document = documentFactory(xml);  
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");  
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);  
        loadCertificates(certificado, senha, signatureFactory);  
        
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName(MFE).getLength(); i++) {  
            assinarMDe(signatureFactory, transformList, privateKey, keyInfo, document, i);  
        }  
  
        return outputXML(document);  
    }  */
        
    private void assinarNFe(XMLSignatureFactory fac,  
            ArrayList<Transform> transformList, PrivateKey privateKey,  
            KeyInfo ki, Document document, int indexNFe) throws Exception {  
  
        NodeList elements = document.getElementsByTagName("infNFe");  
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);  
        String id = el.getAttribute("Id");  
        el.setIdAttribute("Id", true); 
  
        Reference ref = fac.newReference("#" + id,  
                fac.newDigestMethod(DigestMethod.SHA1, null), transformList,  
                null, null);  
  
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(  
                CanonicalizationMethod.INCLUSIVE,  
                (C14NMethodParameterSpec) null), fac  
                .newSignatureMethod(SignatureMethod.RSA_SHA1, null),  
                Collections.singletonList(ref));  
  
        XMLSignature signature = fac.newXMLSignature(si, ki);  
  
        DOMSignContext dsc = new DOMSignContext(privateKey,   
                document.getDocumentElement().getElementsByTagName(NFE).item(indexNFe));  
        signature.sign(dsc);  
    }
    
    
   /* private void assinarMDe(XMLSignatureFactory fac,  
            ArrayList<Transform> transformList, PrivateKey privateKey,  
            KeyInfo ki, Document document, int indexNFe) throws Exception {  
  
        NodeList elements = document.getElementsByTagName("infEvento");
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);
        //org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);  
        String id = el.getAttribute("Id");  
        el.setIdAttribute("Id", true);
  
        Reference ref = fac.newReference("#" + id,  
                fac.newDigestMethod(DigestMethod.SHA1, null), transformList,  
                null, null);  
  
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(  
                CanonicalizationMethod.INCLUSIVE,  
                (C14NMethodParameterSpec) null), fac  
                .newSignatureMethod(SignatureMethod.RSA_SHA1, null),  
                Collections.singletonList(ref));  
  
        XMLSignature signature = fac.newXMLSignature(si, ki);  
  
        DOMSignContext dsc = new DOMSignContext(privateKey,   
                document.getDocumentElement().getElementsByTagName().item(indexNFe));  
        signature.sign(dsc);  
    }*/
    
    
    
    private ArrayList<Transform> signatureFactory(  
            XMLSignatureFactory signatureFactory)  
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {  
        ArrayList<Transform> transformList = new ArrayList<Transform>();  
        TransformParameterSpec tps = null;  
        Transform envelopedTransform = signatureFactory.newTransform(  
                Transform.ENVELOPED, tps);  
        Transform c14NTransform = signatureFactory.newTransform(  
                "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);  
  
        transformList.add(envelopedTransform);  
        transformList.add(c14NTransform);  
        return transformList;  
    }  
  
    private Document documentFactory(String xml) throws SAXException,  
            IOException, ParserConfigurationException {  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        factory.setNamespaceAware(true);  
        Document document = factory.newDocumentBuilder().parse(  
                new ByteArrayInputStream(xml.getBytes()));  
        return document;  
    }  
  
    /*private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
          out.write(buffer, 0, read);
        }
    }*/   
    
    private void loadCertificates(String certificado, String senha,  
            XMLSignatureFactory signatureFactory) throws Exception {  
              
    	/*URL url2 = new URL("http://confirmafacil.com.br/certificado_000001003541493.pfx");            
        File tmpChave = File.createTempFile("certificado", ".pfx");
        copyFile(url2.openStream(), new FileOutputStream(tmpChave));*/  
        
    	InputStream entrada = new FileInputStream(certificado);          
        
        KeyStore ks = KeyStore.getInstance("pkcs12");  
        try {  
            ks.load(entrada, senha.toCharArray());  
        } catch (IOException e) {  
            throw new Exception("Senha do Certificado Digital incorreta ou Certificado inválido.");  
        }  
  
        KeyStore.PrivateKeyEntry pkEntry = null;  
        Enumeration<String> aliasesEnum = ks.aliases();  
        while (aliasesEnum.hasMoreElements()) {  
            String alias = (String) aliasesEnum.nextElement();  
            if (ks.isKeyEntry(alias)) {  
                pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias,  
                        new KeyStore.PasswordProtection(senha.toCharArray()));  
                privateKey = pkEntry.getPrivateKey();  
                break;  
            }  
        }  
  
        X509Certificate cert = (X509Certificate) pkEntry.getCertificate();  
        info("SubjectDN: " + cert.getSubjectDN().toString());  
  
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();  
        List<X509Certificate> x509Content = new ArrayList<X509Certificate>();  
  
        x509Content.add(cert);  
        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);  
        keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));  
    }  
  
    private String outputXML(Document doc) throws TransformerException {  
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        TransformerFactory tf = TransformerFactory.newInstance();  
        Transformer trans = tf.newTransformer();  
        trans.transform(new DOMSource(doc), new StreamResult(os));  
        String xml = os.toString();  
        if ((xml != null) && (!"".equals(xml))) {  
            xml = xml.replaceAll("\\r\\n", "");  
            xml = xml.replaceAll(" standalone=\"no\"", "");  
        }  
        return xml;  
    }  
  
    
    /** 
     * Log ERROR. 
     *  
     * @param error 
     */  
    private static void error(String error) {  
        System.out.println("| ERROR: " + error);  
    }  
  
    /** 
     * Log INFO. 
     *  
     * @param info 
     */  
    private static void info(String info) {  
        System.out.println("| INFO: " + info);  
    }  
  
}    
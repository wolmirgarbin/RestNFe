/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jtron.restnfe.cert;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.apache.commons.httpclient.protocol.Protocol;

import br.com.jtron.restnfe.util.PropertiesHelper;

/**
 * @author jose.pereira
 */
public class AutenticadorCert {
        
    /**
     * @param caminho
     * @param senha 
     */
    /*public static void preparaAmbienteLocal(String alias,String cacertURL) {  
        try {
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");                       
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");    
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());    
            System.setProperty("javax.net.ssl.keyStoreProvider", "SunMSCAPI");    
            System.setProperty("javax.net.ssl.keyStoreType", "Windows-MY");   
            System.setProperty("javax.net.ssl.keyStoreAlias", alias);
            System.setProperty("javax.net.ssl.keyStorePassword", "");                            
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");              
            URL url = new URL(cacertURL);            
            File tempFile = File.createTempFile("pre", "suf");         
            copyFile(url.openStream(), new FileOutputStream(tempFile)); 
            System.setProperty("javax.net.ssl.trustStore", tempFile.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(AutenticadorCert.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }*/     
	
	
	public void preparaAmbiente(InputStream entrada,char[] senha){
		
		try {
			       
	        KeyStore ks = KeyStore.getInstance("pkcs12");		
	        ks.load(entrada, senha);
	        String alias = "";	        
	        Enumeration<String> aliasesEnum = ks.aliases();    
	        while (aliasesEnum.hasMoreElements()) {    
	            alias = (String) aliasesEnum.nextElement();
	            System.out.println(alias);
	            if (ks.isKeyEntry(alias)) break;    
	        }              
	        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);  
	        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, senha);  
	        SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);                          
	                    
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	        ////////////////URL PERMANENTE DA CADEIA DE CARACTERES NECESSARIA NA ASSINATURA SSL COM O SEFAZ ///////////
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////	        
	        String cacert = new File(this.getClass().getClassLoader().getResource("NFeCacerts").getFile()).getAbsolutePath();	        
	        System.setProperty("javax.net.ssl.trustStore", cacert);	        	        
	        socketFactoryDinamico.setFileCacerts(cacert);  
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////	        	        	        
	        
	        Protocol protocol = new Protocol("https", socketFactoryDinamico, 443);    
	        Protocol.registerProtocol("https", protocol);
        
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		}	          
	}
    
    /**
     * 
     * @param in
     * @param out
     * @throws IOException 
     */
    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
          out.write(buffer, 0, read);
        }
    }   
        
}
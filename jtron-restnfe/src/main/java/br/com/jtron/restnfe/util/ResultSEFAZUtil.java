/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jtron.restnfe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jose.pereira
 */
public class ResultSEFAZUtil {
    
    public static String lerMotivo(String xml){		                
        final Pattern pattern = Pattern.compile("<xMotivo>(.+?)</xMotivo>");        
        final Matcher matcher = pattern.matcher(xml);        
        String result = null;
        while(matcher.find()) {
             result = matcher.group(1);
        }                
        return result; 
    }
        
    public static Integer lerStatusServico(String xml){		
		final Pattern pattern = Pattern.compile("<cStat>(.+?)</cStat>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return Integer.valueOf(result);						  
    }
    
    public static String lerCNPJ(String xml){		
		final Pattern pattern = Pattern.compile("<CNPJ>(.+?)</CNPJ>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }
    
    public static String lerXNome(String xml){		
		final Pattern pattern = Pattern.compile("<xNome>(.+?)</xNome>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }    
    
    public static String lerDEmi(String xml){		
		final Pattern pattern = Pattern.compile("<dEmi>(.+?)</dEmi>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }
    
    public static String lerVNF(String xml){		
		final Pattern pattern = Pattern.compile("<vNF>(.+?)</vNF>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }          
    
    public static String lerChNFe(String xml){		
		final Pattern pattern = Pattern.compile("<chNFe>(.+?)</chNFe>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }            
    
    public static String lerUltNSU(String xml){		
		final Pattern pattern = Pattern.compile("<ultNSU>(.+?)</ultNSU>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return result;						  
    }        
    
    public static Integer lerIndCont(String xml){		
		final Pattern pattern = Pattern.compile("<indCont>(.+?)</indCont>");
		final Matcher matcher = pattern.matcher(xml);
		String result = null;
                while(matcher.find()) {
                     result = matcher.group(1);
                }                                
		return Integer.valueOf(result);						  
    }
    
    public static String lerXMLNfeDownload(String xml){				
		try{
                final Matcher matcher = Pattern.compile("(?s)(?=<NFe).*?>.*?(?<=</NFe>)").matcher(xml);
		matcher.find();
		return matcher.group();						  
                }catch(Exception e){
                    return null;
                }
    }
        
}
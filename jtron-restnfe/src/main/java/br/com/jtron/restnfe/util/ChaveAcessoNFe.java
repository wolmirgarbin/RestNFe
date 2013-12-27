package br.com.jtron.restnfe.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ChaveAcessoNFe {

	public String gerarChave(String cUF,String cnpj,String serie,String nNF) {  
        
              
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");        	
            String mod = "55"; // Modelo do Documento Fiscal.                
            String tpEmis = "2"; // Forma de emissão da NF-e                  
              
            StringBuilder chave = new StringBuilder();  
            chave.append(lpadTo(cUF, 2, '0'));  
            chave.append(lpadTo(dateFormat.format(new Date()), 4, '0'));  
            chave.append(lpadTo(cnpj.replaceAll("\\D",""), 14, '0'));  
            chave.append(lpadTo(mod, 2, '0'));  
            chave.append(lpadTo(serie, 3, '0'));  
            chave.append(lpadTo(String.valueOf(nNF), 9, '0'));  
            chave.append(lpadTo(tpEmis, 1, '0'));  
            chave.append(lpadTo(obterCNF(), 8, '0'));  
            chave.append(modulo11(chave.toString()));  
  
            return chave.insert(0, "NFe").toString();     
        
    }  
      
    public static int modulo11(String chave) {  
        int total = 0;  
        int peso = 2;  
              
        for (int i = 0; i < chave.length(); i++) {  
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;  
            peso ++;  
            if (peso == 10)  
                peso = 2;  
        }  
        int resto = total % 11;  
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);  
    }  
  
    public static String lpadTo(String input, int width, char ch) {  
        String strPad = "";  
  
        StringBuffer sb = new StringBuffer(input.trim());  
        while (sb.length() < width)  
            sb.insert(0,ch);  
        strPad = sb.toString();  
          
        if (strPad.length() > width) {  
            strPad = strPad.substring(0,width);  
        }  
        return strPad;  
    }  
    
    /**
	 * Gera um numero randomico para seguranca e formulacao de uma nota fiscal de lote.
	 * @return
	 */
	public static String obterCNF(){		
		Random randomGenerator = new Random();
		StringBuffer randomInt = new StringBuffer();
	    for (int idx = 1; idx <= 10; ++idx){
	    	randomInt.append(randomGenerator.nextInt(100));
	    }	    
	    return randomInt.toString().substring(0,8);		
	}
  
	
}

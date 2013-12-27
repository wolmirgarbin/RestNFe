package br.com.jtron.restnfe.sefaz;

/**
 * @author jose.pereira
 */
public enum URLSefazConsultaDest {
            
        RS("https://nfe.sefaz.rs.gov.br/ws/nfeConsultaDest/nfeConsultaDest.asmx",43),        
        AN("https://www.nfe.fazenda.gov.br/NFeConsultaDest/NFeConsultaDest.asmx",91),        
        RS_HOMOLOGACAO("https://homologacao.nfe.sefaz.rs.gov.br/ws/nfeConsultaDest/nfeConsultaDest.asmx",43),        
        AN_HOMOLOGACAO("https://hom.nfe.fazenda.gov.br/NFeConsultaDest/NFeConsultaDest.asmx",91);                
    
        private String url;	
        private int codigo;

	private URLSefazConsultaDest(String url, int codigo) {
		this.url = url;
                this.codigo = codigo;
	}
	
	public String url(){
		return this.url;
	}
        
        public int codigo(){
		return this.codigo;
	}
        
        public static String getURLPorUF(final Integer uf){            
            switch(uf){                                               
                case 43 :                    
                    return RS.url;                                                                        
                default:
                    return AN.url;  
            }                        
        }
        
        
        
        public static String getURLPorUF(final Integer uf,final Integer ambiente){            
            
            if(ambiente==1){
                    switch(uf){                                                       
                        case 43 :                    
                            return RS.url;
                        default:
                            return AN.url;  
                    }                     
            }else{
                
                    switch(uf){                
                        case 43 :                    
                            return RS_HOMOLOGACAO.url;                           
                        default:
                            return AN_HOMOLOGACAO.url;  
                    }                    
            }
        }                             

	@Override
	public String toString() {
		return this.url;
	}
        
}
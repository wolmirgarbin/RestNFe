package br.com.jtron.restnfe.sefaz;

/**
 * @author jose.pereira
 */
public enum URLSefazDownload {
    
        RS("https://nfe.sefaz.rs.gov.br/ws/nfeDownloadNF/nfeDownloadNF.asmx",43),
        SVAN("https://www.sefazvirtual.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx",0),
        AN("https://www.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx",0),
        RS_HOMOLOGACAO("https://homologacao.nfe.sefaz.rs.gov.br/ws/nfeDownloadNF/nfeDownloadNF.asmx",43),
        SVAN_HOMOLOGACAO("https://hom.sefazvirtual.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx",0),
        AN_HOMOLOGACAO("https://hom.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx",0);
    
        private String url;	
        private int codigo;

	private URLSefazDownload(String url, int codigo) {
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
                case 13 :    
                    return AN.url;
                case 29 :                    
                    return AN.url;
                case 23 :                    
                    return AN.url;
                case 52 :                    
                    return AN.url;
                case 31 :                    
                    return AN.url;
                case 50 :                    
                    return AN.url;    
                case 51 :                    
                    return AN.url;        
                case 26 :                    
                    return AN.url;            
                case 41 :                    
                    return AN.url;                
                case 43 :                    
                    return RS.url;
                case 35 :                    
                    return AN.url;                    
                //Sefaz Virtual Ambiente Nacional - (SVAN)    
                case 32 :                    
                    return SVAN.url;
                case 21 :                    
                    return SVAN.url;
                case 15 :                    
                    return SVAN.url;    
                case 22 :                    
                    return SVAN.url;                                                
                //Sefaz Virtual Rio Grande do Sul - (SVRS)    
                case 12 :                    
                    return AN.url;
                case 27 :                    
                    return AN.url;
                case 16 :                    
                    return AN.url;
                case 53 :                    
                    return AN.url;
                case 25 :                    
                    return AN.url;
                case 33 :                    
                    return AN.url;
                case 24 :                    
                    return AN.url;
                case 11 :                    
                    return AN.url;
                case 14 :                    
                    return AN.url;
                case 42 :                    
                    return AN.url;
                case 28 :                    
                    return AN.url;
                case 17 :                    
                    return AN.url;    
                default:
                    return null;  
            }                        
        }
        
        
        
        public static String getURLPorUF(final Integer uf,final Integer ambiente){            
            
            if(ambiente==1){
                switch(uf){                
                    case 13 :    
                        return AN.url;
                    case 29 :                    
                        return AN.url;
                    case 23 :                    
                        return AN.url;
                    case 52 :                    
                        return AN.url;
                    case 31 :                    
                        return AN.url;
                    case 50 :                    
                        return AN.url;    
                    case 51 :                    
                        return AN.url;        
                    case 26 :                    
                        return AN.url;            
                    case 41 :                    
                        return AN.url;                
                    case 43 :                    
                        return RS.url;
                    case 35 :                    
                        return AN.url;                    
                    //Sefaz Virtual Ambiente Nacional - (SVAN)    
                    case 32 :                    
                        return SVAN.url;
                    case 21 :                    
                        return SVAN.url;
                    case 15 :                    
                        return SVAN.url;    
                    case 22 :                    
                        return SVAN.url;                                                
                    //Sefaz Virtual Rio Grande do Sul - (SVRS)    
                    case 12 :                    
                        return AN.url;
                    case 27 :                    
                        return AN.url;
                    case 16 :                    
                        return AN.url;
                    case 53 :                    
                        return AN.url;
                    case 25 :                    
                        return AN.url;
                    case 33 :                    
                        return AN.url;
                    case 24 :                    
                        return AN.url;
                    case 11 :                    
                        return AN.url;
                    case 14 :                    
                        return AN.url;
                    case 42 :                    
                        return AN.url;
                    case 28 :                    
                        return AN.url;
                    case 17 :                    
                        return AN.url;    
                    default:
                        return null;  
                }                       
            }else{
                
                switch(uf){                
                    case 13 :    
                        return AN_HOMOLOGACAO.url;
                    case 29 :                    
                        return AN_HOMOLOGACAO.url;
                    case 23 :                    
                        return AN_HOMOLOGACAO.url;
                    case 52 :                    
                        return AN_HOMOLOGACAO.url;
                    case 31 :                    
                        return AN_HOMOLOGACAO.url;
                    case 50 :                    
                        return AN_HOMOLOGACAO.url;    
                    case 51 :                    
                        return AN_HOMOLOGACAO.url;        
                    case 26 :                    
                        return AN_HOMOLOGACAO.url;            
                    case 41 :                    
                        return AN_HOMOLOGACAO.url;                
                    case 43 :                    
                        return RS_HOMOLOGACAO.url;
                    case 35 :                    
                        return AN_HOMOLOGACAO.url;                    
                    //Sefaz Virtual Ambiente Nacional - (SVAN)    
                    case 32 :                    
                        return SVAN_HOMOLOGACAO.url;
                    case 21 :                    
                        return SVAN_HOMOLOGACAO.url;
                    case 15 :                    
                        return SVAN_HOMOLOGACAO.url;    
                    case 22 :                    
                        return SVAN_HOMOLOGACAO.url;                                                
                    //Sefaz Virtual Rio Grande do Sul - (SVRS)    
                    case 12 :                    
                        return AN_HOMOLOGACAO.url;
                    case 27 :                    
                        return AN_HOMOLOGACAO.url;
                    case 16 :                    
                        return AN_HOMOLOGACAO.url;
                    case 53 :                    
                        return AN_HOMOLOGACAO.url;
                    case 25 :                    
                        return AN_HOMOLOGACAO.url;
                    case 33 :                    
                        return AN_HOMOLOGACAO.url;
                    case 24 :                    
                        return AN_HOMOLOGACAO.url;
                    case 11 :                    
                        return AN_HOMOLOGACAO.url;
                    case 14 :                    
                        return AN_HOMOLOGACAO.url;
                    case 42 :                    
                        return AN_HOMOLOGACAO.url;
                    case 28 :                    
                        return AN_HOMOLOGACAO.url;
                    case 17 :                    
                        return AN_HOMOLOGACAO.url;    
                    default:
                        return null;  
                } 
                
            }
        }
                
                

	@Override
	public String toString() {
		return this.url;
	}
    
    
}
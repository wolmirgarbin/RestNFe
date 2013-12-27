package br.com.jtron.restnfe.sefaz;

/**
 * @author jose.pereira
 */
public enum URLSefazConsultaSituacao {
    
        AM("https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2",13),
        BA("https://nfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx",29),
        CE("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2",23),
        GO("https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2",52),
        MG("https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2",31),
        MS("https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2",50),
        MT("https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2",51),
        PE("https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2",26),
        PR("https://nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2",41),
        RS("https://nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx",43),
        SP("https://nfe.fazenda.sp.gov.br/nfeweb/services/nfeconsulta2.asmx",35),
        SVAN("https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx",0),
        SVRS("https://nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx",0),
        SCAN("https://www.scan.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx",0),
        AM_HOMOLOGACAO("https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2",13),
        BA_HOMOLOGACAO("https://hnfe.sefaz.ba.gov.br/webservices/nfenw/NfeConsulta2.asmx",29),
        CE_HOMOLOGACAO("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2",23),
        GO_HOMOLOGACAO("https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2",52),
        MG_HOMOLOGACAO("https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2",31),
        MS_HOMOLOGACAO("https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2",50),
        MT_HOMOLOGACAO("https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2",51),
        PE_HOMOLOGACAO("https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2",26),
        PR_HOMOLOGACAO("https://homologacao.nfe2.fazenda.pr.gov.br/nfe/NFeConsulta2",41),
        RS_HOMOLOGACAO("https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx",43),
        SP_HOMOLOGACAO("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeConsulta2.asmx",35),
        SVAN_HOMOLOGACAO("https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx",0),
        SVRS_HOMOLOGACAO("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx",0),
        SCAN_HOMOLOGACAO("https://hom.nfe.fazenda.gov.br/SCAN/NfeConsulta2/NfeConsulta2.asmx",0);        
    
        private String url;	
        private int codigo;

	private URLSefazConsultaSituacao(String url, int codigo) {
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
                    return AM.url;
                case 29 :                    
                    return BA.url;
                case 23 :                    
                    return CE.url;
                case 52 :                    
                    return GO.url;
                case 31 :                    
                    return MG.url;
                case 50 :                    
                    return MS.url;    
                case 51 :                    
                    return MT.url;        
                case 26 :                    
                    return PE.url;            
                case 41 :                    
                    return PR.url;                
                case 43 :                    
                    return RS.url;
                case 35 :                    
                    return SP.url;                    
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
                    return SVRS.url;
                case 27 :                    
                    return SVRS.url;
                case 16 :                    
                    return SVRS.url;
                case 53 :                    
                    return SVRS.url;
                case 25 :                    
                    return SVRS.url;
                case 33 :                    
                    return SVRS.url;
                case 24 :                    
                    return SVRS.url;
                case 11 :                    
                    return SVRS.url;
                case 14 :                    
                    return SVRS.url;
                case 42 :                    
                    return SVRS.url;
                case 28 :                    
                    return SVRS.url;
                case 17 :                    
                    return SVRS.url;    
                default:
                    return null;  
            }                        
        }
        
        
        
        public static String getURLPorUF(final Integer uf,final Integer ambiente){            
            
            if(ambiente==1){
                    switch(uf){                
                        case 13 :    
                            return AM.url;
                        case 29 :                    
                            return BA.url;
                        case 23 :                    
                            return CE.url;
                        case 52 :                    
                            return GO.url;
                        case 31 :                    
                            return MG.url;
                        case 50 :                    
                            return MS.url;    
                        case 51 :                    
                            return MT.url;        
                        case 26 :                    
                            return PE.url;            
                        case 41 :                    
                            return PR.url;                
                        case 43 :                    
                            return RS.url;
                        case 35 :                    
                            return SP.url;                    
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
                            return SVRS.url;
                        case 27 :                    
                            return SVRS.url;
                        case 16 :                    
                            return SVRS.url;
                        case 53 :                    
                            return SVRS.url;
                        case 25 :                    
                            return SVRS.url;
                        case 33 :                    
                            return SVRS.url;
                        case 24 :                    
                            return SVRS.url;
                        case 11 :                    
                            return SVRS.url;
                        case 14 :                    
                            return SVRS.url;
                        case 42 :                    
                            return SVRS.url;
                        case 28 :                    
                            return SVRS.url;
                        case 17 :                    
                            return SVRS.url;    
                        default:
                            return null;  
                    }                
            }else{
                
                switch(uf){                
                        case 13 :    
                            return AM_HOMOLOGACAO.url;
                        case 29 :                    
                            return BA_HOMOLOGACAO.url;
                        case 23 :                    
                            return CE_HOMOLOGACAO.url;
                        case 52 :                    
                            return GO_HOMOLOGACAO.url;
                        case 31 :                    
                            return MG_HOMOLOGACAO.url;
                        case 50 :                    
                            return MS_HOMOLOGACAO.url;    
                        case 51 :                    
                            return MT_HOMOLOGACAO.url;        
                        case 26 :                    
                            return PE_HOMOLOGACAO.url;            
                        case 41 :                    
                            return PR_HOMOLOGACAO.url;                
                        case 43 :                    
                            return RS_HOMOLOGACAO.url;
                        case 35 :                    
                            return SP_HOMOLOGACAO.url;                    
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
                            return SVRS_HOMOLOGACAO.url;
                        case 27 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 16 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 53 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 25 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 33 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 24 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 11 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 14 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 42 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 28 :                    
                            return SVRS_HOMOLOGACAO.url;
                        case 17 :                    
                            return SVRS_HOMOLOGACAO.url;    
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
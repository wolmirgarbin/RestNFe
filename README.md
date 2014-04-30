API REST NFe
=======

URL´s dos serviços :
=======

! CUIDADO ! O parâmetro ambiente pode apontar tanto para produção do SEFAZ quando homologação. Cuidado ao usar este parâmetro.

ambiente( 1 ) = PRODUÇÃO
ambiente( 3 ) = HOMOLOGAÇÃO

```
@Post(params={xml,ambiente})
/nfe/enviar/{chave}
```
Exemplo XML de envio :

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?><enviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><idLote>000000001</idLote><NFe xmlns="http://www.portalfiscal.inf.br/nfe"><infNFe Id="NAO_PREENCHER" versao="2.00"><ide><cUF>33</cUF><cNF>NAO_PREENCHER</cNF><natOp>SAÍDA DE MERCADORIA PARA CONSUMO</natOp><indPag>0</indPag><mod>55</mod><serie>NAO_PREENCHER</serie><nNF>NAO_PREENCHER</nNF><dEmi>NAO_PREENCHER</dEmi><tpNF>1</tpNF><cMunFG>3303302</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>NAO_PREENCHER</cDV><tpAmb>NAO_PREENCHER</tpAmb><finNFe>1</finNFe><procEmi>3</procEmi><verProc>2.2.21</verProc></ide><emit><CNPJ>17715809000100</CNPJ><xNome>MONOGRAME CONFECCAO, COMERCIO E SERVICOS S.A</xNome><xFant>Monograme</xFant><enderEmit><xLgr>RUA PROFESSOR STEPHANE VANNIER</xLgr><nro>99</nro><xBairro>CAMBOINHAS</xBairro><cMun>3303302</cMun><xMun>Niteroi</xMun><UF>RJ</UF><CEP>24358690</CEP><cPais>1058</cPais><xPais>BRASIL</xPais></enderEmit><IE>79881830</IE><CRT>3</CRT></emit><dest><CPF>12378938799</CPF><xNome>Renato Cesar Costa Pinto</xNome><enderDest><xLgr>Rua Cel. Moreira Cesar</xLgr><nro>447</nro><xCpl>apt. 1104</xCpl><xBairro>Icaraí</xBairro><cMun>3303302</cMun><xMun>Niteroi</xMun><UF>RJ</UF><CEP>24230054</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>21988227780</fone></enderDest><IE>ISENTO</IE><email>renato.cesar@hotmail.com</email></dest><det nItem="1"><prod><cProd>1</cProd><cEAN/><xProd>CAMISETA CLASSICA MASCULINA</xProd><NCM>61091000</NCM><CFOP>5556</CFOP><uCom>UN</uCom><qCom>1.0000</qCom><vUnCom>1.0000000000</vUnCom><vProd>1.00</vProd><cEANTrib/><uTrib>UN</uTrib><qTrib>1.0000</qTrib><vUnTrib>1.0000000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMS40><orig>0</orig><CST>40</CST></ICMS40></ICMS><PIS><PISNT><CST>07</CST></PISNT></PIS><COFINS><COFINSNT><CST>07</CST></COFINSNT></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vBCST>0.00</vBCST><vST>0.00</vST><vProd>1.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>1.00</vNF></ICMSTot></total><transp><modFrete>9</modFrete></transp></infNFe></NFe></enviNFe>
```

```
@Get
/nfe/online/{chave}
```

```
@Get
/nfe/pdf/{chave}
```

```
@Post
/nfe/caneclar/{chave}
```


Pagina exemplo do DANFe HTML online :
=======

http://23.253.43.232/nfe/online/33140417715809000100550010000000211286221648

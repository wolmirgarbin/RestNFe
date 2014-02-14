<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<title>Exemplo de Danfe</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="generator" content="pdftohtml 0.39">
<meta name="author" content="þÿ">
<meta name="keywords" content="">
<meta name="date" content="">
<meta name="subject" content="">
</head>
<body bgcolor="#FFFFFF" link="blue" vlink="blue">
<!-- Page 1 -->
<a name="1"></a>
<div style="position:relative;width:892;height:1263;">
<style type="text/css"> 
<!--
	.ft0{font-size:6px;font-family:Times;color:#000000;}
	.ft1{font-size:13px;font-family:Times;color:#000000;}
	.ft2{font-size:10px;font-family:Times;color:#000000;}
	.ft3{font-size:10px;font-family:Times;color:#000000;}
	.ft4{font-size:11px;font-family:Times;color:#000000;}
	.ft5{font-size:6px;font-family:Times;color:#000000;}
	.ft6{font-size:12px;font-family:Times;color:#000000;}
	.ft7{font-size:12px;font-family:Times;color:#000000;}
	.ft8{font-size:11px;font-family:Times;color:#000000;}
	.ft9{font-size:5px;font-family:Times;color:#000000;}
	.ft10{font-size:10px;line-height:14px;font-family:Times;color:#000000;}
	.ft11{font-size:6px;line-height:10px;font-family:Times;color:#000000;}
-->
</style>
<img src="<%=request.getContextPath()%>/img/danfe.png" alt="background image" height="1263" width="892">

<!-- <div style="position:absolute;top:37;left:162"><nobr><span class="ft0"><b>IDENTIFICAÇÃO DO EMITENTE</b></span></nobr></div> -->

<div style="position:absolute;top:39;left:436"><nobr><span class="ft1"><b>DANFE</b></span></nobr></div>
<div style="position:absolute;top:59;left:399"><nobr><span class="ft2">DOCUMENTO AUXILIAR</span></nobr></div>

<!-- Endereco do Emitente -->
<div style="position:absolute;top:149;left:115"><nobr><span class="ft3"><b>${nfe.emitente.endereco}</b></span></nobr></div>
<div style="position:absolute;top:163;left:162"><nobr><span class="ft3"><b>${nfe.emitente.cep} ${nfe.emitente.cidade} - ${nfe.emitente.estado}</b></span></nobr></div>
<!-- <div style="position:absolute;top:178;left:172"><nobr><span class="ft3"><b>Fone 2280-5776</b></span></nobr></div> -->

<div style="position:absolute;top:135;left:556"><nobr><span class="ft4">Consulta de autenticidade no portal nacional da NF-e</span></nobr></div>
<div style="position:absolute;top:232;left:302"><nobr><span class="ft5">INSCRIÇÃO ESTADUAL DO SUBST. TRIBUT.</span></nobr></div>
<div style="position:absolute;top:232;left:36"><nobr><span class="ft5">INSCRIÇÃO ESTADUAL</span></nobr></div>
<div style="position:absolute;top:232;left:595"><nobr><span class="ft5">CNPJ</span></nobr></div>

<!-- CNPJ do emitente -->
<div style="position:absolute;top:247;left:664"><nobr><span class="ft6">${nfe.emitente.cnpj}</span></nobr></div>


<!-- Inscricao Estadual do Emitente -->
<div style="position:absolute;top:247;left:137"><nobr><span class="ft6">  ${nfe.emitente.inscricao}  </span></nobr></div>

<div style="position:absolute;top:100;left:543"><nobr><span class="ft5">CHAVE DE ACESSO</span></nobr></div>
<div style="position:absolute;top:106;left:413"><nobr><span class="ft2">0 - ENTRADA</span></nobr></div>

<!-- Chave da nota fiscal -->
<div style="position:absolute;top:111;left:549"><nobr><span class="ft3"><b> ${fn:replace(nfe.chave,'NFe', '')} </b></span></nobr></div>

<div style="position:absolute;top:116;left:514"><nobr><span class="ft7"><b>1</b></span></nobr></div>
<div style="position:absolute;top:123;left:413"><nobr><span class="ft2">1 - SAÍDA</span></nobr></div>
<div style="position:absolute;top:86;left:430"><nobr><span class="ft2">ELETRÔNICA</span></nobr></div>
<div style="position:absolute;top:72;left:419"><nobr><span class="ft2">DA NOTA FISCAL</span></nobr></div>

<!-- Numero da nota fiscal -->
<div style="position:absolute;top:147;left:422"><nobr><span class="ft8"><b>Nº. <fmt:formatNumber pattern="00000000" value="${nfe.numeracao}" /> </b></span></nobr></div>
<!-- Serie da nota fiscal -->
<div style="position:absolute;top:165;left:442"><nobr><span class="ft8"><b>SÉRIE <fmt:formatNumber pattern="000" value="${nfe.serie}" /></b></span></nobr></div>

<div style="position:absolute;top:176;left:612"><nobr><span class="ft4">ou no site da Sefaz Autorizadora</span></nobr></div>
<div style="position:absolute;top:156;left:616"><nobr><span class="ft4">www.nfe.fazenda.gov.br/portal</span></nobr></div>

<!-- //TODO incluir paginação -->
<div style="position:absolute;top:182;left:433"><nobr><span class="ft8"><b>FOLHA 1/1</b></span></nobr></div>

<div style="position:absolute;top:199;left:36"><nobr><span class="ft5">NATUREZA DA OPERAÇÃO</span></nobr></div>

<div style="position:absolute;top:199;left:543"><nobr><span class="ft5">PROTOCOLO DE AUTORIZAÇÃO DE USO</span></nobr></div>

<!-- Natureza da operacao -->
<div style="position:absolute;top:212;left:35"><nobr><span class="ft6">${nfe.natureza}</span></nobr></div>

<!-- Fazão social -->
<div style="position:absolute;top:128;left:39"><nobr><span class="ft1"><b>${nfe.emitente.nome}</b></span></nobr></div>

<div style="position:absolute;top:266;left:32"><nobr><span class="ft0"><b>DESTINATÁRIO / REMETENTE</b></span></nobr></div>
<div style="position:absolute;top:279;left:36"><nobr><span class="ft5">NOME / RAZÃO SOCIAL</span></nobr></div>
<div style="position:absolute;top:279;left:595"><nobr><span class="ft5">CNPJ / CPF</span></nobr></div>
<div style="position:absolute;top:279;left:749"><nobr><span class="ft5">DATA DA EMISSÃO</span></nobr></div>

<!-- Nome do destinatario -->
<div style="position:absolute;top:289;left:35"><nobr><span class="ft6">${nfe.destinatario.nome}</span></nobr></div>

<!-- CPF do destinatario //TODO CPF ou CNPJ -->
<div style="position:absolute;top:289;left:606"><nobr><span class="ft6">${nfe.destinatario.cpf}</span></nobr></div>

<!-- Data da emissao -->
<div style="position:absolute;top:289;left:768"><nobr><span class="ft6">${nfe.dataEmissao}</span></nobr></div>

<div style="position:absolute;top:304;left:459"><nobr><span class="ft5">BAIRRO / DISTRITO</span></nobr></div>
<div style="position:absolute;top:304;left:36"><nobr><span class="ft5">ENDEREÇO</span></nobr></div>
<div style="position:absolute;top:304;left:672"><nobr><span class="ft5">CEP</span></nobr></div>
<div style="position:absolute;top:304;left:749"><nobr><span class="ft5">DATA DA SAÍDA</span></nobr></div>

<!-- Endereco do destinatario -->
<div style="position:absolute;top:315;left:35"><nobr><span class="ft6">${nfe.destinatario.endereco}</span></nobr></div>
<div style="position:absolute;top:315;left:462"><nobr><span class="ft6">${nfe.destinatario.bairro}</span></nobr></div>
<div style="position:absolute;top:316;left:674"><nobr><span class="ft6">${nfe.destinatario.cep}</span></nobr></div>
<div style="position:absolute;top:339;left:35"><nobr><span class="ft6">${nfe.destinatario.cidade}</span></nobr></div>
<div style="position:absolute;top:339;left:432"><nobr><span class="ft6">${nfe.destinatario.estado}</span></nobr></div>

<!-- Data da saida //TODO -->
<div style="position:absolute;top:330;left:749"><nobr><span class="ft5">HORA DA SAÍDA</span></nobr></div>
<div style="position:absolute;top:315;left:768"><nobr><span class="ft6">25/12/2009</span></nobr></div>

<!-- Inscricao estadual do destinatario -->
<div style="position:absolute;top:339;left:641"><nobr><span class="ft6">${nfe.destinatario.inscricao}</span></nobr></div>

<div style="position:absolute;top:330;left:36"><nobr><span class="ft5">MUNICÍPIO</span></nobr></div>
<div style="position:absolute;top:330;left:429"><nobr><span class="ft5">UF</span></nobr></div>
<div style="position:absolute;top:330;left:595"><nobr><span class="ft5">INSCRIÇÃO ESTADUAL</span></nobr></div>
<div style="position:absolute;top:330;left:459"><nobr><span class="ft5">FONE / FAX</span></nobr></div>
<div style="position:absolute;top:357;left:32"><nobr><span class="ft0"><b>CÁLCULO DO IMPOSTO</b></span></nobr></div>
<div style="position:absolute;top:370;left:35"><nobr><span class="ft5">BASE DE CÁLCULO DO ICMS</span></nobr></div>
<div style="position:absolute;top:370;left:204"><nobr><span class="ft5">VALOR DO ICMS</span></nobr></div>
<div style="position:absolute;top:395;left:315"><nobr><span class="ft5">DESCONTO</span></nobr></div>
<div style="position:absolute;top:395;left:178"><nobr><span class="ft5">VALOR DO SEGURO</span></nobr></div>
<div style="position:absolute;top:395;left:36"><nobr><span class="ft5">VALOR DO FRETE</span></nobr></div>
<div style="position:absolute;top:395;left:591"><nobr><span class="ft5">VALOR TOTAL DO IPI</span></nobr></div>
<div style="position:absolute;top:395;left:715"><nobr><span class="ft5">VALOR TOTAL DA NOTA</span></nobr></div>
<div style="position:absolute;top:395;left:453"><nobr><span class="ft5">OUTRAS DESP. ACESSÓRIAS</span></nobr></div>
<div style="position:absolute;top:370;left:371"><nobr><span class="ft5">BASE DE CÁLCULO DO ICMS S.T.</span></nobr></div>
<div style="position:absolute;top:370;left:536"><nobr><span class="ft5">VALOR DO ICMS SUBSTITUIÇÃO</span></nobr></div>
<div style="position:absolute;top:370;left:702"><nobr><span class="ft5">VALOR TOTAL DOS PRODUTOS</span></nobr></div>

<!-- Dados de imposto -->

<!-- VALOR DO SEGURO -->
<div style="position:absolute;top:405;left:232"><nobr><span class="ft6">${nfe.imposto.seguro}</span></nobr></div>
<!-- OUTRAS DESP. ACESSÓRIAS -->
<div style="position:absolute;top:405;left:508"><nobr><span class="ft6">${nfe.imposto.outros}</span></nobr></div>
<!-- VALOR DO FRETE -->
<div style="position:absolute;top:405;left:89"><nobr><span class="ft6">${nfe.imposto.frete}</span></nobr></div>
<!-- DESCONTO -->
<div style="position:absolute;top:405;left:368"><nobr><span class="ft6">${nfe.imposto.desconto}</span></nobr></div>
<!-- VALOR TOTAL DO IPI -->
<div style="position:absolute;top:405;left:635"><nobr><span class="ft6">${nfe.imposto.ipi}</span></nobr></div>
<!-- VALOR TOTAL DA NOTA -->
<div style="position:absolute;top:405;left:759"><nobr><span class="ft6">${nfe.imposto.valorTotal}</span></nobr></div>
<!-- BASE DE CÁLCULO DO ICMS -->
<div style="position:absolute;top:379;left:103"><nobr><span class="ft6">${nfe.imposto.baseICMS}</span></nobr></div>
<!-- VALOR DO ICMS -->
<div style="position:absolute;top:379;left:271"><nobr><span class="ft6">${nfe.imposto.valorICMS}</span></nobr></div>
<!-- BASE DE CÁLCULO DO ICMS S.T. -->
<div style="position:absolute;top:379;left:439"><nobr><span class="ft6">${nfe.imposto.baseST}</span></nobr></div>
<!-- VALOR DO ICMS SUBSTITUIÇÃO -->
<div style="position:absolute;top:379;left:604"><nobr><span class="ft6">${nfe.imposto.subICMS}</span></nobr></div>
<!-- VALOR TOTAL DOS PRODUTOS -->
<div style="position:absolute;top:380;left:759"><nobr><span class="ft6">${nfe.imposto.valorProdutos}</span></nobr></div>



<!-- //TODO dados da transportadora -->

<div style="position:absolute;top:444;left:405"><nobr><span class="ft9"><!-- 0 - EMITENTE --></span></nobr></div>
<div style="position:absolute;top:435;left:404"><nobr><span class="ft5">9 - Sem Frete<!-- FRETE POR CONTA --></span></nobr></div>
<!-- CNPJ da transportadora -->
<div style="position:absolute;top:445;left:724"><nobr><span class="ft6"></span></nobr></div>
<!-- <div style="position:absolute;top:445;left:486"><nobr><span class="ft6">0</span></nobr></div> -->
<div style="position:absolute;top:451;left:405"><nobr><span class="ft9"><!-- 1 - DESTINATÁRIO --></span></nobr></div>
<!-- Endereco transportadora -->
<div style="position:absolute;top:471;left:35"><nobr><span class="ft6"></span></nobr></div>
<!-- cidade transportadora -->
<div style="position:absolute;top:471;left:404"><nobr><span class="ft6"></span></nobr></div>
<!-- estado transportadora -->
<div style="position:absolute;top:471;left:687"><nobr><span class="ft6"></span></nobr></div>
<!-- quantidade de mercadorias -->
<div style="position:absolute;top:496;left:87"><nobr><span class="ft6"></span></nobr></div>
<!-- Nome da transportadora -->
<div style="position:absolute;top:445;left:35"><nobr><span class="ft6"></span></nobr></div>


<div style="position:absolute;top:423;left:32"><nobr><span class="ft0"><b>TRANSPORTADOR / VOLUMES TRANSPORTADOS</b></span></nobr></div>
<div style="position:absolute;top:435;left:504"><nobr><span class="ft5">CÓDIGO ANTT</span></nobr></div>
<div style="position:absolute;top:435;left:596"><nobr><span class="ft5">PLACA DO VEÍC</span></nobr></div>
<div style="position:absolute;top:435;left:715"><nobr><span class="ft5">CNPJ / CPF</span></nobr></div>

<div style="position:absolute;top:435;left:35"><nobr><span class="ft5">NOME / RAZÃO SOCIAL</span></nobr></div>
<div style="position:absolute;top:435;left:683"><nobr><span class="ft5">UF</span></nobr></div>
<div style="position:absolute;top:461;left:35"><nobr><span class="ft5">ENDEREÇO</span></nobr></div>
<div style="position:absolute;top:461;left:404"><nobr><span class="ft5">MUNICÍPIO</span></nobr></div>
<div style="position:absolute;top:461;left:683"><nobr><span class="ft5">UF</span></nobr></div>
<div style="position:absolute;top:461;left:715"><nobr><span class="ft5">INSCRIÇÃO ESTADUAL</span></nobr></div>
<div style="position:absolute;top:487;left:736"><nobr><span class="ft5">PESO LÍQUIDO</span></nobr></div>
<div style="position:absolute;top:496;left:305"><nobr><span class="ft6">.</span></nobr></div>
<div style="position:absolute;top:496;left:458"><nobr><span class="ft6">.</span></nobr></div>
<div style="position:absolute;top:487;left:609"><nobr><span class="ft5">PESO BRUTO</span></nobr></div>
<div style="position:absolute;top:487;left:304"><nobr><span class="ft5">MARCA</span></nobr></div>
<div style="position:absolute;top:487;left:457"><nobr><span class="ft5">NUMERAÇÃO</span></nobr></div>
<div style="position:absolute;top:487;left:151"><nobr><span class="ft5">ESPÉCIE</span></nobr></div>
<div style="position:absolute;top:487;left:36"><nobr><span class="ft5">QUANTIDADE</span></nobr></div>
<div style="position:absolute;top:516;left:32"><nobr><span class="ft0"><b>DADOS DOS PRODUTOS / SERVIÇOS</b></span></nobr></div>
<div style="position:absolute;top:530;left:40"><nobr><span class="ft5">CÓDIGO</span></nobr></div>
<div style="position:absolute;top:541;left:37"><nobr><span class="ft5">PRODUTO</span></nobr></div>
<div style="position:absolute;top:530;left:168"><nobr><span class="ft5">DESCRIÇÃO DO PRODUTO / SERVIÇO</span></nobr></div>
<div style="position:absolute;top:530;left:415"><nobr><span class="ft5">NCM/SH</span></nobr></div>
<div style="position:absolute;top:530;left:457"><nobr><span class="ft5">CST</span></nobr></div>
<div style="position:absolute;top:530;left:483"><nobr><span class="ft5">CFOP</span></nobr></div>

<div style="position:absolute;top:530;left:514"><nobr><span class="ft5">UNID</span></nobr></div>
<div style="position:absolute;top:530;left:544"><nobr><span class="ft5">QUANT</span></nobr></div>

<div style="position:absolute;top:530;left:589"><nobr><span class="ft5">VALOR</span></nobr></div>
<div style="position:absolute;top:541;left:594"><nobr><span class="ft5">UNIT</span></nobr></div>
<div style="position:absolute;top:530;left:640"><nobr><span class="ft5">VALOR</span></nobr></div>
<div style="position:absolute;top:541;left:640"><nobr><span class="ft5">TOTAL</span></nobr></div>
<div style="position:absolute;top:530;left:684"><nobr><span class="ft5">B.CÁLC</span></nobr></div>
<div style="position:absolute;top:541;left:689"><nobr><span class="ft5">ICMS</span></nobr></div>
<div style="position:absolute;top:530;left:724"><nobr><span class="ft5">VALOR</span></nobr></div>
<div style="position:absolute;top:541;left:728"><nobr><span class="ft5">ICMS</span></nobr></div>
<div style="position:absolute;top:530;left:762"><nobr><span class="ft5">VALOR</span></nobr></div>
<div style="position:absolute;top:541;left:771"><nobr><span class="ft5">IPI</span></nobr></div>
<div style="position:absolute;top:530;left:800"><nobr><span class="ft5">ALÍQ.</span></nobr></div>
<div style="position:absolute;top:541;left:801"><nobr><span class="ft5">ICMS</span></nobr></div>
<div style="position:absolute;top:530;left:831"><nobr><span class="ft5">ALÍQ.</span></nobr></div>
<div style="position:absolute;top:541;left:837"><nobr><span class="ft5">IPI</span></nobr></div>

<c:forEach items="${nfe.produtos}" var="prod">
	<div style="position:absolute;top:554;left:37"><nobr><span class="ft2">${prod.codigo}</span></nobr></div>
	<div style="position:absolute;top:554;left:88"><nobr><span class="ft2">${prod.descricao}</span></nobr></div>
	
	<!-- NCM -->
	<div style="position:absolute;top:554;left:412"><nobr><span class="ft2">${prod.ncm}</span></nobr></div>	
	<!-- CST TODO validar fixo-->
	<div style="position:absolute;top:554;left:454"><nobr><span class="ft2">40</span></nobr></div>	
	<!-- CFOP -->
	<div style="position:absolute;top:554;left:480"><nobr><span class="ft2">${prod.cfop}</span></nobr></div>
	<!-- UN -->
	<div style="position:absolute;top:554;left:514"><nobr><span class="ft2">${prod.un}</span></nobr></div>
	<!-- QUANT -->
	<div style="position:absolute;top:554;left:543"><nobr><span class="ft2">${prod.quant}</span></nobr></div>
	<!-- VLR. UNIT. -->
	<div style="position:absolute;top:554;left:582"><nobr><span class="ft2">${prod.vlrUnit}</span></nobr></div>	
	<!-- VALOR TOTAL -->
	<div style="position:absolute;top:554;left:633"><nobr><span class="ft2">${prod.total}</span></nobr></div>
		
</c:forEach>


<div style="position:absolute;top:994;left:32"><nobr><span class="ft0"><b>DADOS ADICIONAIS</b></span></nobr></div>
<div style="position:absolute;top:1007;left:36"><nobr><span class="ft5">INFORMAÇÕES COMPLEMENTARES</span></nobr></div>
<div style="position:absolute;top:1007;left:521"><nobr><span class="ft5">RESERVADO AO FISCO</span></nobr></div>
<div style="position:absolute;top:1018;left:36"><nobr><span class="ft10">DECLARAMOS QUE OS PRODUTOS DESTA NFE ESTAO DEVIDAMENTE <br>ACONDICIONADOS PARA SUPORTAR OS RISCOS NORMAIS DE CARREGAMENTO, <br>TRANSPORTE E DESCARREGAMENTO, CONFORME LEGISLACAO EM VIGOR.</span></nobr></div>
<div style="position:absolute;top:1135;left:633"><nobr><span class="ft5">Emitido pelo RESTNFe v.1.1.0 - www.restnfe.com.br</span></nobr></div>
<div style="position:absolute;top:1135;left:32"><nobr><span class="ft5">Powered by RestNFe - www.restnfe.com.br</span></nobr></div>
<div style="position:absolute;top:1143;left:-104"><nobr><span class="ft6">-
 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 - - - - - - - - - - - - - - - - - - -</span></nobr></div>
<div style="position:absolute;top:1160;left:37"><nobr><span class="ft11">RECEBEMOS DE ${nfe.emitente.nome} E/OU SERVIÇOS CONSTANTES DA NOTA FISCAL ELETRÔNICA INDICADA AO LADO.  EMISSÃO: <br>${nfe.dataEmissao}
  VALOR TOTAL: ${nfe.imposto.valorTotal}  DESTINATÁRIO: ${nfe.destinatario.nome} - ${nfe.destinatario.endereco}, ${nfe.destinatario.bairro}, ${nfe.destinatario.cidade}-${nfe.destinatario.estado}</span></nobr></div>
<div style="position:absolute;top:1164;left:768"><nobr><span class="ft8"><b>NF-e</b></span></nobr></div>
<div style="position:absolute;top:1194;left:36"><nobr><span class="ft5">DATA DO RECEBIMENTO</span></nobr></div>
<div style="position:absolute;top:1204;left:757"><nobr><span class="ft8"><b>SÉRIE ${nfe.serie}</b></span></nobr></div>
<div style="position:absolute;top:1183;left:738"><nobr><span class="ft8"><b>Nº. ${nfe.numeracao}</b></span></nobr></div>
<div style="position:absolute;top:1194;left:188"><nobr><span class="ft5">IDENTIFICAÇÃO E ASSINATURA DO RECEBEDOR</span></nobr></div>
</div>



</body></html>
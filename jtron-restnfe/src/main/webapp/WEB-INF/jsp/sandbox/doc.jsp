<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #101020;font-family: verdana;font-size: 0.8em;" >
<p style="color: #CCDF32">/**</p>
<p style="color: #CCDF32">*</p>
<p style="color: #CCDF32">* <span style="color: #FFF"> Consultar procotolo de uma NFe no ambiente SEFAZ. </span></p>
<p style="color: #CCDF32">* <span style="color: #FFF"> Este serviço identifica o estado da emissão da nota pela chave</span></p>
<p style="color: #CCDF32">* <span style="color: #FFF"> e faz a consulta no ambiente de SEFAZ correspondente.</span></p>
<p style="color: #CCDF32">*</p>
<p style="color: #CCDF32">* @GET</p>
<p style="color: #CCDF32">* @param ambiente</p>
<p style="color: #CCDF32">* @param chave</p>
<p style="color: #CCDF32">*/</p>
<p style="color: #CCDF32"><span style="color: #00ABEB">/nfe/consultar/protocolo/{ambiente}/{chave}</span></p>
<p style="color: #CCDF32">/**</p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* <span style="color: #FFF">Emissão de NFe. Uma vez gerado o XML com a chave correta basta passar para</span></p> 
<p style="color: #CCDF32">* <span style="color: #FFF">este rest e a emissão é feita e validada. Caso sucesso tudo é armazenado e </span></p>
<p style="color: #CCDF32">* <span style="color: #FFF">protocoloado para garantir validade juridica. Caso erro o mesmo é retornado</span></p>
<p style="color: #CCDF32">* <span style="color: #FFF">para tratamento. </span></p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* @GET</p>
<p style="color: #CCDF32">* @param xml</p>
<p style="color: #CCDF32">* @param ambiente</p>
<p style="color: #CCDF32">* @param nota</p>
<p style="color: #CCDF32">* @param serie</p>	 
<p style="color: #CCDF32">*/</p>
<p style="color: #CCDF32"><span style="color: #00ABEB">/nfe/emitir</span></p>
<p style="color: #CCDF32">/**</p>
<p style="color: #CCDF32">*</p>
<p style="color: #CCDF32">* <span style="color: #FFF"> Download do XML assinado digitalmente</span></p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* @GET</p>
<p style="color: #CCDF32">* @param chave</p>
<p style="color: #CCDF32">*/</p>
<p style="color: #CCDF32">/nfe/download/xml/{chave}</p>
<p style="color: #CCDF32">/**</p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* <span style="color: #FFF"> NFe web online em HTML</span></p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* @GET</p>
<p style="color: #CCDF32">* @param chave</p>
<p style="color: #CCDF32">*/</p>
<p style="color: #CCDF32">/nfe/online/{chave}</p>


<p style="color: #CCDF32">/**</p>
<p style="color: #CCDF32">* </p>
<p style="color: #CCDF32">* <span style="color: #FFF"> Sandbox para teste das api´s rest</span></p>
<p style="color: #CCDF32">*</p> 
<p style="color: #CCDF32">* @GET</p>
<p style="color: #CCDF32">*/</p>
<p style="color: #CCDF32"><span style="color: #00ABEB">/sandbox</span></p>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>RestNFe Sandbox</title>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>

<body>

<!-- <form id="chaveForm" class="form-horizontal" method="post">
<fieldset>
Form Name
<legend>Gerar Chave</legend>
Text input
<div class="form-group">
  <label class="col-md-4 control-label" for="uf">UF</label>  
  <div class="col-md-4">
  <input id="uf" name="uf" type="text" placeholder="Código UF IBGE" class="form-control input-md" required="">
  <span class="help-block">Estado do emitente</span>  
  </div>
</div>
Text input
<div class="form-group">
  <label class="col-md-4 control-label" for="cnpj">CNPJ</label>  
  <div class="col-md-4">
  <input id="cnpj" name="cnpj" type="text" placeholder="CNPJ" class="form-control input-md" required="">
  <span class="help-block">CNPJ do emitente</span>  
  </div>
</div>
Text input
<div class="form-group">
  <label class="col-md-4 control-label" for="serie">Série</label>  
  <div class="col-md-4">
  <input id="serie" name="serie" type="text" placeholder="Número da série" class="form-control input-md" required="">
  <span class="help-block">900 a 999 de uso exclusivo de NF-e </span>  
  </div>
</div>
Text input
<div class="form-group">
  <label class="col-md-4 control-label" for="numero">Nota Fiscal</label>  
  <div class="col-md-4">
  <input id="numero" name="numero" type="text" placeholder="Número da nota" class="form-control input-md" required="">
  <span class="help-block">Numeração unica de nota para cada série</span>  
  </div>
</div>
<div style="margin: 15px;display: none;" id="chaveResult" class="well"></div>
Button
<div class="form-group">
  <label class="col-md-4 control-label" for="gerarChave"></label>
  <div class="col-md-4">
    <button id="gerarChave" name="gerarChave" class="btn btn-primary" >Gerar Cahve</button>
  </div>
</div>
</fieldset>
</form> -->

<form id="notaForm" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Emitir Nota</legend>

<!-- Multiple Radios -->
<div class="form-group">
  <label class="col-md-4 control-label" for="ambiente">Ambiente</label>
  <div class="col-md-4">
  <div class="radio">
    <label for="ambiente-0">
      <input type="radio" name="ambiente" id="ambiente" value="1" disabled="disabled" >
      Produção
    </label>
	</div>
  <div class="radio">
    <label for="ambiente-1">
      <input type="radio" name="ambiente" id="ambiente" value="2" checked="checked" >
      Homologação
    </label>
	</div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="serie">Série</label>  
  <div class="col-md-4">
  <input id="serie" name="serie" type="text" placeholder="Número da série" class="form-control input-md" required="">
  <span class="help-block">900 a 999 de uso exclusivo de NF-e </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="numero">Nota Fiscal</label>  
  <div class="col-md-4">
  <input id="numero" name="numero" type="text" placeholder="Número da nota" class="form-control input-md" required="">
  <span class="help-block">Numeração unica de nota para cada série</span>  
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="xml">XML</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="xml" name="xml"></textarea>
  </div>
</div>

<div style="margin: 15px;display: none;" id="notaResult" class="well"></div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="emitirNota"></label>
  <div class="col-md-4">
    <button id="emitirNota" name="emitirNota" class="btn btn-primary">Emitir Nota</button>
  </div>
</div>

</fieldset>
</form>

<script type="text/javascript">
$( document ).ready(function() {	  	
	$('#chaveForm').on( "submit", function( event ) {
		gerarChave();
		return false;
	});
	$('#notaForm').on( "submit", function( event ) {
		emitirNota();
		return false;
	});		
});

<%-- function gerarChave(){	
	$('#gerarChave').prop('disabled', true);
	var uf = limpaInput($("#uf").val());
	var cnpj = limpaInput($("#cnpj").val());
	var serie = limpaInput($("#serie").val());
	var numero = limpaInput($("#numero").val());	
	$.ajax({
	  dataType: 'text',
	  url: '<%=request.getContextPath()%>/nfe/gerar/chave/'+uf+'/'+cnpj+'/'+serie+'/'+numero
	}).done(function( data ) {
		$( "#chaveResult" ).html( data  );
		$("#chaveResult").show("slow");
		$('#gerarChave').prop('disabled', false);
	}).error(function (request, status, error) {
        alert(request.responseText);
        $('#gerarChave').prop('disabled', false);
	});	
} --%>

function emitirNota(){
	$('#emitirNota').prop('disabled', true);
	
	$.ajax({
	  dataType: 'text',	
      type: "POST",
      data:{ xml:$("#xml").val(),ambiente:$("#ambiente:checked").val(),serie:$("#serie").val(),nota:$("#numero").val() },
	  url: '<%=request.getContextPath()%>/nfe/emitir' 
	}).done(function( data ) {
		$( "#notaResult" ).html( data  );
		$("#notaResult").show("slow");
		$('#emitirNota').prop('disabled', false);
	}).error(function (request, status, error) {
        alert(request.responseText);
        $('#emitirNota').prop('disabled', false); 
	});	
}

function limpaInput(str){
	return str.replace(/[^a-z0-9\s]/gi, '');
}
</script>

</body>
</html>
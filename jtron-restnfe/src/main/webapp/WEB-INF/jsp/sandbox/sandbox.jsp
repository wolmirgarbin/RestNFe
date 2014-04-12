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

<form id="notaForm" class="form-horizontal">

<fieldset>

<!-- Form Name -->
<legend>Ambiente de teste Emitir Nota</legend>

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
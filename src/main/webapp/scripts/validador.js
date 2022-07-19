/**
 *validação de formulario
 */
 
 function validar() {
	let nome = formularioContato.nome.value
	let fone = formularioContato.fone.value
	
	if ( nome === "" ) {
		alert("preencha  o campo nome")
		formularioContato.nome.focus();
		return false
	}
	else if ( fone === "" ) {
		alert("preencha  o campo fone")
		formularioContato.fone.focus();
		return false
	}
	else {
		document.forms["formularioContato"].submit();
	}
	
}
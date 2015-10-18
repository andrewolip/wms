$(document).ready(function() {
	$('#btnInserirObra').click(function(e) {
		e.preventDefault();
		
		// Recupera os valor digitados no formulário
		var obra = {
			nome: $('#nomeObra').val(),
			descricao: $('#descricaoObra').val()
		}
		
		$.ajax({
			type : "post",
			url : "http://localhost:8080/obra/inserir",
			data : JSON.stringify(obra),
			contentType : "application/json;  ",
			dataType : "text",
			success : function(data, status, jqXHR) {
				alert('Obra Cadastrada com Sucesso!');
				limparTela();
			},
			error : function(jqXHR, status) {
				// error handler
				console.log(jqXHR);
				alert('falha ' + status.code);
			}
		});
		
	});
	
	function limparTela() {
		$('#nomeObra').val('');
		$('#descricaoObra').val('');
	}
	
});
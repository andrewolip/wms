$(document).ready(function() {
	$('#btnInserirFuncao').click(function(e) {
		e.preventDefault();
		
		// Recupera os valor digitados no formulário
		var funcao = {
			nome: $('#nomeFuncao').val(),
			descricao: $('#descricaoFuncao').val()
		}
		
		$.ajax({
			type : "post",
			url : "http://localhost:8080/funcao/inserir",
			data : JSON.stringify(funcao),
			contentType : "application/json;  ",
			dataType : "text",
			success : function(data, status, jqXHR) {
				alert('Função cadastrada com Sucesso!');
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
		$('#nomeFuncao').val('');
		$('#descricaoFuncao').val('');
	}
	
});
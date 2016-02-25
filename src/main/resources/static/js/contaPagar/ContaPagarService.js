app.factory('contaPagarService', ['$http', '$location', '$log', function($http, $location, $log) {
	var contaPagar = {};
	contaPagar.itensConta = [];

	contaPagar.buscarContaPagarPorNotaFiscal = function(notaFiscal) {
		return $http.get('/contasPagar/buscarPorNotaFiscal/' + notaFiscal);
	}
	
	contaPagar.salvarContaPagar = function(contaPagar) {
		return $http.put('/contasPagar/salvar', contaPagar);
	}
	
	contaPagar.listarPorObra = function(id) {
		return $http.get('/contasPagar/listar_por_obra/' + id);
	}
	
	contaPagar.removerContaPagar = function(contaPagar) {
		return $http({
			url : '/contasPagar/remover/' + contaPagar.idContaPagar,
			method : 'DELETE',
			data : contaPagar,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	contaPagar.atualizarContaPagar = function(contaPagar) {
		return $http.put('/contasPagar/atualizar', contaPagar);
	}
	
	contaPagar.addItemConta = function(itemConta) {
		contaPagar.itensConta.push(itemConta);
	}
	
	contaPagar.removerItemConta = function(itemConta) {
		contaPagar.itensConta.remove(itemConta);
	} 
	
	contaPagar.salvarItensConta = function(itensConta) {
		return $http.put('itensConta/salvarItensConta', itensConta);
	}

	contaPagar.listarContasNaoPagasPorObra = function(id) {
		return $http.get('contasPagar/listar_contas_nao_pagas/' + id);
	}

	contaPagar.realizarLancamento = function(contaPagar) {
		return $http.post('contasPagar/realizar_lancamento', contaPagar);
	}

	contaPagar.realizarEstorno = function(contaPagar) {
		return $http.post('contasPagar/realizar_estorno', contaPagar);
	}
	
	return contaPagar;
	
}]);
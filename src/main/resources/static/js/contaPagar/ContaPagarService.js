app.factory('contaPagarService', ['$http', '$location', '$log', function($http, $location, $log) {
	var contaPagar = {};
	contaPagar.itensConta = [];

	contaPagar.buscarContaPagarPorNotaFiscal = function(notaFiscal) {
		return $http.get('/contasPagar/buscarPorNotaFiscal/' + notaFiscal);
	}
	
	contaPagar.salvarContaPagar = function(contaPagar) {
		return $http.put('/contasPagar/salvar', contaPagar);
	}
	
	contaPagar.listarContasPagar = function() {
		return $http.get('/contasPagar/listar');
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
	
	contaPagar.listarItensPorConta = function(id) {
		return $http.get('itensConta/listar_itens_por_conta/' + id);
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
	
	return contaPagar;
	
}]);
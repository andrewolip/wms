app.factory('contaPagarService', ['$http', '$location', '$log', function($http, $location, $log) {
	var contaPagar = {};
	contaPagar.itensConta = [];

	contaPagar.salvarContaPagar = function(contaPagar) {
		return $http.post('/contasPagar/inserir', contaPagar);
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
	
	contaPagar.listarItensConta = function(id) {
		return $http.get('/contasPagar/listar_itens' + id);
	}
	
	contaPagar.addItemConta = function(itemConta) {
		contaPagar.itensConta.push(itemConta);
	}
	
	contaPagar.removerItemConta = function(itemConta) {
		contaPagar.itensConta.remove(itemConta);
	} 
	
//	factory.listarObras = function() {
//		return $http.get('/obras/listar');
//	}
//	
//	factory.listarUnidadesPorObra = function(id) {
//		return $http.get('unidades/listar_por_obra/' + id);
//	}
	
//	factory.listarPorObra = function(obra) {
//		return $http.get('contasPagar/listar_por_obra', obra);
//	}
//	
//	factory.listarPorUnidade = function(unidade) {
//		return $http.get('contasPagar/listar_por_unidade/', unidade);
//	}
	
	return contaPagar;
	
}]);
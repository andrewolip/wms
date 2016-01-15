app.factory('contaPagarService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var contaPagar = {};
	var contasPagar = [];

	factory.salvarContaPagar = function(contaPagar) {
		return $http.post('/contasPagar/inserir', contaPagar);
	}
	
	factory.listarContasPagar = function() {
		return $http.get('/contasPagar/listar');
	}
	
	factory.removerContaPagar = function(contaPagar) {
		return $http({
			url : '/contasPagar/remover/' + contaPagar.idContaPagar,
			method : 'DELETE',
			data : contaPagar,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarContaPagar = function(contaPagar) {
		return $http.put('/contasPagar/atualizar', contaPagar);
	}
	
	factory.listarItensConta = function(id) {
		return $http.get('/contasPagar/listar_itens' + id);
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
	
	return factory;
	
}]);
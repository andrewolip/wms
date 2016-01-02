app.factory('contaPagarService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var contaPagar = {};
	var contasPagar = [];

	factory.salvarContaPagar = function(contaPagar) {
		return $http.post('/contasPagar/inserir', contaPagar);
	}
	
	factory.buscarContaPagar = function(id) {
		return $http.get('/contasPagar/buscar/' + id);
	}
	
	factory.listarContasPagar = function() {
		console.log("ContaPagarService.js");
		console.log(contasPagar);
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
		console.log("ContaPagarService.js atualizar");
		console.log(contaPagar);
		return $http.put('/contasPagar/atualizar', contaPagar);
	}
	
	return factory;
	
}]);
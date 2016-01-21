app.factory('itensContaService', ['$http', '$location', '$log', function($http, $location, $log) {
	var factory = {};
	var itemConta = {}
	var itensConta = [];
	
	factory.busarItemConta = function(id) {
		return $http.get('/itensConta/buscar/' + id);
	}
	
	factory.listarItensConta = function() {
		return $http.get('/itensConta/listar');
	}
	
	factory.listarItensPorConta = function(id) {
		return $http.get('itensConta/listar_por_conta/' + id);
	}
	
	factory.removerItemConta = function(itemConta) {
		return $http({
			url : 'itensConta/apagar/' + itemConta.idItemConta,
			method : 'DELETE',
			data : itemConta,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.salvarItemConta = function(itemConta) {
		return $http.put('itensConta/salvar', itemConta);
	}

	return factory;
	
}]);
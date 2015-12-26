app.factory('unidadeService', ['$http', '$location', '$log', function($http, $location, $log) {
	var factory = {};
	var unidade = {};
	
	factory.salvarUnidade = function(unidade) {
		return $http.post('/unidades/inserir', unidade);
	}
	
	factory.buscarUnidade = function(id) {
		return $http.get('/unidades/buscar/' + id);
	}
	
	factory.listarUnidades = function() {
		return $http.get('/unidades/listar');
	}
	
	factory.apagarUnidade = function(unidade) {
		return $http({
			url : '/unidades/apagar/' + unidade.idUnidade,
			method : 'DELETE',
			data : unidade,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarUnidade = function(unidade) {
		return $http.put('/unidades/atualizar', unidade);
	}
	
	return factory;
	
}]);
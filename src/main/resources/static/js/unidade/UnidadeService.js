app.factory('unidadeService', ['$http', '$location', '$log', function($http, $location, $log) {
	var factory = {};
	var unidade = {};
	
	factory.buscarUnidade = function(id) {
		return $http.get('/unidades/buscar/' + id);
	}
	
	factory.listarUnidades = function() {
		return $http.get('/unidades/listar');
	}
	
	factory.listarUnidadesPorObra = function(id) {
		return $http.get('unidades/listar/' + id);
	}
	
	factory.removerUnidade = function(unidade) {
		return $http({
			url : 'unidades/apagar/' + unidade.idUnidadeObra,
			method : 'DELETE',
			data : unidade,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.salvarUnidadeObra = function(unidade) {
		return $http.put('unidades/salvar', unidade);
	}
	
	return factory;
	
}]);
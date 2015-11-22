app.factory('unidadeService', ['$http', function($http) {
	var factory = {};
	var unidade = {};
	var unidades = [];
	
	factory.salvarUnidade = function(unidade) {
		return $http.post('/unidades/inserir', unidade);
	}
	
	factory.atualizarUnidade = function(unidade) {
		return $http.put('/unidades/atualizar', unidade);
	}
	
	factory.buscarUnidade = function(unidade) {
		return $http.get('/unidades/buscar/' + unidade.idUnidadeObra);
	}
	
	factory.listarUnidades = function() {
		return $http.get('/unidades/listar', unidades);
	}
	
	factory.removerUnidade = function(unidade) {
		return $http({
			url : '/unidades/remover/' + unidades.idUnidadeObra,
			method : 'DELETE',
			data : unidade,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	return factory;
	
}]);
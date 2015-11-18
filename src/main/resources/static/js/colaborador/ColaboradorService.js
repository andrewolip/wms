app.factory('colaboradorService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var colaborador = {};
	var colaboradores = [];

	factory.salvarColaborador = function(colaborador) {
		return $http.post('/colaboradores/inserir', colaborador);
	}
	
	factory.buscarColaborador = function(id) {
		return $http.get('/colaboradores/buscar/' + id);
	}
	
	factory.listarColaboradores = function() {
		return $http.get('/colaboradores/listar');
	}
	
	factory.removerColaborador = function(colaborador) {
		return $http({
			url : '/colaboradores/remover/' + colaborador.idColaborador,
			method : 'DELETE',
			data : colaborador,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarColaborador = function(colaborador) {
		return $http.put('/colaboradores/atualizar', colaborador);
	}
	
	return factory;
	
}]);
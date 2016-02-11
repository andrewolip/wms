app.factory('fasesService', ['$http', '$location', '$log', function($http, $location, $log) {
	var factory = {};
	var fase = {}
	var fases = [];
	
	factory.busarFase = function(id) {
		return $http.get('/fases/buscar/' + id);
	}
	
	factory.listarFases = function() {
		return $http.get('/fases/listar');
	}
	
	factory.listarPorUnidade = function(id) {
		return $http.get('fases/listar_por_unidade/' + id);
	}
	
	factory.removerFase = function(fase) {
		return $http({
			url : 'fases/apagar/' + fase.idFaseUnidade,
			method : 'DELETE',
			data : fase,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.salvarFase = function(fase) {
		return $http.put('fases/salvar', fase);
	}

	factory.salvarListaDeFases = function(fases) {
		return $http.put('fases/salvarLista', fases);
	}

	return factory;
	
}]);
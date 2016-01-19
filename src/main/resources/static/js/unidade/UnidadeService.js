app.factory('unidadeService', ['$http', '$location', '$log', function($http, $location, $log) {
	var unidade = {};
	unidade.fases = [];
	
	unidade.addFase = function(fase) {
		// se nao funcionar, colocar no formato JSON
		unidade.fases.push(fase);
	}
	
	unidade.removerFase = function(fase) {
		unidade.fases.remove(fase);
	} 
	
	unidade.buscarUnidade = function(id) {
		return $http.get('/unidades/buscar/' + id);
	}
	
	unidade.listarUnidades = function() {
		return $http.get('/unidades/listar');
	}
	
	unidade.listarUnidadesPorObra = function(id) {
		return $http.get('unidades/listar_por_obra/' + id);
	}
	
	unidade.removerUnidade = function(unidade) {
		return $http({
			url : 'unidades/apagar/' + unidade.idUnidadeObra,
			method : 'DELETE',
			data : unidade,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	unidade.salvarUnidadeObra = function(unidade) {
		return $http.put('unidades/salvar', unidade);
	}
	
	return unidade;
	
}]);
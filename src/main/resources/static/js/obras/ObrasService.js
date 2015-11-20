app.factory('obrasService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var obra = {};
	var obras = [];

	factory.salvarObra = function(obra) {
		return $http.post('/obras/inserir', obra);
	}
	
	factory.buscarObra = function(id) {
		return $http.get('/obras/buscar/' + id);
	}
	
	factory.listarObras = function() {
		return $http.get('/obras/listar');
	}
	
	factory.apagarObra = function(obra) {
		return $http({
			url : '/obras/apagar/' + obra.idObra,
			method : 'DELETE',
			data : obra,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarObra = function(obra) {
		return $http.put('/obras/atualizar', obra);
	}
	
	return factory;
	
}]);
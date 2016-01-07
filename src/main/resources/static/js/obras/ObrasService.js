app.factory('obrasService', ['$http', '$location', '$log', function($http, $location, $log) {
	var factory = {};
	var obra = {
		localizacao: {}
	};
	var obras = [];
	
	factory.objetoCompartilhado = function(newObra) {
		obra = newObra;
		return obra;
	}

	factory.salvarObra = function(obra) {
		return $http.post('/obras/inserir', obra);
	}
	
	factory.salvarUnidadeObra = function(unidade) {
		return $http.post('/unidades/salvar', unidade); 
	}
	
	factory.buscarObra = function(id) {
		return $http.get('/obras/buscar/' + id);
	}
	
	factory.listarObras = function() {
		return $http.get('/obras/listar');
	}
	
	factory.listarUnidades = function() {
		return $http.get('unidades/listar');
	}

	factory.listarUnidadesPorObra = function(id) {
		return $http.get('unidades/listar/' + id);
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
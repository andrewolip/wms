app.factory('clienteService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var cliente = {};
	var clientes = [];

	factory.salvarCliente = function(cliente) {
		return $http.post('/clientes/inserir', cliente);
	}
	
	factory.buscarCliente = function(id) {
		return $http.get('/clientes/buscar/' + id);
	}
	
	factory.listarClientes = function() {
		return $http.get('/clientes/listar');
	}
	
	factory.listarCoordenadores = function() {
		return $http.get('/clientes/listar_coordenadores');
	}
	
	factory.removerCliente = function(cliente) {
		return $http({
			url : '/clientes/remover/' + cliente.idCliente,
			method : 'DELETE',
			data : cliente,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarCliente = function(cliente) {
		return $http.put('/clientes/atualizar', cliente);
	}
	
	return factory;
	
}]);
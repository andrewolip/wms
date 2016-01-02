app.factory('fornecedorService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var fornecedor = {};
	var fornecedores = [];

	factory.salvarFornecedor = function(fornecedor) {
		return $http.post('/fornecedores/inserir', fornecedor);
	}
	
	factory.buscarFornecedor = function(id) {
		return $http.get('/fornecedores/buscar/' + id);
	}
	
	factory.listarFornecedores = function() {
		return $http.get('/fornecedores/listar');
	}
	
	factory.removerFornecedor = function(fornecedor) {
		return $http.put('/fornecedores/atualizar', fornecedor);
	}
	
	factory.atualizarFornecedor = function(fornecedor) {
		return $http.put('/fornecedores/atualizar', fornecedor);
	}
	
	return factory;
	
}]);
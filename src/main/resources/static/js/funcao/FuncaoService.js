app.factory('funcaoService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var funcao = {};
	var funcoes = [];

	factory.salvarFuncao = function(funcao) {
		return $http.post('/funcoes/inserir', funcao);
	}
	
	factory.buscarFuncao = function(id) {
		return $http.get('/funcoes/buscar/' + id);
	}
	
	factory.listarFuncoes = function() {
		return $http.get('/funcoes/listar');
	}
	
	factory.removerFuncao = function(funcao) {
		return $http({
			url : '/funcoes/remover/' + funcao.idFuncao,
			method : 'DELETE',
			data : funcao,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	factory.atualizarFuncao = function(funcao) {
		return $http.put('/funcoes/atualizar', funcao);
	}
	
	return factory;
	
}]);
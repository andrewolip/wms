app.factory('usuarioService', ['$http', '$location', function($http, $location) {
	var factory = {};
	var usuario = {};
	var usuarios = [];

	factory.salvarUsuario = function(usuario) {
		return $http.post('/usuarios/inserir', usuario);
	}
	
	factory.buscarUsuario = function(id) {
		return $http.get('/usuarios/buscar/' + id);
	}
	
	factory.listarUsuarios = function() {
		return $http.get('/usuarios/listar');
	}
	
	factory.listarCoordenadores = function() {
		return $http.get('/usuarios/listar_coordenadores');
	}
	
	factory.removerUsuario = function(usuario) {
//		return $http.put('/usuarios/remover', usuario);
	}
	
	factory.atualizarUsuario = function(usuario) {
		return $http.put('/usuarios/atualizar', usuario);
	}
	
	return factory;
	
}]);
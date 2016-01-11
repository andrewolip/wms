app.controller('UsuarioInstanceController', function($scope,
		$uibModalInstance, $log, usuarioService, usuario) {
	$scope.usuario = usuario;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(usuario) {
		usuario.ativo = true;
		usuarioService.atualizarUsuario(usuario).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
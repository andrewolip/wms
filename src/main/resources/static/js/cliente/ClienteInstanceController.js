app.controller('ClienteInstanceController', function($scope,
		$uibModalInstance, $log, clienteService, cliente) {
	$scope.cliente = cliente;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(cliente) {
		cliente.ativo = true;
		clienteService.atualizarCliente(cliente).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
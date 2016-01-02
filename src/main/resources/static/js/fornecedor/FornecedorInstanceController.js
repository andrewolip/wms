app.controller('FornecedorInstanceController', function($scope,
		$uibModalInstance, $log, fornecedorService, fornecedor) {
	$scope.fornecedor = fornecedor;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(fornecedor) {
		fornecedor.ativo = true;
		fornecedorService.atualizarFornecedor(fornecedor).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
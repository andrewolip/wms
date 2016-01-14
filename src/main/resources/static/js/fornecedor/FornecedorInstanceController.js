app.controller('FornecedorInstanceController', function($scope,
		$uibModalInstance, $log, fornecedorService, fornecedor, buscaCepService) {
	
	$scope.fornecedor = fornecedor;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};
	
	$scope.buscarCep = function(localizacao) {
		buscaCepService.buscarCep(localizacao).success(function(data, status){
			$scope.fornecedor.localizacao = data;
		}); 
	}

	$scope.atualizar = function(fornecedor) {
		fornecedor.ativo = true;
		fornecedorService.atualizarFornecedor(fornecedor).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
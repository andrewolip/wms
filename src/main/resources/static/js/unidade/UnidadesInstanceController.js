app.controller('UnidadesInstanceController', function($scope,
		$uibModalInstance, $log, unidadeService, unidade, $stateParams) {
	
	$scope.unidade = {};
	$scope.unidade.obra = $stateParams;
	
	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};
	
	$scope.salvarUnidade = function(unidade) {
		unidadeService.salvarUnidadeObra(unidade).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});  
	}
});
app.controller('ObrasInstanceController', function($scope,
		$uibModalInstance, $log,obrasService, obra) {
	$scope.obra = obra;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(obra) {
		obrasService.atualizarObra(obra).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
app.controller('ColaboradorInstanceController', function($scope,
		$uibModalInstance, $log, colaboradorService, colaborador) {
	$scope.colaborador = colaborador;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(colaborador) {
		colaboradorService.atualizarColaborador(colaborador).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
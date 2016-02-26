app.controller('ColaboradorObraInstanceController', function($scope,
		$uibModalInstance, $log, colaboradorService, colaborador) {
	$scope.colaborador = colaborador;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(colaborador, obra) {
		colaborador.obra = obra;
		colaboradorService.atualizarColaborador(colaborador).success(function(data) {
			setTimeout(continueExecution, 300);
			
			function continueExecution() {
				$uibModalInstance.close();
			}
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
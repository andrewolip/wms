app.controller('ColaboradorObraInstanceController', function($scope,
		$uibModalInstance, $log, colaboradorService, colaborador) {
	$scope.colaborador = colaborador;
	$scope.funcionario = {}; 
	$scope.obra = {};

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(colaborador, obra) {
		
		$scope.colaborador.obra = obra;
		colaboradorService.atualizarColaborador($scope.colaborador).success(function(data) {
			setTimeout(continueExecution, 300);
			
			function continueExecution() {
				$uibModalInstance.close();
			}
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
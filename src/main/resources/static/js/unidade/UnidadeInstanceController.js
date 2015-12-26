app.controller('UnidadeInstanceController', function($scope,
		$uibModalInstance, $log,unidadeService, unidade) {
	$scope.unidade = unidade;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(unidade) {
		unidadeService.atualizarUnidade(unidade).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
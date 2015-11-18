app.controller('FuncaoInstanceController', function($scope,
		$uibModalInstance, $log, funcaoService, funcao) {
	$scope.funcao = funcao;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(funcao) {
		funcaoService.atualizarFuncao(funcao).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
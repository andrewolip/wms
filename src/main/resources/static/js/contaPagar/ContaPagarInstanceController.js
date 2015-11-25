app.controller('ContaPagarInstanceController', function($scope,
		$uibModalInstance, $log, contaPagarService, contaPagar) {
	$scope.contaPagar = contaPagar;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(contaPagar) {
		console.log("instanceController.js");
		contaPagarService.atualizarContaPagar(contaPagar).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
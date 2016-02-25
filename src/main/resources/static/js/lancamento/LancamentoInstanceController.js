app.controller('LancamentoInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, $stateParams, contaPagarService, contaPagar, $window) {
	
	$scope.contaPagar = contaPagar;
	$scope.lancamento = {};
	$scope.contas = [];
	  
  	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.realizarLancamento = function(contaPagar) {

		$log.info('verificando se contaPagar está null...');
		$log.info(contaPagar);

		contaPagarService.realizarLancamento(contaPagar).success(function(data) {
			$log.info(data);
			$uibModalInstance.close();
		}).error(function(error) {
			$log.info(error);
		});
	}
	
});

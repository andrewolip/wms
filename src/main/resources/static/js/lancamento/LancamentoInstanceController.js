app.controller('LancamentoInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, $stateParams, contaPagarService, contaPagar, $window, $state) {
	
	$scope.contaPagar = contaPagar;
	$scope.lancamento = {};
	$scope.contas = [];


	  
  	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.realizarLancamento = function(contaPagar) {

		contaPagarService.realizarLancamento(contaPagar).success(function(data) {
			
			$uibModalInstance.close();
		}).error(function(error) {
			$log.info(error);
		});
	}
	
});

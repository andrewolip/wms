app.controller('EstornoInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, $stateParams, contaPagarService, contaPagar, $window) {
	
	$scope.contaPagar = contaPagar;
	$scope.estorno = {};
	$scope.contas = [];
	  
  	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.realizarEstorno = function(contaPagar) {

		$log.info('verificando se contaPagar está null...');
		$log.info(contaPagar);

		contaPagarService.realizarEstorno(contaPagar).success(function(data) {
			$log.info(data);
			$uibModalInstance.close();
		}).error(function(error) {
			$log.info(error);
		});
	}
	
});

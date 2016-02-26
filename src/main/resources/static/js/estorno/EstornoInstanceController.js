app.controller('EstornoInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, $stateParams, contaPagarService, contaPagar, $window, $state) {
	
	$scope.contaPagar = contaPagar;
	$scope.estorno = {};
	$scope.contas = [];

	
	  
  	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.realizarEstorno = function(contaPagar) {

		contaPagarService.realizarEstorno(contaPagar).success(function(data) {
			
			$uibModalInstance.close();
		}).error(function(error) {
			$log.info(error);
		});
	}
	
});

app.controller('LancamentoInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, $stateParams, $window) {
	
	  
  	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	
	
});

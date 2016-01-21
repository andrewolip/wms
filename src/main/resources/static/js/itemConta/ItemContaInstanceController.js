app.controller('ItemContaInstanceController', [	'$scope', function($scope, 
		$log, $stateParams, contaPagarService, $uibModalInstance) {
	
	$scope.contaPagar = {};
	$scope.contaPagar.itensConta = contaPagarService.itensConta;
	$scope.itemConta = {};
	
	
	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};	
	
	$scope.salvarItemConta = function(itemConta) {
		contaPagarService.addItemConta(itemConta);
		$uibModalInstance.close();
		$log.info($scope.contaPagar.itensConta);
	}
	
	$scope.removerItemConta = function(itemConta) {
		contaPagarService.removerItemConta(itemConta);
		$log.info('remover item');
	}

}]);
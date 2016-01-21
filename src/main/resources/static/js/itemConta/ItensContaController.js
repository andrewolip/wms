app.controller('ItensContaController', ['$scope', '$uibModal', '$log', 'itensContaService', '$window', '$location', '$stateParams',
                                      function($scope, $uibModal, $log, itensContaService, $window, $location, $stateParams) {
	
	$scope.obra = $stateParams;
	$scope.itensConta = [];
	$scope.contasPagar = [];
	$scope.contaPagar = {};

	$scope.listarItensPorConta = function() {
		itensContaService.listarItensPorConta($scope.contaPagar.idContaPagar).success(function(data) {
			$scope.itemConta = data;
		}).error(function(error) {
			$log.error(error);
		});
	}
	 
	$scope.removerItemConta = function(itemConta){
		var deleteItemConta = $window
		.confirm('Tem certeza que gostaria de apagar o item '
				+ itemConta.nome + '?');

		if (deleteItemConta) {
			itensContaService.removerItemConta(itemConta).success(
					function(data) {
						$scope.listarItensPorConta();
					}).error(function(error) {
				$log.error(error);
			});
		} else{} 
	}
}]);
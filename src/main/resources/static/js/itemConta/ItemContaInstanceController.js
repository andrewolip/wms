app.controller('ItemContaInstanceController', [	'$scope', 
                                				'$log',
                                				'contaPagarService',
		function($scope, 
				$log,
				contaPagar,
				contaPagarService) {
	
	$scope.contaPagar = contaPagar;
	$scope.itemConta = {};
	$scope.itensConta = [];
	
//	$scope.cancelar = function() {
//		$uibModalInstance.dismiss('cancelar');
//	};

	$scope.adicionarItem = function(itemConta) {
		$scope.contaPagar.addItemConta(itemConta).success(
			function(data) {
//				$uibModalInstance.close();
			}).error(function(error) {
				resultado = error.Message;
			});
	};
	
//	$scope.listarItensConta = function() {
//		console.log("listando itens da conta");
//		contaPagarService.listarItensConta($scope.contaPagar.idContaPagar).success(
//			function(data) {
//				$scope.itensConta = data;
//			}).error(function(msg) {
//				$log.info(msg);
//			});
//	}
}]);
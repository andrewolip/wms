app.controller('LancamentoController', ['$scope', '$uibModal', '$log',
                                      function($scope, $uibModal, $log) {

	$scope.lancamento = {};

	$scope.modalLancamento = function(tamanho, contaSelecionada) {

		$log.info('chamou');
		
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalLancamentoContent.html',
			controller : 'LancamentoInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				conta : function() {
					return angular.copy(contaSelecionada);
				}
			}
		}); 

		modalInstance.result.then(
				function(selectedItem) {
					$scope.selected = selectedItem;
				//	$scope.listarUnidadesPorObra($scope.obra.idObra);
				}, function() {
					$log.info('Modal foi fechada em: '
							+ new Date());
				});

	};
	

}]);
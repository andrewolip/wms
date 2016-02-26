app.controller('LancamentoController', ['$scope', '$uibModal', '$log', 'lancamentosService', '$stateParams',
                                      function($scope, $uibModal, $log, lancamentosService, $stateParams) {

	$scope.lancamento = {};	
	$scope.lancamentos = [];

	$scope.listarLancamentosPorObra = function() {
		// passar idObra por parametro
		lancamentosService.listarLancamentosPorObra($stateParams.idObra).success(function(response) {
			$scope.lancamentos = response;
		}).error(function(error) {
			$log.error(error);
		});
	}

}]);
app.controller('FasesController', ['$scope', '$uibModal', '$log', 'fasesService', '$window', '$location', '$stateParams',
                                      function($scope, $uibModal, $log, fasesService, $window, $location, $stateParams) {
	
	$scope.obra = $stateParams;
	$scope.fases = [];
	$scope.unidades = [];
	$scope.unidade = {};

	

	$scope.listarFasesPorUnidade = function() {
		fasesService.listarFasesPorUnidade($scope.unidade.idUnidadeObra).success(function(data) {
			$scope.fase = data;
		}).error(function(error) {
			$log.error(error);
		});
	}
	 
	$scope.removerFase = function(fase){
		var deleteFase = $window
		.confirm('Tem certeza que gostaria de apagar a fase '
				+ fase.nomeFase + '?');

		if (deleteFase) {
			fasesService.removerFase(fase).success(
					function(data) {
						$scope.listarFasesPorUnidade();
					}).error(function(error) {
				$log.error(error);
			});
		} else{} 
	}
	
}]);
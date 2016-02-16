app.controller('UnidadesController', ['$scope', '$uibModal', '$log', 'unidadeService', '$window', '$location', '$stateParams',
                                      function($scope, $uibModal, $log, unidadeService, $window, $location, $stateParams) {
	
	$scope.obra = $stateParams;
	$scope.unidades = [];
	$scope.unidade = {};
	
	$scope.listarUnidadesPorObra = function() {
		unidadeService.listarUnidadesPorObra($scope.obra.idObra).success(function(data) {
			$scope.unidades = data;
		}).error(function(error) {
			$log.error(error);
		});
	}

	$scope.removerUnidade = function(unidade){
		var deleteUnidade = $window
		.confirm('Tem certeza que gostaria de apagar a unidade '
				+ unidade.nomeUnidade + '?');

		if (deleteUnidade) {
			unidadeService.removerUnidade(unidade).success(
					function(data) {
						$scope.listarUnidadesPorObra();
					}).error(function(error) {
				$log.error(error);
			});
		} else{} 
	}
	
	$scope.modalUnidadeUpdate = function(tamanho, unidadeSelecionada) {
		
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalUnidadesContent.html',
			controller : 'UnidadesInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				unidade : function() {
					return angular.copy(unidadeSelecionada);
				}
			}
		}); 

		modalInstance.result.then(
				function(selectedItem) {
					$scope.selected = selectedItem;
					$scope.listarUnidadesPorObra();
				}, function() {
					$log.info('Modal foi fechada em: '
							+ new Date());
				});
	};

	$scope.modalUnidadeEditUpdate = function(tamanho, unidadeSelecionada) {
		
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalUnidadesContentEdit.html',
			controller : 'UnidadesInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				unidade : function() {
					return angular.copy(unidadeSelecionada);
				}
			}
		}); 

		modalInstance.result.then(
				function(selectedItem) {
					$scope.selected = selectedItem;
					$scope.listarUnidadesPorObra();
				}, function() {
					$log.info('Modal foi fechada em: '
							+ new Date());
				});
	};
	
}]);
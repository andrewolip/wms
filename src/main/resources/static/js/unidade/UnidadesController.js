app.controller('UnidadesController',				[
						'$scope',
						'$uibModal',
						'$log',
						'unidadeService',
						'$window',
						'$location',
						'$stateParams',
						function($scope, $uibModal, $log, unidadeService,
								$window, $location, $stateParams) {

							$scope.obras = [];
							$scope.obra = $stateParams;
							$scope.unidades = [];

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
									unidadeService.apagarUnidade(unidade).success(
											function(data) {
												$scope.listarUnidadesPorObra();
											}).error(function(error) {
										$log.error(error);
									});
								} else{} 
							}
							
							// Abre a Modal ao clicar em 'Adicionar Unidade'
							$scope.modalUnidadeUpdate = function(tamanho, unidadeSelecionada) {
								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalUnidadesContent.html',
									controller : 'UnidadesInstanceController',
									size : tamanho,
									resolve : {
										obra : function() {
											return angular.copy(unidadeSelecionada);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											unidadeService.listarUnidadesPorObra($scope.obra.idObra);
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

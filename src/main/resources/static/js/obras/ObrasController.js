app.controller('ObrasController',				[
						'$scope',
						'$uibModal',
						'$log',
						'obrasService',
						'$window',
						'$location',
						'$stateParams',
						function($scope, $uibModal, $log, obrasService,
								$window, $location, $stateParams) {

							$scope.obras = [];
							$scope.obra = $stateParams;	

							$scope.listarObras = function() {
								obrasService.listarObras().success(
										function(data) {
											$scope.obras = data;
										});
							};

							$scope.removerObra = function(obra) {

								var deleteObra = $window
										.confirm('Tem certeza que gostaria de apagar a obra '
												+ obra.nome + '?');

								if (deleteObra) {
									obrasService.apagarObra(obra).success(
											function(data) {
												$scope.listarObras();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarObra = function(id) {
								obrasService.buscarObra(id).success(function(data) {
									$scope.obra = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Obra'
							$scope.modalObrasUpdate = function(size, selectedObra) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalObrasContent.html',
									controller : 'ObrasInstanceController',
									size : size,
									resolve : {
										obra : function() {
											return angular.copy(selectedObra);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarObras();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
							
							// Abre a Modal ao clicar em 'Adicionar Unidade'
							$scope.modalUnidadeUpdate = function(tamanho, unidadeSelecionada) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalUnidadesContent.html',
									controller : 'ObrasInstanceController',
									size : tamanho,
									resolve : {
										obra : function() {
											return unidadeSelecionada;
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

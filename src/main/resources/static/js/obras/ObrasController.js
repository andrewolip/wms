app
		.controller(
				'ObrasController',
				[
						'$scope',
						'$uibModal',
						'$log',
						'obrasService',
						'$window',
						'$location',
						'unidadeService',
						function($scope, $uibModal, $log, obrasService,
								$window, $location, unidadeService) {

							$scope.obra = {};
							$scope.obras = [];

							$scope.listarObras = function() {
								obrasService.listarObras().success(
										function(data) {
											$scope.obras = data;
										});
							};

							$scope.inserirObra = function(obra) {
								obrasService.inserirObra(obra).success(
										function() {
											$scope.obra = obra;
											obrasService.listarObras();
										}).error(function(error) {
									console(error);
								});
							}

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
							$scope.modalUpdate = function(size, selectedObra) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalObrasContent.html',
									controller : 'ObrasInstanceController',
									size : size,
									resolve : {
										obra : function() {
											return selectedObra;
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
						} ]);

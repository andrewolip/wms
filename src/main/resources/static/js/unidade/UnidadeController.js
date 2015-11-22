app.controller('UnidadesController',				[
						'$scope',
						'$uibModal',
						'$log',
						'obrasService',
						'$window',
						'$location',
						'unidadeService',
						'$stateParams',
						'$state',
						function($scope, $uibModal, $log, obrasService,
								$window, $location, unidadeService, $stateParams) {

							$scope.obra = {
								idObra: $stateParams.idObra,
								nome: $stateParams.nome
							};

							$scope.unidade = {};
							
							$scope.unidades = [];
							
						/*	var init = function() {
								obrasService.buscarObra($stateParams.idObra).success(function(data) {
									$scope.obra = data;
								});	
							}	

							init(); */
							
							$scope.listarUnidades = function() {
								unidadeService.listarUnidades().success(
										function(data) {
											$scope.unidades = data;
										});
							};

							$scope.salvarUnidade = function(unidade) {
								unidadeService.salvarUnidade(unidade).success(
										function() {
											$scope.unidade = unidade;
										}).error(function(error) {
									console(error);
								});
							}

							$scope.removerUnidade = function(unidade) {

								var deleteUnidade = $window
										.confirm('Tem certeza que gostaria de apagar a Unidade '
												+ unidade.nome + '?');

								if (deleteUnidade) {
									unidadeService.removerUnidade(unidade).success(
											function(data) {
												$scope.listarUnidades();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarUnidade = function(unidade) {
								unidadeService.buscarUnidade(unidade.idUnidade).success(function(data) {
									$scope.unidade = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Unidade'
							$scope.modalUpdate = function(tamanho, unidadeSelecionada) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalUnidadesContent.html',
									controller : 'UnidadesInstanceController',
									size : tamanho,
									resolve : {
										unidade : function() {
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
						} ]);

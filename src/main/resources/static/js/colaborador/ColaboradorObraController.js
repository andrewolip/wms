app.controller('ColaboradorObraController',				[
						'$scope',
						'$uibModal',
						'$log',
						'colaboradorService',
						'$window',
						'$location',
						'$stateParams',
						function($scope, $uibModal, $log, colaboradorService,
								$window, $location, $stateParams) {

							$scope.obra = $stateParams;
							$scope.colaborador = {};
							$scope.colaboradores = [];

							$scope.listarColaboradoresPorObra = function() {
								colaboradorService.listarColaboradoresPorObra($scope.obra.idObra).success(
										function(data) {
											$scope.colaboradores = data;
										});
							};
							
							$scope.inserirColaborador = function(colaborador) {
								colaborador.obra = $scope.obra;
								colaboradorService.inserirColaborador(colaborador).success(
										function() {
											$scope.colaborador = colaborador;
											colaboradorService.listarColaboradoresPorObra();
										}).error(function(error) {
									$log.info(error);
								});
							}

							$scope.removerColaborador = function(colaborador) {

								var deleteColaborador = $window
										.confirm('Tem certeza que gostaria de remover a colaborador '
												+ colaborador.nome + 'com nº de contrato ' + colaborador.numeroContrato + '?');

								if (deleteColaborador) {
									colaboradorService.removerColaborador(colaborador).success(
											function(data) {
												$scope.listarColaboradoresPorObra();
											}).error(function(error) {
										console(error);
									});
								}
							}
							
							$scope.buscarColaborador = function(id) {
								colaboradorService.buscarColaborador(id).success(function(data) {
									$scope.colaborador = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Colaborador'
							$scope.modalUpdateColaboradorObra = function(size, selectedColaborador) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalColaboradorObraContent.html',
									controller : 'ColaboradorObraInstanceController',
									size: size,
									backdrop: 'static',
									resolve: {
										colaborador : function() {
											return angular.copy(selectedColaborador);
										},
										obra : function() {
											return $scope.obra;
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarColaboradoresPorObra();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

app.controller('ColaboradorController',				[
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

							$scope.listarColaboradores = function() {
								colaboradorService.listarColaboradores().success(
										function(data) {
											$scope.colaboradores = data;
										});
							};
							
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
									console(error);
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
							$scope.modalUpdate = function(size, selectedColaborador) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalColaboradorContent.html',
									controller : 'ColaboradorInstanceController',
									size : size,
									resolve : {
										colaborador : function() {
											return angular.copy(selectedColaborador);
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

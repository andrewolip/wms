app.controller('ContaPagarController',				[
						'$scope',
						'$uibModal',
						'$log',
						'contaPagarService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, contaPagarService,
								$window, $location) {

							$scope.contaPagar = {};
							$scope.contasPagar = [];

							$scope.listarContasPagar = function() {
								contaPagarService.listarContasPagar().success(
										function(data) {
											$scope.contasPagar = data;
										});
							};
							
							$scope.removerContaPagar = function(contaPagar) {

								var deleteContaPagar = $window
										.confirm('Tem certeza que gostaria de remover a conta a pagar '
												+ contaPagar.nome + '?');

								if (deleteContaPagar) {
									contaPagarService.removerContaPagar(contaPagar).success(
											function(data) {
												$scope.listarContasPagar();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarContaPagar = function(id) {
								contaPagarService.buscarContaPagar(id).success(function(data) {
									$scope.contaPagar = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Conta a Pagar'
							$scope.modalUpdate = function(size, selectedContaPagar) {
								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalContaPagarContent.html',
									controller : 'ContaPagarInstanceController',
									size : size,
									resolve : {
										contaPagar : function() {
											return angular.copy(selectedContaPagar);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarContasPagar();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

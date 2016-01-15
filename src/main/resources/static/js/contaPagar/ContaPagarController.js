app.controller('ContaPagarController',   [ 	'$scope',
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
										.confirm('Tem certeza que gostaria de remover a conta a pagar ?');

								if (deleteContaPagar) {
									contaPagarService.removerContaPagar(contaPagar).success(
											function(data) {
												$scope.listarContasPagar();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							// Abre a Modal ao clicar em 'Adicionar Conta a Pagar'
							$scope.modalUpdate = function(tamanho, contaPagarSelecionada) {
								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalContaPagarContent.html',
									controller : 'ContaPagarInstanceController',
									size : tamanho,
									resolve : {
										contaPagar : function() {
											return angular.copy(contaPagarSelecionada);
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
							
							
//							Botão Adicionar Fornecedor a partir da tela de cadastro de conta a pagar
//							
//							$scope.addFornecedor = function(size, selectedFornecedor) {
//								var modalInstance = $uibModal.open({
//									templateUrl : 'pages/templates/modalFornecedorContent.html',
//									controller : 'FornecedorInstanceController',
//									size : size,
//									resolve : {
//										contaPagar : function() {
//											return angular.copy(selectedFornecedor);
//										}
//									}
//								});
//							};
							
							
//							$scope.listarContasPagarPorObra = function() {
//								console.log("listar contas por obra");
//								contaPagarService.listarPorObra($scope.obraAtual).success(
//										function(data) {
//											$scope.contasPagar = data;
//										});
//							};
							
//							$scope.listarContasPagarPorUnidade = function() {
//								console.log("listar contas por unidade");
//								contaPagarService.listarPorUnidade($scope.unidadeAtual).success(
//										function(data) {
//											$scope.contasPagar = data;
//										});
//							};
}]);

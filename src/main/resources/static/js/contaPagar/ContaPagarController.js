app.controller('ContaPagarController',				[
						'$scope',
						'$uibModal',
						'$log',
						'contaPagarService',
						'obrasService',
						'unidadeService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, contaPagarService,
								$window, $location) {

							$scope.contaPagar = {};
							$scope.contasPagar = [];
							$scope.obras = [];
							$scope.unidades = [];

							$scope.listarContasPagar = function() {
								console.log("listar contas sem filtro");
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
							
							$scope.addFornecedor = function(size, selectedFornecedor) {
								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalFornecedorContent.html',
									controller : 'FornecedorInstanceController',
									size : size,
									resolve : {
										contaPagar : function() {
											return angular.copy(selectedFornecedor);
										}
									}
								});
							};
							
							$scope.listarObras = function() {
								contaPagarService.listarObras().success(
										function(data) {
											$scope.obras = data;
										});
							};
							
							$scope.obraAtual = $scope.obras[0];
							$scope.listarUnidadesPorObra = function() {
								contaPagarService.listarUnidadesPorObra($scope.obraAtual.idObra).success(function(data) {
									$scope.unidades = data;
								}).error(function(error) {
									$log.error(error);
								});
								
								console.log("listou Unidades por obra");
								$scope.listarContasPagarPorObra();
								console.log("chamou listar contas por obra");
							};
							
							$scope.listarContasPagarPorObra = function() {
								console.log("listar contas por obra");
								contaPagarService.listarPorObra($scope.obraAtual).success(
										function(data) {
											$scope.contasPagar = data;
										});
							};
							
							$scope.listarContasPagarPorUnidade = function() {
								console.log("listar contas por unidade");
								contaPagarService.listarPorUnidade($scope.unidadeAtual).success(
										function(data) {
											$scope.contasPagar = data;
										});
							};
}]);

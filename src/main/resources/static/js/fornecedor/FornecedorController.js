app.controller('FornecedorController',				[
						'$scope',
						'$uibModal',
						'$log',
						'fornecedorService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, fornecedorService,
								$window, $location) {

							$scope.fornecedor = {};
							$scope.fornecedores = [];
							$scope.allFornecedores = [];

							$scope.listarFornecedores = function() {
								$scope.fornecedores = [];
								fornecedorService.listarFornecedores().success(
									function(data) {
										$scope.allFornecedores = data;
										
										for(var i=0; i < $scope.allFornecedores.length; i++) {
											if($scope.allFornecedores[i].ativo == true) {
												$scope.fornecedores.push($scope.allFornecedores[i]);
											}
										}
									});
							};
							
							$scope.removerFornecedor = function(fornecedor) {

								var deleteFornecedor = $window
										.confirm('Tem certeza que gostaria de remover o fornecedor '
												+ fornecedor.nome + '?');

								if (deleteFornecedor) {
									fornecedor.ativo = false;
									fornecedorService.removerFornecedor(fornecedor).success(
											function(data) {
												$scope.listarFornecedores();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarFornecedor = function(id) {
								fornecedorService.buscarFornecedor(id).success(function(data) {
									$scope.fornecedor = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Fornecedor'
							$scope.modalUpdate = function(size, selectedFornecedor) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalFornecedorContent.html',
									controller : 'FornecedorInstanceController',
									size : size,
									resolve : {
										fornecedor : function() {
											return angular.copy(selectedFornecedor);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarFornecedores();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

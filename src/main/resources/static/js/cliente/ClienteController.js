app.controller('ClienteController',				[
						'$scope',
						'$uibModal',
						'$log',
						'clienteService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, clienteService,
								$window, $location) {

							$scope.cliente = {};
							$scope.clientes = [];

							$scope.listarClientes = function() {
								clienteService.listarClientes().success(
										function(data) {
											$scope.clientes = data;
										});
							};
							
							$scope.removerCliente = function(cliente) {

								var deleteCliente = $window
										.confirm('Tem certeza que gostaria de remover o cliente '
												+ cliente.nomeFantasia + '?');

								if (deleteCliente) {
									clienteService.removerCliente(cliente).success(
											function(data) {
												$scope.listarClientes();
											}).error(function(error) {
												console.log(error);
									});
								}
							}
							
							$scope.buscarCliente = function(id) {
								clienteService.buscarCliente(id).success(function(data) {
									$scope.cliente = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Cliente'
							$scope.modalUpdate = function(size, selectedCliente) {
								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalClienteContent.html',
									controller : 'ClienteInstanceController',
									size : size,
									backdrop: 'static',
									resolve : {
										cliente : function() {
											return angular.copy(selectedCliente);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarClientes();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

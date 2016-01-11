app.controller('UsuarioController',				[
						'$scope',
						'$uibModal',
						'$log',
						'usuarioService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, usuarioService,
								$window, $location) {

							$scope.usuario = {};
							$scope.usuarios = [];
//							$scope.allUsuarios = []; // lista auxiliar para usuarios desativados

							$scope.listarUsuarios = function() {
								usuarioService.listarUsuarios().success(
										function(data) {
											$scope.usuarios = data;
										});
								
								// Usuários não podem ser exluidos, então seriam desativados
//								$scope.usuarios = [];
//								usuarioService.listarUsuarios().success(
//									function(data) {
//										$scope.allUsuarios = data;
//										
//										for(var i=0; i < $scope.allUsuarios.length; i++) {
//											if($scope.allUsuarios[i].ativo == true) {
//												$scope.usuarios.push($scope.allUsuarios[i]);
//											}
//										}
//									});
							};
							
							$scope.listarCoordenadores = function() {
								usuarioService.listarCoordenadores().success(
									function(data) {
										$scope.usuarios = data;
										$log.info($scope.usuarios);
									});
							};
							
							$scope.removerUsuario = function(usuario) {

								var deleteUsuario = $window
										.confirm('Tem certeza que gostaria de remover o usuário '
												+ usuario.nome + '?');

								if (deleteUsuario) {
									usuario.ativo = false;
									usuarioService.removerUsuario(usuario).success(
											function(data) {
												$scope.listarUsuarios();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarUsuario = function(id) {
								usuarioService.buscarUsuario(id).success(function(data) {
									$scope.usuario = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Usuario'
							$scope.modalUpdate = function(size, selectedUsuario) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalUsuarioContent.html',
									controller : 'UsuarioInstanceController',
									size : size,
									resolve : {
										usuario : function() {
											return angular.copy(selectedUsuario);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarUsuarios();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

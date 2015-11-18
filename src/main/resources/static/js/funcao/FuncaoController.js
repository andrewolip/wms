app.controller('FuncaoController',				[
						'$scope',
						'$uibModal',
						'$log',
						'funcaoService',
						'$window',
						'$location',
						function($scope, $uibModal, $log, funcaoService,
								$window, $location) {

							$scope.funcao = {};
							$scope.funcoes = [];

							$scope.listarFuncoes = function() {
								funcaoService.listarFuncoes().success(
										function(data) {
											$scope.funcoes = data;
										});
							};
							
							$scope.inserirFuncao = function(funcao) {
								funcaoService.inserirFuncao(funcao).success(
										function() {
											$scope.funcao = funcao;
											funcaoService.listarFuncoes();
										}).error(function(error) {
									console(error);
								});
							}

							$scope.removerFuncao = function(funcao) {

								var deleteFuncao = $window
										.confirm('Tem certeza que gostaria de remover a função '
												+ funcao.nome + '?');

								if (deleteFuncao) {
									funcaoService.removerFuncao(funcao).success(
											function(data) {
												$scope.listarFuncoes();
											}).error(function(error) {
										console(error);
									});
								} else{}
							}
							
							$scope.buscarFuncao = function(id) {
								funcaoService.buscarFuncao(id).success(function(data) {
									$scope.funcao = data;
								}).error(function(msg) {
									$log.info(msg);
								});
							}
							
							// Abre a Modal ao clicar em 'Adicionar Funcao'
							$scope.modalUpdate = function(size, selectedFuncao) {

								var modalInstance = $uibModal.open({
									templateUrl : 'pages/templates/modalFuncaoContent.html',
									controller : 'FuncaoInstanceController',
									size : size,
									resolve : {
										funcao : function() {
											return angular.copy(selectedFuncao);
										}
									}
								});

								modalInstance.result.then(
										function(selectedItem) {
											$scope.selected = selectedItem;
											$scope.listarFuncoes();
										}, function() {
											$log.info('Modal foi fechada em: '
													+ new Date());
										});
							};
}]);

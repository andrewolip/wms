app.controller('UnidadeController', [ '$scope', '$uibModal', '$log',
		'unidadeService', 'obrasService', '$routeParams',
		function($scope, $uibModal, $log, unidadeService, obrasService, $routeParams) {
	
			$scope.unidade = {};
			$scope.unidades = [];
			
			$scope.salvarUnidade = function(unidade) {
				unidadeService.salvarUnidade(unidade).success(function(data) {
					$scope.unidade = data;
				});
			}
			
			$scope.atualizarUnidade = function(unidade) {
				unidadeService.atualizarUnidade(unidade).success(function(data) {
					$scope.unidade = data;
				});
			}
			
			$scope.buscarUnidade = function(unidade) {
				unidadeService.buscarUnidade(unidade).success(function(data) {
					$scope.unidade = unidade;
				});
			}
			
			$scope.listarUnidade = function() {
				unidadeService.listarUnidades().success(function(data) {
					$scope.unidades = data;
				});
			}

			$scope.modalUpdate = function(size, selectedUnidade) {

				var modalInstance = $uibModal.open({
					templateUrl : 'pages/templates/modalUnidadesContent.html',
					controller : 'UnidadesInstanceController',
					size : size,
					resolve : {
						unidade : function() {
							return selectedUnidade;
						}
					}
				});

				modalInstance.result.then(function(selectedItem) {
					$scope.selected = selectedItem;
				}, function() {
					$log.info('Modal foi fechada em: ' + new Date());
				});
			};

		} ]);
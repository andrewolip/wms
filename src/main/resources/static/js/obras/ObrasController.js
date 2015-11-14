app.controller('ObrasController', [ '$scope', '$uibModal', '$log',
		'obrasService', function($scope, $uibModal, $log, obrasService) {

			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				obrasService.listarObras().success(function(data) {
					$scope.obras = data;
				});
			};

			$scope.inserirObra = function(obra) {
				obrasService.inserirObra(obra).success(function() {
					$scope.obra = obra;
					obrasService.listarObras();
				}).error(function(error) {
					console(error);
				});
			}

			$scope.apagarObra = function(obra) {
				obrasService.apagarObra(obra).success(function(data) {
					$scope.listarObras();
				}).error(function(error) {
					console(error);
				});
			}

			// Abre a Modal ao clicar em 'Adicionar Obra'
			$scope.modalUpdate = function(size, selectedObra) {

				var modalInstance = $uibModal.open({
					templateUrl : 'modalObrasContent.html',
					controller : 'ObrasInstanceController',
					size : size,
					resolve : {
						obra : function() {
							return selectedObra;
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


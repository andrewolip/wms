app.controller('ObrasController', [ '$scope', '$http', '$uibModal', '$log',
		'obraService', function($scope, $http, $uibModal, $log, obraService) {

			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				obraService.listarObras().success(function(data) {
					$scope.obras = data;
				});
			};

			$scope.inserirObra = function(obra) {
				obraService.inserirObra(obra).success(function() {
					$scope.obra = obra;
				}).error(function(error) {
					console(error);
				});
			}

			$scope.apagarObra = function(obra) {
				obraService.apagarObra(obra).success(function(data) {
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

app.controller('ObrasInstanceController', function($scope, $http,
		$uibModalInstance, $log, obra) {
	$scope.obra = obra;

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(obra) {
		$http.put('/obras/atualizar', obra).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});

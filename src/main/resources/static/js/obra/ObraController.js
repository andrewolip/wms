app.controller('ObraController', [
		'$scope',
		'$http',
		'$uibModal',
		'$log',
		function($scope, $http, $uibModal, $log) {

			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				$http.get('/obras/listar', {}).then(
						function(response) {
							$scope.obras = response.data;
				});
			};

			$scope.apagarObra = function(obra) {
				$http({
					url : '/obras/apagar/' + obra.idObra,
					method : 'DELETE',
					data : obra,
					headers : {
						"Content-Type" : "application/json;charset=utf-8"
					}
				}).success(function(data) {
					$scope.listarObras();
				}, function(error) {
					console.log(error);
				});
			};

			// Abre a Modal ao clicar em 'Adicionar Obra'
			$scope.modalUpdate = function (size, selectedObra) {

			    var modalInstance = $uibModal.open({
			      templateUrl: 'modalObraContent.html',
			      controller: 'ObraInstanceController',
			      size: size,
			      resolve: {
			    	  obra: function () {
			          return selectedObra;
			        }
			      }
			    });

			    modalInstance.result.then(function (selectedItem) {
			      $scope.selected = selectedItem;
			    }, function () {
			      $log.info('Modal foi fechada em: ' + new Date());
			    });
			  };
		} ]);


app.controller('ObraInstanceController', function($scope, $http, $uibModalInstance, $log, obra) {
	$scope.obra = obra;
	
	$scope.cancelar = function () {
	    $uibModalInstance.dismiss('cancelar');
	 };
	 
	 $scope.atualizar = function (obra) {
		 $http.put('/obras/atualizar', obra)
			.success(function(data) {
				$uibModalInstance.close();
			}).error(function(error) {
				resultado = error.Message;
			});
	 };
});

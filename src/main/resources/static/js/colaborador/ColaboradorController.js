app.controller('ColaboradorController', [
		'$scope',
		'$http',
		'$uibModal',
		'$log',
		function($scope, $http, $uibModal, $log) {

			$scope.colaborador = {};
			$scope.colaboradores = [];

			$scope.listarColaboradores = function() {
				$http.get('/colaboradores/listar', {}).then(
						function(response) {
							$scope.colaboradores = response.data;
				});
			};

			$scope.apagarColaborador = function(colaborador) {
				$http({
					url : '/colaboradores/apagar/' + colaborador.idColaborador,
					method : 'DELETE',
					data : colaborador,
					headers : {
						"Content-Type" : "application/json;charset=utf-8"
					}
				}).success(function(data) {
					$scope.listarColaboradores();
				}, function(error) {
					console.log(error);
				});
			};

			// Abre a Modal ao clicar em 'Adicionar Colaborador'
			$scope.modalUpdate = function (size, selectedColaborador) {

			    var modalInstance = $uibModal.open({
			      templateUrl: 'modalColaboradorContent.html',
			      controller: 'ColaboradorInstanceController',
			      size: size,
			      resolve: {
			    	  colaborador: function () {
			          return selectedColaborador;
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


app.controller('ColaboradorInstanceController', function($scope, $http, $uibModalInstance, $log, colaborador) {
	$scope.colaborador = colaborador;
	
	$scope.cancelar = function () {
	    $uibModalInstance.dismiss('cancelar');
	 };
	 
	 $scope.atualizar = function (colaborador) {
		 console.log(colaborador);
		 $http.put('/colaboradores/atualizar', colaborador)
			.success(function(data) {
				$uibModalInstance.close();
			}).error(function(error) {
				resultado = error.Message;
			});
	 };
});

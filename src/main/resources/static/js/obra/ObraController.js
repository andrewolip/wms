app.controller('ObraController', [
		'$scope',
		'$http',
		'$uibModal',
		function($scope, $http, $uibModal) {

			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				$http.get('http://localhost:8080/obras/listar', {}).then(
						function(response) {
							$scope.obras = response.data;
				});
			};

			$scope.apagarObra = function(obra) {
				$http({
					url : 'http://localhost:8080/obras/apagar/' + obra.idObra,
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

			$scope.editarObra = function(obra) {
				console.log(obra.nome);
			}
			
			// Abre a Modal ao clicar em 'Adicionar Obra'
			$scope.open = function () {
			    var modalInstance = $uibModal.open({
			      templateUrl: 'modalObraContent.html',
			      controller: 'ObraController',
			      scope: $scope
			    });
			  };
			  
			 $scope.inserir = function (obra) {
				 $http.post('http://localhost:8080/obras/inserir', obra)
					.success(function(data) {
						delete $scope.obra;
						$scope.obraForm.$setPristine();
					}).error(function(error) {
						resultado = error.Message;
					});
			  };
			  
		} ]);

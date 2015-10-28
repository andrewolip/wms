app.controller('ObraController', [ '$scope', '$http', '$uibModal',
		function($scope, $http, $uibModal) {
	
			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				$http.get('http://localhost:8080/obras/listar', {}).then(function(response) {
					$scope.obras = response.data;
		    	});
				console.log("A lista é: " + $scope.obras);
			};

			$scope.salvarObra = function(obra) {
				
				$http.post('http://localhost:8080/obras/inserir', obra).then(function(success) {
					$scope.tableParams.reload();
		        }).error(function(error) {
		        	resultado = error.Message;
		        });
			};
			
			$scope.apagarObra = function(obra) {
				
			        $http({ url: 'http://localhost:8080/obras/apagar/' + obra.idObra, 
			                method: 'DELETE', 
			                data: obra, 
			                headers: {"Content-Type": "application/json;charset=utf-8"}
			        }).then(function(res) {
			        	$scope.tableParams.reload();
			            console.log(res.data);
			        }, function(error) {
			            console.log(error);
			        });
			   };
			
			$scope.editarObra = function(obra) {
				console.log(obra.nome);
			}
			
			$scope.open = function(obra) {

				$uibModal.open({
					templateUrl : 'modalObraContent.html',
					backdrop : true,
					windowClass : 'modal',
					controller : 'ObraController',
					resolve : {
						obra : function() {
							return $scope.obra;
						}
					}
				});
			};				
	} ]);

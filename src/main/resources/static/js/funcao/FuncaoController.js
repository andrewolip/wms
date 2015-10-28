app.controller('ObraController', [ '$scope', '$http', '$uibModal',
		function($scope, $http, $uibModal) {
	
			$scope.funcao = {};
			$scope.funcoes = [];

			$scope.listarFuncoes = function() {
				$http.get('http://localhost:8080/funcoes/listar', {}).then(function(response) {
					$scope.funcoes = response.data;
		    	});
			};

			$scope.salvarObra = function(funcao) {
				
				$http.post('http://localhost:8080/funcoes/inserir', funcao).then(function(success) {
					$scope.tableParams.reload();
		        }).error(function(error) {
		        	resultado = error.Message;
		        });
			};
			
			$scope.apagarObra = function(funcao) {
				
			        $http({ url: 'http://localhost:8080/funcoes/apagar/' + funcao.idObra, 
			                method: 'DELETE', 
			                data: funcao, 
			                headers: {"Content-Type": "application/json;charset=utf-8"}
			        }).then(function(res) {
			        	$scope.tableParams.reload();
			            console.log(res.data);
			        }, function(error) {
			            console.log(error);
			        });
			   };
			
			$scope.editarObra = function(funcao) {
				console.log(funcao.nome);
			}
			
			$scope.open = function(funcao) {

				$uibModal.open({
					templateUrl : 'modalObraContent.html',
					backdrop : true,
					windowClass : 'modal',
					controller : 'ObraController',
					resolve : {
						funcao : function() {
							return $scope.funcao;
						}
					}
				});
			};				
	} ]);

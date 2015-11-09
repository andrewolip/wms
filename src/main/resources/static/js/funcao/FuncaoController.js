app.controller('FuncaoController', [
		'$scope',
		'$http',
		'$uibModal',
		'$log',
		function($scope, $http, $uibModal, $log) {

			$scope.funcao = {};
			$scope.funcoes = [];

			$scope.listarFuncoes = function() {
				$http.get('/funcoes/listar', {}).then(
						function(response) {
							$scope.funcoes = response.data;
				});
			};

			$scope.apagarFuncao = function(funcao) {
				$http({
					url : '/funcoes/apagar/' + funcao.idFuncao,
					method : 'DELETE',
					data : funcao,
					headers : {
						"Content-Type" : "application/json;charset=utf-8"
					}
				}).success(function(data) {
					$scope.listarFuncoes();
				}, function(error) {
					console.log(error);
				});
			};

			// Abre a Modal ao clicar em 'Adicionar Funcao'
			$scope.modalUpdate = function (size, selectedFuncao) {

			    var modalInstance = $uibModal.open({
			      templateUrl: 'modalFuncaoContent.html',
			      controller: 'FuncaoInstanceController',
			      size: size,
			      resolve: {
			    	  funcao: function () {
			          return selectedFuncao;
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


app.controller('FuncaoInstanceController', function($scope, $http, $uibModalInstance, $log, funcao) {
	$scope.funcao = funcao;
	
	$scope.cancelar = function () {
	    $uibModalInstance.dismiss('cancelar');
	 };
	 
	 $scope.atualizar = function (funcao) {
		 $http.put('/funcoes/atualizar', funcao)
			.success(function(data) {
				$uibModalInstance.close();
			}).error(function(error) {
				resultado = error.Message;
			});
	 };
});

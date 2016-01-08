app.controller('ObrasInstanceController', function($scope,
		$uibModalInstance, $log, obrasService, unidadeService, buscaCepService, obra, $stateParams) {

	$scope.obra = obra;
	$scope.unidade = {};
	$scope.unidade.obra = $stateParams;
	
	$scope.buscarCep = function(localizacao) {
		buscaCepService.buscarCep(localizacao).success(function(data, status){
			$scope.obra.localizacao = data;
		}); 
	}

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizarObra = function(obra) {
		obrasService.atualizarObra(obra).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
	
	$scope.salvarUnidade = function(unidade) {
		
		unidadeService.salvarUnidadeObra(unidade).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});  
		
	}
});
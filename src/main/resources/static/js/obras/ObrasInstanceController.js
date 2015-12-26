app.controller('ObrasInstanceController', function($scope,
		$uibModalInstance, $log, obrasService, buscaCepService, obra, $stateParams) {

	$scope.obra = obra;
	
	$scope.buscarCep = function(localizacao) {
		buscaCepService.buscarCep(localizacao).success(function(data, status){
			$scope.obra.localizacao = data;
		}); 
	}

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atribuirUnidadeAObra = function(unidade) {
		$scope.obra = $stateParams;
		$scope.obra.unidades.push(unidade);
		
		$scope.atualizarObra($scope.obra);
	}
	
	$scope.atualizarObra = function(obra) {
		obrasService.atualizarObra(obra).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
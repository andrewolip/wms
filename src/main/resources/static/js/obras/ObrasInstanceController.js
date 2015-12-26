app.controller('ObrasInstanceController', function($scope,
		$uibModalInstance, $log, obrasService, buscaCepService, obra) {

	$scope.obra = obra;
	
	$scope.buscarCep = function(localizacao) {
		buscaCepService.buscarCep(localizacao).success(function(data, status){
			$scope.obra.localizacao = data;
		}); 
	}

	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(obra) {
		//$log.info(obra.localizacao.localidade);

		obrasService.atualizarObra(obra).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
});
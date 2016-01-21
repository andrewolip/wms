app.controller('ContaPagarInstanceController', [ '$scope', 
                                 				'$uibModalInstance', 
                                				'$uibModal',
                                				'$log', 
                                				'contaPagarService', 
                                				'contaPagar', 
                                				'obrasService', 
                                				'unidadeService',
		function($scope, 
				$uibModalInstance, 
				$uibModal,
				$log, 
				contaPagarService, 
				contaPagar, 
				obrasService, 
				unidadeService) {
	
	$scope.contaPagar = contaPagar;
	$scope.obras = [];
	$scope.unidades = [];
	$scope.obraAtual = {};
	
	//DatePicker
	$scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];
	$scope.altInputFormats = ['dd-MM-yyyy'];
	$scope.maxDate;
	$scope.minDate;
	
	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};

	$scope.atualizar = function(contaPagar) {
		contaPagarService.atualizarContaPagar(contaPagar).success(function(data) {
			$uibModalInstance.close();
		}).error(function(error) {
			resultado = error.Message;
		});
	};
	
	$scope.listarObras = function() {
		obrasService.listarObras().success(
			function(data) {
				$scope.obras = data;
			}).error(function(error) {
				$log.error(error);
			});
	};
	
	$scope.listarUnidadesPorObra = function() {
		if($scope.obraAtual) {
			unidadeService.listarUnidadesPorObra($scope.obraAtual.idObra).success(
				function(data) {
					$scope.unidades = data;
				}).error(function(error) {
					$log.error(error);
				});
		}
	}
	
	$scope.$watch('contaPagar.obra', function(obra){
		$scope.obraAtual = obra;
		console.log($scope.obraAtual);
		console.log(obra);
		
		if(!$scope.contaPagar.unidade) {
			$scope.listarUnidadesPorObra();
		} else {
			unidadeAtual = $scope.contaPagar.unidade; 
		}
		
		if($scope.obraAtual == null) {
			$scope.contaPagar.unidadeObra = null;
			$scope.unidades = [];
		}
	});
	
	$scope.$watch('unidadeAtual', function(unidade){
		$scope.contaPagar.unidade = unidade;
	});
	
	$scope.dataVencimento = {
			aberto: false
	};
	
	$scope.abrirDataVencimento = function() {
		  $scope.dataVencimento.aberto = true;
	};
	
	$scope.modalUpdateItemConta = function(tamanho, itemContaSelecionado) {
		console.log("abrindo edit item");
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalItemContaContent.html',
			controller : 'ItemContaInstanceController',
			size : tamanho,
			resolve : {
				itemConta : function() {
					return angular.copy(itemContaSelecionado);
				}
			}
		});

//		modalInstance.result.then(
//				function(selectedItem) {
//					$scope.selected = selectedItem;
//					$scope.listarItensConta();
//				}, function() {
//					$log.info('Modal foi fechada em: '
//							+ new Date());
//				});
	};
}]);
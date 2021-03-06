app.controller('ContaPagarInstanceController', function($scope, 
		$uibModalInstance, $uibModal, $log, contaPagarService, itensContaService, contaPagar, obrasService, unidadeService, $window) {
	
	$scope.contaPagar = contaPagar;
	$scope.itensConta = contaPagarService.itensConta;
	$scope.obras = [];
	$scope.unidades = [];
	$scope.obraAtual = {};
	$scope.submitted = false;
	
	
	//DatePicker
	$scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];
	$scope.altInputFormats = ['dd-MM-yyyy'];
	$scope.maxDate;
	$scope.minDate;
	
	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
		for ( var item in $scope.itensConta) {
			$scope.itensConta.splice(0, $scope.itensConta.length);
		}
	};
	
	$scope.$watch('contaPagar', function(contaPagar){
		if(!contaPagar) {
			$scope.contaPagar = {};
			$scope.itensConta = [];
		} else {
			$scope.listarItensPorConta();
		}
	});
	
	$scope.atualizar = function(contaPagar, itensConta) {
		$scope.calcularValorConta();
		contaPagar.status = 1;
		contaPagarService.salvarContaPagar(contaPagar).then(function(response) {
			if(itensConta.length > 0) {
				for (var i=0; i < itensConta.length; i++) {
					itensConta[i].contaPagar = response.data;
				}
		
				itensContaService.salvarLista(itensConta).success(function(data) {
					 $log.info(itensConta);
				}).error(function(error) {
					$log.info(error);
				}); 
			}
		},
		function(error) {
			$log.info(error);
		});
		
		
		setTimeout(continueExecution, 300);
		
		function continueExecution() {
			$uibModalInstance.close();
			
		}
	};
	
	
	
	$scope.listarObras = function() {
		obrasService.listarObras().success(
			function(data) {
				$scope.obras = data;
			}).error(function(error) {
				$log.error(error);
			});
	};

	// Para popular a combobox Unidade da Obra na modalContaPagar
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
		
		if($scope.contaPagar) {
			if(!$scope.contaPagar.unidade) {
				$scope.listarUnidadesPorObra();
			} else {
				unidadeAtual = $scope.contaPagar.unidade; 
			}
				
			if(!$scope.obraAtual) {
				$scope.contaPagar.unidadeObra = null;
				$scope.unidades = [];
			}
		}
	});
	
	$scope.$watch('unidadeAtual', function(unidade){
		if(unidade) {
			$scope.contaPagar.unidade = unidade;
		}
	});
	
	$scope.dataVencimento = {
			aberto: false
	};
	
	$scope.abrirDataVencimento = function() {
		  $scope.dataVencimento.aberto = true;
	};
	
	$scope.adicionarItem = function() {
		var itemConta = {
				nome: "",
				quantidade: null,
				valorUnitario: null,
				unidade: "",
				isEdited: true
		};
		$scope.itensConta.push(itemConta);
		$scope.calcularValorConta();
	};
	
	
	
	$scope.listarItensPorConta = function() {
		if(contaPagar) {
			itensContaService.listarItensPorConta(contaPagar.idContaPagar).then(function(response) {
				$scope.itensConta = response.data;
			}, function(error) {
				$log.error(error);
			});
		}
	}
	
	$scope.removerItem = function(itemConta) {
		if(!itemConta.idItem) {
			$scope.removerItemContaArray(itemConta);
		} else {
			$scope.removerItemContaBD(itemConta);
		}
		$scope.calcularValorConta();
	}
	
	$scope.removerItemContaArray = function(itemConta) {
		var deleteItem = $window
			.confirm('Tem certeza que gostaria de apagar o item '
				+ itemConta.nome + '?');

		if(deleteItem) {
			$scope.deleteItem(itemConta);
		}
	}
	
	$scope.deleteItem = function(itemConta) {
		var i;
		for (i = 0; i < $scope.itensConta.length; i++) {
			if ($scope.itensConta[i] == itemConta) {
				break;
			}
		}
		$scope.itensConta.splice(i, 1);
	}
	
	$scope.removerItemContaBD = function(itemConta) {
		var deleteItem = $window.confirm('Tem certeza que deseja remover o Item ' + itemConta.nome + ' do Banco de Dados?');
		if(deleteItem) {
			$scope.deleteItem(itemConta);
			itensContaService.removerItemConta(itemConta).success(function(data) {
			
		}).error(function(error) {
			$log.error(error);
		});
		}	
	};
	
	$scope.calcularValorConta = function() {
		$scope.contaPagar.valorConta = 0.0;
		for ( var item in $scope.itensConta) {
			$scope.contaPagar.valorConta += ($scope.itensConta[item].valorUnitario * $scope.itensConta[item].quantidade);
			console.log($scope.itensConta[item]);
		}
	};
});
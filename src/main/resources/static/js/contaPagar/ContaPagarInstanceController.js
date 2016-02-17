app.controller('ContaPagarInstanceController', function($scope, 
		$uibModalInstance, $uibModal, $log, contaPagarService, contaPagar, obrasService, unidadeService, $window) {
	
	$scope.contaPagar = contaPagar;
	$scope.itensConta = contaPagarService.itensConta;
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
	
	$scope.$watch('contaPagar', function(contaPagar){
		debugger;
		if(!contaPagar) {
			$scope.contaPagar = {};
		} else {
			$scope.listarItensConta();
		}
	});

	$scope.atualizar = function(contaPagar) {
		contaPagar.itensConta = $scope.itensConta;
		
		contaPagarService.atualizarContaPagar(contaPagar).success(function(data) {
			$uibModalInstance.close();
			$scope.itensConta = [];
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
	
	$scope.calcularValorConta = function() {
		$scope.contaPagar.valorConta = 0.0;
		for ( var item in $scope.itensConta) {
			$scope.contaPagar.valorConta += ($scope.itensConta[item].valorUnitario * $scope.itensConta[item].quantidade);
			console.log($scope.itensConta[item]);
		}
	};

	$scope.removerItem = function(itemConta) {
		var deleteItem = $window
		.confirm('Tem certeza que gostaria de apagar o item '
			+ itemConta.nome + '?');

		if (deleteItem) {
			var i = 0;
			for (var i in $scope.itensConta) {
				if ($scope.itensConta[i] == itemConta)
					break;
				i++;
			}
			
			$scope.itensConta.splice(i, 1);
			$scope.calcularValorConta();
		}
	};
	
	$scope.listarItensConta = function() {
		debugger;
		$scope.itensConta = contaPagarService.listarItensConta($scope.contaPagar.idContaPagar);
	}
});
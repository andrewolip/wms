app.controller('ContaPagarController',   [ 	'$scope', '$uibModal', '$log', 'contaPagarService', '$window',	'$location', '$stateParams',
                                           	function($scope, $uibModal, $log, contaPagarService, $window, $location, $stateParams) {

	$scope.obra = $stateParams;
	$scope.contaPagar = {};
	$scope.contasPagar = [];

	$scope.listarContasPagarPorObra = function() {
		contaPagarService.listarPorObra($scope.obra.idObra).success(
				function(data) {
					$scope.contasPagar = data;
				});
	};

	$scope.listarContasNaoPagasPorObra = function() {
		contaPagarService.listarContasNaoPagasPorObra($scope.obra.idObra).success(function(response) {
			$scope.contasPagar = response;

			$log.info($scope.contasPagar);
			
		}).error(function(error) {
			$log.error(error);
		});		
	}

	$scope.removerContaPagar = function(contaPagar) {

		var deleteContaPagar = $window
		.confirm('Tem certeza que gostaria de remover a conta a pagar ?');

		if (deleteContaPagar) {
			contaPagarService.removerContaPagar(contaPagar).success(
					function(data) {
						$scope.listarContasPagarPorObra();
					}).error(function(error) {
						console(error);
					});
		}
	}

	// Abre a Modal ao clicar em 'Adicionar Conta a
	// Pagar'
	$scope.modalContaPagarUpdate = function(tamanho, contaPagarSelecionada) {
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalContaPagarContent.html',
			controller : 'ContaPagarInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				contaPagar : function() {
					return angular.copy(contaPagarSelecionada);
				}
			}
		});

		modalInstance.result.finally(
				function() {
					$scope.listarContasPagarPorObra();
				}
		);
	};

	$scope.modalLancamentoContaPagar = function(tamanho, contaSelecionada) {
		
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalLancamentoContent.html',
			controller : 'LancamentoInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				contaPagar : function() {
					return angular.copy(contaSelecionada);
				}
			}
		}); 
		
		modalInstance.result.then(
				function(selectedItem) {
					$scope.selected = selectedItem;
				//	$scope.listarUnidadesPorObra($scope.obra.idObra);
					$scope.listarContasPagarPorObra();
				}, function() {
					$log.info('Modal foi fechada em: '
							+ new Date());
				});
	};

	$scope.modalEstornoContaPagar = function(tamanho, contaSelecionada) {
		
		var modalInstance = $uibModal.open({
			templateUrl : 'pages/templates/modalEstornoContent.html',
			controller : 'EstornoInstanceController',
			size : tamanho,
			backdrop: 'static',
			resolve : {
				contaPagar : function() {
					return angular.copy(contaSelecionada);
				}
			}
		}); 
		
		modalInstance.result.then(
				function(selectedItem) {
					$scope.selected = selectedItem;
				//	$scope.listarUnidadesPorObra($scope.obra.idObra);
					$scope.listarContasPagarPorObra();
				}, function() {
					$log.info('Modal foi fechada em: '
							+ new Date());
				});

	};


//	Botão Adicionar Fornecedor a partir da tela de cadastro de conta a pagar

//	$scope.addFornecedor = function(size, selectedFornecedor) {
//	var modalInstance = $uibModal.open({
//	templateUrl : 'pages/templates/modalFornecedorContent.html',
//	controller : 'FornecedorInstanceController',
//	size : size,
//	resolve : {
//	contaPagar : function() {
//	return angular.copy(selectedFornecedor);
//	}
//	}
//	});
//	};




//	$scope.listarContasPagarPorUnidade = function() {
//	console.log("listar contas por unidade");
//	contaPagarService.listarPorUnidade($scope.unidadeAtual).success(
//	function(data) {
//	$scope.contasPagar = data;
//	});
//	};
}]);

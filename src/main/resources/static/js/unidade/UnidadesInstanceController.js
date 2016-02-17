app.controller('UnidadesInstanceController', function($scope,
		$uibModalInstance, $log, $uibModal, unidade, unidadeService, fasesService, $stateParams, $window) {
	
	if(unidade != null) {
		$scope.unidade = unidade;
	} else {
		$scope.unidade = {};
	}

	$scope.fases = [];
	$scope.unidade.obra = $stateParams;
	// $scope.fase = fase;

	//DatePicker
	$scope.formats = ['dd/MM/yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];
	$scope.altInputFormats = ['dd/MM/yyyy'];
	$scope.maxDate = [];
	$scope.minDate = [];

	$scope.editorEnabled = false;

	$scope.dataInicioAberto = [];
	$scope.dataPrevistaTerminoAberto = [];

	$scope.adicionarFase = function() {
		var fase = {
				nomeFase: "",
				dataInicio: null,
				dataPrevistaTermino: null,
				editorEnabled: true
		};
		$scope.fases.push(fase);
	};

	$scope.abrirFaseDataInicio = function($event, index) {
		$event.preventDefault();
		$event.stopPropagation();

		$scope.dataInicioAberto[index] = true;
	};

	$scope.abrirFaseDataPrevistaTermino = function($event, index) {
		$event.preventDefault();
		$event.stopPropagation();

		$scope.dataPrevistaTerminoAberto[index] = true;
	};

	$scope.faseDataInicioChange = function(index, fase) {
		$log.info("Chamou Data Inicio Change!!!!");
		$scope.minDate[index] = fase.dataInicio;
	};

	$scope.faseDataPrevistaTerminoChange = function(index, fase) {
		$scope.maxDate[index] = fase.dataPrevistaTermino;
	};

	$scope.removerFase = function(fase) {
		if(fase.idFaseUnidade == null) {
			$scope.removerFaseArray(fase);

		} else {
			$scope.removerFaseBD(fase);
		}
	}

	$scope.removerFaseArray = function(fase) {
		var index = $scope.fases.indexOf(fase);
		$scope.fases.splice(index, 1);
	}

	$scope.removerFaseBD = function(fase) {

		var deleteFase = $window.confirm('Tem certeza que deseja remover a Fase ' + fase.nomeFase + ' do Banco de Dados?');
		if(deleteFase) {
			fasesService.removerFase(fase).success(function(data) {
			$scope.removerFaseArray(fase);
		}).error(function(error) {
			$log.error(error);
		});
		}	
	};
	
	$scope.salvarUnidade = function(unidade, fases) {

		unidadeService.salvarUnidadeObra(unidade).then(function(response) {
			for (var i=0; i < fases.length; i++) {
				fases[i].unidadeObra = response.data;
			}

			fasesService.salvarListaDeFases(fases).success(function(data) {
				 $log.info(fases);
			}).error(function(error) {
				$log.info(error);
			}); 
		},

		function(error) {
			$log.info(error);
		});

		$uibModalInstance.close();
	}
	
	$scope.dataInicio = {
			aberto: false
	};
	  
	$scope.dataEntrega = {
			aberto: false	 
	}
	  
	$scope.dataPrevistaTermino = {
			aberto: false
	}
		  
	  $scope.clear = function() {
	    $scope.dt = null;
	  };

	  $scope.abrirDataInicio = function() {
	    $scope.dataInicio.aberto = true;
	  };
	  
	  $scope.abrirDataEntrega = function() {
		  $scope.dataEntrega.aberto = true;
	  }
	  
	  $scope.abrirDataPrevistaTermino = function() {
		  $scope.dataPrevistaTermino.aberto = true;
	  }

	  $scope.setDate = function(year, month, day) {
	    $scope.dt = new Date(year, month, day);
	  };

	  $scope.getDayClass = function(date, mode) {
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i = 0; i < $scope.events.length; i++) {
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	  };
	  
	  $scope.dataInicioChange = function(unidade) {
		  $scope.minDate = unidade.dataInicio;
	  }
	  
	  $scope.dataPrevistaChange = function(unidade) {
		  $scope.maxDate = unidade.dataPrevistaTermino;
	  }
	  
	  	$scope.cancelar = function() {
			$uibModalInstance.dismiss('cancelar');
		};
				
		$scope.listarFasesPorUnidade = function(unidade) {
			fasesService.listarFasesPorUnidade(unidade.idUnidadeObra).success(function(data){
				$scope.fases = data;
			}).error(function(error) {
				$log.error(error);
			});
		}
});

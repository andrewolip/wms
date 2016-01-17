app.controller('FasesInstanceController', function($scope,
		$uibModalInstance, $log, fasesService, $stateParams) {
	
	$scope.unidade = {};
	$scope.unidade.fases = [];
	$scope.fase = {};
	
	//DatePicker
	$scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];
	$scope.altInputFormats = ['dd-MM-yyyy'];
	$scope.maxDate;
	$scope.minDate;
	
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
	  
	  $scope.dataInicioChange = function(fase) {
		  $scope.minDate = fase.dataInicio;
	  }
	  
	  $scope.dataPrevistaChange = function(fase) {
		  $scope.maxDate = fase.dataPrevistaTermino;
	  }
	
	$scope.cancelar = function() {
		$uibModalInstance.dismiss('cancelar');
	};		  
	
	$scope.salvarFase = function(fase) {
		fasesService.salvarFase(fase).success(function(){
			$uibModalInstance.close();
		}).error(function(error){
			$log.error(error);
		});
	}
	
});
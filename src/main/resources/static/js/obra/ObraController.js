app.controller('ObraController', [ '$scope', '$location', 'ObraService',
		function($scope, $location, ObraService) {
	
			$scope.obra = {};
			$scope.obras = [];

			$scope.listarObras = function() {
				console.log('Passando pelo Controller...');
				$scope.obras = ObraService.listarObras();
				console.log('Passou...');
			};

			$scope.salvarObra = function() {
				var resultado = ObraService.salvarObra($scope.obra);
			};
		} ]);
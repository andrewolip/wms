app.controller('ObraController', [
		'$scope',
		'$http',
		'$uibModal',
		function($scope, $http, $uibModal) {

			$scope.obra = {};
			$scope.obras = [];
			$scope.selected = {
				obra : $scope.obras[0]
			};

			$scope.listarObras = function() {
				$http.get('/obras/listar', {}).then(
						function(response) {
							$scope.obras = response.data;
							console.log($scope.obras);
						});
			};

			$scope.apagarObra = function(obra) {
				$http({
					url : '/obras/apagar/' + obra.idObra,
					method : 'DELETE',
					data : obra,
					headers : {
						"Content-Type" : "application/json;charset=utf-8"
					}
				}).success(function() {
					$scope.listarObras();
				}, function(error) {
					console.log(error);
				});
			};

			$scope.editarObra = function(id) {
				console.log(id);
				var index = getSelectedIndex(id);
				$scope.obras[index].idObra = $scope.obra.idObra;
				$scope.obras[index].nome = $scope.obra.nome;
				$scope.obras[index].descricao = $scope.obra.descricao;
				$scope.open();
			}

			// Abre a Modal ao clicar em 'Adicionar Obra'
			$scope.open = function() {
				$uibModal.open({
					templateUrl : 'modalObraContent.html',
					controller : 'ObraController',
					scope : $scope
				});
			};

			function getSelectedIndex(id) {
				for (var i = 0; i < $scope.obras.length; i++) {
					if ($scope.obras[i].idObra == id) {
						return i;
					}
				}
				return -1;
			}

			$scope.inserir = function(obra) {
				$http.post('/obras/inserir', obra)
					.success(function() {
						delete $scope.obra;
						$scope.obraForm.$setPristine();
						$scope.$close();
					}).error(function(error) {
						console.log(error.Message);
					});
			};

		} ]);

app.directive('ngConfirmClick', [ function() {
	return {
		link : function(scope, element, attr) {
			var msg = attr.ngConfirmClick || "Are you sure?";
			var clickAction = attr.confirmedClick;
			element.bind('click', function(event) {
				if (window.confirm(msg)) {
					scope.$eval(clickAction)
				}
			});
		}
	};
} ])

app.factory('buscaCepService', ['$http', '$log', function($http, $log) {
	var factory = {};

	factory.buscarCep = function(localizacao) {
		return $http.get('http://cep.correiocontrol.com.br/' + localizacao.cep + '.json');
	}
   
   return factory;
}]);

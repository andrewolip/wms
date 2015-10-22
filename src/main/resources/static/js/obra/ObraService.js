app.service('ObraService', ['$http', function($http) {
    var service = {};

    service.salvarObra = function(obra) {
        var resultado = '';

        $http.post('http://localhost:8080/obra/inserir', obra).then(function(success) {
        	console.log("Service");
        }).error(function(error) {
        	resultado = error.Message;
        });

        return resultado;
    };
    
    service.listarObras = function() {
    	var obras = [];
    	
    	$http.get('http://localhost:8080/obra/listar').then(function(success) {
    		console.log(success);
    	});
    }

    return service;
}]);
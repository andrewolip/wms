app.service('ObraService', ['$http', function($http) {
    var service = {};
    
    service.salvarObra = function(obra) {
    	var resultado = '';

    	console.log('Chamou Service...');
    	
        $http.post('http://localhost:8080/obra/inserir', obra).then(function(success) {
        	console.log("Service");
        }).error(function(error) {
        	resultado = error.Message;
        });

        return resultado;
    };
    
    service.listarObras = function() {
    	
    	
    	$http.get('http://localhost:8080/obra/listar', {}).then(function(response) {
    		obras = response.data;
    	});
    	
    	return obras;
    }

    return service;
}]);
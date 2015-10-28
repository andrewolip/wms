app.service('FuncaoService', ['$http', function($http) {
    var service = {};
    
    service.salvarFuncao = function(funcao) {
    	var resultado = '';

    	console.log('Chamou Service...');
    	
        $http.post('http://localhost:8080/funcao/inserir', funcao).then(function(success) {
        	console.log("Service");
        }).error(function(error) {
        	resultado = error.Message;
        });

        return resultado;
    };
    
    service.listarFuncoes = function() {
    	
    	
    	$http.get('http://localhost:8080/funcao/listar', {}).then(function(response) {
    		funcoes = response.data;
    	});
    	
    	return funcoes;
    }

    return service;
}]);
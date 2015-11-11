app.service('obraService', [ '$http', function($http) {
	var service = {};
	var obras = [];
	var obra = {};

	this.salvarObra = function(obra) {
		return $http.post('/obras/inserir', obra);
	}

	this.listarObras = function() {
		return $http.get('/obras/listar');
	}

	this.apagarObra = function(obra) {
		return $http({
			url : '/obras/apagar/' + obra.idObra,
			method : 'DELETE',
			data : obra,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}

} ]);
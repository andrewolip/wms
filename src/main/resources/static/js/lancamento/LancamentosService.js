app.factory('lancamentosService', ['$http', '$location', '$log', function($http, $location, $log) {
	var lancamento = {};
	var lancamentos = [];

	
	lancamento.listarLancamentos = function() {
		return $http.get('/unidades/listar');
	}
	
	lancamento.listarLancamentosPorObra = function(id) {
		return $http.get('lancamentos/listar_por_obra/' + id);
	}

	lancamento.listarLancamentos = function() {
		return $http.get('/lancamentos/listar/' + id)
	}
	
	lancamento.removerLancamento = function(lancamento) {
		return $http({
			url : 'lancamento/remover/' + lancamento.idLancamento,
			method : 'DELETE',
			data : lancamento,
			headers : {
				"Content-Type" : "application/json;charset=utf-8"
			}
		});
	}
	
	return lancamento;
	
}]);
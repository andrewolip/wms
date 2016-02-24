app.controller('wmsSimplePieChartUnidadeController',['$scope', function($scope) {

	$scope.simplePieUnidade = {
            "type": "pie",
			  "theme": "light",
			  "dataProvider": [ {
			    "status": "Em Andamento",
			    "quantidade": 6
			  }, {
			    "status": "Inativa",
			    "quantidade": 2
			  }, {
			    "status": "Concluída",
			    "quantidade": 4
			  }],
			  "valueField": "quantidade",
			  "titleField": "status",
			   "balloon":{
			   "fixedPosition":true
			  },
			  "export": {
			    "enabled": true
			  }
			};
	
}]);


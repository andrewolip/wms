app.controller('wmsSimplePieController',['$scope', function($scope) {

	$scope.simplePie = {
            "type": "pie",
			  "theme": "light",
			  "dataProvider": [ {
			    "status": "Em Andamento",
			    "quantidade": 3
			  }, {
			    "status": "Inativa",
			    "quantidade": 1
			  }, {
			    "status": "Concluída",
			    "quantidade": 2
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


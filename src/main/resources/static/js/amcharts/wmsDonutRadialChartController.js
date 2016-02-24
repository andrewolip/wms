app.controller('wmsDonutRadialChartController', ['$scope', function($scope) {

	$scope.donutRadialChart = {
		"type": "pie",
	    "theme": "light",
	    "innerRadius": "40%",
	    "gradientRatio": [-0.4, -0.4, -0.4, -0.4, -0.4, -0.4, 0, 0.1, 0.2, 0.1, 0, -0.2, -0.5],
	    "dataProvider": [{
	        "status": "Dentro do Orçamento",
	        "porcentagem": 80
	    }, {
	        "status": "Excedeu Orçamento",
	        "porcentagem": 20
	    }],
	    "balloonText": "[[value]]%",
	    "valueField": "porcentagem",
	    "titleField": "status",
	    "balloon": {
	        "drop": true,
	        "adjustBorderColor": false,
	        "color": "#FFFFFF",
	        "fontSize": 16
	    },
	    "export": {
	        "enabled": true
	    }
	}

}]);
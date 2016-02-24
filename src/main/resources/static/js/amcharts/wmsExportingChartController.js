app.controller('wmsExportingChartController', ['$scope', function($scope) {

	var chartData = [ {
				  "nomeObra": "Obra 1",
				  "porcentagem": 100000,
				  "color": "#5858FA"
				}, {
				  "nomeObra": "Obra 2",
				  "porcentagem": 58000,
				  "color": "#FF6600"
				}, {
				  "nomeObra": "Obra 3",
				  "porcentagem": 75000,
				  "color": "#FF9E01"
				}, {
				  "nomeObra": "Obra 4",
				  "porcentagem": 250000,
				  "color": "#FCD202"
				},{
				  "nomeObra": "Obra 5",
				  "porcentagem": 350000,
				  "color": "#2EFE9A"
				},{
				  "nomeObra": "Obra 6",
				  "porcentagem": 480000,
				  "color": "#FF0F00"
				}];

	$scope.exportingChart = {
		 "theme": "light",
		  type: "serial",
		  dataProvider: chartData,
		  categoryField: "nomeObra",
		  depth3D: 20,
		  angle: 30,

		  categoryAxis: {
		    labelRotation: 90,
		    gridPosition: "start"
		  },

		  valueAxes: [ {
		    title: "Valor Gasto em cada obra"
		  } ],

		  graphs: [ {

		    valueField: "porcentagem",
		    colorField: "color",
		    type: "column",
		    lineAlpha: 0.1,
		    fillAlphas: 1
		  } ],

		  chartCursor: {
		    cursorAlpha: 0,
		    zoomable: false,
		    categoryBalloonEnabled: false
		  },
		  export: {
		    enabled: true
		  }
			};

}]);



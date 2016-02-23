app.controller('wmsGanttChartController',['$scope','unidadeService', 'fasesService', '$log', function($scope, unidadeService, fasesService, $log) {

	// $scope.unidades = unidadeService.listarUnidadesPorObra();

	$scope.unidades = [];
	$scope.unidade = {};
	$scope.fases = [];
	var ganttJson;

	$scope.inicializadorJson = function(obra) {

		$log.info('ID Obra ' + obra.idObra);
		
		var jsonObj;

		unidadeService.listarUnidadesFases(obra.idObra).success(function(data) {
					
		//	$log.info(data[0]);
			
		/*	for(var i = 0; i < data.length; i++) {
				
				ganttJson = [{
						"nomeUnidade": data[i][0],
						"fases": [{
							"dataInicio": data[i][1],
							"dataPrevistaTermino": data[i][2],
							"nomeFase": data[i][3]
						}]
				}];
				
			} */
			
		});

		$scope.wmsGantt = {
                "type": "gantt",
                "period": "DD",
			    "theme": "light",
			//    "dataLoader": {
				//    "url": "/unidades/listar_unidades_fases/" + obra.idObra
				 // }, 
			    "valueAxis": {
			    	"type": "date",
			    	"minPeriod": "DD"
			    },

			  //  "marginRight": 70,
			    
			    "balloonDateFormat": "JJ:NN",
			    "columnWidth": 0.5,
			    "brightnessStep": 10,
			    "graph": {
			        "fillAlphas": 1,
			        "balloonText": "<b>[[nomeFase]]</b>: [[open]] [[value]]"
			    },
			    "rotate": true,
			    "categoryField": "nomeUnidade",
			    "segmentsField": "fases",
			    "dataDateFormat": "DD/MM/YYYY",
			    "startDateField": "dataInicio",
			   // "startField": "start",
			    "endDateField": "dataPrevistaTermino",
			  //  "dataProvider": ganttJson,
			    "dataProvider": [ {
			        "nomeUnidade": "Unidade #1",
			        "fases": [ {
			            "dataInicio": "18/02/2016",
			            "dataPrevistaTermino": "24/03/2016",
			            "nomeFase": "Fase #1"
			        }, {
			        	"dataInicio": "24/02/2016",
			            "dataPrevistaTermino": "27/03/2016",
			            "nomeFase": "Fase #2"
			        }, {
			        	"dataInicio": "20/02/2016",
			            "dataPrevistaTermino": "23/03/2016",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #2",
			        "fases": [ {
			            "dataInicio": "04/04/2016",
			            "dataPrevistaTermino": "10/04/2016",
			            "nomeFase": "Fase #2"
			        }, {
			        	"dataInicio": "15/03/2016",
			            "dataPrevistaTermino": "15/04/2016",
			            "nomeFase": "Fase #3"
			        }, {
			        	"dataInicio": "15/03/2016",
			            "dataPrevistaTermino": "24/04/2016",
			            "nomeFase": "Fase #1"
			        } ]
			    }], 
			    "valueScrollbar": {
			        "autoGridCount":true
			    },
			    "chartCursor": {
			        "cursorcor":"#55bb76",
			        "valueBalloonsEnabled": false,
			        "cursorAlpha": 0,
			        "valueLineAlpha":0.5,
			        "valueLineBalloonEnabled": true,
			        "valueLineEnabled": true,
			        "zoomable":false,
			        "valueZoomable":true
			    },
			    "chartScrollbar": {

  				},
			    "export": {
			        "enabled": true
			     }
			  };
	};

	

}]);

app.directive('amchart', function () {
            return {
                replace: true,
                scope: {
                    options: '=ngModel'
                },
                template: "<div class='amchart' style='width: 100%; height: 400px;'></div>",
                link: function (scope, $el) {
                    //Gerando um uid para colocar no elemento
                    var guid = function guid() {
                        function s4() {
                            return Math.floor((1 + Math.random()) * 0x10000)
                                    .toString(16)
                                    .substring(1);
                        }
                        return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
                                s4() + '-' + s4() + s4() + s4();
                    };

                    var id = guid();
                    $el.attr('id', id);
                    var chart;

                    //Função que renderiza o gráfico na tela
                    var renderChart = function (amChartOptions) {
                        var option = amChartOptions || scope.options;
                        if (scope.options) {

                            //verificando qual tipo é o gráfico
                            switch (option.type) {
                                case "serial":
                                    chart = new AmCharts.AmSerialChart();
                                    chart = option.theme ? new AmCharts.AmSerialChart(AmCharts.themes[option.theme]) : new AmCharts.AmSerialChart();
                                    break;
                                case "pie":
                                    chart = new AmCharts.AmPieChart();
                                    chart = option.theme ? new AmCharts.AmPieChart(AmCharts.themes[option.theme]) : new AmCharts.AmPieChart();
                                    break;
                                case "funnel":
                                    chart = new AmCharts.AmFunnelChart();
                                    chart = option.theme ? new AmCharts.AmFunnelChart(AmCharts.themes[option.theme]) : new AmCharts.AmFunnelChart();
                                    break;
                                case "gauge":
                                    chart = new AmCharts.AmAngularGauge();
                                    chart = option.theme ? new AmCharts.AmAngularGauge(AmCharts.themes[option.theme]) : new AmCharts.AmAngularGauge();
                                    break;
                                case "radar":
                                    chart = new AmCharts.AmRadarChart();
                                    chart = option.theme ? new AmCharts.AmRadarChart(AmCharts.themes[option.theme]) : new AmCharts.AmRadarChart();
                                    break;
                                case "xy":
                                    chart = new AmCharts.AmXYChart();
                                    chart = option.theme ? new AmCharts.AmXYChart(AmCharts.themes[option.theme]) : new AmCharts.AmXYChart();
                                    break;
                                case "gantt":
                                	chart = new AmCharts.AmGanttChart();
                                	chart = option.theme ? new AmCharts.AmGanttChart(AmCharts.themes[option.theme]) : new AmCharts.AmGanttChart();
                                	break;
                            }

                            chart.dataProvider = option.data;

                            //Colocando no objeto chart todos as propriedades que vierem no option
                            var chartKeys = Object.keys(option);
                            for (var i = 0; i < chartKeys.length; i++) {
                                if (chartKeys[i] !== "theme") {
                                    if (typeof option[chartKeys[i]] !== 'object' && typeof option[chartKeys[i]] !== 'function') {
                                        chart[chartKeys[i]] = option[chartKeys[i]];
                                    } else {
                                        chart[chartKeys[i]] = angular.copy(option[chartKeys[i]]);
                                    }
                                }
                            }
                            //Método do objeto Amchart para rendererizar o gráfico
                            chart.write(id);
                        }
                    };

                    renderChart(scope.options);
                    scope.$watch('options', function (newValue, oldValue) {
                        if (id === $el[0].id || !id) {
                            renderChart(newValue);
                        }
                    }, true);

                }
            };
        });
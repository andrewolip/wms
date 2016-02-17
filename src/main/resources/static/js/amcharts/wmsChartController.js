app.controller('wmsChartController',['$scope',	function($scope) {
	$scope.wmsGantt = {

                "type": "gantt",
			    "theme": "light",
			    "marginRight": 70,
			    "period": "DD",
			    "dataDateFormat":"dd/MM/yyyy",
			    "balloonDateFormat": "JJ:NN",
			    "columnWidth": 0.5,
			    "valueAxis": {
			        "type": "date",
			        "minimum": 7,
			        "maximum": 31
			    },
			    "brightnessStep": 10,
			    "graph": {
			        "fillAlphas": 1,
			        "balloonText": "<b>[[nomeFase]]</b>: [[open]] [[value]]"
			    },
			    "rotate": true,
			    "categoryField": "nomeUnidade",
			    "segmentsField": "fases",
			    "colorField": "cor",
			    "startDate": "2015-01-01",
			    "startField": "start",
			    "endField": "end",
			    "durationField": "duracao",
			    "dataProvider": [ {
			        "nomeUnidade": "Unidade ",
			        "fases": [ {
			            "start": 7,
			            "duracao": 2,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 2,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #2",
			        "fases": [ {
			            "start": 10,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 1,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        }, {
			            "duracao": 4,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #3",
			        "fases": [ {
			            "start": 12,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "start": 16,
			            "duracao": 2,
			            "cor": "#FFE4C4",
			            "nomeFase": "nomeFase #4"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #4",
			        "fases": [ {
			            "start": 9,
			            "duracao": 6,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 4,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #5",
			        "fases": [ {
			            "start": 8,
			            "duracao": 1,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        }, {
			            "duracao": 4,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #6",
			        "fases": [ {
			            "start": 15,
			            "duracao": 3,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #7",
			        "fases": [ {
			            "start": 9,
			            "duracao": 2,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 1,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 8,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #8",
			        "fases": [ {
			            "start": 9,
			            "duracao": 8,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 7,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #9",
			        "fases": [ {
			            "start": 11,
			            "duracao": 8,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "start": 16,
			            "duracao": 2,
			            "cor": "#FFE4C4",
			            "nomeFase": "Fase #4"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #10",
			        "fases": [ {
			            "start": 9,
			            "duracao": 4,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 3,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 5,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #11",
			        "fases": [ {
			            "start": 6,
			            "duracao": 3,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #12",
			        "fases": [ {
			            "start": 12,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "start": 16,
			            "duracao": 2,
			            "cor": "#FFE4C4",
			            "nomeFase": "Fase #4"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #13",
			        "fases": [ {
			            "start": 8,
			            "duracao": 10,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #14",
			        "fases": [ {
			            "start": 12,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 3,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #15",
			        "fases": [ {
			            "start": 18,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 2,
			            "cor": "#FFE4C4",
			            "nomeFase": "Fase #4"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #16",
			        "fases": [ {
			            "start": 17,
			            "duracao": 2,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        }, {
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 2,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #17",
			        "fases": [ {
			            "start": 13,
			            "duracao": 2,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "duracao": 1,
			            "cor": "#8dc49f",
			            "nomeFase": "Fase #3"
			        }, {
			            "duracao": 4,
			            "cor": "#46615e",
			            "nomeFase": "Fase #1"
			        } ]
			    }, {
			        "nomeUnidade": "Unidade #18",
			        "fases": [ {
			            "start": 10,
			            "duracao": 3,
			            "cor": "#727d6f",
			            "nomeFase": "Fase #2"
			        }, {
			            "start": 17,
			            "duracao": 4,
			            "cor": "#FFE4C4",
			            "nomeFase": "Fase #4"
			        } ]
			    } ],
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
			    "export": {
			        "enabled": true
			     }
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
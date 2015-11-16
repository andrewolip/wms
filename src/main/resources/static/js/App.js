var app = angular.module('WmsApp', ['smart-table', 'ui.bootstrap', 'ngMessages', 'ngRoute']);


app.config(function ($routeProvider) {
	
	$routeProvider.when('/dashboard', {
		templateUrl: 'pages/dashboard.html',
		controller: 'DashboardController'
	}).
	
	when('/obras', {
		templateUrl: 'pages/obras.html',
		controller: 'ObrasController'
	}).
	
	when('/obra/:idObra', {
		templateUrl: 'pages/obra.html',
		controller: 'UnidadeController'
	});
});
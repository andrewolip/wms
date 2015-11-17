var app = angular.module('WmsApp', ['smart-table', 'ui.bootstrap', 'ngMessages', 'ui.router']);

app.config(function config($stateProvider) {
	
	$stateProvider.state("dashboard", {
		url: "/dashboard",
		controller: "DashboardController",
		templateUrl: "pages/dashboard.html"
	});
	
	$stateProvider.state("obras", {
		url: "/obras",
		templateUrl: "pages/obras.html",
		controller: "ObrasController"
		
	});
	
	$stateProvider.state("obra", {
		url: "/obra/:idObra?nome",
		templateUrl: "pages/obra.html",
		controller: "UnidadesController"
	});
	
	$stateProvider.state("funcoes", {
		url: "/funcoes",
		templateUrl: "pages/funcoes.html",
		controller: "FuncaoController"
	});
});
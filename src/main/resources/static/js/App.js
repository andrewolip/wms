var app = angular.module('WmsApp', ['smart-table', 'ui.bootstrap', 'ngMessages', 'ui.router', 'ui.utils.masks']);

app.config(function config($stateProvider) {
	
	var obraObject = {idObra: null, nome: null, dataInicio: null, localizacao: {uf: null, localidade: null, logradouro: null,
		cep: null}, dataTermino: null, dataPrevistaTermino: null, unidades: []};
	
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
		url: "/obra/",
		templateUrl: "pages/obra.html",
		controller: "ObrasController",
		params: obraObject
	});

	$stateProvider.state("contasPagar", {
		url: "/contasPagar",
		templateUrl: "pages/contasPagar.html",
		controller: "ContaPagarController"
	});
	
	$stateProvider.state("funcoes", {
		url: "/funcoes",
		templateUrl: "pages/funcoes.html",
		controller: "FuncaoController"
	});
	
	$stateProvider.state("clientes", {
		url: "/clientes",
		templateUrl: "pages/clientes.html",
		controller: "ClienteController"
	});
	
	$stateProvider.state("colaboradores", {
		url: "/colaboradores",
		templateUrl: "pages/colaboradores.html",
		controller: "ColaboradorController"
	});
	
	$stateProvider.state("contas_bancarias", {
		url: "/contas_bancarias",
		templateUrl: "pages/contas_bancarias.html",
		controller: "ContaBancariaController"
	});
	
	$stateProvider.state("empresas", {
		url: "/empresas",
		templateUrl: "pages/empresas.html",
		controller: "EmpresaController"
	});
	
	$stateProvider.state("fornecedores", {
		url: "/fornecedores",
		templateUrl: "pages/fornecedores.html",
		controller: "FornecedorController"
	});
	
	$stateProvider.state("materiais", {
		url: "/materiais",
		templateUrl: "pages/materiais.html",
		controller: "MaterialController"
	});
	
	$stateProvider.state("usuarios", {
		url: "/usuarios",
		templateUrl: "pages/usuarios.html",
		controller: "UsuarioController"
	});

	$stateProvider.state("unidades", {
		url: "/unidades/",
		templateUrl: "pages/unidades.html",
		controller: "ObrasController",
		params: {idUnidadeObra: null, idObra: null, descricao: null, nomeUnidade: null}
	});
});
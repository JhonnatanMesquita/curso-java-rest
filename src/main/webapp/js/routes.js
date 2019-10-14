app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl :"./_pages/home.html"
        })
        .when("/pessoa", {
            templateUrl : "./_pages/pessoa/pessoa.html",
            controller : PessoaController
        })
        .when("/pessoa/cadastrar",{
            templateUrl : "./_pages/pessoa/pessoa-cadastrar.html",
            controller : PessoaController
        })
        .when("/pessoa/alterar/:id",{
            templateUrl : "./_pages/pessoa/pessoa-alterar.html",
            controller : PessoaController
        })
        .when("/conta", {
            templateUrl : "./_pages/conta/conta.html",
            controller : ContaController
        })
        .when("/conta/cadastrar",{
            templateUrl : "./_pages/conta/conta-cadastrar.html",
            controller : ContaController
        })
        .when("/conta/alterar/:id",{
            templateUrl : "./_pages/conta/conta-alterar.html",
            controller : ContaController
        });

});
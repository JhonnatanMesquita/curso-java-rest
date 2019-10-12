mPrincipal.controller("HomeController", HomeController);

HomeController.$inject = ["$scope", "$rootScope", "LoginService"]

function HomeController($scope, $rootScope, LoginService){

    const self = this;
    self.service = LoginService;

    $rootScope.telas = ["LOGIN", "RECUPERAR_SENHA", "HOME", "REGISTRO"];
    $rootScope.telaSelecionada = $rootScope.telas[0];

    self.abrirTelaRecuperarSenha = function () {
        $rootScope.telaSelecionada = $rootScope.telas[1];
    };

    self.abrirTelaRegistro = function () {
        $rootScope.telaSelecionada = $rootScope.telas[3];
    };

}
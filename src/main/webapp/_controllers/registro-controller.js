mPrincipal.controller("RegistroController", RegistroController);

RegistroController.$inject = ["$scope", "RegistroService", "$rootScope"]

function RegistroController($scope, RegistroService, $rootScope) {
    const self = this;

    self.service = RegistroService;

    self.pessoa = {
        nome: null,
        cpf: null,
        agencia: null,
        conta: null,
        senha: null
    };
    
    self.registrar = function (pessoa) {
        RegistroService.pessoa = pessoa;
        console.log(RegistroService.pessoa);
        $rootScope.telaSelecionada = $rootScope.telas[0];
    }
}
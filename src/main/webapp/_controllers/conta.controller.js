app.controller("ContaController", ContaController);

ContaController.$inject = ["$scope", "ContaService", "$location", "$routeParams"];

function ContaController($scope, ContaService, $location, $routeParams) {

    const self = this;

    self.conta = {
        id : null,
        agencia : null,
        conta : null,
        senha : null
    }

    self.id = $routeParams.id;

    self.getContas = function () {
        ContaService.getContas().then(res =>{
            self.contas = res.data;
        }).catch(function(err){
            self.contas = null;
        });
    }

    self.buscar = function (id) {
        ContaService.buscar(id).then(res =>{
            self.conta = res.data;
        });
    }

    self.alterar = function (conta, id) {
        ContaService.alterar(conta, id).then(res =>{
            alert(`${conta.agencia} alterada com sucesso!`);
            $location.path( "/conta" );
        }).catch(function(err){
            alert("Ocorreu um erro ao cadastrar, verifique os campos e tente novamente!");
        });
    }

    self.deletar = function (id) {
        var r = confirm(`Você realmente deseja deletar?`);
        if (r == true) {
            ContaService.deletar(id).then( res =>{
                alert("Pessoa deletada com sucesso!");
                self.getContas();
            });
        }      
    }

    self.cadastrar = function (conta){
        ContaService.inserir(conta).then(res =>{
            alert(`${conta.agencia} cadastrado com sucesso!`);
            $location.path( "/conta" );
        }).catch(function(err){
            alert("Ocorreu um erro ao cadastrar, verifique os campos e tente novamente!");
        });
    }
}
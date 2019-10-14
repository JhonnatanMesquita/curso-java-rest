app.controller("PessoaController", PessoaController);

PessoaController.$inject = ["$scope", "PessoaService", "ContaService", "$location", "$routeParams"];

function PessoaController($scope, PessoaService, ContaService, $location, $routeParams) {

    const self = this;

    self.pessoa = {
        id : null,
        nome : null,
        cpf : null,
        conta : {
            id : null
        }
    }

    self.contas = {
        id : null,
        agencia : null,
        conta : null,
        senha : null
    }

    self.id = $routeParams.id;

    self.getContas = function() {
        ContaService.getContas().then(res => {
            self.contas = res.data;
        }).catch(function(err){
            self.contas = null;
        });
    }

    self.getPessoas = function () {
        PessoaService.getPessoas().then(res =>{
            self.pessoas = res.data;
        }).catch(function(err){
            self.pessoas = null;
        });
    }

    self.buscar = function (id) {
        PessoaService.buscar(id).then(res =>{
            self.pessoa = res.data;
        });
    }

    self.alterar = function (pessoa, id) {

        if(pessoa.conta.id == null){
            pessoa.conta = null;
        }

        PessoaService.alterar(pessoa, id).then(res =>{
            alert(`${pessoa.nome} alterada com sucesso!`);
            $location.path( "/pessoa" );
        }).catch(function(err){
            alert("Ocorreu um erro ao cadastrar, verifique os campos e tente novamente!");
        });
    }

    self.deletar = function (id) {
        var r = confirm(`Você realmente deseja deletar?`);
        if (r == true) {
            PessoaService.deletar(id).then( res =>{
                alert("Pessoa deletada com sucesso!");
                self.getPessoas();
            });
        }      
    }

    self.cadastrar = function (pessoa){

        if(pessoa.conta.id == null){
            pessoa.conta = null;
        }

        PessoaService.inserir(pessoa).then(res =>{
            alert(`${pessoa.nome} cadastrado com sucesso!`);
            $location.path( "/pessoa" );
        }).catch(function(err){
            alert("Ocorreu um erro ao cadastrar, verifique os campos e tente novamente!");
        });
    }
}
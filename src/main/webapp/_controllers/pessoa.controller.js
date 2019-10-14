app.controller("PessoaController", PessoaController);

PessoaController.$inject = ["$scope", "PessoaService", "$location", "$routeParams"];

function PessoaController($scope, PessoaService, $location, $routeParams) {

    const self = this;

    self.pessoa = {
        nome : null,
        cpf : null
    };

    self.id = $routeParams.id;

    self.getPessoas = function () {
        PessoaService.getPessoas().then(res =>{
            self.pessoas = res.data;
        });
    };

    self.buscar = function (id) {
        PessoaService.buscar(id).then(res =>{
            self.pessoa = res.data;
        });
    };

    self.alterar = function (pessoa, id) {
        PessoaService.alterar(pessoa, id).then(res =>{
            alert(`${pessoa.nome} alterada com sucesso!`);
            $location.path( "/pessoa" );
        });
    };

    self.deletar = function (id) {
        var r = confirm(`Você realmente deseja deletar?`);
        if (r === true) {
            PessoaService.deletar(id).then( res =>{
                alert("Pessoa deletada com sucesso!");
                self.getPessoas();
            });
        }      
    };

    self.cadastrar = function (pessoa){
        PessoaService.inserir(pessoa).then(res =>{
            alert(`${pessoa.nome} cadastrado com sucesso!`);
            $location.path( "/pessoa" );
        });
    };
}
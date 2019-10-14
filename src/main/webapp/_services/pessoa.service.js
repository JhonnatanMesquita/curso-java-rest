app.service("PessoaService", PessoaService);

PessoaService.$inject = ["$http", "config"];

function PessoaService($http, config) {

    const self = this;

    self.getPessoas = function () {
        return $http.get(`${config.apiUrl}/pessoa`);
    };

    self.buscar = function (id) {
        return $http.get(`${config.apiUrl}/pessoa/${id}`)
    };

    self.deletar = function (id) {
        return $http.delete(`${config.apiUrl}/pessoa/${id}`);
    };

    self.inserir = function(pessoa){
        return $http.post(`${config.apiUrl}/pessoa`, pessoa);
    };

    self.alterar = function(pessoa, id){
        return $http.put(`${config.apiUrl}/pessoa/${id}`, pessoa);
    };
}
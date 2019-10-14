app.service("ContaService", ContaService);

ContaService.$inject = ["$http", "config"];

function ContaService($http, config) {

    const self = this;

    self.getContas = function () {
        return $http.get(`${config.apiUrl}/conta`);
    };

    self.buscar = function (id) {
        return $http.get(`${config.apiUrl}/conta/${id}`)
    }

    self.deletar = function (id) {
        return $http.delete(`${config.apiUrl}/conta/${id}`);
    }

    self.inserir = function(conta){
        return $http.post(`${config.apiUrl}/conta`, conta);
    }

    self.alterar = function(conta, id){
        return $http.put(`${config.apiUrl}/conta/${id}`, conta);
    }
}
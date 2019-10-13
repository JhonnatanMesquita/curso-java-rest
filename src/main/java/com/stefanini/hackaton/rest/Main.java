package com.stefanini.hackaton.rest;

import com.stefanini.hackaton.rest.DAO.ContaDAO;
import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.entidades.Conta;
import com.stefanini.hackaton.rest.entidades.Pessoa;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Stateless
@Path("/")
@ApplicationPath("/api")
public class Main extends Application {

    @Inject
    PessoaDAO pessoaDAO;

    @Inject
    ContaDAO contaDAO;

    @GET

    @Path("/bd")
    public Response run (){
        Conta c = new Conta("0001-5", "95485-7", "123");
        Pessoa p = new Pessoa("11111", "ze", c);

        Conta c2 = new Conta("0001-5", "65254-1", "456");
        Pessoa p2 = new Pessoa("22222", "jao", c2);

        contaDAO.salvar(c);
        contaDAO.salvar(c2);

        pessoaDAO.salvar(p);
        pessoaDAO.salvar(p2);

        return Response.ok("Banco de dados instanciado com sucesso!").build();
    }

}

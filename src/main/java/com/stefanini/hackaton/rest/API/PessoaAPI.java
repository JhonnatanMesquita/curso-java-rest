package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.entidades.Pessoa;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.rest.parsers.PessoaParse;
import com.stefanini.hackaton.rest.persistence.RepositorioPessoa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoa")
public class PessoaAPI {

    @Inject
    RepositorioPessoa repositorioPessoa;

    @Inject
    PessoaParse pessoaParse;


    PessoaDAO pessoaDAO = new PessoaDAO();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar() {

        return Response.ok(pessoaDAO.buscarTodos()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarCpf(@PathParam("id") Integer id){

        Pessoa p = pessoaDAO.buscarId(id);

        System.out.println(p);

        return Response.ok(p).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Pessoa pessoa) throws NegocioException{

        if(pessoa.getCpf() == null){
            throw new NegocioException("Dados incorretos");
        }

        pessoaDAO.salvar(pessoa);

        return Response.status(200).entity(pessoa).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        pessoaDAO.deletar(id);
        return Response.ok("Deletado com sucesso").build();
    }

}

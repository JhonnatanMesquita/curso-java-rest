package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.entidades.Pessoa;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pessoa")
public class PessoaAPI {


    PessoaDAO pessoaDAO = new PessoaDAO();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar() throws NegocioException{

        List<Pessoa> p = pessoaDAO.buscarTodos();

        if(p == null || p.isEmpty()){
            throw new NegocioException("Nenhuma pessoa encontrada!");
        }

        return Response.status(200).entity(p).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarCpf(@PathParam("id") Integer id) throws NegocioException{

        Pessoa p = pessoaDAO.buscarId(id);

        if(p == null){
            throw new NegocioException("Essa pessoa não existe!");
        }

        return Response.status(200).entity(p).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Pessoa pessoa) throws NegocioException{

        if(pessoa.getCpf() == null){
            throw new NegocioException("Dados incorretos");
        }

        pessoaDAO.salvar(pessoa);

        return Response.status(201).entity(pessoa).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        pessoaDAO.deletar(id);
        return Response.status(204).entity("Deletado com sucesso").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(Pessoa pessoa, @PathParam("id") Integer id) throws  NegocioException{

        Pessoa p = pessoaDAO.buscarId(id);

        if(p == null){
            throw new NegocioException("Essa pessoa não foi encontrada!");
        }

        updateData(pessoa, p);

        p = pessoaDAO.atualizar(pessoa);

        return Response.status(202).entity(p).build();

    }

    private void updateData(Pessoa newObj, Pessoa obj){
        if (newObj.getId() == null) {
            newObj.setId(obj.getId());
        }
        if(newObj.getCpf() == null){
            newObj.setCpf(obj.getCpf());
        }
        if(newObj.getNome() == null){
            newObj.setNome(obj.getNome());
        }
        if(newObj.getConta() == null){
            newObj.setConta(obj.getConta());
        }
    }

}

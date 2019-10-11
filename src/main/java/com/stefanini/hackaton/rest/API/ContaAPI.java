package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.ContaDAO;
import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.entidades.Conta;
import com.stefanini.hackaton.rest.entidades.Pessoa;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/conta")
public class ContaAPI {

    @Inject
    ContaDAO contaDAO;

    @Inject
    PessoaDAO pessoaDAO;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar() throws NegocioException {

        List<Conta> c = contaDAO.buscarTodos();

        if(c == null || c.isEmpty()){
            throw new NegocioException("Nenhuma conta foi encontrada!");
        }

        return Response.status(200).entity(c).build();

    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") Integer id) throws NegocioException{

        Conta c = contaDAO.buscarId(id);

        if(c == null){
            throw new NegocioException("A conta não existe!");
        }

        return Response.status(200).entity(c).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Conta conta){

        conta.setId(null);

        contaDAO.salvar(conta);

        return Response.status(201).entity(conta).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        contaDAO.deletar(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(Conta conta, @PathParam("id") Integer id) throws NegocioException{
        Conta c = contaDAO.buscarId(id);

        if(c == null){
            throw new NegocioException("Essa conta não foi encontrada!");
        }

        updateData(conta, c);

        c = contaDAO.atualizar(conta);

        return Response.status(202).entity(c).build();
    }

    @PUT
    @Path("/associar/{pessoa}/{conta}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response associar(@PathParam("pessoa") Integer idPessoa, @PathParam("conta") Integer idConta) throws NegocioException{

        Pessoa p = pessoaDAO.buscarId(idPessoa);

        if(p == null){
            throw new NegocioException("Pessoa não encontrada");
        }

        Conta c = contaDAO.buscarId(idConta);

        if(c == null){
            throw new NegocioException("Conta não encontrada");
        }

        p.setConta(c);

        p = pessoaDAO.atualizar(p);

        return Response.status(202).entity(p).build();
    }


    private void updateData(Conta newObj, Conta obj){
        if (newObj.getId() == null) {
            newObj.setId(obj.getId());
        }
        if (newObj.getConta() == null) {
            newObj.setConta(obj.getConta());
        }
        if (newObj.getAgencia() == null) {
            newObj.setAgencia(obj.getAgencia());
        }
        if (newObj.getSenha() == null) {
            newObj.setSenha(obj.getSenha());
        }
    }
}

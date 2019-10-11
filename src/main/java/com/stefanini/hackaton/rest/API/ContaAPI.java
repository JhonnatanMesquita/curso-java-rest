package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.ContaDAO;
import com.stefanini.hackaton.rest.entidades.Conta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conta")
public class ContaAPI {

    ContaDAO contaDAO = new ContaDAO();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar(){

        return Response.ok(contaDAO.buscarTodos()).build();

    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") Integer id) {

        Conta c = contaDAO.buscarId(id);

        System.out.println(c);

        return Response.ok(c).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Conta conta){

        contaDAO.salvar(conta);

        return Response.ok(conta).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        contaDAO.deletar(id);
        return Response.ok("Conta deletada com sucesso!").build();
    }
}

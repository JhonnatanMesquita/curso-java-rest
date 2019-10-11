package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.DTO.PessoaDTO;
import com.stefanini.hackaton.rest.entidades.Conta;
import com.stefanini.hackaton.rest.entidades.Pessoa;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.rest.parsers.PessoaParse;
import com.stefanini.hackaton.rest.persistence.RepositorioPessoa;
import com.sun.org.apache.xpath.internal.operations.Neg;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/pessoa")
public class PessoaAPI {

    @Inject
    RepositorioPessoa repositorioPessoa;

    @Inject
    PessoaParse pessoaParse;


    PessoaDAO pessoaDAO = new PessoaDAO();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar() throws NegocioException{

//        Map<String, Pessoa> mapP = repositorioPessoa.getMapPessoa();
//
//        if(mapP == null ||
//                mapP.isEmpty()){
//            throw new NegocioException("Nenhum usuário encontrado!");
//        }
//
//        List<PessoaDTO> pessoaDTO = pessoaParse.toMapDTO(mapP);
//
//        return Response.ok(pessoaDTO).build();

        return Response.ok(pessoaDAO.buscarTodos()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarCpf(@PathParam("id") Integer id) throws NegocioException{

//        Pessoa pessoa = repositorioPessoa.getMapPessoa().get(id);
//
//        if(pessoa == null){
//            throw new NegocioException("Usuario não encontrado!");
//        }
//
//        PessoaDTO pessoaDTO = pessoaParse.toDTO(pessoa);
//
//        return Response.ok(pessoaDTO).build();

        Pessoa p = pessoaDAO.buscarId(id);

        System.out.println(p);

        return Response.ok(p).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Pessoa pessoa) throws NegocioException{

        //if(repositorioPessoa.getMapPessoa().get(pessoa.getCpf()) != null){
            //throw new NegocioException("Este CPF já está cadastrado!");
        //}

        //repositorioPessoa.getMapPessoa().put(pessoa.getCpf(), pessoa);
        //return Response.ok(repositorioPessoa.getMapPessoa().get(pessoa.getCpf())).build();

        if(pessoa.getCpf() == null){
            throw new NegocioException("Dados incorretos");
        }


        //if(pessoaDAO.buscarId(pessoa.getId()) != null){
            //throw new NegocioException("Este CPF já esta cadastrado!");
        //}

        pessoaDAO.salvar(pessoa);

        return Response.status(200).entity(pessoa).build();
    }

    @POST
    @Path("/batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirLista(List<Pessoa> pessoaList){
        for (Pessoa pessoa: pessoaList) {
            repositorioPessoa.getMapPessoa().put(pessoa.getCpf(), pessoa);
        }
        return Response.ok(repositorioPessoa.getMapPessoa()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id){
        repositorioPessoa.deleteMapPesso(id);
        return Response.ok("Deletado com sucesso").build();
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response atualizar(PessoaDTO pessoaDTO, @PathParam("id") String id){

        Pessoa pessoa = pessoaParse.toEntity(pessoaDTO);

        Object obj = repositorioPessoa.atualizarMapPessoa(id, pessoa);

        return Response.ok(obj).build();
    }

}

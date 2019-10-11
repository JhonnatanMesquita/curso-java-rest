package com.stefanini.hackaton.rest.API;

import com.stefanini.hackaton.rest.DAO.ContaDAO;
import com.stefanini.hackaton.rest.DAO.PessoaDAO;
import com.stefanini.hackaton.rest.DTO.ContaDTO;
import com.stefanini.hackaton.rest.entidades.Conta;
import com.stefanini.hackaton.rest.entidades.Pessoa;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.rest.parsers.AbstractParse;
import com.stefanini.hackaton.rest.parsers.ContaParse;
import com.stefanini.hackaton.rest.persistence.RepositorioConta;
import com.stefanini.hackaton.rest.persistence.RepositorioPessoa;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/conta")
public class ContaAPI {

    @Inject
    RepositorioConta repositorioConta;

    @Inject
    RepositorioPessoa repositorioPessoa;

    @Inject
    ContaParse contaParse;

    ContaDAO contaDAO = new ContaDAO();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultar() throws NegocioException{

//        Map<Integer, Conta> mapC = repositorioConta.getMapConta();
//
//        if(mapC.isEmpty()){
//            throw new NegocioException("Nenhuma conta encontrada!");
//        }
//
//        List<ContaDTO> contaDTO = contaParse.toMapDTO(mapC);
//
//        return Response.ok(contaDTO).build();

        return Response.ok(contaDAO.buscarTodos()).build();

    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") Integer id) throws NegocioException {

//        Conta c = repositorioConta.getMapConta().get(id);
//
//        if(c == null){
//            throw new NegocioException("Conta não encontrada!");
//        }
//
//        ContaDTO contaDTO = contaParse.toDTO(c);
//
//        return Response.ok(contaDTO).build();

        Conta c = contaDAO.buscarId(id);

        System.out.println(c);

        return Response.ok(c).build();
    }

    @GET
    @Path("/agencia/{agencia}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("agencia") String agencia) throws NegocioException{

        List<Conta> contaList = repositorioConta.findAgencia(agencia);

        if(contaList == null || contaList.isEmpty()){
            throw new NegocioException("Agencia não encontrada!");
        }

        List<ContaDTO> contaDTO = contaParse.toListDTO(contaList);

        return Response.ok(contaDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Conta conta) throws NegocioException{

//        if(repositorioConta.getMapConta().get(conta.getId()) != null){
//            throw new NegocioException("Esta conta já esta cadastrada!");
//        }
//
//        final Boolean[] temConta = {false};
//
//        repositorioConta.getMapConta().forEach( (key, c) ->{
//            if(c.getConta().equals(conta.getConta())){
//                temConta[0] = true;
//            }
//        });
//
//        if(temConta[0]){
//            throw new NegocioException("Esta conta já existe!");
//        }
//
//        repositorioConta.getMapConta().put(conta.getId(), conta);
//
//        return Response.ok(repositorioConta.getMapConta()).build();

        contaDAO.salvar(conta);

        return Response.ok(conta).build();
    }

    @POST
    @Path("/batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirLista(List<Conta> contaList){
        for (Conta conta: contaList) {
            repositorioConta.getMapConta().put(conta.getId(), conta);
        }
        return Response.ok("Lista inserida com sucesso!").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        repositorioConta.deletar(id);
        return Response.ok("Conta deletada com sucesso!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizar(ContaDTO contaDTO, @PathParam("id") Integer id){

        Conta conta = contaParse.toEntity(contaDTO);

        Object obj = repositorioConta.atualizarMapConta(id, conta);
        return Response.ok(obj).build();
    }

    @PUT
    @Path("/associar/{pessoa}/{conta}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response associar(@PathParam("pessoa") String idPessoa, @PathParam("conta") Integer idConta){
        Pessoa pessoa = repositorioPessoa.getMapPessoa().get(idPessoa);
        Conta conta = repositorioConta.getMapConta().get(idConta);

        pessoa.setConta(conta);

        repositorioPessoa.getMapPessoa().put(pessoa.getCpf(), pessoa);

        return Response.ok(pessoa).build();
    }
}

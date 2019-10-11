package com.stefanini.hackaton.rest.DAO;

import com.stefanini.hackaton.rest.entidades.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

public class PessoaDAO{

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    public PessoaDAO (){
    }

    public void salvar (Pessoa p){
        em.persist(p);
    }

    public Pessoa buscarId(Integer id){
        try{
            return em.find(Pessoa.class, id);
        }catch (NullPointerException e){
            throw e;
        }
    }

    public Collection<Pessoa> buscarTodos(){
        Query query = em.createQuery("SELECT e FROM Pessoa e");
        return (Collection<Pessoa>) query.getResultList();
    }

    public Pessoa atualizar(Pessoa p){
        return em.merge(p);
    }

    public void deletar (Integer id){
        Pessoa p = buscarId(id);
        em.remove(p);
    }
}

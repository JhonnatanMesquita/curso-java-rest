package com.stefanini.hackaton.rest.DAO;

import com.stefanini.hackaton.rest.entidades.Conta;

import javax.persistence.*;
import java.util.Collection;

public class ContaDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public ContaDAO(){
    }

    public void salvar (Conta c){
        em.persist(c);
    }

    public Conta buscarId(Integer id){
        try{
            return em.find(Conta.class, id);
        }catch (NullPointerException e){
            throw e;
        }
    }

    public Collection<Conta> buscarTodos(){
        Query query = em.createQuery("SELECT e FROM Conta e");
        return (Collection<Conta>) query.getResultList();
    }

    public Conta atualizar(Conta c){
        return em.merge(c);
    }

    public void deletar (Integer id){
        Conta c = buscarId(id);
        em.remove(c);
    }
}

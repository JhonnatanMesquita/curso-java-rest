package com.stefanini.hackaton.rest.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class GenericDAO<T, I extends Serializable>  {


    @PersistenceContext(unitName = "PU")
    EntityManager em;

    private Class<T> persistedClass;

    public GenericDAO(){
    }

    public GenericDAO(Class<T> persistedClass){
        this();
        this.persistedClass = persistedClass;
    }

    public void salvar (T t){
        em.persist(t);
    }

    public T buscarId(I id){
        return em.find(persistedClass, id);
    }

    public List<T> buscarTodos(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return em.createQuery(query).getResultList();
    }

    public T atualizar(T t){
        return em.merge(t);
    }

    public void deletar (I id){
        T t = buscarId(id);
        em.remove(t);
    }
}

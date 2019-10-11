package com.stefanini.hackaton.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Path("/")
@ApplicationPath("/")
public class Main extends Application {

    //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
    //EntityManager entityManager = entityManagerFactory.createEntityManager();

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @GET
    public Response run(){
        return Response.ok("Funfando").build();
    }
}

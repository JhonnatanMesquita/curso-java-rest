package com.stefanini.hackaton.rest;

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

    @GET
    public Response run(){
        return Response.ok("Funfando").build();
    }
}

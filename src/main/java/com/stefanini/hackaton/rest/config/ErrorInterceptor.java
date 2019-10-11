package com.stefanini.hackaton.rest.config;

import com.stefanini.hackaton.rest.exceptions.NegocioException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Provider
public class ErrorInterceptor implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {

        Status status = null;
        final StringWriter sw = new StringWriter();

        if(e instanceof NegocioException){
            status = Status.BAD_REQUEST;
        }
        else {
            status = Status.INTERNAL_SERVER_ERROR;
            e.printStackTrace(new PrintWriter(sw));
        }

        ErrorMessage msg = new ErrorMessage(e.getMessage(), status.getStatusCode(), sw.toString());

        return Response.status(status.getStatusCode()).entity(msg).type(MediaType.APPLICATION_JSON).build();
    }
}

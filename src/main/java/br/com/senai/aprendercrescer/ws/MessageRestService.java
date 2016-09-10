/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Senai
 */
@Path("/message")
public class MessageRestService {

    @GET
    @Path("/rest/{batatinha}")

    public Response printMessage( @PathParam("batatinha") String mensagem) {

        String resultado = "123 testando a vida do " + mensagem;

        return Response.status(200).entity(resultado).build();
    }
@GET
@Path("/ping")
@Produces(value = "application/json")
public String ping(){
    return"{'ping':'pong'}";
}


}

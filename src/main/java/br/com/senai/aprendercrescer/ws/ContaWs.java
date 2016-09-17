/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.ContaController;
import br.com.senai.aprendercrescer.model.Conta;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/conta")
public class ContaWs {
    
    @GET
    @Path("/getconta")
    @Produces("application/json")
    public Response getAllConta() {
        ContaController contaController;
        contaController = new ContaController();
        try {
            ArrayList<Conta> lista
                    = contaController.getContas();
            JSONObject retorno = new JSONObject();
            JSONObject jConta;
            for (Conta conta : lista) {
                jConta = new JSONObject();
                jConta.put("idConta", conta.getIdconta());
                jConta.put("idgrupo",conta.getDescricao());
                jConta.put("login",conta.getTipoconta());
                jConta.put("senha",conta.getValor());
                retorno.put("conta" + conta.getIdconta(), jConta.toString());
            }
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
            return Response.status(200).entity(ex).build();
        }
    }
    
}

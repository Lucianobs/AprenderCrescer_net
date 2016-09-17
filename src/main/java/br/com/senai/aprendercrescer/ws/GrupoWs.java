/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/grupo")
public class GrupoWs {

    
        @GET
        @Path("/getgrupo")
        @Produces("application/json")
        public Response getAllGrupo() {
            GrupoController grupoController;
            grupoController = new GrupoController();
            try {
                ArrayList<Grupo> lista
                        = grupoController.getGrupo();
                JSONObject retorno = new JSONObject();
                JSONObject jGrupo;
                for (Grupo grupo : lista) {
                    jGrupo = new JSONObject();
                    jGrupo.put("idGrupo", grupo.getIdgrupo());
                    jGrupo.put("tipousuario", grupo.getTipousuario());
                    jGrupo.put("descricaogrupo", grupo.getDescricaogrupo());
                    retorno.put("grupo" + grupo.getIdgrupo(), jGrupo.toString());
                }
                return Response.status(200).entity(retorno.toString()).build();
            } catch (Exception ex) {
                System.out.println("Erro" + ex);
                return Response.status(200).entity(ex).build();
            }
        }

    }

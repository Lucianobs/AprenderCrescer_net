
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Grupo;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

    @POST
    @Path("/setgrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setGrupo(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();
        String batata = "";
        try {
            BufferedReader in
                    = new BufferedReader(
                            new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
                batata = batata + requisicao;
            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta
                    = new JSONObject(requisicaoFinal.toString());
            Grupo grupo = new Grupo();

            grupo.setTipousuario(resposta.getString("tipousuario"));
            grupo.setDescricaogrupo(resposta.getString("descricaogrupo"));

            new GrupoController().insereGrupo(grupo);

            Response.status(200).entity(
                    grupo.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).
                    entity(ex.toString()).build();
        }
        return null;
    }

}

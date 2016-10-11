package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/usuario")
public class UsuarioWs {
    /*
     @GET
     @Path("/getusuario")
     @Produces("application/json")
     public Response getUsuario() {
     try {
     JSONObject retorno = new JSONObject();
     retorno.put("nome", "Luciano");
     retorno.put("idade", 29);
     return Response.status(200).entity(retorno.toString()).build();
     } catch (JSONException ex) {
     Logger.getLogger(UsuarioWs.class.getName()).log(Level.SEVERE, null, ex);
     }

     return Response.status(500).build();
     }*/

    @GET
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getAllUsuarios() {
        // ArrayList<JSONObject> listaJson = new ArrayList<JSONObject>();

        try {
            UsuarioController ususarioControler;
            ususarioControler = new UsuarioController();
            ArrayList<Usuario> lista = ususarioControler.getUsuarios();

            JSONObject jUsuario;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Usuario usuario : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jUsuario = new JSONObject();
                jUsuario.put("IdUsuario", usuario.getIdUsuario());
                jUsuario.put("IdGrupo", usuario.getIdGrupo());
                jUsuario.put("Login", usuario.getLogin());
                jUsuario.put("senha", usuario.getSenhaUsuario());
                jUsuario.put("nome", usuario.getNomeUsuario());
                jUsuario.put("flagInativo", usuario.getFlagInativo() + "");
                retorno.append(jUsuario.toString());
                controle = true;
            }

            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();

        }
    }

    @POST
    @Path("/setusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setUsuario(InputStream dadosServ) {
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
            Usuario usuario = new Usuario();

            usuario.setLogin(resposta.getString("Login"));
            usuario.setNomeUsuario(resposta.getString("nome"));
            usuario.setSenhaUsuario(resposta.getInt("senha") + "");
            usuario.setIdGrupo(resposta.getInt("IdGrupo"));
            usuario.setFlagInativo(resposta.getString("flagInativo"));

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("[\"result\":" + "\"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).
                    entity(ex.toString()).build();
        }
    }

    @POST
    @Path("/updateusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response updateUsuario(InputStream dadosServ) {
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
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(resposta.getInt("IdUsuario"));
            usuario.setLogin(resposta.getString("Login"));
            usuario.setNomeUsuario(resposta.getString("nome"));
            usuario.setSenhaUsuario(resposta.getInt("senha") + "");
            usuario.setIdGrupo(resposta.getInt("IdGrupo"));
            usuario.setFlagInativo(resposta.getString("flagInativo"));

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\"" + ":\"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("[\"result\":" + "\"Erro no Cadastro\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(501).
                    entity(ex.toString()).build();
        }
    }

    @DELETE
    @Path("/deleteusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response deleteUsuario(InputStream dadosServ) {
        StringBuffer requisicaoFinal = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);
            }
            System.out.println(requisicaoFinal.toString());
            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            System.out.println("" + resposta.getInt("IdUsuario"));
            int IdUsuario = resposta.getInt("IdUsuario");

            if (new UsuarioController().deleteUsuario(IdUsuario)) {
                return Response.status(200).entity("{\"result\": \"sucesso\"}").build();
            } else {
                return Response.status(500).entity("{\"result\": \"error\"}").build();
            }
        } catch (Exception ex) {
            return Response.status(500).entity(ex.toString()).build();
        }
    }
}

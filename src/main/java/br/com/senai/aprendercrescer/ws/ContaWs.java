
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.ContaController;
import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Conta;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            JSONObject jConta;
            for (Conta conta : lista) {
                if (controle) {
                    retorno.append(" , ");
                }
                jConta = new JSONObject();
                jConta.put("idconta", conta.getIdconta());
                jConta.put("descricao", conta.getDescricao());
                jConta.put("tipoconta", conta.getTipoconta());
                jConta.put("valor", conta.getValor());
                retorno.append(jConta.toString());
                controle = true;
            }
            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
            return Response.status(200).entity(ex).build();
        }
    }

    @POST
    @Path("/setconta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setConta(InputStream dadosServ) {
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
            Conta conta = new Conta();

            conta.setDescricao(resposta.getString("descricao"));
            conta.setTipoconta(resposta.getString("tipoconta"));
            conta.setValor(resposta.getDouble("valor"));

            new ContaController().insereConta(conta);

            Response.status(200).entity(
                    conta.toString()).build();
        } catch (Exception ex) {
            return Response.status(501).
                    entity(ex.toString()).build();
        }
        return null;
    }
}

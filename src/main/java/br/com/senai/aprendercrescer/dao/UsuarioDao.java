package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class UsuarioDao {

    Statement st;

    public UsuarioDao() {
        try {
            st = Conexao.getConexao().createStatement();
        } catch (SQLException ex) {
            System.out.println("Erro ao pegar conexao" + ex);
        }
    }

    public Usuario getUsuarioByID(int id) {
        ResultSet rs;
        Usuario usuario;
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, IDGRUPO,LOGIN,"
                    + " SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,"
                    + "FLAGINATIVO FROM USUARIO WHERE IDUSUARIO = " + id);
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("IDUSUARIO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setNome(rs.getString("NOMEUSUARIO"));
                usuario.setSenha(rs.getString("SENHAUSUARIO"));
                return usuario;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean insereUsuario(Usuario usuario) {
        String sql = "";
        Date data = new Date();
        ResultSet rs;
        int id = 0;
        try {

            sql = "SELECT COALESCE(MAX(IDUSUARIO)+1, 1) AS IDUSUARIO FROM USUARIO ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("IDUSUARIO");
            }
            usuario.setIdUsuario(id);
            sql = "INSERT INTO usuario( idusuario, idgrupo, login, "
                    + "senhausuario, nomeusuario, dtalteracao, flaginativo)"
                    + "VALUES (" + usuario.getIdUsuario()
                    + ", " + usuario.getIdGrupo()
                    + ", '" + usuario.getLogin()
                    + "' , '" + usuario.getSenha()
                    + "' , '" + usuario.getNome()
                    + "' , '" + data.toString()
                    + "', '' )";
            System.out.println(sql);
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public boolean updateUsuario(Usuario usuario) {
        Date data = new Date();
        String sql = "UPDATE usuario SET "
                + "IdUsuario=" + usuario.getIdUsuario() + ", "
                + "IdGrupo= '" + usuario.getIdGrupo() + "',"
                + "Login='" + usuario.getLogin() + "',"
                + "senhausuario='" + usuario.getSenha() + "', "
                + "nomeusuario='" + usuario.getNome() + "',"
                + "dtalteracao='" + data + "', "
                + "flaginativo='" + usuario.getFlagInativo() + "',"
                + "WHERE IdUsuario= " + usuario.getIdUsuario() + ";";
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro no Update :" + ex);
        }
        return false;
    }

    public ArrayList<Usuario> getUsuarios() {
        ResultSet rs;
        Usuario usuario;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            rs = st.executeQuery("SELECT  IDUSUARIO, IDGRUPO,LOGIN,"
                    + " SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,"
                    + "FLAGINATIVO FROM USUARIO ORDER BY IDUSUARIO");
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("IDUSUARIO"));
                usuario.setIdGrupo(rs.getInt("IDGRUPO"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHAUSUARIO"));
                usuario.setNome(rs.getString("NOMEUSUARIO"));
               // usuario.setFlagInativo(rs.getString("FLAGINATIVO").toCharArray()[0]);

                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de consulta" + ex);
        }
        return lista;
    }

    public boolean deleteUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = " + id;
        try {
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro Delete: " + ex);
        }
        return false;
    }
}

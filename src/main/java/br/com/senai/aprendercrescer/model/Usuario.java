package br.com.senai.aprendercrescer.model;

import java.util.Date;

public class Usuario {

    private int IdUsuario;
    private int IdGrupo;
    private String Login;
    private String senha;
    private String nome;
    private char flagInativo;
    private Date dtAltercao;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idusuario) {
        this.IdUsuario = idusuario;
    }

    public int getIdGrupo() {
        return IdGrupo;
    }

    public void setIdGrupo(int idgrupo) {
        this.IdGrupo = idgrupo;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getFlagInativo() {
        return flagInativo;
    }

    public void setFlagInativo(char flagInativo) {
        this.flagInativo = flagInativo;
    }

    public Date getDtAltercao() {
        return dtAltercao;
    }

    public void setDtAltercao(Date dtAltercao) {
        this.dtAltercao = dtAltercao;
    }

    public void setTipousuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDescricaogrupo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

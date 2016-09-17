package br.com.senai.aprendercrescer.model;

import java.util.Date;

public class Usuario {
  private int idUsuario;
  private int idgrupo;
  private String login;
  private String senha;
  private String nome;
  private char flagInativo;
  private Date dtAltercao;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idusuario) {
        this.idUsuario = idusuario;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

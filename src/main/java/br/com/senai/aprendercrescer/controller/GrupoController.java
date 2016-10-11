/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.Grupo;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class GrupoController {

    GrupoDao grupoDao;

    public GrupoController() {
        if (grupoDao == null) {
            grupoDao = new GrupoDao();
        }
    }

    public boolean insereGrupo(Grupo grupo) {
        grupoDao.gravar(grupo);
        return true;
    }

    public ArrayList<Grupo> getGrupo() {
        return grupoDao.getAll();
    }

    public boolean deleteGrupo(int id) {
        Grupo grupo = new Grupo();
        grupoDao.apagar(grupo);
        return true;

    }
}

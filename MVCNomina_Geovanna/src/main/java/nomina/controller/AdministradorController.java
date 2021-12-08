/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.controller;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import nomina.hibernate.AdministradorDAO;
import nomina.hibernate.EntityManagerProvider;
import nomina.modelo.administrador;


public class AdministradorController {

    private AdministradorDAO administradorDAO;

    public AdministradorController() {
        EntityManager defaultEntityManager = EntityManagerProvider
                .open(EntityManagerProvider.DEFAULT_PERSISTENCE_UNIT);

        administradorDAO = new AdministradorDAO(defaultEntityManager);
    }

    public ArrayList<administrador> getListaAdministradores() {
        return this.administradorDAO.getListaAdministradores();
    }

    public void addAdmin(administrador administrador) {
        this.administradorDAO.addAdmin(administrador);
    }

    public void updateAdmin(administrador administrador) {
        this.administradorDAO.updateAdmin(administrador);
    }

    public void deleteAdmin(administrador administrador) {
        this.administradorDAO.deleteAdmin(administrador);
    }

}
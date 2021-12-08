package nomina.hibernate;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GenerationType;
import nomina.modelo.administrador;

public class AdministradorDAO {

 private final EntityManager EM;

    public AdministradorDAO(EntityManager entityManager) {
        this.EM = entityManager;
    }

    public void addAdmin(administrador administrador) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.persist(administrador);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public ArrayList<administrador> getListaAdministradores() {
        String queryFindAll = "SELECT a FROM administrador a";

        return new ArrayList<>(EM.createQuery(queryFindAll, administrador.class).getResultList());
    }

    public void updateAdmin(administrador administrador) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();

            // If the entity is not managed in the current persistence context,
            // perform a merge to attach it and consider the changes provided.
            // This will allow transaction.commit() to propagate changes to the DB.
            if (!EM.contains(administrador)) {
                EM.merge(administrador);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deleteAdmin(administrador administrador) {
        EntityTransaction transaction = EM.getTransaction();

        try {
            transaction.begin();
            EM.remove(administrador);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
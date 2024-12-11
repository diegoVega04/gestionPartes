package diego.gestionpartes.DAO;

import diego.gestionpartes.Models.Alumno;
import diego.gestionpartes.Models.Parte;
import diego.gestionpartes.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DAO {
    static public ObservableList<Parte> cargarPartes () {
        ObservableList<Parte> partes = FXCollections.observableArrayList();
        Transaction t = null;

        try (Session sesion = HibernateUtil.getSession()) {
            t = sesion.beginTransaction();

            List<Parte> listaPartes =sesion.createQuery("FROM Parte", Parte.class).list();
            partes.addAll(listaPartes);

            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }

        return partes;
    }

    static public ObservableList<Alumno> cargarAlumnos () {
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
        Transaction t = null;

        try (Session sesion = HibernateUtil.getSession()) {
            t = sesion.beginTransaction();

            List<Alumno> listaPartes =sesion.createQuery("FROM Alumno", Alumno.class).list();
            alumnos.addAll(listaPartes);

            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }

        return alumnos;
    }
}

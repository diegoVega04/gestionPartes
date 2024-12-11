package diego.gestionpartes.Controllers;

import diego.gestionpartes.DAO.DAO;
import diego.gestionpartes.Models.Parte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppController {
    @FXML
    public TableView tabla_partes;
    @FXML
    public TableColumn col_expediente;
    @FXML
    public TableColumn col_alumno;
    @FXML
    public TableColumn col_grupo;
    @FXML
    public TableColumn col_profesor;
    @FXML
    public TableColumn col_fecha;
    @FXML
    public TableColumn col_descripcion;
    @FXML
    public TableColumn col_sancion;

    public ObservableList<Parte> partes = FXCollections.observableArrayList();

    public void initialize() {
        col_expediente.setCellValueFactory(new PropertyValueFactory<>("expediente_alumno"));
        col_alumno.setCellValueFactory(new PropertyValueFactory<>("alumno"));
        col_grupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        col_profesor.setCellValueFactory(new PropertyValueFactory<>("profesor"));
        col_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        col_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        col_sancion.setCellValueFactory(new PropertyValueFactory<>("sancion"));

        partes.addAll(DAO.cargarPartes());

        tabla_partes.setItems(partes);
    }
}
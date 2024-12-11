package diego.gestionpartes.Controllers;

import diego.gestionpartes.DAO.DAO;
import diego.gestionpartes.Models.Alumno;
import diego.gestionpartes.Models.Parte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.PropertySheet;

public class listaAlumnosController {
    @FXML
    public Pagination pagination;
    @FXML
    public TableView tablaAlumnos;
    @FXML
    public TableColumn colExpediente;
    @FXML
    public TableColumn colNombre;
    @FXML
    public TableColumn colGrupo;
    @FXML
    public TableColumn colPuntos;
    @FXML
    public TextField expedienteBuscar;
    @FXML
    public Button btnBuscar;
    @FXML
    public Button btnLimpiar;

    public ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
    private final int filas_pagina = 6;

    public void initialize() {
        colExpediente.setCellValueFactory(new PropertyValueFactory<>("numero_expediente"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre_alum"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos_acumulados"));

        alumnos.addAll(DAO.cargarAlumnos());

        tablaAlumnos.setItems(alumnos);

        onBtnLimpiar(null);
    }

    private TableView<PropertySheet.Item> crearPagina(int indice) {
        mostrarPagina(indice, alumnos);
        return tablaAlumnos;
    }

    private void mostrarPagina(int indice, ObservableList<Alumno> lista) {
        int a = indice * filas_pagina;
        int b = Math.min(a + filas_pagina, lista.size());
        tablaAlumnos.setItems(FXCollections.observableArrayList(lista.subList(a, b)));
    }

    @FXML
    public void onBtnBuscar(ActionEvent event) {
        ObservableList<Alumno> filtradaExp = FXCollections.observableArrayList();
        for (Alumno a: alumnos) {
            int exp = a.getNumero_expediente();
            if (Integer.parseInt(expedienteBuscar.getText()) == exp) {
                filtradaExp.add(a);
            }
        }

        tablaAlumnos.setItems(filtradaExp);

        int pageCount = (int) Math.ceil(filtradaExp.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(index -> {
            mostrarPagina(index, filtradaExp);
            return tablaAlumnos;
        });

        mostrarPagina(0, filtradaExp);
    }

    @FXML
    public void onBtnLimpiar(ActionEvent event) {
        tablaAlumnos.setItems(alumnos);

        int pageCount = (int) Math.ceil(alumnos.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(this::crearPagina);

        mostrarPagina(0, alumnos);
    }
}

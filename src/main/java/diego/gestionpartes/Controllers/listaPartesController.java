package diego.gestionpartes.Controllers;

import diego.gestionpartes.DAO.DAO;
import diego.gestionpartes.Models.Parte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.PropertySheet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class listaPartesController {
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
    @FXML
    public Pagination pagination;
    @FXML
    public TextField expedienteBuscar;
    @FXML
    public DatePicker fechaInicio;
    @FXML
    public DatePicker fechaFin;
    @FXML
    public Button btnFechas;
    @FXML
    public Button btnNumeroExpediente;
    @FXML
    public Button btnLimpiar;

    public ObservableList<Parte> partes = FXCollections.observableArrayList();
    private final int filas_pagina = 6;
    DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");



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

        // Configurar la paginación
        int pageCount = (int) Math.ceil(partes.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(this::crearPagina);

        // Mostrar la primera página
        mostrarPagina(0, partes);
    }

    private TableView<PropertySheet.Item> crearPagina(int indice) {
        mostrarPagina(indice, partes);
        return tabla_partes;
    }

    private void mostrarPagina(int indice, ObservableList<Parte> lista) {
        int a = indice * filas_pagina;
        int b = Math.min(a + filas_pagina, lista.size());
        tabla_partes.setItems(FXCollections.observableArrayList(lista.subList(a, b)));
    }

    @FXML
    public void onBtnFechas(ActionEvent event) {
        ObservableList<Parte> filtradaFecha = FXCollections.observableArrayList();
        for (Parte a: partes) {
            LocalDate fecha = LocalDate.parse(a.getFecha(), formateadorFecha);
            if (!fecha.isBefore(fechaInicio.getValue()) && !fecha.isAfter(fechaFin.getValue())) {
                filtradaFecha.add(a);
            }
        }

        tabla_partes.setItems(filtradaFecha);

        int pageCount = (int) Math.ceil(filtradaFecha.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(index -> {
            mostrarPagina(index, filtradaFecha);
            return tabla_partes;
        });

        mostrarPagina(0, filtradaFecha);
    }

    @FXML
    public void onBtnNumeroExpediente(ActionEvent event) {
        ObservableList<Parte> filtradaExp = FXCollections.observableArrayList();
        for (Parte a: partes) {
            int exp = a.getExpediente_alumno();
            if (Integer.parseInt(expedienteBuscar.getText()) == exp) {
                filtradaExp.add(a);
            }
        }

        tabla_partes.setItems(filtradaExp);

        int pageCount = (int) Math.ceil(filtradaExp.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(index -> {
            mostrarPagina(index, filtradaExp);
            return tabla_partes;
        });

        mostrarPagina(0, filtradaExp);
    }

    @FXML
    public void onBtnLimpiar(ActionEvent event) {
        tabla_partes.setItems(partes);

        int pageCount = (int) Math.ceil(partes.size() / (double) filas_pagina);
        pagination.setPageCount(pageCount);
        pagination.setPageFactory(this::crearPagina);

        mostrarPagina(0, partes);
    }
}
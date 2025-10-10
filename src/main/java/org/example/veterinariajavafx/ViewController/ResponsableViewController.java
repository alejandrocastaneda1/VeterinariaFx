package org.example.veterinariajavafx.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.veterinariajavafx.App;
import org.example.veterinariajavafx.Model.Responsable;

public class ResponsableViewController {

    private App app;

    @FXML
    private TableView<Responsable> tablaResponsables;

    @FXML
    private TableColumn<Responsable, String> colNombre;

    @FXML
    private TableColumn<Responsable, String> colContacto;

    @FXML
    private TableColumn<Responsable, String> colDireccion;

    @FXML
    private TableColumn<Responsable, Integer> colNivelFidelidad;

    @FXML
    private TextField txtNombre, txtContacto, txtDireccion, txtNivelFidelidad;

    private ObservableList<Responsable> listaResponsables = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        // Configurar las columnas de la tabla
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colNivelFidelidad.setCellValueFactory(new PropertyValueFactory<>("nivelFidelidad"));

        // Asignar la lista a la tabla
        tablaResponsables.setItems(listaResponsables);
    }

    @FXML
    void agregarResponsable(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            String contacto = txtContacto.getText();
            String direccion = txtDireccion.getText();
            int nivelFidelidad = Integer.parseInt(txtNivelFidelidad.getText());

            Responsable nuevo = new Responsable(nombre, contacto, direccion, nivelFidelidad);
            listaResponsables.add(nuevo);

            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Nivel de fidelidad debe ser un número entero.");
        }
    }

    @FXML
    void eliminarResponsable(ActionEvent event) {
        Responsable seleccionado = tablaResponsables.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaResponsables.remove(seleccionado);
        } else {
            mostrarAlerta("Seleccione un responsable para eliminar.");
        }
    }

    @FXML
    void actualizarResponsable(ActionEvent event) {
        Responsable seleccionado = tablaResponsables.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setContacto(txtContacto.getText());
            seleccionado.setDireccion(txtDireccion.getText());
            try {
                seleccionado.setNivelFidelidad(Integer.parseInt(txtNivelFidelidad.getText()));
            } catch (NumberFormatException e) {
                mostrarAlerta("Nivel de fidelidad debe ser un número entero.");
                return;
            }
            tablaResponsables.refresh();
            limpiarCampos();
        } else {
            mostrarAlerta("Seleccione un responsable para actualizar.");
        }
    }

    @FXML
    void buscarResponsable(ActionEvent event) {
        String nombreBuscado = txtNombre.getText();
        for (Responsable r : listaResponsables) {
            if (r.getNombre().equalsIgnoreCase(nombreBuscado)) {
                txtContacto.setText(r.getContacto());
                txtDireccion.setText(r.getDireccion());
                txtNivelFidelidad.setText(String.valueOf(r.getNivelFidelidad()));
                tablaResponsables.getSelectionModel().select(r);
                return;
            }
        }
        mostrarAlerta("No se encontró un responsable con ese nombre.");
    }

    @FXML
    void volverInicio(ActionEvent event) {
        app.openViewInicio();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtContacto.clear();
        txtDireccion.clear();
        txtNivelFidelidad.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

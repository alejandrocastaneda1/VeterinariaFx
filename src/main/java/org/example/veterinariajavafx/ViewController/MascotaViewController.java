package org.example.veterinariajavafx.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.veterinariajavafx.App;
import org.example.veterinariajavafx.Model.Mascota;

public class MascotaViewController {

    private App app;

    @FXML
    private TableView<Mascota> tablaMascotas;
    @FXML
    private TableColumn<Mascota, String> colNombre, colEspecie, colRaza, colEdad, colPeso, colId;
    @FXML
    private TextField txtNombre, txtEspecie, txtRaza, txtEdad, txtPeso, txtId;

    private final ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();

    @FXML
    void volverInicio(ActionEvent event) {
        app.openViewInicio();
    }

    @FXML
    void agregarMascota(ActionEvent event) {
        try {
            Mascota m = new Mascota(
                    txtNombre.getText(),
                    txtEspecie.getText(),
                    txtRaza.getText(),
                    txtEdad.getText()
            );
            m.setPeso(txtPeso.getText());
            m.setId(txtId.getText());
            listaMascotas.add(m);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error", "Verifica los datos ingresados.");
        }
    }

    @FXML
    void eliminarMascota(ActionEvent event) {
        Mascota seleccionada = tablaMascotas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaMascotas.remove(seleccionada);
        } else {
            mostrarAlerta("Error", "Selecciona una mascota para eliminar.");
        }
    }

    @FXML
    void actualizarMascota(ActionEvent event) {
        Mascota seleccionada = tablaMascotas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setNombre(txtNombre.getText());
            seleccionada.setEspecie(txtEspecie.getText());
            seleccionada.setRaza(txtRaza.getText());
            seleccionada.setEdad(txtEdad.getText());
            seleccionada.setPeso(txtPeso.getText());
            seleccionada.setId(txtId.getText());
            tablaMascotas.refresh();
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Selecciona una mascota para actualizar.");
        }
    }

    @FXML
    void buscarMascota(ActionEvent event) {
        String nombreBuscado = txtNombre.getText().trim();
        for (Mascota m : listaMascotas) {
            if (m.getNombre().equalsIgnoreCase(nombreBuscado)) {
                txtEspecie.setText(m.getEspecie());
                txtRaza.setText(m.getRaza());
                txtEdad.setText(m.getEdad());
                txtPeso.setText(m.getPeso());
                txtId.setText(m.getId());
                tablaMascotas.getSelectionModel().select(m);
                return;
            }
        }
        mostrarAlerta("No encontrado", "No existe una mascota con ese nombre.");
    }

    @FXML
    void initialize() {
        colNombre.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNombre()));
        colEspecie.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEspecie()));
        colRaza.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getRaza()));
        colEdad.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEdad()));
        colPeso.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getPeso()));
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));

        tablaMascotas.setItems(listaMascotas);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtEspecie.clear();
        txtRaza.clear();
        txtEdad.clear();
        txtPeso.clear();
        txtId.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

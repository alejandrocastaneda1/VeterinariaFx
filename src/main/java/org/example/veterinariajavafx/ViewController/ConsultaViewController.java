package org.example.veterinariajavafx.ViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.veterinariajavafx.App;
import org.example.veterinariajavafx.Model.Consulta;

public class ConsultaViewController {

    private App app;

    @FXML
    private TableView<Consulta> tablaConsultas;
    @FXML
    private TableColumn<Consulta, String> colNumId, colFecha, colAnimalId;
    @FXML
    private TableColumn<Consulta, Float> colValorBase, colCostoFinal;
    @FXML
    private TextField txtNumId, txtFecha, txtAnimalId, txtValorBase, txtCostoFinal;

    private final ObservableList<Consulta> listaConsultas = FXCollections.observableArrayList();

    @FXML
    void volverInicio(ActionEvent event) {
        app.openViewInicio();
    }

    @FXML
    void agregarConsulta(ActionEvent event) {
        try {
            String numId = txtNumId.getText();
            String fecha = txtFecha.getText();
            String animalId = txtAnimalId.getText();
            float valorBase = Float.parseFloat(txtValorBase.getText());
            float costoFinal = Float.parseFloat(txtCostoFinal.getText());

            Consulta c = new Consulta(numId, fecha, animalId, valorBase, costoFinal);
            listaConsultas.add(c);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error", "Verifica los datos ingresados.");
        }
    }

    @FXML
    void eliminarConsulta(ActionEvent event) {
        Consulta seleccionada = tablaConsultas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaConsultas.remove(seleccionada);
        } else {
            mostrarAlerta("Error", "Selecciona una consulta para eliminar.");
        }
    }

    @FXML
    void actualizarConsulta(ActionEvent event) {
        Consulta seleccionada = tablaConsultas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setNumId(txtNumId.getText());
            seleccionada.setFecha(txtFecha.getText());
            seleccionada.setAnimalId(txtAnimalId.getText());
            seleccionada.setValorBase(Float.parseFloat(txtValorBase.getText()));
            seleccionada.setCostoFinal(Float.parseFloat(txtCostoFinal.getText()));
            tablaConsultas.refresh();
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Selecciona una consulta para actualizar.");
        }
    }

    @FXML
    void buscarConsulta(ActionEvent event) {
        String idBuscado = txtNumId.getText().trim();
        for (Consulta c : listaConsultas) {
            if (c.getNumId().equalsIgnoreCase(idBuscado)) {
                txtFecha.setText(c.getFecha());
                txtAnimalId.setText(c.getAnimalId());
                txtValorBase.setText(String.valueOf(c.getValorBase()));
                txtCostoFinal.setText(String.valueOf(c.getCostoFinal()));
                tablaConsultas.getSelectionModel().select(c);
                return;
            }
        }
        mostrarAlerta("No encontrado", "No existe una consulta con ese ID.");
    }

    @FXML
    void initialize() {
        colNumId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNumId()));
        colFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getFecha()));
        colAnimalId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getAnimalId()));
        colValorBase.setCellValueFactory(c -> new javafx.beans.property.SimpleFloatProperty(c.getValue().getValorBase()).asObject());
        colCostoFinal.setCellValueFactory(c -> new javafx.beans.property.SimpleFloatProperty(c.getValue().getCostoFinal()).asObject());

        tablaConsultas.setItems(listaConsultas);
    }

    private void limpiarCampos() {
        txtNumId.clear();
        txtFecha.clear();
        txtAnimalId.clear();
        txtValorBase.clear();
        txtCostoFinal.clear();
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

package org.example.veterinariajavafx.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.veterinariajavafx.App;
import org.example.veterinariajavafx.Model.Mascota;

public class MascotaViewController {
    App app;
    ObservableList<Mascota> listMascotas= FXCollections.observableArrayList();
    Mascota selectedMascota;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Mascota> tableMascotas;

    @FXML
    private TableColumn<Mascota, String> tcEspecieMascota;

    @FXML
    private TableColumn<Mascota, String> tcNombreMascota;

    @FXML
    void initialize() {
        this.app=app;
        initView();
    }

    public void setApp(App app) {
        this.app = app;
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerMascotas();

        // Limpiar la tabla
        tableMascotas.getItems().clear();

        // Agregar los elementos a la tabla
        tableMascotas.setItems(listMascotas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void obtenerMascotas() {
        listMascotas.addAll(mascotaController.obtenerListaMascotas());
    }

    private void initDataBinding() {
            tcNombreMascota.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void listenerSelection() {
        tableMascotas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMascota  = newSelection;
//            mostrarInformacionCliente(selectedCliente);
        });
    }
}

package org.example.veterinariajavafx.ViewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.veterinariajavafx.App;

public class InicioViewController {
App app;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void irAConsultas(ActionEvent event) {
        app.openViewConsulta();
    }

    @FXML
    void irAMascotas(ActionEvent event) {
        app.openViewMascota();

    }

    @FXML
    void irAResponsables(ActionEvent event) {
        app.openViewResponsable();

    }

    @FXML
    void initialize() {

    }
    public void setApp(App app) {
        this.app = app;
    }
}

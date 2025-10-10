package org.example.veterinariajavafx.ViewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.veterinariajavafx.App;

public class PropietarioViewController {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEnviarPropietario;

    @FXML
    private TextField tfNombrePropietario;

    @FXML
    void onEnviarForm(ActionEvent event) {
        app.openViewMascota();
    }

    @FXML
    void initialize() {
    }

    public void setApp(App app) {
        this.app = app;
    }
}

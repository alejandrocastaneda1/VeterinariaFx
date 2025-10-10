package org.example.veterinariajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.veterinariajavafx.ViewController.*;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión Veterinaria - Amigos Peludos 🐾");
        openViewInicio(); // Comienza con la pantalla de inicio
    }

    // -------------------------
    // MÉTODOS PARA CAMBIAR DE VISTA
    // -------------------------

    public void openViewInicio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/veterinariajavafx/CrudInicio.fxml"));
            AnchorPane rootLayout = loader.load();
            InicioViewController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openViewResponsable() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/veterinariajavafx/crudResponsable.fxml"));
            AnchorPane rootLayout = loader.load();
            ResponsableViewController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openViewMascota() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/veterinariajavafx/crudMascota.fxml"));
            AnchorPane rootLayout = loader.load();
            MascotaViewController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openViewConsulta() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/veterinariajavafx/crudConsulta.fxml"));
            AnchorPane rootLayout = loader.load();
            ConsultaViewController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

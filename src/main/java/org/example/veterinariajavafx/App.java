package org.example.veterinariajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.veterinariajavafx.ViewController.MascotaViewController;
import org.example.veterinariajavafx.ViewController.PropietarioViewController;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Mascotas");
        openViewPropietario();
    }

    private void openViewPropietario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudPropietario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PropietarioViewController propietarioViewController = loader.getController();
            propietarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void openViewMascota() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudMascota.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MascotaViewController mascotaViewController = loader.getController();
            mascotaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

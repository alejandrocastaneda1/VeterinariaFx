module co.edu.uniquindio.empresajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.veterinariajavafx to javafx.fxml;
    exports org.example.veterinariajavafx;

    opens org.example.veterinariajavafx.Model to javafx.fxml;
    exports org.example.veterinariajavafx.Model;

    opens org.example.veterinariajavafx.ViewController to javafx.fxml;
    exports org.example.veterinariajavafx.ViewController;

//    opens org.example.veterinariajavafx.controller to javafx.fxml;
//    exports org.example.veterinariajavafx.controller;
}
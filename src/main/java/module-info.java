module org.example.veterinariajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.veterinariajavafx to javafx.fxml;
    opens org.example.veterinariajavafx.ViewController to javafx.fxml;

    exports org.example.veterinariajavafx;
    exports org.example.veterinariajavafx.ViewController;
    exports org.example.veterinariajavafx.Model;
}

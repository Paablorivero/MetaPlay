module org.example.proyectometaplay {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectometaplay to javafx.fxml;
    exports org.example.proyectometaplay;
}
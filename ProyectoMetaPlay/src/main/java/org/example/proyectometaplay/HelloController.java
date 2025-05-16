package org.example.proyectometaplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      VBox_MenuPrincipal.setVisible(true);
        VBox_InicioSesion.setVisible(false);
        Vbox_Registro.setVisible(false);
    }

    //Paneles de la aplicacion
    @FXML
    private VBox VBox_MenuPrincipal;

    @FXML
    private VBox VBox_InicioSesion;

    @FXML
    private VBox Vbox_Registro;

    //Botones de la aplicacion
    @FXML
    private Button Btn_IniciarSesion;

    @FXML
    protected void onBtn_IniciarSesion() {
        VBox_MenuPrincipal.setVisible(false);
        VBox_InicioSesion.setVisible(true);
        Vbox_Registro.setVisible(false);
    }



}//
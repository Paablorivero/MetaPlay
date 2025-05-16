package org.example.proyectometaplay;

import Model.AccessSql;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    AccessSql miData = new AccessSql();


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
    private Button Btn_Registrarse;

    //Campos de Registro Usuario
    @FXML
    private TextField TextField_RegistroNombre;

    @FXML
    private TextField TextField_RegistroApellidos;

    @FXML
    private TextField TextField_RegistroUsuario;

    @FXML
    private TextField TextField_RegistroContraseña;

    @FXML
    private TextField TextField_RegistroCorreo;

    @FXML
    private TextField TextField_RegistroNacimiento;

    //Campos de Registro Empresa
    @FXML
    private TextField TextField_RegistroCIF;

    @FXML
    private TextField TextField_RegistroNombreEmpresa;

    @FXML
    private TextField TextField_RegistroContraseñaEmpresa;

    @FXML
    private TextField TextField_RegistroCorreoEmpresa;

    //Metodos
    @FXML
    protected void onBtn_IniciarSesion() {
        VBox_MenuPrincipal.setVisible(false);
        VBox_InicioSesion.setVisible(true);
        Vbox_Registro.setVisible(false);
    }

    @FXML
    protected void onBtn_Registrarse() {
        VBox_MenuPrincipal.setVisible(false);
        VBox_InicioSesion.setVisible(false);
        Vbox_Registro.setVisible(true);
    }




}//
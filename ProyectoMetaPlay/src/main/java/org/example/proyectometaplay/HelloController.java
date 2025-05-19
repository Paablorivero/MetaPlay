package org.example.proyectometaplay;

import Model.Empresa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VBox_MenuPrincipal.setVisible(true);
        VBox_InicioSesion.setVisible(false);
        Vbox_Registro.setVisible(false);


    }

    //Validaciones
    private boolean validateName(String name){
        return (name.length() > 3 && name.matches("[A-Z]{1}[a-z]{2,25}"));
    }

    private boolean validatePhone(String phone){
        return phone.matches("[1-9]{9}");
    }

    private boolean validateEmail(String email){
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailPattern);
    }

    private boolean validateDni(String dni) {
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }

    private boolean validateCif(String cif) {
        return cif.matches("[A-Z]{1}[0-9]{8}");
    }

    //Paneles de la aplicacion
    @FXML
    private VBox VBox_MenuPrincipal;

    @FXML
    private VBox VBox_InicioSesion;

    @FXML
    private VBox Vbox_Registro;

    //Botones de la aplicacion
    //Botones Pagina principal
    @FXML
    private Button Btn_IniciarSesion;
    @FXML
    private Button btn_MostrarJuegos;
    @FXML
    private Button btn_filtrarConsola;
    @FXML
    private Button btn_filtrarGenero;

    //Botones panel Iniciar sesion
    @FXML
    private Button Btn_Registrarse;
    @FXML
    private Button Btn_Acceder;

    //Botones panel registro
    @FXML
    private Button Btn_RegistrarUsuario;
    @FXML
    private Button Btn_RegistrarEmpresa;

    //Formulario Registrar Usuario
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

    //Formulario Registrar empresa
    @FXML
    private TextField TextField_RegistroCIF;
    @FXML
    private TextField TextField_RegistroNombreEmpresa;
    @FXML
    private TextField TextField_RegistroContraseñaEmpresa;
    @FXML
    private TextField TextField_RegistroCorreoEmpresa;

    @FXML
    protected void onBtn_IniciarSesion() {
        VBox_MenuPrincipal.setVisible(false);
        VBox_InicioSesion.setVisible(true);
        Vbox_Registro.setVisible(false);
    }
    @FXML
    protected void onBtn_RegistrarUsuario() {
        VBox_MenuPrincipal.setVisible(false);
        VBox_InicioSesion.setVisible(false);
        Vbox_Registro.setVisible(true);
    }

    @FXML
    protected void onBtn_RegistrarEmpresa() {
    //    Empresa newEmpresa = new Empresa(
        //TextField_RegistroCIF.getText(),
       // TextField_RegistroNombreEmpresa.getText(),
        //TextField_RegistroContraseñaEmpresa.getText(),
        //TextField_RegistroCorreoEmpresa.getText()

     //   );

    }

    @FXML
    protected void Btn_RegistrarUsuario() {}




}//
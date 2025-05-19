package org.example.proyectometaplay;

import Model.AccessSql;
import Model.Empresa;
import Model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private static AccessSql miData = new AccessSql();

    private void selectPanelVisible(int panel){
        switch (panel) {

            case 0:
                VBox_MenuPrincipal.setVisible(true);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                break;

            case 1:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(true);
                Vbox_Registro.setVisible(false);
                break;

            case 2:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(true);
                break;

            default:
                VBox_MenuPrincipal.setVisible(true);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
        }
    }
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
        selectPanelVisible(1);
    }
    @FXML
    protected void onBtn_RegistrarUsuario() {
    selectPanelVisible(2);
    }

    @FXML
    protected void onBtn_RegistrarEmpresa() {
        Empresa newEmpresa = new Empresa(
        TextField_RegistroCIF.getText(),
        TextField_RegistroNombreEmpresa.getText(),
        TextField_RegistroContraseñaEmpresa.getText(),
        TextField_RegistroCorreoEmpresa.getText()
      );
        miData.registrarEmpresa(newEmpresa);
        selectPanelVisible(1);

    }

    @FXML
    protected void Btn_RegistrarUsuario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(TextField_RegistroNacimiento.getText(), formatter);
        Usuario newUsuario = new Usuario(
                TextField_RegistroNombre.getText(),
                TextField_RegistroApellidos.getText(),
                TextField_RegistroUsuario.getText(),
                TextField_RegistroContraseña.getText(),
                TextField_RegistroCorreo.getText(),
                fechaNacimiento

                );
        miData.registrarUsuario(newUsuario);
        selectPanelVisible(1);
    }




}//
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
import java.util.List;
import javafx.scene.control.Alert;

import javafx.event.ActionEvent;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private static AccessSql miData = new AccessSql();
    //Metodo para administrar el panel que quiero que este visible
    private void selectPanelVisible(int panel){
        switch (panel) {

            case 0:
                VBox_MenuPrincipal.setVisible(true);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);

                break;

            case 1:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(true);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                break;

            case 2:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(true);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                break;
            case 3:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(true);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                break;
            case 4:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(true);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                break;
            case 5:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(true);
                Vbox_BusquedaFiltrada.setVisible(false);
                break;
            case 6:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(true);
                break;
            default:
                VBox_MenuPrincipal.setVisible(true);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
        }
    }
    //Metodo para limpiar las celdas del formulario de registrar cada vez que entremos en el panel de registrar
    private void limpiarFormulario() {
        TextField_RegistroCIF.setText("");
        TextField_RegistroNombreEmpresa.setText("");
        TextField_RegistroContraseñaEmpresa.setText("");
        TextField_RegistroCorreoEmpresa.setText("");
        TextField_RegistroNombre.setText("");
        TextField_RegistroApellidos.setText("");
        TextField_RegistroUsuario.setText("");
        TextField_RegistroContraseña.setText("");
        TextField_RegistroCorreo.setText("");
        TextField_RegistroNacimiento.setText("");
    }
    //Metodo para limpiar iniciar sesion
    private void cleanLogIn(){
        TextField_InicioSesionUsuario.setText("");
        TextField_InicioSesionContraseña.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    selectPanelVisible(0);

    TextField_RegistroNombre.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue){
            if(!validateName(TextField_RegistroNombre.getText())){
                TextField_RegistroNombre.setText("");
                TextField_RegistroNombre.setPromptText("Valor incorrecto");
            }
        }
    });
    TextField_RegistroNombreEmpresa.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue){
            if(!validateName(TextField_RegistroNombreEmpresa.getText())){
                TextField_RegistroNombreEmpresa.setText("");
                TextField_RegistroNombreEmpresa.setPromptText("Valor incorrecto");
            }
        }
    });

    TextField_RegistroCorreo.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue){
            if(!validateEmail(TextField_RegistroCorreo.getText())){
                TextField_RegistroCorreo.setText("");
                TextField_RegistroCorreo.setPromptText("Valor incorrecto");
            }
        }
    });

    TextField_RegistroCorreoEmpresa.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue){
            if(!validateEmail(TextField_RegistroCorreoEmpresa.getText())){
                TextField_RegistroCorreoEmpresa.setText("");
                TextField_RegistroCorreoEmpresa.setPromptText("Valor incorrecto");
            }
        }
    });

    TextField_RegistroCIF.focusedProperty().addListener((observable, oldValue, newValue) -> {
        if(!newValue){
            if(!validateCif(TextField_RegistroCIF.getText())){
                TextField_RegistroCIF.setText("");
                TextField_RegistroCIF.setPromptText("Valor incorrecto");
            }
        }
    });

    TextField_RegistroNacimiento.setPromptText("dd/MM/yyyy");



    }

    //Validaciones
    private boolean validateName(String name){
        return (name.length() > 3 && name.matches("[A-Z]{1}[a-z]{2,25}"));
    }


    private boolean validateEmail(String email){
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailPattern);
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

    @FXML
    private VBox Vbox_MenuDeUsuario;

    @FXML
    private VBox Vbox_MejorValorados;

    @FXML
    private VBox VboxFiltrarJuego;

    @FXML
    private VBox Vbox_BusquedaFiltrada;

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
    @FXML
    private Button Btn_atras_InicioSesion;

    //Botones panel registro
    @FXML
    private Button Btn_RegistrarUsuario;
    @FXML
    private Button Btn_RegistrarEmpresa;
    @FXML
    private Button btn_atras_Registrarse;


    //Botones mejor valorados
    @FXML
    private Button Btn_VolverInicio;
    @FXML
    private Button btn_atras_MejorValorados;

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

    //Texfiel inicio sesion
    @FXML
    private TextField TextField_InicioSesionUsuario;
    @FXML
    private TextField TextField_InicioSesionContraseña;

    @FXML
    protected void onBtn_IniciarSesion() {
        selectPanelVisible(1);
        cleanLogIn();
    }
    @FXML
    protected void onBtn_Registrarse() {
    selectPanelVisible(2);
    limpiarFormulario();
    }

    @FXML
    protected void onBtn_atras_Registrarse() {
        selectPanelVisible(1);
        limpiarFormulario();
    }
    @FXML
    protected void onBtn_atras_InicioSesion() {
        selectPanelVisible(0);
    }

    //registrar Empresa
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
    //Registrar Usuario
    @FXML
    protected void onBtn_RegistrarUsuario() {
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

    @FXML
    protected void onBtn_Acceder() {
        String usuarioInt = TextField_InicioSesionUsuario.getText();
        String password = TextField_InicioSesionContraseña.getText();

        // Obtener la lista de usuarios de la base de datos
        List <Usuario> usuarios = miData.getUsuarios();

        // Buscar coincidencia de usuario y contraseña
        boolean credencialesValidas = false;
        Usuario usuarioAutenticado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(usuarioInt) &&
                    usuario.getContrasena().equals(password)) {
                credencialesValidas = true;
                usuarioAutenticado = usuario;
                break;
            }
        }
        if(credencialesValidas == true) {
            selectPanelVisible(3);
        }else {
            showAlert(Alert.AlertType.ERROR, "Error", "Usuario o contraseña incorrectos");
            cleanLogIn();
        }

    }
    //Mostrar alertas
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();}


    //Boton del menu de usuario a mejores valorados
    @FXML
    private void onBtn_MostrarJuegos(){
        selectPanelVisible(4);
    }
    @FXML
    private void onBtn_VolverInicio(){
        selectPanelVisible(0);
    }
    @FXML
    private void onbtn_atras_MejorValorados(){
        selectPanelVisible(0);
    }



}//
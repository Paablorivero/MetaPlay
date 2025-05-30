package org.example.proyectometaplay;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

import javafx.event.ActionEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//DECLARACION DE VARIABLES
    private static AccessSql miData = new AccessSql();
    private ObservableList<VideoJuego> VideojuegosFiltrados = FXCollections.observableArrayList();
    List<VideoJuego> filtroGenero = FXCollections.observableArrayList();
    private int tipoDeFiltro = 0;
    String seleccionFiltro;

//PANELES DE LA APP
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

    @FXML
    private VBox Vbox_SeleccionJuego;

//PAGINA PRINCIPAL
    @FXML
    private Button Btn_IniciarSesion;
    @FXML
    private Button btn_MostrarJuegos;
    @FXML
    private Button btn_filtrarConsola;
    @FXML
    private Button btn_filtrarGenero;

//INICIO DE SESION
    @FXML
    private Button Btn_Registrarse;
    @FXML
    private Button Btn_Acceder;
    @FXML
    private Button Btn_atras_InicioSesion;
    @FXML
    private TextField TextField_InicioSesionUsuario;
    @FXML
    private TextField TextField_InicioSesionContraseña;

//VENTANA DE REGISTRO
    @FXML
    private Button Btn_RegistrarUsuario;
    @FXML
    private Button Btn_RegistrarEmpresa;
    @FXML
    private Button btn_atras_Registrarse;
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

//VENTANA MEJOR VALORADOS
    @FXML
    private Button Btn_VolverInicio;
    @FXML
    private Button btn_atras_MejorValorados;
    @FXML
    private ListView<VideoJuego> ListView_MejorValorados;

//VENTANA REGISTRAR EMPRESA
    @FXML
    private TextField TextField_RegistroCIF;
    @FXML
    private TextField TextField_RegistroNombreEmpresa;
    @FXML
    private TextField TextField_RegistroContraseñaEmpresa;
    @FXML
    private TextField TextField_RegistroCorreoEmpresa;

//VENTANA FILTRO
    @FXML
    private ChoiceBox<String> SeleccionFiltro;

//VENTANA BUSQUEDA FILTRADA
    @FXML
    private ListView<VideoJuego> ListView_JuegosFiltrados;

//ACCIONES DE BOTONES
    //Navegacion entre paneles
    @FXML
    protected void onInicioButton(ActionEvent event){//Boton comun para volver al menu principal
        //Ir al panel inicial
        selectPanelVisible(0);
        limpiarFormulario();
        cleanLogIn();
        SeleccionFiltro.getItems().clear();
    }

    @FXML
    protected void onEntrarMenuFiltrarConsolaButton(ActionEvent event){
        selectPanelVisible(5);
        FiltroConsola();
        tipoDeFiltro = 0;
    }

    @FXML
    protected void onEntrarMenuFiltrarGeneroButton(ActionEvent event){
        selectPanelVisible(5);
        FiltroGenero();
        seleccionFiltro = SeleccionFiltro.getValue();
        List<VideoJuego> filtroGenero = miData.getVideoJuegosGenero(convertirTextoAGenero(seleccionFiltro));
        tipoDeFiltro = 1;
    }

    @FXML
    protected void onFiltrarButton(ActionEvent event){
        selectPanelVisible(6);
        VideojuegosFiltrados.addAll(filtroGenero);
        ListView_JuegosFiltrados.setItems(VideojuegosFiltrados);
    }



//METODO INICIALIZADOR
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    selectPanelVisible(0);

    //Validaciones de los campos de texto
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

    //Le damos un formato de celdas al listview Para que salga bien los mejores valorados
        ListView_MejorValorados.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(VideoJuego videojuego, boolean empty) {
                super.updateItem(videojuego, empty);
                if (empty || videojuego == null) {
                    setText(null);
                } else {
                    setText(String.format("ID: %d, Nombre: %s, Puntuación Global: %.2f",
                            videojuego.getId(),
                            videojuego.getNombre(),
                            videojuego.getPuntuacionGlobal()));
                }
            }
        });

    //Listview para los mejores valorados
        try {
            ListView_MejorValorados.setItems(FXCollections.observableList(miData.obtenerMejoresVideojuegos()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//FIN DE METODO INICIALIZADOR

//VALIDACIONES DE LOS CAMPOS DE TEXTO
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
        alert.showAndWait();
    }

    private void FiltroConsola() {
        SeleccionFiltro.getItems().addAll("PlayStation 5", "Xbox Series X", "Nintendo Switch", "PC", "PlayStation 4");
        SeleccionFiltro.setValue("Seleccione Consola");

        // Listener para detectar cambios
        SeleccionFiltro.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Seleccionaste: " + newVal);
        });
    }

    private void FiltroGenero() {
        SeleccionFiltro.getItems().addAll("ACCION", "AVENTURA", "CATASTROFE", "CIENCIA_FICCION",
        "COMEDIA", "DOCUMENTALES", "DRAMA", "FANTASIA");
        SeleccionFiltro.setValue("Seleccione Genero");

        // Listener para detectar cambios
        SeleccionFiltro.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Seleccionaste: " + newVal);
        });
    }

    //Boton del menu de usuario a mejores valorados
    @FXML
    private void onBtn_MostrarJuegos(){
        selectPanelVisible(4);
    }

    //METODOS DE LIMPIEZA DE FORMULARIO
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

    //METODO PARA SELECCION DE PANELES
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
                Vbox_SeleccionJuego.setVisible(false);
                break;

            case 1:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(true);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
                break;

            case 2:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(true);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
                break;
            case 3:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(true);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
                break;
            case 4:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(true);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
                break;
            case 5:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(true);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
                break;
            case 6:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(true);
                Vbox_SeleccionJuego.setVisible(false);
                break;
            case 7:
                VBox_MenuPrincipal.setVisible(false);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(true);
                break;
            default:
                VBox_MenuPrincipal.setVisible(true);
                VBox_InicioSesion.setVisible(false);
                Vbox_Registro.setVisible(false);
                Vbox_MenuDeUsuario.setVisible(false);
                Vbox_MejorValorados.setVisible(false);
                VboxFiltrarJuego.setVisible(false);
                Vbox_BusquedaFiltrada.setVisible(false);
                Vbox_SeleccionJuego.setVisible(false);
        }
    }

    public static GeneroV convertirTextoAGenero(String texto) {
        switch (texto) {
            case "ACCION":
                return GeneroV.ACCION;
            case "AVENTURA":
                return GeneroV.AVENTURA;
            case "CATASTROFE":
                return GeneroV.CATASTROFE;
            case "CIENCIA_FICCION":
                return GeneroV.CIENCIA_FICCION;
            case "COMEDIA":
                return GeneroV.COMEDIA;
            case "DOCUMENTALES":
                return GeneroV.DOCUMENTALES;
            case "DRAMA":
                return GeneroV.DRAMA;
            case "FANTASIA":
                return GeneroV.FANTASIA;
            default:
                return null;
        }
    }
}//
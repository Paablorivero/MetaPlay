package Model;




import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccessSql {

    //acceder a todos videojuegos
    public List<VideoJuego> getVideojuegos() {
        List<VideoJuego> videojuegos = new LinkedList<>();

        String prod = "SELECT * FROM Videojuegos";

        try (Connection connection = DataBaseSql.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                int id_consola = dataSet.getInt(2);
                String titulo = dataSet.getString(3);
                GeneroV genero = GeneroV.valueOf(dataSet.getString(4));
                String desarrollador = dataSet.getString(5);
                double precio = dataSet.getDouble(6);


                VideoJuego v = new VideoJuego(id, id_consola, titulo, genero, desarrollador, precio);
                videojuegos.add(v);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return videojuegos;
    }

    //acceder a todos los usuarios
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new LinkedList<>();

        String prod = "SELECT * FROM Usuario";

        try (Connection connection = DataBaseSql.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                String nombre = dataSet.getString(2);
                String apellido = dataSet.getString(3);
                String usuario = dataSet.getString(4);
                String contrasena = dataSet.getString(5);
                String correo = dataSet.getString(6);
                LocalDate fechaNacimiento = LocalDate.parse(dataSet.getString(7));


                Usuario u = new Usuario(id, nombre, apellido, usuario, contrasena, correo, fechaNacimiento);
                usuarios.add(u);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }

    //acceder a todos los valoraciones de los usuarios
    public List<Valoracion_Usuario> getValoracionesUsuarios() {
        List<Valoracion_Usuario> valoracionUsuarios = new LinkedList<>();

        String prod = "SELECT * FROM Valoracion_Usuario";

        try (Connection connection = DataBaseSql.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                int idVideojuego = dataSet.getInt(2);
                int idUsuario = dataSet.getInt(3);
                int puntuacion = dataSet.getInt(4);
                String comentario = dataSet.getString(5);
                LocalDate fechaValoracion = LocalDate.parse(dataSet.getString(6));


                Valoracion_Usuario vu = new Valoracion_Usuario(id, idVideojuego, idUsuario, puntuacion, comentario, fechaValoracion);
                valoracionUsuarios.add(vu);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valoracionUsuarios;
    }


    //acceder a todos los valoraciones de la empresas
    public List<Valoracion_Empresa> getValoracionesEmpresas() {
        List<Valoracion_Empresa> valoracionEmpresas = new LinkedList<>();

        String prod = "SELECT * FROM Valoracion_Empresa";

        try (Connection connection = DataBaseSql.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                int idVideojuego = dataSet.getInt(2);
                int cifEmpresa = dataSet.getInt(3);
                int puntuacion = dataSet.getInt(4);
                String comentario = dataSet.getString(5);
                LocalDate fechaValoracion = LocalDate.parse(dataSet.getString(6));


                Valoracion_Empresa ve = new Valoracion_Empresa(id, idVideojuego, cifEmpresa, puntuacion, comentario, fechaValoracion);
                valoracionEmpresas.add(ve);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valoracionEmpresas;
    }

    //registrar un videojuego
    public static void registrarVideojuego(VideoJuego juego) {

        String sql = "INSERT INTO Videojuegos (ID, Consola_ID, Nombre, Genero, Desarrollador, Precio) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, juego.getId());
            statement.setInt(2, juego.getId_consola());
            statement.setString(3, juego.getNombre());
            statement.setString(4, juego.getGenero().toString());
            statement.setString(5, juego.getDesarrollador().toString());
            statement.setDouble(6, juego.getPrecio());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar videojuego: " + e.getMessage());
        }
    }

    //registrar un cliente
    public static void registrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO Usuario (ID, Nombre, Apellidos, Usuario, Contasena, Correo, Fecha_Nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

           statement.setInt(1, usuario.getId());
           statement.setString(2, usuario.getNombre());
           statement.setString(3, usuario.getApellidos());
           statement.setString(4, usuario.getUsuario());
           statement.setString(5, usuario.getContrasena());
           statement.setString(6, usuario.getCorreo());
           statement.setDate(7, java.sql.Date.valueOf(usuario.getFechaNacimiento()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    //registrar una empresa
    public static void registrarEmpresa(Empresa empresa) {

        String sql = "INSERT INTO Empresa (CIF, Nombre, Contasena, Correo) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, empresa.getCif());
            statement.setString(2, empresa.getNombre());
            statement.setString(3, empresa.getContrasena());
            statement.setString(4, empresa.getCorreo());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar empresa: " + e.getMessage());
        }
    }


    //registrar una consola
    public static void registrarConsola(Consola consola) {

        String sql = "INSERT INTO Consola (ID, Nombre, Empresa_desarrolladora) VALUES (?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, consola.getId());
            statement.setString(2, consola.getNombre());
            statement.setString(3, consola.getEmpresaDesarrollo());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar consola: " + e.getMessage());
        }
    }


    //insertar una valoracion del usuario
    public static void valoracionUsuario(Valoracion_Usuario valoracion_usuario) {

        String sql = "INSERT INTO Valoracion_Usuario (ID, Videojuego_ID, Usuario_ID, Puntuacion, Comentario, Fecha_valoracion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, valoracion_usuario.getId());
            statement.setInt(2, valoracion_usuario.getIdVideojuego());
            statement.setInt(3, valoracion_usuario.getIdUsuario());
            statement.setInt(4, valoracion_usuario.getPuntuacion());
            statement.setString(5, valoracion_usuario.getComentario());
            statement.setDate(6, java.sql.Date.valueOf(valoracion_usuario.getFechaValoracion()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar valoracion del usuario: " + e.getMessage());
        }
    }


    //insertar una valoracion de la empresa
    public static void valoracionEmpresa(Valoracion_Empresa valoracion_empresa) {

        String sql = "INSERT INTO Valoracion_Empresa (ID, Videojuego_ID, Empresa_CIF, Puntuacion, Comentario, Fecha_valoracion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, valoracion_empresa.getId());
            statement.setInt(2, valoracion_empresa.getIdVideojuego());
            statement.setInt(3, valoracion_empresa.getCifEmpresa());
            statement.setInt(4, valoracion_empresa.getPuntuacion());
            statement.setString(5, valoracion_empresa.getComentario());
            statement.setDate(6, java.sql.Date.valueOf(valoracion_empresa.getFechaValoracion()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar valoracion del usuario: " + e.getMessage());
        }
    }




    //Encontrar en la lista los videojuegos de un genero exacto (filtro por genero)

    public List<VideoJuego> getVideoJuegosGenero(GeneroV genero) {
        List<VideoJuego> videoJuegos = new ArrayList<>();

        String sql = "SELECT ID, Consola_ID, Nombre, Genero, Desarrollador, Precio FROM Videojuegos WHERE Genero=?";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, genero.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    VideoJuego juego = new VideoJuego();
                    juego.setId(resultSet.getInt("ID"));
                    juego.setId_consola(resultSet.getInt("Consola_ID"));
                    juego.setNombre(resultSet.getString("Nombre"));
                    juego.setGenero(GeneroV.fromString(resultSet.getString("Genero")));
                    juego.setDesarrollador(resultSet.getString("Desarrollador"));
                    juego.setPrecio(resultSet.getDouble("Precio"));
                    videoJuegos.add(juego);

                }
            }

        } catch (SQLException e){
            System.out.println("Error al consultar videoJuegos de genero: " + e.getMessage());
        }

        return videoJuegos;
    }

    //Encontrar en la lista los videojuegos de una consola exacta (filtro por consola)

    public List<VideoJuego> getVideoJuegosConsola(Consola consola) {
        List<VideoJuego> videoJuegos = new ArrayList<>();

        String sql = "SELECT ID, Consola_ID, Nombre, Genero, Desarrollador, Precio FROM Videojuegos WHERE Consola_ID=?";

        try (Connection connection = DataBaseSql.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, consola.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    VideoJuego juego = new VideoJuego();
                    juego.setId(resultSet.getInt("ID"));
                    juego.setId_consola(resultSet.getInt("Consola_ID"));
                    juego.setNombre(resultSet.getString("Nombre"));
                    juego.setGenero(GeneroV.fromString(resultSet.getString("Genero")));
                    juego.setDesarrollador(resultSet.getString("Desarrollador"));
                    juego.setPrecio(resultSet.getDouble("Precio"));
                    videoJuegos.add(juego);

                }
            }

        } catch (SQLException e){
            System.out.println("Error al consultar videoJuegos de genero: " + e.getMessage());
        }

        return videoJuegos;
    }











































}

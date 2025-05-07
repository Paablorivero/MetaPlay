package Model;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class AccessDCuniverseSQL {

    //acceder a todos videojuegos
    public List<VideoJuego> getVideojuegos() {
        List<VideoJuego> videojuegos = new LinkedList<>();

        String prod = "SELECT * FROM Videojuegos";

        try (Connection connection = DataBaseManagerSQL.getConnection(); Statement statement = connection.createStatement();
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

        try (Connection connection = DataBaseManagerSQL.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                String nombre = dataSet.getString(2);
                String apellido = dataSet.getString(3);
                String usuario = dataSet.getString(4);
                String correo = dataSet.getString(5);
                LocalDate fechaNacimiento = LocalDate.parse(dataSet.getString(6));


                Usuario u = new Usuario(id, nombre, apellido, usuario, correo, fechaNacimiento);
                usuarios.add(u);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }

















































}

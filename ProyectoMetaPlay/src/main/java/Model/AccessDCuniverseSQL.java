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
        List<VideoJuego> productos = new LinkedList<>();

        String prod = "SELECT * FROM Videojuegos";

        try (Connection connection = DataBaseManagerSQL.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(prod);) {
            while(dataSet.next()){

                int id = dataSet.getInt(1);
                String titulo = dataSet.getString(2);
                java.sql.Date sqlDate = dataSet.getDate(3);

                //convertir DATA de sql en LocalDate java
                LocalDate fecha_reg = sqlDate.toLocalDate();

                Articulo a =  new Articulo(cod, titulo, fecha_reg);
                productos.add(a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }


















































}

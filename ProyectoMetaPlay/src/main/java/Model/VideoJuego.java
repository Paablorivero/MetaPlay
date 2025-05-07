package Model;

public class VideoJuego {

    private String id;
    private String id_consola;
    private String nombre;
    private GeneroV genero;
    private String desarrollador;
    private double precio;

    public VideoJuego(String id, String id_consola, String nombre, GeneroV genero, String desarrollador, double precio) {
        this.id = id;
        this.id_consola = id_consola;
        this.nombre = nombre;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getId_consola() {
        return id_consola;
    }

    public GeneroV getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public String toString() {
        return "VideoJuego{" +
                "id='" + id + '\'' +
                ", id_consola='" + id_consola + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", desarrollador='" + desarrollador + '\'' +
                ", precio=" + precio +
                '}';
    }
}

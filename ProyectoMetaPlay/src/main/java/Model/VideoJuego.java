package Model;

public class VideoJuego {

    private int id;
    private int id_consola;
    private String nombre;
    private GeneroV genero;
    private String desarrollador;
    private double precio;

    public VideoJuego(int id, int id_consola, String nombre, GeneroV genero, String desarrollador, double precio) {
        this.id = id;
        this.id_consola = id_consola;
        this.nombre = nombre;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.precio = precio;
    }

    public VideoJuego() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_consola() {
        return id_consola;
    }

    public void setId_consola(int id_consola) {
        this.id_consola = id_consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GeneroV getGenero() {
        return genero;
    }

    public void setGenero(GeneroV genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

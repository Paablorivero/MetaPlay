package Model;

public class Empresa {

    private int cif;
    private String nombre;
    private String contrasena;
    private String correo;

    public Empresa(int cif, String nombre, String contrasena, String correo) {
        this.cif = cif;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public int getCif() {
        return cif;
    }

    public void setCif(int cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cif=" + cif +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

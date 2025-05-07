package Model;

public class Consola {
    private String id;
    private String nombre;
    private String empresaDesarrollo;

    public Consola(String id, String nombre, String empresaDesarrollo) {
        this.id = id;
        this.nombre = nombre;
        this.empresaDesarrollo = empresaDesarrollo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresaDesarrollo() {
        return empresaDesarrollo;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", empresaDesarrollo='" + empresaDesarrollo + '\'' +
                '}';
    }
}

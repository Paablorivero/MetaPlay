package Model;

import java.time.LocalDate;

public class Valoracion {

    private String id;
    private String videojuegoId;
    private String usuarioId;
    private int valoracion;
    private String comentario;
    private LocalDate fecha;

    public Valoracion(String id, String videojuegoId, String usuarioId, int valoracion, String comentario, LocalDate fecha) {
        this.id = id;
        this.videojuegoId = videojuegoId;
        this.usuarioId = usuarioId;
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVideojuegoId(String videojuegoId) {
        this.videojuegoId = videojuegoId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Valoracion{" +
                "id='" + id + '\'' +
                ", videojuegoId='" + videojuegoId + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", valoracion=" + valoracion +
                ", comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}

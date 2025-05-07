package org.example.proyectometaplay;

import Model.AccessDCuniverseSQL;
import Model.Usuario;
import Model.VideoJuego;

import java.util.List;

public class MainTest {

    private static AccessDCuniverseSQL BD = new AccessDCuniverseSQL();

    public static void main(String[] args) {

    monstrarVideojuegos();
    monstrarUsuarios();
    }
        public static void monstrarVideojuegos() {
            List<VideoJuego> videojuegos = BD.getVideojuegos();
            for (VideoJuego videojuego : videojuegos) {
                System.out.println(videojuego.toString());
            }

            if (videojuegos.isEmpty()) {
                System.out.println("No hay videojuegos");
            }

        }

    public static void monstrarUsuarios() {
        List<Usuario> usuarios = BD.getUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
        }
    }








    }








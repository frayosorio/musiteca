package musiteca;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class ReproductorMP3 {

    private static Player reproductor;

    public static void detener() {
        if (reproductor != null) {
            reproductor.close();
            reproductor = null;
        }
    }

    public static void reproducir(String nombreArchivo) {
        detener();
        try {
            FileInputStream fis = new FileInputStream(nombreArchivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            reproductor = new Player(bis);

        } catch (Exception e) {
        }

        //Ejecutar en nuevo hilo, la reproducción de la canción
        new Thread() {

            public void run() {
                try {
                    reproductor.play();
                } catch (Exception e) {
                }
            }

        }.start();
    }

}

package proyectoprubeas;

import javax.imageio.IIOException;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Sonidos {
    private Clip clip;
    public Sonidos() {
    }


    public void reproducirSonido(String ruta, boolean enLoop) {
        try {
            File archivo = new File(ruta);
            InputStream inputStream = Sonidos.class.getResourceAsStream(ruta);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if (enLoop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void detenerSonido() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

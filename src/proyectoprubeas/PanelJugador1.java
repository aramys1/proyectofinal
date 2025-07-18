package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PanelJugador1 extends JPanel {
    Jugador1 jugador1;
    Color color;
    private Image imagen;
    private Image imagen2;
    private boolean seleccionado = false;
    public PanelJugador1(){
        this.setOpaque(false);
        imagen = new ImageIcon(getClass().getResource("/panama.png")).getImage();
        imagen2 = new ImageIcon(getClass().getResource("/united-states.png")).getImage();

    }

    public void setJugador1(Jugador1 jugador1){
        this.jugador1 = jugador1;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public Image getImagenEquipo1(){
        return imagen;
    }

    public Image getImagenEquipo2(){
        return imagen2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (jugador1 != null) {
            g.drawImage(imagen,(int)jugador1.getX(),(int)jugador1.getY(),(int) jugador1.getDiametro(),(int) jugador1.getDiametro(),this );

        }
    }

    public void setImagen(Image imagenEquipo1) {
        this.imagen = imagenEquipo1;
    }



}

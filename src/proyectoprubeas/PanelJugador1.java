package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PanelJugador1 extends JPanel {
    Jugador1 jugador1;
    Color color;
    public PanelJugador1(){
        this.setOpaque(false);

    }

    public void setJugador1(Jugador1 jugador1){
        this.jugador1 = jugador1;
    }
    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval((int)jugador1.getX(), (int)jugador1.getY(), (int)jugador1.getDiametro(), (int)jugador1.getDiametro());
    }

}

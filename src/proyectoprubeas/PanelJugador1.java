package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PanelJugador1 extends JPanel {
    Jugador1 jugador1;
    public PanelJugador1(){
        this.setOpaque(false);
    }

    public void setJugador1(Jugador1 jugador1){
        this.jugador1 = jugador1;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int)jugador1.getX(), (int)jugador1.getY(), 40, 40);
    }

}

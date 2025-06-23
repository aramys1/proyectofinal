package proyectoprubeas;

import javax.swing.*;
import java.awt.*;



public class PanelPelota extends JPanel {
    private Balon balon;

    public PanelPelota(){
        setOpaque(false);
    }

      public void setBalon(Balon balon){
            this.balon = balon;
      }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int)balon.getX(), (int)balon.getY(), 40, 40);
    }
}

package proyectoprubeas;

import javax.swing.*;
import java.awt.*;



public class PanelPelota extends JPanel {
    private Balon balon;
    private Image imagenBalon;

    public PanelPelota(){
        setOpaque(false);
        imagenBalon = new ImageIcon(getClass().getResource("/football.png")).getImage();
    }

      public void setBalon(Balon balon){
            this.balon = balon;
      }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (balon != null) {
            g.drawImage(imagenBalon,(int)balon.getX(),(int)balon.getY(),(int) balon.getDiametro(),(int) balon.getDiametro(),this );
        }
    }
}

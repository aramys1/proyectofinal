package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PanelConimagenes extends JPanel {
    private Image imagen;

    public PanelConimagenes(String ruta) {
        this.imagen = new ImageIcon(ruta).getImage();
        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}

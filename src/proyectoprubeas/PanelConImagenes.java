package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PanelConImagenes extends JPanel {
    private Image imagen;

    public PanelConImagenes(String ruta) {
        this.imagen = new ImageIcon(ruta).getImage();
        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}

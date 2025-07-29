package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class CampoFutbol extends JPanel {

    private Image fondo = new ImageIcon(getClass().getResource("/Oficial.png")).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));

        int w = getWidth();
        int h = getHeight();

        g.drawImage(fondo, 0, 0, w, h, this);


        // Líneas del campo
        g2.drawLine(w / 2, 0, w / 2,  h); // Línea central
        g2.drawOval(w / 2 - 100, h / 2 - 100, 200, 200); // Círculo central

        // Área grande izquierda y derecha
        g2.drawRect(-1, h / 2 - 200, 200, 400); // izquierda
        g2.drawRect(w - 190, h / 2 - 200, 200, 400); // derecha

        g2.drawArc(w - 150 - 90, h / 2 - 75, 100, 150, 90, 180);
        g2.drawArc(50 + 100 - 0, h / 2 - 75, 100, 150, 270, 180);




    }
}

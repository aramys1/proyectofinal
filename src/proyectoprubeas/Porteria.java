package proyectoprubeas;

import java.awt.*;

public class Porteria {
    private Rectangle area;

    public Porteria(int x, int y, int ancho, int alto) {
        this.area = new Rectangle(x, y, ancho, alto);
    }

    public boolean balonEntra(Rectangle balon) {
        return area.intersects(balon);
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(area.x, area.y, area.width, area.height);
    }

    public Rectangle getArea() {
        return area;
    }
}




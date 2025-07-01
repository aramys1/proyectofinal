package proyectoprubeas;

import java.awt.*;

public class Balon {

    double x = 200;
    double y = 200;
    double velocidadY = 0;
    double velocidadX = 0;
    double diametro = 40;



    public Balon(){

    }

    //metodo que mueve el balon
    public void moverBalon(){
        if(Math.abs(this.velocidadX) < 0.01) this.velocidadX = 0;
        if(Math.abs(this.velocidadY) < 0.01) this.velocidadY = 0;

        x = x + velocidadX;
        y = y + velocidadY;

        if (x < 0) {
            x = 0; // Ajustar posición para que no se salga
            velocidadX *= -1; // Invertir dirección X
            System.out.println("Jugador golpeó pared izquierda y rebotó!");
            velocidadX = velocidadX * 0.7;
            velocidadY = velocidadY * 0.7;

        } else if (x + diametro > Constantes.WIDTH_PANTALLA) {
            x = Constantes.WIDTH_PANTALLA - diametro; // Ajustar posición
            velocidadX *= -1; // Invertir dirección X
            System.out.println("Jugador golpeó pared derecha y rebotó!");
            velocidadX = velocidadX * 0.7;
            velocidadY = velocidadY * 0.7;
        }

        // Comprobar colisión con bordes verticales y rebotar
        if (y < 0) {
            y = 0; // Ajustar posición
            velocidadY *= -1; // Invertir dirección Y
            System.out.println("Jugador golpeó pared superior y rebotó!");
            velocidadX = velocidadX * 0.7;
            velocidadY = velocidadY * 0.7;
        } else if (y + diametro > Constantes.HEIGHT_PANTALLA) {
            y = Constantes.HEIGHT_PANTALLA - diametro; // Ajustar posición
            velocidadY *= -1; // Invertir dirección Y
            System.out.println("Jugador golpeó pared inferior y rebotó!");
            velocidadX = velocidadX * 0.7;
            velocidadY = velocidadY * 0.7;
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, (int)diametro+10, (int)diametro+10);
    }



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVelocidadY() {
        return velocidadY;
    }

    public double getVelocidadX() {
        return velocidadX;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelocidadX(double velocidadX) {
        this.velocidadX = velocidadX;
    }

    public void setVelocidadY(double velocidadY) {
        this.velocidadY = velocidadY;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
}

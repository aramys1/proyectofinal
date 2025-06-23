package proyectoprubeas;

import java.awt.*;

public class Jugador1 {
    double x = 300;
    double y = 50;
    double velocidadX = 0;
    double velocidadY = 0;
    double ancho = 40;
    double alto = 40;



    public Jugador1(){}

    //metodo que mueve el balon
    public void moverJugador(){
        x = x + velocidadX;
        y = y + velocidadY;

        if (x < 0) {
            x = 0; // Ajustar posición para que no se salga
            velocidadX *= -1; // Invertir dirección X
            System.out.println("Jugador golpeó pared izquierda y rebotó!");

        } else if (x + 40 > 700) {
            x = 700 - 40; // Ajustar posición
            velocidadX *= -1; // Invertir dirección X
            System.out.println("Jugador golpeó pared derecha y rebotó!");
        }

        // Comprobar colisión con bordes verticales y rebotar
        if (y < 0) {
            y = 0; // Ajustar posición
            velocidadY *= -1; // Invertir dirección Y
            System.out.println("Jugador golpeó pared superior y rebotó!");
        } else if (y + 40 > 700) {
            y = 700 - 40; // Ajustar posición
            velocidadY *= -1; // Invertir dirección Y
            System.out.println("Jugador golpeó pared inferior y rebotó!");
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 40, 40);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVelocidadX() {
        return velocidadX;
    }

    public double getVelocidadY() {
        return velocidadY;
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
}

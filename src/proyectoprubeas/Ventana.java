package proyectoprubeas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ventana extends JFrame implements MouseListener{
    int tecla = 0;
    public JPanel panel = new JPanel();
    PanelPelota pelota = new PanelPelota();
    Balon balon = new Balon(200, 200, 0,0);
    Timer gameLoopTimer;
    PanelJugador1 panelJugador1 = new PanelJugador1();
    Jugador1 jugador1 = new Jugador1();
    BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    Boolean qPressed = false;
    int acceso = 0;
    int keyPress = 0;
    double velocidadxantes = 0;
    double velocidadyantes = 0;
    int colision = 0;



    public Ventana(){
        panel.addMouseListener(this);
        pelota.setBalon(balon);
        panelJugador1.setJugador1(jugador1);
        this.setBounds(100,100,700,700);
        //this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();




        gameLoopTimer = new Timer (30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){


                Rectangle boundsBalon = balon.getBounds();
                Rectangle boundsJugador1 = jugador1.getBounds();
                if(boundsBalon.intersects(boundsJugador1)){
                    balon.setVelocidadX(jugador1.getVelocidadX());
                    balon.setVelocidadY(jugador1.getVelocidadY());
                    System.out.println("velocidad en x " + jugador1.getVelocidadX());
                    keyPress = 0;
                    System.out.println("colision");
                    colision = 1;
                    jugador1.setVelocidadY(-jugador1.getVelocidadY());
                    jugador1.setVelocidadX(-jugador1.getVelocidadX());
                }


                if(colision == 1){
                    double velocidadX = (jugador1.getVelocidadX() * 0.89);
                    double velocidadY = (jugador1.getVelocidadY() * 0.89);
                    jugador1.setVelocidadX(velocidadX);
                    jugador1.setVelocidadY(velocidadY);
                    balon.setVelocidadX(balon.getVelocidadX() * 0.89);
                    balon.setVelocidadY(balon.getVelocidadY() * 0.89);
                    //jugador1.moverJugador();
                }

                jugador1.setVelocidadX(jugador1.getVelocidadX()*0.99);
                jugador1.setVelocidadY(jugador1.getVelocidadY()*0.99);

                tecla = 0;
                jugador1.moverJugador();
                panelJugador1.repaint();
                balon.moverBalon();
                pelota.repaint();

            }
        });
        gameLoopTimer.start();

    }

    public void iniciarComponentes(){
        colocarPanel();
        colocarPelota();
        colocarJugador1();
    }

    public void colocarPanel(){

        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        this.getContentPane().add(panel);
        panel.setBounds(0,0,700,700);
    }

    public void colocarPelota(){
        panel.add(pelota);

        pelota.setBounds(0,0, panel.getWidth(), panel.getHeight());
    }

    public void colocarJugador1(){

        panel.add(panelJugador1);
        panelJugador1.setBounds(0,0,panel.getWidth(), panel.getHeight());
    }


    //variables para mouse
    double mouseXInicial = 0;
    double mouseYInicial = 0;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseXInicial = e.getX();
        mouseYInicial = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Rectangle jugadorBounds = jugador1.getBounds();
        colision = 0;
        double mousePositionX = e.getX();
        double mousePositionY = e.getY();

        if(jugadorBounds.contains(mouseXInicial, mouseYInicial)){
            double diferenciaMouseJugadorX = Math.abs(mousePositionX - jugador1.getX());
            double diferenciaMouseJugadorY = Math.abs(mousePositionY - jugador1.getY());

            double symbolX = 1;
            double symbolY = 1;
            if(mousePositionX > jugador1.getX()){
                symbolX = -1;
            }
            if(mousePositionY > jugador1.getY()){
                symbolY = -1;
            }

            double anguloDeDireccion = Math.atan(diferenciaMouseJugadorY/diferenciaMouseJugadorX);
            double hipotenusa = Math.sqrt(diferenciaMouseJugadorX*diferenciaMouseJugadorX + diferenciaMouseJugadorY*diferenciaMouseJugadorY);

            if(hipotenusa >= 100){
                jugador1.setVelocidadX(symbolX*100*Math.cos(anguloDeDireccion));
                jugador1.setVelocidadY(symbolY*100*Math.sin(anguloDeDireccion));
            }
            else if(hipotenusa < 100){
                jugador1.setVelocidadX(symbolX*5*Math.cos(anguloDeDireccion));
                jugador1.setVelocidadY(symbolY*5*Math.sin(anguloDeDireccion));
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



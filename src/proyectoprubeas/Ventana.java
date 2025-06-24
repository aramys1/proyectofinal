package proyectoprubeas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements MouseListener{
    int tecla = 0;
    public JPanel panel = new JPanel();
    PanelPelota pelota = new PanelPelota();
    Balon balon = new Balon();
    Timer gameLoopTimer;
    PanelJugador1 panelJugador1 = new PanelJugador1();
    Jugador1 jugador1 = new Jugador1(300, 50);
    int keyPress = 0;
    int colision = 0;

    //nuevo jugador
    Jugador1 jugador2 = new Jugador1(400,400);
    PanelJugador1 panelJugador2 = new PanelJugador1();



    public Ventana(){
        panel.addMouseListener(this);
        pelota.setBalon(balon);

        panelJugador2.setJugador1(jugador2);

        this.setBounds(100,100,700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();




        gameLoopTimer = new Timer (30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                actualizarJuego(jugador2, panelJugador2);

            }
        });
        gameLoopTimer.start();

    }

    public void iniciarComponentes(){
        colocarPanel();
        colocarPelota();
        colocarJugador(panelJugador2);
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

    public void colocarJugador(PanelJugador1 panelJugador){
        panel.add(panelJugador);
        panelJugador.setBounds(0,0,panel.getWidth(), panel.getHeight());
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
        Rectangle jugadorBounds = jugador2.getBounds();
        colision = 0;
        double mousePositionX = e.getX();
        double mousePositionY = e.getY();

        if(jugadorBounds.contains(mouseXInicial, mouseYInicial)){
            double diferenciaMouseJugadorX = Math.abs(mousePositionX - jugador2.getX());
            double diferenciaMouseJugadorY = Math.abs(mousePositionY - jugador2.getY());

            double symbolX = 1;
            double symbolY = 1;
            if(mousePositionX > jugador2.getX()){
                symbolX = -1;
            }
            if(mousePositionY > jugador2.getY()){
                symbolY = -1;
            }

            double anguloDeDireccion = Math.atan(diferenciaMouseJugadorY/diferenciaMouseJugadorX);
            double hipotenusa = Math.sqrt(diferenciaMouseJugadorX*diferenciaMouseJugadorX + diferenciaMouseJugadorY*diferenciaMouseJugadorY);

            if(hipotenusa >= 100){
                jugador2.setVelocidadX(symbolX*100*Math.cos(anguloDeDireccion));
                jugador2.setVelocidadY(symbolY*100*Math.sin(anguloDeDireccion));
            }
            else if(hipotenusa < 100){
                jugador2.setVelocidadX(symbolX*5*Math.cos(anguloDeDireccion));
                jugador2.setVelocidadY(symbolY*5*Math.sin(anguloDeDireccion));
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void actualizarJuego(Jugador1 jugador, PanelJugador1 panelJugador){
        Rectangle boundsBalon = balon.getBounds();
        Rectangle boundsJugador1 = jugador.getBounds();
        if(boundsBalon.intersects(boundsJugador1)){
            balon.setVelocidadX(jugador.getVelocidadX());
            balon.setVelocidadY(jugador.getVelocidadY());
            System.out.println("velocidad en x " + jugador.getVelocidadX());
            keyPress = 0;
            System.out.println("colision");
            colision = 1;
            jugador.setVelocidadY(-jugador.getVelocidadY());
            jugador.setVelocidadX(-jugador.getVelocidadX());
        }


        if(colision == 1){
            double velocidadX = (jugador.getVelocidadX() * 0.89);
            double velocidadY = (jugador.getVelocidadY() * 0.89);
            jugador.setVelocidadX(velocidadX);
            jugador.setVelocidadY(velocidadY);
            balon.setVelocidadX(balon.getVelocidadX() * 0.89);
            balon.setVelocidadY(balon.getVelocidadY() * 0.89);

        }

        jugador.setVelocidadX(jugador.getVelocidadX()*0.99);
        jugador.setVelocidadY(jugador.getVelocidadY()*0.99);

        tecla = 0;
        jugador.moverJugador();
        panelJugador.repaint();
        balon.moverBalon();
        pelota.repaint();
    }

}



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

    //otro jugador
    Jugador1 jugador3 = new Jugador1(500,500);
    PanelJugador1 panelJugador3 = new PanelJugador1();

    //otro jugaddor
    Jugador1 jugador4 = new Jugador1(100, 100);
    PanelJugador1 panelJugador4 = new PanelJugador1();

    //arreglo de objetos
    Jugador1[] jugadores = new Jugador1[3];



    public Ventana(){
        jugadores[0] = jugador2;
        jugadores[1] = jugador3;
        jugadores[2] = jugador4;

        panel.addMouseListener(this);
        pelota.setBalon(balon);

        panelJugador2.setJugador1(jugador2);
        panelJugador2.setColor(Color.BLACK);

        panelJugador3.setJugador1(jugador3);
        panelJugador3.setColor(Color.white);

        panelJugador4.setJugador1(jugador4);
        panelJugador4.setColor(Color.orange);

        this.setBounds(100,100,700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();




        gameLoopTimer = new Timer (30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                actualizarJuego(jugador2, panelJugador2);
                actualizarJuego(jugador3,panelJugador3);
                actualizarJuego(jugador4, panelJugador4);

            }
        });
        gameLoopTimer.start();

    }

    public void iniciarComponentes(){
        colocarPanel();
        colocarPelota();
        colocarJugador(panelJugador2);
        colocarJugador(panelJugador3);
        colocarJugador(panelJugador4);
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
        double x = e.getX();
        double y = e.getY();
        generarDireccionMouse(x,y,jugador2);
        generarDireccionMouse(x,y,jugador3);
        generarDireccionMouse(x,y,jugador4);




    }


    public void generarDireccionMouse(double x, double y, Jugador1 jugador){
        if(Math.abs(balon.getVelocidadX())< 0.5 && Math.abs(balon.getVelocidadY()) < 0.5){
            Rectangle jugadorBounds = jugador.getBounds();
            colision = 0;
            double mousePositionX = x;
            double mousePositionY = y;

            if(jugadorBounds.contains(mouseXInicial, mouseYInicial)){
                double diferenciaMouseJugadorX = Math.abs(mousePositionX - jugador.getX());
                double diferenciaMouseJugadorY = Math.abs(mousePositionY - jugador.getY());

                double symbolX = 1;
                double symbolY = 1;
                if(mousePositionX > jugador.getX()){
                    symbolX = -1;
                }
                if(mousePositionY > jugador.getY()){
                    symbolY = -1;
                }

                double anguloDeDireccion = Math.atan(diferenciaMouseJugadorY/diferenciaMouseJugadorX);
                double hipotenusa = Math.sqrt(diferenciaMouseJugadorX*diferenciaMouseJugadorX + diferenciaMouseJugadorY*diferenciaMouseJugadorY);

                if(hipotenusa >= 100){
                    jugador.setVelocidadX(symbolX*30*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*30*Math.sin(anguloDeDireccion));
                }
                else if(hipotenusa < 100){
                    jugador.setVelocidadX(symbolX*10*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*10*Math.sin(anguloDeDireccion));
                }

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
            System.out.println("velocidad en x " + jugador.getVelocidadX());
            keyPress = 0;
            System.out.println("colision");
            colision = 1;


            if(Math.abs(balon.getVelocidadX()) < 0.1 && Math.abs(balon.getVelocidadY()) < 0.1){
                System.out.println("el jugador golpea");
                balon.setVelocidadX(jugador.getVelocidadX());
                balon.setVelocidadY(jugador.getVelocidadY());
                jugador.setVelocidadY(-jugador.getVelocidadY());
                jugador.setVelocidadX(-jugador.getVelocidadX());

                if(jugador.getX() > balon.getX()){
                    System.out.println("redibujado");
                    jugador.setX(jugador.getX()+5);

                }
                else if(jugador.getX() < balon.getX()){
                    System.out.println("redibujado");
                    jugador.setX(jugador.getX()-5);

                }

                if(jugador.getY() > balon.getY()){
                    System.out.println("redibujado");
                    jugador.setY(jugador.getY()+5);

                }
                else if(jugador.getY() < balon.getY()){
                    System.out.println("redibujado");
                    jugador.setY(jugador.getY()-5);

                }

            }
            else{
                System.out.println("el balon golpea");
                jugador.setVelocidadX(balon.getVelocidadX());
                jugador.setVelocidadY(balon.getVelocidadY());
                balon.setVelocidadX(-balon.getVelocidadX());
                balon.setVelocidadY(-balon.getVelocidadY());


                if(jugador.getX() > balon.getX()){
                    System.out.println("redibujado");
                    balon.setX(balon.getX()-5);


                }
                else if(jugador.getX() < balon.getX()){
                    System.out.println("redibujado");
                    balon.setX(balon.getX()+5);

                }

                if(jugador.getY() > balon.getY()){
                    System.out.println("redibujado");
                    balon.setY(balon.getY()-5);

                }
                else if(jugador.getY() < balon.getY()){
                    System.out.println("redibujado");
                    balon.setY(balon.getY()+5);

                }

            }

        }

        //balon balon
        int i = 0;
        int j = 0;
        int frenoDeMano = 0;

        for(i = 0; i < jugadores.length; i++){
            for(j = i+1; j < jugadores.length; j++){
                if(jugadores[i].getBounds().intersects(jugadores[j].getBounds())){
                    System.out.println("colision entre jugadores");
                    frenoDeMano = 1;

                    if(Math.abs(jugadores[i].getVelocidadX()) > Math.abs(jugadores[j].getVelocidadX())){
                        jugadores[j].setVelocidadX(jugadores[i].getVelocidadX());
                        jugadores[i].setVelocidadX(-jugadores[i].getVelocidadX());

                    }
                    else if(Math.abs(jugadores[i].getVelocidadX()) < Math.abs(jugadores[j].getVelocidadX())){
                        jugadores[i].setVelocidadX(jugadores[j].getVelocidadX());
                        jugadores[j].setVelocidadX(-jugadores[j].getVelocidadX());

                    }
                    else {
                        // MISMA velocidad → invertir ambos
                        jugadores[i].setVelocidadX(-jugadores[i].getVelocidadX());
                        jugadores[j].setVelocidadX(-jugadores[j].getVelocidadX());
                    }

                    if(Math.abs(jugadores[i].getVelocidadY()) > Math.abs(jugadores[j].getVelocidadY())){
                        jugadores[j].setVelocidadY(jugadores[i].getVelocidadY());
                        jugadores[i].setVelocidadY(-jugadores[i].getVelocidadY());

                    }
                    else if(Math.abs(jugadores[i].getVelocidadY()) < Math.abs(jugadores[j].getVelocidadY())){
                        jugadores[i].setVelocidadY(jugadores[j].getVelocidadY());
                        jugadores[j].setVelocidadY(-jugadores[j].getVelocidadY());

                    }
                    else {
                        jugadores[i].setVelocidadY(-jugadores[i].getVelocidadY());
                        jugadores[j].setVelocidadY(-jugadores[j].getVelocidadY());
                    }


                    break;
                }
            }
            if(frenoDeMano == 1){
                break;
            }
        }




        if(colision == 1){
            double velocidadX = (jugador.getVelocidadX() * 0.89);
            double velocidadY = (jugador.getVelocidadY() * 0.89);


            jugador.setVelocidadX(velocidadX);
            jugador.setVelocidadY(velocidadY);

            balon.setVelocidadX(balon.getVelocidadX() * 0.99);
            balon.setVelocidadY(balon.getVelocidadY() * 0.99);

        }

        jugador.setVelocidadX(jugador.getVelocidadX()*0.99);
        jugador.setVelocidadY(jugador.getVelocidadY()*0.99);

        balon.setVelocidadX(balon.getVelocidadX() * 0.99);
        balon.setVelocidadY(balon.getVelocidadY() * 0.99);


        tecla = 0;
        jugador.moverJugador();
        panelJugador.repaint();
        balon.moverBalon();
        pelota.repaint();
    }

}



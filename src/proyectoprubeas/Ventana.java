package proyectoprubeas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ventana extends JFrame{
    int tecla = 0;
    public JPanel panel;
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
        pelota.setBalon(balon);
        panelJugador1.setJugador1(jugador1);
        this.setBounds(100,100,700,700);
        //this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode(); // Obtener el código de la tecla presionada

                if (keyCode >= KeyEvent.VK_NUMPAD0 && keyCode <= KeyEvent.VK_NUMPAD9) {
                    tecla = keyCode - KeyEvent.VK_NUMPAD0;
                    keyPress = 1;
                    System.out.println("Se presiono una tecla");// Convertir el código de tecla a su valor numérico
                }


            }
        });


        gameLoopTimer = new Timer (30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){



                if(keyPress == 1){
                    switch (tecla){
                        case 8:
                            jugador1.setVelocidadX(0);
                            jugador1.setVelocidadY(-10);
                            colision = 0;
                            velocidadxantes = jugador1.getVelocidadX();
                            velocidadyantes = jugador1.getVelocidadY();

                            break;
                        case 2:
                            jugador1.setVelocidadX(0);
                            jugador1.setVelocidadY(10);
                            colision = 0;
                            velocidadxantes = jugador1.getVelocidadX();
                            velocidadyantes = jugador1.getVelocidadY();
                            break;
                        case 4:
                            jugador1.setVelocidadX(-10);
                            jugador1.setVelocidadY(0);
                            colision = 0;
                            velocidadxantes = jugador1.getVelocidadX();
                            velocidadyantes = jugador1.getVelocidadY();
                            break;
                        case 6:
                            jugador1.setVelocidadX(10);
                            jugador1.setVelocidadY(0);
                            colision = 0;
                            velocidadxantes = jugador1.getVelocidadX();
                            velocidadyantes = jugador1.getVelocidadY();
                            break;
                        case 9:
                            jugador1.setVelocidadX(10);
                            jugador1.setVelocidadY(-10);
                            colision = 0;
                            break;
                        case 3:
                            jugador1.setVelocidadX(10);
                            jugador1.setVelocidadY(10);
                            colision = 0;
                            break;
                        case 1:
                            jugador1.setVelocidadX(-10);
                            jugador1.setVelocidadY(10);
                            colision = 0;
                            break;
                        case 7:
                            jugador1.setVelocidadX(-10);
                            jugador1.setVelocidadY(-10);
                            colision = 0;
                            break;
                        default:
                            colision = 0;
                            break;
                    }
                }









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
        panel = new JPanel();
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









}



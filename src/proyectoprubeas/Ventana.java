package proyectoprubeas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ventana extends JFrame implements MouseListener{
    BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    int tecla = 0;
    Porteria porteriaIzquierda;
    Porteria porteriaDerecha;

    JPanel panelPorterias = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (porteriaIzquierda != null && porteriaDerecha != null) {
                porteriaIzquierda.dibujar(g);
                porteriaDerecha.dibujar(g);
            }
        }
    };

    //objeto para el sonido
    Sonidos sonidos = new Sonidos();


    public JPanel panel = new JPanel();
    PanelPelota pelota = new PanelPelota();
    Balon balon = new Balon(sonidos);
    JLabel marcadorLabel = new JLabel();


    boolean juegoPausado = false;
    boolean golEnProceso = false;
    int golesParaGanar = 3;

    Timer gameLoopTimer;
    int golesAzul = 0;
    int golesRojo = 0;
    PanelJugador1 panelJugador1 = new PanelJugador1();
    Jugador1 jugador1 = new Jugador1(300, 50);
    int keyPress = 0;
    int colision = 0;


    //objetos de jugadores
    Jugador1 jugador2;
    PanelJugador1 panelJugador2;

    Jugador1 jugador3;
    PanelJugador1 panelJugador3;

    Jugador1 jugador4;
    PanelJugador1 panelJugador4;

    Jugador1 jugador5;
    PanelJugador1 panelJugador5;

    Jugador1 jugador6;
    PanelJugador1 panelJugador6;

    Jugador1 jugador7;
    PanelJugador1 panelJugador7;

    Jugador1 jugador8;
    PanelJugador1 panelJugador8;

    Jugador1 jugador9;
    PanelJugador1 panelJugador9;

    //arreglo de objetos de jugadores
    Jugador1[] jugadores;
    PanelJugador1[] panelesJugadores;

    //Este metodo pasa la instancia de los jugadores a los paneles de los jugadores
    void setAtributosaObjetos(int cantidadJugadores){
        for(int i = 0; i < cantidadJugadores; i++){
            panelesJugadores[i].setJugador1(jugadores[i]);
            if( i < cantidadJugadores/2){

                panelesJugadores[i].setImagen(panelesJugadores[i].getImagenEquipo1());
            }
            else if(i >= cantidadJugadores/2){

                panelesJugadores[i].setImagen(panelesJugadores[i].getImagenEquipo2());
            }
            panelesJugadores[i].repaint();
        }

    }


    int cantidadDeJugadores = 0;

    public Ventana(){
        System.out.println(Constantes.WIDTH_PANTALLA);
        try{
            System.out.println("Cantidad de jugadores 2, 3, 4");
            cantidadDeJugadores = Integer.parseInt(bufer.readLine());

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        switch (cantidadDeJugadores){
            case 2:
                jugadores = new Jugador1[4];
                panelesJugadores = new PanelJugador1[4];
                //nuevo jugador
                jugador2 = new Jugador1(100,200);
                panelJugador2 = new PanelJugador1();
                jugadores[0] = jugador2;
                panelesJugadores[0] = panelJugador2;

                jugador3 = new Jugador1(100,500);
                panelJugador3 = new PanelJugador1();
                jugadores[1] = jugador3;
                panelesJugadores[1] = panelJugador3;

                jugador4 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 200);
                panelJugador4 = new PanelJugador1();
                jugadores[2] = jugador4;
                panelesJugadores[2] = panelJugador4;

                jugador5 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 500);
                panelJugador5 = new PanelJugador1();
                jugadores[3] = jugador5;
                panelesJugadores[3] = panelJugador5;

                setAtributosaObjetos(4);
                break;

            case 3:
                jugadores = new Jugador1[6];
                panelesJugadores = new PanelJugador1[6];
                //nuevo jugador
                jugador2 = new Jugador1(150,200-65);
                panelJugador2 = new PanelJugador1();
                jugadores[0] = jugador2;
                panelesJugadores[0] = panelJugador2;

                jugador3 = new Jugador1(150,600-65);
                panelJugador3 = new PanelJugador1();
                jugadores[1] = jugador3;
                panelesJugadores[1] = panelJugador3;

                jugador4 = new Jugador1(250,400-65);
                panelJugador4 = new PanelJugador1();
                jugadores[2] = jugador4;
                panelesJugadores[2] = panelJugador4;

                jugador5 = new Jugador1(Constantes.WIDTH_PANTALLA-205, 100);
                panelJugador5 = new PanelJugador1();
                jugadores[3] = jugador5;
                panelesJugadores[3] = panelJugador5;

                jugador6 = new Jugador1(Constantes.WIDTH_PANTALLA-205, 500);
                panelJugador6 = new PanelJugador1();
                jugadores[4] = jugador6;
                panelesJugadores[4] = panelJugador6;

                jugador7 = new Jugador1(Constantes.WIDTH_PANTALLA-305, 400-65);
                panelJugador7 = new PanelJugador1();
                jugadores[5] = jugador7;
                panelesJugadores[5] = panelJugador7;

                setAtributosaObjetos(6);
                break;

            case 4:
                jugadores = new Jugador1[8];
                panelesJugadores = new PanelJugador1[8];
                //nuevo jugador
                jugador2 = new Jugador1(100,100);
                panelJugador2 = new PanelJugador1();
                jugadores[0] = jugador2;
                panelesJugadores[0] = panelJugador2;

                jugador3 = new Jugador1(100,200);
                panelJugador3 = new PanelJugador1();
                jugadores[1] = jugador3;
                panelesJugadores[1] = panelJugador3;

                jugador4 = new Jugador1(100,300);
                panelJugador4 = new PanelJugador1();
                jugadores[2] = jugador4;
                panelesJugadores[2] = panelJugador4;

                jugador5 = new Jugador1(100,400);
                panelJugador5 = new PanelJugador1();
                jugadores[3] = jugador5;
                panelesJugadores[3] = panelJugador5;

                jugador6 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 100);
                panelJugador6 = new PanelJugador1();
                jugadores[4] = jugador6;
                panelesJugadores[4] = panelJugador6;

                jugador7 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 200);
                panelJugador7 = new PanelJugador1();
                jugadores[5] = jugador7;
                panelesJugadores[5] = panelJugador7;

                jugador8 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 300);
                panelJugador8 = new PanelJugador1();
                jugadores[6] = jugador8;
                panelesJugadores[6] = panelJugador8;

                jugador9 = new Jugador1(Constantes.WIDTH_PANTALLA-150, 400);
                panelJugador9 = new PanelJugador1();
                jugadores[7] = jugador9;
                panelesJugadores[7] = panelJugador9;

                setAtributosaObjetos(8);
                break;
        }


        panel.addMouseListener(this);
        pelota.setBalon(balon);



        this.setResizable(false);

        this.setBounds(0, 0, Constantes.WIDTH_PANTALLA+20, Constantes.HEIGHT_PANTALLA+20);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
        // Crear porterías
        int ancho = 60;
        int alto = 300;
        porteriaIzquierda = new Porteria(0, Constantes.HEIGHT_PANTALLA / 2 - alto / 2, ancho, alto);
        porteriaDerecha = new Porteria(Constantes.WIDTH_PANTALLA - ancho, Constantes.HEIGHT_PANTALLA / 2 - alto / 2, ancho, alto);

        // Panel para dibujar porterías
        panelPorterias.setOpaque(false);
        panel.add(panelPorterias);
        panelPorterias.setBounds(0, 0, panel.getWidth(), panel.getHeight());

        // Configurar marcador
        marcadorLabel.setText("Azul: 0     Rojo: 0");
        marcadorLabel.setFont(new Font("Arial", Font.BOLD, 24));
        marcadorLabel.setForeground(Color.WHITE);
        marcadorLabel.setBounds(Constantes.WIDTH_PANTALLA / 2 - 150, 10, 300, 50);
        marcadorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel marcadorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        marcadorPanel.setLayout(new BorderLayout());
        marcadorPanel.setBounds(marcadorLabel.getBounds());
        marcadorPanel.add(marcadorLabel);
        marcadorPanel.setOpaque(false);

        panel.add(marcadorPanel);


        gameLoopTimer = new Timer (30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){


                actualizarJuego(jugador2, panelJugador2);
                actualizarJuego(jugador3,panelJugador3);
                actualizarJuego(jugador4, panelJugador4);
                actualizarJuego(jugador5, panelJugador5);
                if(cantidadDeJugadores == 3){
                    actualizarJuego(jugador6, panelJugador6);
                    actualizarJuego(jugador7, panelJugador7);
                }
                else if(cantidadDeJugadores == 4){
                    actualizarJuego(jugador6, panelJugador6);
                    actualizarJuego(jugador7, panelJugador7);
                    actualizarJuego(jugador8, panelJugador8);
                    actualizarJuego(jugador9, panelJugador9);
                }

            }
        });
        gameLoopTimer.start();

    }

    //Este metodo llama a otros metodos que colocan los paneles de los diferentes componentes en la ventana
    public void iniciarComponentes(){

        colocarPanel();
        colocarPelota();

        colocarJugador(panelJugador2);
        colocarJugador(panelJugador3);
        colocarJugador(panelJugador4);
        colocarJugador(panelJugador5);
        if(cantidadDeJugadores == 3){
            colocarJugador(panelJugador6);
            colocarJugador(panelJugador7);
        }
        else if(cantidadDeJugadores == 4){
            colocarJugador(panelJugador6);
            colocarJugador(panelJugador7);
            colocarJugador(panelJugador8);
            colocarJugador(panelJugador9);
        }
        colocarCampo();

    }



    public void colocarPanel(){


        panel.setLayout(null);
        panel.setBackground(new Color(34,139,34));
        this.getContentPane().add(panel);
        panel.setBounds(0,0,Constantes.WIDTH_PANTALLA, Constantes.HEIGHT_PANTALLA);


    }


    public void colocarPelota(){
        panel.add(pelota);

        pelota.setBounds(0,0, panel.getWidth(), panel.getHeight());
    }

    public void colocarJugador(PanelJugador1 panelJugador){
        panel.add(panelJugador);
        panelJugador.setBounds(0,0,panel.getWidth(), panel.getHeight());
    }

    public void colocarCampo() {
        CampoFutbol campo = new CampoFutbol();
        campo.setOpaque(false);
        campo.setBounds(0, 0, Constantes.WIDTH_PANTALLA, Constantes.HEIGHT_PANTALLA);
        panel.add(campo);
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
    int contadorTurno = 1;

    @Override
    public void mouseReleased(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        if(cantidadDeJugadores == 2){
            if(contadorTurno % 2 != 0){
                generarDireccionMouse(x,y,jugador2);
                generarDireccionMouse(x,y,jugador3);
            }
            else if(contadorTurno % 2 == 0){
                generarDireccionMouse(x,y,jugador4);
                generarDireccionMouse(x,y,jugador5);
            }
        }
        else if(cantidadDeJugadores == 3){
            if(contadorTurno % 2 != 0){
                generarDireccionMouse(x,y,jugador2);
                generarDireccionMouse(x,y,jugador3);
                generarDireccionMouse(x,y,jugador4);
            }
            else if(contadorTurno % 2 == 0){
                generarDireccionMouse(x,y,jugador5);
                generarDireccionMouse(x,y,jugador6);
                generarDireccionMouse(x,y,jugador7);
            }
        }

    }


    //Este metodo calcula la direccion en que apunta el jugador y establece la velocidad que la ficha va a tener
    public void generarDireccionMouse(double x, double y, Jugador1 jugador){
        if(Math.abs(balon.getVelocidadX())< 0.5 && Math.abs(balon.getVelocidadY()) < 0.5 && jugadoresDetenidos()){
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

                if(hipotenusa >= 20 && hipotenusa < 40){
                    jugador.setVelocidadX(symbolX*20*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*20*Math.sin(anguloDeDireccion));
                }
                else if(hipotenusa >= 40 && hipotenusa < 60){
                    jugador.setVelocidadX(symbolX*40*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*40*Math.sin(anguloDeDireccion));
                }
                else if(hipotenusa >= 60 && hipotenusa < 80){
                    jugador.setVelocidadX(symbolX*60*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*60*Math.sin(anguloDeDireccion));
                }
                else if(hipotenusa >= 80 && hipotenusa < 100){
                    jugador.setVelocidadX(symbolX*80*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*80*Math.sin(anguloDeDireccion));
                }
                else if(hipotenusa >= 100){
                    jugador.setVelocidadX(symbolX*100*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*100*Math.sin(anguloDeDireccion));
                }
                else{
                    jugador.setVelocidadX(symbolX*10*Math.cos(anguloDeDireccion));
                    jugador.setVelocidadY(symbolY*10*Math.sin(anguloDeDireccion));
                }
                contadorTurno++;

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    //Esto es lo que pasa dentro del bucle, colisiones y movimiento
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
                sonidos.reproducirSonido("/RecursosDeSonido/GolpeDeBalon.wav");

                //pruebas
                double dx = balon.getX() - jugador.getX();
                double dy = balon.getY() - jugador.getY();
                double hipotenusa = Math.sqrt(dx*dx + dy*dy);

                double nx = dx / hipotenusa;
                double ny = dy / hipotenusa;

                double dot = jugador.getVelocidadX() * nx + jugador.getVelocidadY() * ny;

                jugador.setVelocidadX(jugador.getVelocidadX() * 0.5);
                jugador.setVelocidadY(jugador.getVelocidadY() * 0.5);
                balon.setVelocidadX(nx * dot * 0.8);
                balon.setVelocidadY(ny * dot * 0.8);

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
                sonidos.reproducirSonido("/RecursosDeSonido/GolpeDeBalon.wav");
                double dx = balon.getX() - jugador.getX();
                double dy = balon.getY() - jugador.getY();
                double hipotenusa = Math.sqrt(dx*dx + dy*dy);

                double nx = dx / hipotenusa;
                double ny = dy / hipotenusa;

                double dot = jugador.getVelocidadX() * nx + jugador.getVelocidadY() * ny;

                jugador.setVelocidadX(nx * dot);
                jugador.setVelocidadY(ny * dot);
                balon.setVelocidadX(balon.getVelocidadX() * 0.5);
                balon.setVelocidadY(balon.getVelocidadY() * 0.5);


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



        jugador.setVelocidadX(jugador.getVelocidadX()*0.84);
        jugador.setVelocidadY(jugador.getVelocidadY()*0.84);

        balon.setVelocidadX(balon.getVelocidadX() * 0.985);
        balon.setVelocidadY(balon.getVelocidadY() * 0.985);


        tecla = 0;
        if (!juegoPausado) {
            jugador.moverJugador();
            panelJugador.repaint();
            balon.moverBalon();
            pelota.repaint(); 
        }
        // Detección de gol
        if (!golEnProceso && porteriaIzquierda.balonEntra(balon.getBounds())) {
            golEnProceso = true;
            golesRojo++;
            marcadorLabel.setText("Azul: " + golesAzul + "  |  Rojo: " + golesRojo);
            System.out.println("¡GOL DEL EQUIPO ROJO!");
            if (golesRojo >= golesParaGanar) {
                terminarJuego("Rojo");
                return;
            }
            juegoPausado = true;

            new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    reiniciarPosiciones();
                    juegoPausado = false;
                    golEnProceso = false;
                    ((Timer) evt.getSource()).stop();
                }
            }).start();
        }

        if (!golEnProceso && porteriaDerecha.balonEntra(balon.getBounds())) {
            golEnProceso = true;
            golesAzul++;
            marcadorLabel.setText("Azul: " + golesAzul + "     Rojo: " + golesRojo);
            System.out.println("¡GOL DEL EQUIPO AZUL!");
            juegoPausado = true;
            if (golesAzul >= golesParaGanar) {
                terminarJuego("Azul");
                return;
            }
            new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    reiniciarPosiciones();
                    juegoPausado = false;
                    golEnProceso = false;
                    ((Timer) evt.getSource()).stop();
                }
            }).start();
        }

        
    }


    //funcion que comprueba que los jugadores esten completamente detenidos
    public Boolean jugadoresDetenidos(){
        for(int i = 0; i<jugadores.length; i++){
            if(jugadores[i].getVelocidadX() > 0.3 || jugadores[i].getVelocidadY() > 0.3){
                return false;
            }
        }
        return true;
    }


    //Funcion que reinicia la posicion de los jugadores
    public void reiniciarPosiciones() {
        // Reiniciar balón al centro
        balon.setX(Constantes.WIDTH_PANTALLA / 2 - balon.getDiametro() / 2);
        balon.setY(Constantes.HEIGHT_PANTALLA / 2 - balon.getDiametro() / 2);
        balon.setVelocidadX(0);
        balon.setVelocidadY(0);

        // Reiniciar posiciones de jugadores según la cantidad
        switch (cantidadDeJugadores) {
            case 2:
                jugador2.setX(100); jugador2.setY(200);
                jugador3.setX(100); jugador3.setY(500);
                jugador4.setX(Constantes.WIDTH_PANTALLA - 150); jugador4.setY(200);
                jugador5.setX(Constantes.WIDTH_PANTALLA - 150); jugador5.setY(500);
                break;

            case 3:
                jugador2.setX(150); jugador2.setY(135);
                jugador3.setX(150); jugador3.setY(535);
                jugador4.setX(250); jugador4.setY(335);
                jugador5.setX(Constantes.WIDTH_PANTALLA - 205); jugador5.setY(100);
                jugador6.setX(Constantes.WIDTH_PANTALLA - 205); jugador6.setY(500);
                jugador7.setX(Constantes.WIDTH_PANTALLA - 305); jugador7.setY(335);
                break;

            case 4:
                jugador2.setX(100); jugador2.setY(100);
                jugador3.setX(100); jugador3.setY(200);
                jugador4.setX(100); jugador4.setY(300);
                jugador5.setX(100); jugador5.setY(400);
                jugador6.setX(Constantes.WIDTH_PANTALLA - 150); jugador6.setY(100);
                jugador7.setX(Constantes.WIDTH_PANTALLA - 150); jugador7.setY(200);
                jugador8.setX(Constantes.WIDTH_PANTALLA - 150); jugador8.setY(300);
                jugador9.setX(Constantes.WIDTH_PANTALLA - 150); jugador9.setY(400);
                break;
        }

        // Detener movimiento de jugadores
        for (Jugador1 jugador : jugadores) {
            jugador.setVelocidadX(0);
            jugador.setVelocidadY(0);
        }

        // Redibujar todo
        pelota.repaint();
        for (PanelJugador1 panelJugador : panelesJugadores) {
            panelJugador.repaint();
        }
        panelPorterias.repaint();
    }

    public void terminarJuego(String equipoGanador) {
        juegoPausado = true;
        gameLoopTimer.stop();

        int opcion = JOptionPane.showOptionDialog(
            this,
            "¡Ganó el equipo " + equipoGanador + "!\n¿Qué deseas hacer?",
            "Fin del juego",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]{"Jugar otra vez", "Salir"},
            "Jugar otra vez"
        );

        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose(); 
            Main.main(null); 
        } else {
            System.exit(0); 
        }
    }




}



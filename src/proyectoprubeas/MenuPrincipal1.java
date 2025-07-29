package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal1 {
    private JPanel  menuPrincipal1;
    private JButton dosVsDos;
    private JButton tresVsTres;
    private JLabel seleccion;
    Sonidos sonido = new Sonidos();

    public MenuPrincipal1(JFrame frame) {
        sonido.reproducirSonido("/RecursosDeSonido/EstadioAmbiente.wav", true);
        menuPrincipal1 = new JPanel(); // INICIALIZAMOS EL PANEL
        menuPrincipal1 = new PanelConimagenes("recursos/FondoMenu.png");
        menuPrincipal1.setLayout(null);

        seleccion = new JLabel();
        seleccion.setText("Seleccion de modo");
        seleccion.setHorizontalAlignment(SwingConstants.CENTER);
        seleccion.setBounds(360, 200, 200,100 );
        seleccion.setFont(new Font("Dialog", Font.BOLD, 20));
        seleccion.setForeground(Color.WHITE);
        menuPrincipal1.add(seleccion);

        //Imagen del 2v2
        ImageIcon iconOriginal = new ImageIcon("recursos/2v2.png");
        Image img = iconOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // El scale ese es para que no se vea fea la imagen con pixeles
        ImageIcon icon = new ImageIcon(img);

        //Imagen del 3v3

        ImageIcon iconOriginal2 = new ImageIcon("recursos/3v3.png");
        Image img2 = iconOriginal2.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // El scale ese es para que no se vea fea la imagen con pixeles
        ImageIcon icon2 = new ImageIcon(img2);

        dosVsDos = new JButton(icon);

        dosVsDos.setBounds(150, 300, 300, 300);
        dosVsDos.setFont(new Font("Dialog", Font.BOLD, 20));
        dosVsDos.setForeground(Color.WHITE); // texto blanco
        dosVsDos.setBackground(Color.GREEN);
        dosVsDos.setHorizontalAlignment(SwingConstants.CENTER);
        menuPrincipal1.add(dosVsDos);



        tresVsTres = new JButton(icon2);
        tresVsTres.setBounds(500, 300, 300, 300);
        tresVsTres.setFont(new Font("Dialog", Font.BOLD, 20));
        dosVsDos.setForeground(Color.WHITE); // texto blanco
        tresVsTres.setBackground(Color.GREEN);
        dosVsDos.setHorizontalAlignment(SwingConstants.CENTER);
        menuPrincipal1.add(tresVsTres);



        dosVsDos.addActionListener(e -> {
            sonido.detenerSonido();
            Configuracion.cantidadDeJugadores = 2;
            Ventana juego = new Ventana();
            juego.setVisible(true);
            frame.dispose();
        });

        tresVsTres.addActionListener(e -> {
            sonido.detenerSonido();
            Configuracion.cantidadDeJugadores = 3;
            Ventana juego = new Ventana();
            juego.setVisible(true);
        });
    }


    public JPanel getPanel() {
        return menuPrincipal1;
    }

}

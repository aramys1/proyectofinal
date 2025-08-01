package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PantallaIncial {
    private JPanel PantallaIncial;
    private JButton jugarButton;
    Sonidos sonido = new Sonidos();

    public PantallaIncial(JFrame frame){
        sonido.reproducirSonido("/RecursosDeSonido/EstadioAmbiente.wav", true);
        PantallaIncial = new PanelConImagenes("recursos/Fondo.png");

        // Botón encima del fondo
        jugarButton = new JButton("Jugar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fondo semi-transparente redondeado
                g2.setColor(new Color(0, 0, 0, 100));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        PantallaIncial.setLayout(null);
        jugarButton.setBounds(350, 600, 300, 100);
        jugarButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 34));
        PantallaIncial.add(jugarButton);

        jugarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jugarButton.setFont(new Font("Arial", Font.BOLD, 38));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jugarButton.setFont(new Font("Arial", Font.BOLD, 34));
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sonido.detenerSonido();
            }
        });


        jugarButton.setContentAreaFilled(false);
        jugarButton.setOpaque(false);
        jugarButton.setBorderPainted(false);
        jugarButton.setFocusPainted(false);

        jugarButton.setForeground(Color.WHITE);
        jugarButton.setHorizontalAlignment(SwingConstants.CENTER);


        jugarButton.addActionListener(e -> {
            MenuPrincipal1 menuPrincipal1 = new MenuPrincipal1(frame);
            frame.setContentPane(menuPrincipal1.getPanel());
            frame.revalidate();
            frame.repaint();
        });
    }

    public JPanel getPanel() {
        return PantallaIncial;
    }


}

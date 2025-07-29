package proyectoprubeas;

import javax.swing.*;
import java.awt.*;

public class PantallaIncial {
    private JPanel PantallaIncial;
    private JButton jugarButton;

    public PantallaIncial(JFrame frame){

        PantallaIncial = new PanelConimagenes("recursos/Fondo.png");

        // Botón encima del fondo
        jugarButton = new JButton("Jugar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Boton para la redondes sin pixeles

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
                jugarButton.setFont(new Font("Arial", Font.BOLD, 38)); // un poco más grande
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jugarButton.setFont(new Font("Arial", Font.BOLD, 34)); // vuelve al normal
            }
        });


        jugarButton.setContentAreaFilled(false);
        jugarButton.setOpaque(false);
        jugarButton.setBorderPainted(false);
        jugarButton.setFocusPainted(false);

        jugarButton.setForeground(Color.WHITE); // texto blanco
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

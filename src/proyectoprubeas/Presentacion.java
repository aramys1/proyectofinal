package proyectoprubeas;

import javax.swing.*;

public class Presentacion {
    private JPanel panel1;
    private JButton BTNJugar;


    Presentacion(JFrame frame){
        BTNJugar.addActionListener(e -> {
            PantallaIncial pantallaIncial = new PantallaIncial(frame);
            frame.setContentPane(pantallaIncial.getPanel());
            frame.revalidate();
            frame.repaint();
        });
    }
    public JPanel getPanel() {
        return panel1;
    }


}

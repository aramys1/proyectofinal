package proyectoprubeas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Proyecto de Prubeas");
        Presentacion presentacion = new Presentacion(frame);

        frame.setContentPane(presentacion.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(938, 938);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


    }
}

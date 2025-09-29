package Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Hilos.Auto;
import Utils.Etiqueta;

public class Carrera extends JFrame {

    private JPanel panel;
    private final int altura = 700;
    // private final int ancho=1382;

    // AQUI ESTAN LOS NOMBRE DE LOS JUGADORES
    private List<String> jugadores;

    // AQUI SE GUARDARA LOS JUGADORES GANADORES GLOBAL
    public static final List<String> ganadores = new ArrayList<>();

    public Carrera(List<String> jugadores) {
        this.jugadores = jugadores;

        this.setTitle("!Qué comienze la competición!!"); // TITULO DE LA VENTANA
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // SE HABRA LA VENTANA COMPLETA
        this.setLocationRelativeTo(null); // HACE QUE LA PANTALLA SALGA EN EL CENTRO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        this.setResizable(false); // PARA QUE EL USUARIO NO REDUZCA LA PANTALLA

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        componentes();
        this.setVisible(true); // Hacer visible primero para que tenga tamaño real
    }

    // ANCHO 1382 ALTURA 784
    private void componentes() {
        carrera();
        etiquetas();
    }

    private void carrera() {

        int cantidad = jugadores.size();

        JLabel[] label = new JLabel[cantidad];
        List<Auto> autos = new ArrayList<>();
        String[] url = { "img/Carro 1.png", "img/Carro 2.png", "img/Carro 3.png", "img/Carro 4.png" };

        int y = -30;
        for (int i = 0; i < label.length; i++) {
            JLabel img = new Etiqueta(0, y, 250, 220, url[i]).conImagen();

            label[i] = img;
            panel.add(img);
            y += 200;
        }

        for (int i = 0; i < cantidad; i++) {
            Auto auto = new Auto(jugadores.get(i), label[i], 1000);
            autos.add(auto);
            auto.start(); // COMIENZA CADA HILO DE LOS AUTOS
        }

        new Thread(() -> {
            try {
                for (Auto a : autos) {
                    a.join(); // ESPERAR CADA AUTO
                }
            } catch (InterruptedException e) {}

            this.setVisible(false);

            String [] arrayGanadores=ganadores.toArray(new String[0]);
            new Ganadores(arrayGanadores).setVisible(true);
            ganadores.clear();
        }).start();

    }

    private void etiquetas() {
        contador();

        int cada = altura / 4;
        int contador = cada;
        for (int i = 0; i < 4; i++) {
            JLabel calle = new Etiqueta(20, contador, 1200, 40, "img/linea.png").conImagen();
            panel.add(calle);
            contador += cada;
        }

        JLabel lineaMeta = new Etiqueta(1070, 0, 400, 800, "img/linea meta.png").conImagen();
        panel.add(lineaMeta);

        int posicionY = -20;
        for (int i = 0; i < jugadores.size(); i++) {
            JLabel nombres = new Etiqueta(jugadores.get(i), 30, posicionY, 200, 200, Color.BLACK, 25, "Forte").normal();
            panel.add(nombres);
            posicionY += 165;
        }

        /*
         * int cantidad=jugadores.size();
         * 
         * JLabel []label=new JLabel[cantidad];
         * 
         * int y=50;
         * for(int i=0;i<label.length;i++){
         * JLabel img=new Etiqueta(jugadores.get(i),50,y , 200, 200, Color.BLACK, 20,
         * "Arial").normal();
         * 
         * label[i]=img;
         * panel.add(img);
         * y+=130;
         * }
         */

    }

    private void contador() {
        JLabel n3 = new Etiqueta(String.valueOf(3), 550, 200, 600, 400, Color.RED, 200, "Forte").normal();
        n3.setVisible(false);
        panel.add(n3);
        panel.revalidate();
        panel.repaint();

        JLabel n2 = new Etiqueta(String.valueOf(2), 550, 200, 600, 400, Color.YELLOW, 200, "Forte").normal();
        n2.setVisible(false);
        panel.add(n2);

        JLabel n1 = new Etiqueta(String.valueOf(1), 600, 200, 600, 400, Color.GREEN, 200, "Forte").normal();
        n1.setVisible(false);
        panel.add(n1);

        JLabel vamos = new Etiqueta("GO!!", 430, 200, 600, 400, Color.BLACK, 200, "Forte").normal();
        vamos.setVisible(false);
        panel.add(vamos);

        JLabel banderin = new Etiqueta(620, 200, 600, 400, "img/banderin.png").conImagen();
        banderin.setVisible(false);
        panel.add(banderin);

        Thread hilo = new Thread(() -> {

            try {

                SwingUtilities.invokeLater(() -> n3.setVisible(true));
                Thread.sleep(2000); // 2 s
                SwingUtilities.invokeLater(() -> n3.setVisible(false));

                SwingUtilities.invokeLater(() -> n2.setVisible(true));
                Thread.sleep(1000); // 1 s
                SwingUtilities.invokeLater(() -> n2.setVisible(false));

                SwingUtilities.invokeLater(() -> n1.setVisible(true));
                Thread.sleep(1000); // 1 s
                SwingUtilities.invokeLater(() -> n1.setVisible(false));

                SwingUtilities.invokeLater(() -> vamos.setVisible(true));
                SwingUtilities.invokeLater(() -> banderin.setVisible(true));
                Thread.sleep(2000); // 2 s
                SwingUtilities.invokeLater(() -> vamos.setVisible(false));
                SwingUtilities.invokeLater(() -> banderin.setVisible(false));

            } catch (InterruptedException e) {
            }

        });

        hilo.start();
    }
}
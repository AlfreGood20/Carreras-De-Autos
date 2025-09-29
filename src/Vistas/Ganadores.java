package Vistas;

import javax.swing.*;

import Utils.Etiqueta;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Ganadores extends JFrame{

    private JLabel lblTitulo;
    private JLabel[] lblGanadores;
    private JButton btnVolver, btnReiniciar;

    public Ganadores(String[] ganadores) {
        setTitle("Ganadores de la Carrera");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HACE QUE EL USUARIO NO PUEDA CERRAR LA VENTANA
        setResizable(false); // PARA QUE EL USUARIO NO REDUZCA LA PANTALLA

        // Panel título
        lblTitulo = new JLabel("¡Felicidades! Resultados de la Carrera", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel ganadores
        JPanel panelGanadores = new JPanel(new GridLayout(ganadores.length, 1));
        lblGanadores = new JLabel[ganadores.length];

        for (int i = 0; i < ganadores.length; i++) {
            lblGanadores[i] = new JLabel((i+1) + "°: " + ganadores[i], SwingConstants.CENTER);
            panelGanadores.add(lblGanadores[i]);
        }

        JLabel primer=new Etiqueta(100, 35, 50, 50, "img/Primer Lugar.png").conImagen();
        add(primer);

        JLabel segundo=new Etiqueta(100, 90, 50, 50, "img/Segundo Lugar.png").conImagen();
        add(segundo);

        JLabel tercer=new Etiqueta(100, 150, 50, 50, "img/Tercer Lugar.png").conImagen();
        add(tercer);

        add(panelGanadores, BorderLayout.CENTER);

        // Panel botones
        JPanel panelBotones = new JPanel();
        btnVolver = new JButton("Volver a Jugar");
        btnReiniciar = new JButton("Reiniciar Jugadores");
        
        panelBotones.add(btnVolver);
        panelBotones.add(btnReiniciar);
        add(panelBotones, BorderLayout.SOUTH);

        // Acciones botones
        btnVolver.addActionListener(e -> {
            /*List<String> jugadores=Arrays.asList(ganadores);
            this.setVisible(false);

            new Carrera(jugadores);*/
        });

        btnReiniciar.addActionListener(e -> {
            /*this.setVisible(false);
            
            new Menu();*/
        });
    }

    public static void main(String[] args)  {

        String [] ganadores={"Alfredo","Bot 2","Bot 4"};
        new Ganadores(ganadores).setVisible(true);
    }
}

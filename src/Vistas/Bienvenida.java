package Vistas;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Bienvenida extends JFrame {

    public Bienvenida() {
        setTitle("CARRERA DEL AÑO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(52, 73, 94));
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(52, 73, 94));
        panelLogo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        JLabel labelLogo = new JLabel(" BIENVENIDO A ESTA CARRERA");
        labelLogo.setFont(new Font("Arial", Font.BOLD, 15));
        labelLogo.setForeground(Color.WHITE);

        JLabel labelLog = new JLabel(" PRESIONA EL MENU PARA IR AL CENTRO DE PREPARACION");
        labelLog.setFont(new Font("Arial", Font.BOLD, 15));
        labelLog.setForeground(Color.WHITE);

        JLabel logoImagen = ConImagen();

        JButton botonMenu = new JButton("Menú");
        botonMenu.setFont(new Font("Arial", Font.BOLD, 18));
        botonMenu.setBackground(new Color(46, 204, 113)); // Color verde
        botonMenu.setForeground(Color.BLACK);
        botonMenu.setFocusPainted(false);
        botonMenu.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));


        // BOTON DE ENTTRAR A MENU
        botonMenu.addActionListener(e -> {
            this.setVisible(false);
            new Menu();
        });

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(52, 73, 94));
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        panelLogo.add(logoImagen);
        panelLogo.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio
        panelLogo.add(labelLogo);
        panelLogo.add(labelLog);

        panelBoton.add(botonMenu);

        panelPrincipal.add(panelLogo, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        add(panelPrincipal);

    }

    private JLabel ConImagen() {
        try {
            File file = new File("img/auto.png");
            if (file.exists()) {
                Image image = ImageIO.read(file);
                Image imagenEscalada = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
                JLabel labelImagen = new JLabel(iconoEscalado);
                labelImagen.setHorizontalAlignment(JLabel.CENTER);
                return labelImagen;
            } else {
                System.out.println("El archivo no existe: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        JLabel labelError = new JLabel("LOGO");
        labelError.setFont(new Font("Arial", Font.BOLD, 24));
        labelError.setForeground(Color.WHITE);
        return labelError;
    }
}
package Utils;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Vistas.Carrera;

public class Util {

    public static JTextField Jugador1TextField;
    public static JTextField Jugador2TextField;
    public static JTextField Jugador3TextField;
    public static JTextField Jugador4TextField;

    // botones para saber la cantidad de jugadores
    public static void CrearBotonesJ(JFrame ventaFrame, String texto, int x, int y, int width, int height) {

        JButton JButton = new JButton(texto);
        JButton.setBounds(x, y, width, height);
        JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (texto.equals("2")) {
                    // habilitar los text field de jugador 1 y 2
                    if (Jugador1TextField != null)
                        Jugador1TextField.setEnabled(true);
                    if (Jugador2TextField != null)
                        Jugador2TextField.setEnabled(true);
                    // deshabilitar los text field de jugador 3 y 4
                    if (Jugador3TextField != null)
                        Jugador3TextField.setEnabled(false);
                    if (Jugador4TextField != null)
                        Jugador4TextField.setEnabled(false);
                } else if (texto.equals("3")) {
                    // habilitar los text field de jugador 1, 2 y 3
                    if (Jugador1TextField != null)
                        Jugador1TextField.setEnabled(true);
                    if (Jugador2TextField != null)
                        Jugador2TextField.setEnabled(true);
                    if (Jugador3TextField != null)
                        Jugador3TextField.setEnabled(true);
                    // deshabilitar el text field de jugador 4
                    if (Jugador4TextField != null)
                        Jugador4TextField.setEnabled(false);
                } else if (texto.equals("4")) {
                    // habilitar los text field de jugador 1, 2, 3 y 4
                    if (Jugador1TextField != null)
                        Jugador1TextField.setEnabled(true);
                    if (Jugador2TextField != null)
                        Jugador2TextField.setEnabled(true);
                    if (Jugador3TextField != null)
                        Jugador3TextField.setEnabled(true);
                    if (Jugador4TextField != null)
                        Jugador4TextField.setEnabled(true);
                }
            }
        });
        ventaFrame.add(JButton);
    }

    public static void CrearBotonStart(JFrame ventaFrame, String texto, int x, int y, int width, int height) {
        JButton JButton = new JButton(texto);
        JButton.setBounds(x, y, width, height);

        JButton.addActionListener(e -> {
            List<String> jugadores = new ArrayList<>();
            
            // Para cada campo: si contiene el texto por defecto, se añade "Bot", sino el nombre ingresado
            if (Jugador1TextField != null) {
                String t1 = Jugador1TextField.getText();
                jugadores.add("Nombre Jugador 1".equals(t1) ? "Bot 1" : t1.trim());
            }
            if (Jugador2TextField != null) {
                String t2 = Jugador2TextField.getText();
                jugadores.add("Nombre Jugador 2".equals(t2) ? "Bot 2" : t2.trim());
            }
            if (Jugador3TextField != null) {
                String t3 = Jugador3TextField.getText();
                jugadores.add("Nombre Jugador 3".equals(t3) ? "Bot 3" : t3.trim());
            }
            if (Jugador4TextField != null) {
                String t4 = Jugador4TextField.getText();
                jugadores.add("Nombre Jugador 4".equals(t4) ? "Bot 4" : t4.trim());
            }
            ventaFrame.setVisible(false);
            new Carrera(jugadores);
        });
        ventaFrame.add(JButton);
    }

    public static void CrearTitulos(JFrame ventaFrame, String texto, int x, int y, int width, int height) {
        JLabel JTitulo = new JLabel(texto);
        JTitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        JTitulo.setBounds(x, y, width, height);
        ventaFrame.add(JTitulo);

    }

    public static void CrearCamposTexto(JFrame ventaFrame, String texto, int x, int y, int width, int height) {
        JTextField JugadorTextField = new JTextField(texto);
        JugadorTextField.setBounds(x, y, width, height);
        JugadorTextField.setVisible(true);
        JugadorTextField.setEnabled(false);

        if (texto.contains("2"))
            Jugador2TextField = JugadorTextField;
        else if (texto.contains("1"))
            Jugador1TextField = JugadorTextField;
        else if (texto.contains("3"))
            Jugador3TextField = JugadorTextField;
        else if (texto.contains("4"))
            Jugador4TextField = JugadorTextField;
        ventaFrame.add(JugadorTextField);

    }
}
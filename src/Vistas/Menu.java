package Vistas;

import javax.swing.*;
import Utils.*;

public class Menu extends JFrame{

    public Menu() {
        //creamos la ventana menu donde va todo
        JFrame ventaFrame = new JFrame("Menu Principal");
        ventaFrame.setSize(500, 700);
        ventaFrame.setLocationRelativeTo(null);
        ventaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventaFrame.setLayout(null);
        
        // titulo de cuanto jugadores van a participar
        Util.CrearTitulos(ventaFrame, "Cuantos corredores van a participar", 120 , 5, 300, 50);

        //titulo de nombre de los jugadores
        Util.CrearTitulos(ventaFrame, "Nombre de los jugadores", 150, 200, 300, 50);
        
        //aqui van los titulos de los jugadores y textfield para escribir los nombres
        Util.CrearTitulos(ventaFrame, "Jugador 1", 50, 250, 100, 40);
        
        //text field para escribir el nombre del jugador 1
        Util.CrearCamposTexto(ventaFrame, "Nombre Jugador 1", 50, 290, 350, 25);

        //jugador 2
        Util.CrearTitulos(ventaFrame, "Jugador 2", 50, 325, 100, 40);
        
        //text field para escribir el nombre del jugador 2  
        Util.CrearCamposTexto(ventaFrame, "Nombre Jugador 2", 50, 370, 350, 25);

        //jugador 3
        Util.CrearTitulos(ventaFrame, "Jugador 3",50, 410, 100, 40);
        
        //text field para escribir el nombre del jugador 3
        Util.CrearCamposTexto(ventaFrame, "Nombre Jugador 3", 50, 450, 350, 25);

        //text titulo para escribir el nombre del jugador 4

        Util.CrearTitulos(ventaFrame, "Jugador 4", 50, 490, 100, 40);
        
        //text field para escribir el nombre del jugador 4
        Util.CrearCamposTexto(ventaFrame, "Nombre Jugador 4", 50, 530, 350, 25);

        // Ahora crear botones de selección de cantidad tras inicializar campos
        //aqui van los botones para saber la cantidad de jugadores
        Util.CrearBotonesJ(ventaFrame, "2", 50, 100, 100, 50);
        Util.CrearBotonesJ(ventaFrame, "3", 200, 100, 100, 50);
        Util.CrearBotonesJ(ventaFrame, "4", 350, 100, 100, 50);

        //boton para iniciar la carrera
        Util.CrearBotonStart(ventaFrame, "Iniciar Carrera", 150, 600, 200, 50);

        ventaFrame.setVisible(true);
    }
}
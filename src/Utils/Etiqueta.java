package Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Etiqueta {

    private String titulo;
    private int x;
    private int y;
    private int ancho;
    private int altura;
    private Color colorDeLetra;
    private int tamañoLetra;
    private String tipografia; //Arial etc;
    private String url;

    public Etiqueta(

    String titulo, 
    int x, 
    int y, 
    int ancho, 
    int altura, 
    Color colorDeLetra, 
    int tamañoLetra,
    String tipografia) {

        this.titulo = titulo;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.colorDeLetra = colorDeLetra;
        this.tamañoLetra = tamañoLetra;
        this.tipografia = tipografia;
    }

    public Etiqueta(
        int x, 
        int y, 
        int ancho, 
        int altura,
        String url) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.url = url;
    }

    public JLabel normal(){
        JLabel etiqueta = new JLabel(titulo);
		etiqueta.setBounds(x, y, ancho, altura);
		etiqueta.setForeground(colorDeLetra);
		etiqueta.setFont(new Font(tipografia, Font.BOLD, tamañoLetra));
		return etiqueta;
    }

    public JLabel conImagen(){
         try {
	        //CREAMOS LA IMAGEN CON LA FUNCION DEL SISTEMA
	        BufferedImage imagenOriginal = ImageIO.read(new File(url));

	        //IMAGEN ESCALADA
	        Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, altura, Image.SCALE_FAST); // Más rápido que SCALE_SMOOTH

	        //ESTO DIBUJA LA IMAGEN PARA QUE SEA MAS RAPIDO
	        BufferedImage imagenFinal = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = imagenFinal.createGraphics();
	        g2d.drawImage(imagenEscalada, 0, 0, null);
	        g2d.dispose();
	        
	        //SE LO AGREGAMOS A LA ETIQUETA
	        JLabel ilustracion = new JLabel(new ImageIcon(imagenFinal));
	        ilustracion.setBounds(x, y, ancho, altura);
	        return ilustracion;
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new JLabel("Error al cargar imagen");
	    }
	}
}


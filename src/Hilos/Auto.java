package Hilos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Vistas.Carrera;

public class Auto extends Thread{

    
    private JLabel auto;
    private int meta;
    private String nombre;
    
    public Auto(String nombre,JLabel auto, int meta){
        this.nombre=nombre;
        this.auto=auto;
        this.meta=meta;
    }

   @Override
    public void run(){
        try { Thread.sleep(5900); } catch (InterruptedException e) {}

        while (auto.getX() < meta) {
            int avance = (int)(Math.random() * 10 + 1); // MUEVE ALEATORIAMANTE

            SwingUtilities.invokeLater(() -> auto.setLocation(auto.getX() + avance, auto.getY()));

            try { Thread.sleep(50); } catch (InterruptedException e) {}
        }

        synchronized (Carrera.ganadores) {
            Carrera.ganadores.add(nombre);
        }
    }

   public JLabel getAuto() {
    return auto;
   }

   public void setAuto(JLabel auto) {
    this.auto = auto;
   }

   public int getMeta() {
    return meta;
   }

   public void setMeta(int meta) {
    this.meta = meta;
   }

   public String getNombre() {
    return nombre;
   }

   public void setNombre(String nombre) {
    this.nombre = nombre;
   }

    

}
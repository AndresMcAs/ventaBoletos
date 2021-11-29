package modelo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
  *   @author HP
  *   clase asiento sirve para representar a los asientos de la sala
  *
  */

public class Asiento extends JLabel{

  private static final long serialVersionUID = 5L;
	
  private boolean reservado = false;
  public final int VALOR;
  	
  public Asiento(String nombre, int valor) {
	
    super(nombre);
    VALOR = valor;
    
    setHorizontalAlignment(SwingConstants.CENTER);
    setFont(new Font("Verdana", Font.BOLD, 20));
    setOpaque(true);
    setBackground(Color.WHITE);
    setForeground(Color.DARK_GRAY);
    setBorder(BorderFactory.createCompoundBorder(
                   BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GREEN),
                   BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
    setToolTipText("Disponible,fila: " + VALOR);
    reservado = false;
  }
  
  /*
   *  reservar metodo que se encarga de mostara si un asiento esta ocupado o no 
   *  
   */
  public void reservar() {
        
   
    setForeground(Color.RED);
    setToolTipText("Reservado");
    setBorder(null);
    setBorder(BorderFactory.createCompoundBorder(
                  BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED),
                  BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
    reservado = true;
  }
        
  public boolean estaReservado() {
    return reservado;
  }
}
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
	
  private boolean reservado;
  public final int VALOR;
  	
  public Asiento(String nombre, int valor) {
	
    super(nombre);
    VALOR = valor;
    reservado = false;
    setHorizontalAlignment(SwingConstants.CENTER);
    setFont(new Font("Verdana", Font.BOLD, 20));
    setOpaque(true);
    setBackground(Color.WHITE);
    setForeground(Color.DARK_GRAY);
    setBorder(BorderFactory.createCompoundBorder(
                   BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GREEN),
                   BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
    setToolTipText("Disponible,fila: " + VALOR);
  }
  
  /*
   *  reservar metodo que se encarga de mostara si un asiento esta ocupado o no 
   *  
   */
  public void reservar() {
        
    reservado = true;
    setForeground(Color.RED);
    setToolTipText("Reservado");
    setBorder(null);
    setBorder(BorderFactory.createCompoundBorder(
                  BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED),
                  BorderFactory.createEmptyBorder(10, 10, 10, 10)));
  }
        
  public boolean estaReservado() {
    return reservado;
  }
}
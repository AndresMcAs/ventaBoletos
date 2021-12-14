package control;

import basedatos.SalaDao;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Asiento;
import modelo.Sala;


/**
 * Muestra el tablero de los asientos de una sala 
 * @author HP
 *
 */
public class PanelAsientos extends JPanel{

  private static final long serialVersionUID = 1L;
  	
  private Asiento[][] asientos;
  SalaDao salaDao = new SalaDao();
  Sala sala = new Sala();
  
  /**
   * constructor del tablero de los asientos de la sala 
   */
  public PanelAsientos() {
    /*nombre de la sala a buscar para mostrar su numero de asiento*/
    sala = salaDao.buscarSala("Sala 1");
    int i;
    int j;
    iniciarAsientos();
    setLayout(new GridLayout(8, 9, 2, 2));
    for (i = 0; i < sala.getFila(); i++)
      for (j = 0; j < sala.getColumna(); j++)
        add(asientos[i][j]);
    setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(5, 5, 5, 5),
        BorderFactory.createTitledBorder("Asientos de la " + sala.getNombre())),
            BorderFactory.createLoweredSoftBevelBorder()));
  }
	
  public void iniciarAsientos() {
	
	//filas - columnas 
    asientos = new Asiento[sala.getFila()][sala.getColumna()];
    int numeroAsiento = sala.getFila();
    int valor = sala.getFila();
       
    for (int i = 0; i < sala.getFila(); i++) { 
   
      asientos[i][0] = new Asiento(numeroAsiento + "A", valor);
      asientos[i][1] = new Asiento(numeroAsiento + "B", valor);
      asientos[i][2] = new Asiento(numeroAsiento + "C", valor);
      asientos[i][3] = new Asiento(numeroAsiento + "D", valor);
      asientos[i][4] = new Asiento(numeroAsiento + "E", valor);
      asientos[i][5] = new Asiento(numeroAsiento + "F", valor);
      asientos[i][6] = new Asiento(numeroAsiento + "G", valor);
      asientos[i][7] = new Asiento(numeroAsiento + "H", valor);
      asientos[i][8] = new Asiento(numeroAsiento + "I", valor);
      numeroAsiento--;
      valor--;
    }
    reservar();
  }
  
  private void reservar() {
    int reservas = 25;
    Random azar = new Random();
    
    while (reservas > 0) {
      int fila = azar.nextInt(8);
      int columna = azar.nextInt(9);
      if (!asientos[fila][columna].estaReservado()) {
        asientos[fila][columna].reservar();
        reservas--;
      }
    }
  }
  
  /** 
   * comprueba si un asiento esta reservado o no
   * @param asiento
   * @return Asiento
   */
  public Asiento compruebaAsiento(String asiento) {

    for (int i = 0; i < sala.getFila(); i++) {
      for (int j = 0; j < sala.getColumna(); j++) {
        if (asientos[i][j].getText().equals(asiento)) {
          if (asientos[i][j].estaReservado()) {
            JOptionPane.showMessageDialog(null, asiento + " ya esta reservado",
                        "Reservar asientos", JOptionPane.WARNING_MESSAGE);
            return null;
          } else {
            return asientos[i][j];
          }
        }
      }
    }
    JOptionPane.showMessageDialog(null, "No existe el asiento: " + asiento,
               "Reservar asientos", JOptionPane.WARNING_MESSAGE);
    return null;
  }
}
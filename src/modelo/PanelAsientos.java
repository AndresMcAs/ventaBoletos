package modelo;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelAsientos extends JPanel{

  private static final long serialVersionUID = 1L;
	
  private Asiento[][] asientos;
	
  public PanelAsientos() {
    int i;
    int j;
    iniciarAsientos();
    setLayout(new GridLayout(8, 9, 2, 2));
      for (i = 0; i < 8; i++)
      for (j = 0; j < 9; j++)
        add(asientos[i][j]);
    setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(5, 5, 5, 5),
        BorderFactory.createTitledBorder("Asientos de la Sala")),
            BorderFactory.createLoweredSoftBevelBorder()));
  }
	
  private void iniciarAsientos() {
    asientos = new Asiento[8][9];
    int nAsiento = 8;
    int valor = 8;
        
    for (int i = 0; i < 8; i++) {                   
      asientos[i][0] = new Asiento(nAsiento + "A", valor);
      asientos[i][1] = new Asiento(nAsiento + "B", valor);
      asientos[i][2] = new Asiento(nAsiento + "C", valor);
      asientos[i][3] = new Asiento(nAsiento + "D", valor);
      asientos[i][4] = new Asiento(nAsiento + "E", valor);
      asientos[i][5] = new Asiento(nAsiento + "F", valor);
      asientos[i][6] = new Asiento(nAsiento + "G", valor);
      asientos[i][7] = new Asiento(nAsiento + "H", valor);
      asientos[i][8] = new Asiento(nAsiento + "I", valor);
      nAsiento--;
      valor--;
    }
  }
	
  public Asiento compruebaAsiento(String asiento) {
	
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 9; j++)
        if (asientos[i][j].getText().equals(asiento)) {
          if (asientos[i][j].estaReservado()) {
            JOptionPane.showMessageDialog(null, asiento + " ya está reservado",
                        "Reservar asientos", JOptionPane.WARNING_MESSAGE);
            return null;
          } else
            return asientos[i][j];
        }
    }
    //Si los bucles finalizan sin que haya habido un return, es que este asiento no existe
    JOptionPane.showMessageDialog(null, "No existe el asiento: " + asiento,
               "Reservar asientos", JOptionPane.WARNING_MESSAGE);
    return null;
  }
}
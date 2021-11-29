package control;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import basedatos.SalaDao;
import modelo.Asiento;
import modelo.Sala;


public class PanelAsientos extends JPanel{

  private static final long serialVersionUID = 1L;
  	
  private Asiento[][] asientos;
  SalaDao dao = new SalaDao();
  Sala s = new Sala();
	 
  public PanelAsientos() {
	s = dao.buscarSala("Sala 1");
    int i;
    int j;
    iniciarAsientos();
    setLayout(new GridLayout(8, 9, 2, 2));
      for (i = 0; i < s.getFila(); i++)
      for (j = 0; j < s.getColumna(); j++)
        add(asientos[i][j]);
    setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(5, 5, 5, 5),
        BorderFactory.createTitledBorder("Asientos de la "+s.getNombre())),
            BorderFactory.createLoweredSoftBevelBorder()));
  }
	
  public void iniciarAsientos() {
	//filas - columnas 
    asientos = new Asiento[s.getFila()][s.getColumna()];
    int nAsiento = s.getFila();
    int valor = s.getFila();
       
    for (int i = 0; i < s.getFila(); i++) { 
    	
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
    reservar();
  }
  
  private void reservar() {
		int reservas = 25;
		Random azar = new Random();
		while(reservas > 0) {
			int fila = azar.nextInt(8);
			int columna = azar.nextInt(9);
			if (!asientos[fila][columna].estaReservado()) {
				asientos[fila][columna].reservar();
				reservas--;
			}
			
		}
	}
	
  public Asiento compruebaAsiento(String asiento) {
	
    for (int i = 0; i < s.getFila(); i++) {
      for (int j = 0; j < s.getColumna(); j++)
        if (asientos[i][j].getText().equals(asiento)) {
          if (asientos[i][j].estaReservado()) {
            JOptionPane.showMessageDialog(null, asiento + " ya esta reservado",
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
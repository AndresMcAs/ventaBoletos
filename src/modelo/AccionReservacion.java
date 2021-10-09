
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AccionReservacion implements ActionListener {
   
  private PanelReservar pnReservar;
    
  @Override
  public void actionPerformed(ActionEvent e) {
    int limite;
    String confirmacion;
    int respuesta;
    String peticionReservas = pnReservar.getReservas();
    String[] reservas = peticionReservas.split(","); //comporvacion de los datos ingresados 
     /*
     * Comprobamos si existen los asientos solicitados
     * y si están reservados o no. Solo se admiten 5 reservas
     * máximo. Si ha solicitado más, serán ignoradas.
     */
    PanelAsientos asientos = new PanelAsientos();
    limite = (reservas.length > 5)? 5:reservas.length;
    //En este arraylist anotamos los asientos solicitados que podrían reservarse
    ArrayList<Asiento> reservasValidas = new ArrayList<Asiento>();
    for (int i = 0; i < limite; i++) {
      Asiento asiento = asientos.compruebaAsiento(reservas[i]);
      if (asiento != null)
        reservasValidas.add(asiento);
	  }
    if (reservasValidas.isEmpty())
        JOptionPane.showMessageDialog(null, "No hay asientos reservables en su petición.\n"
        	                +"Indique nombres de asientos que se muestren disponibles con color verde",
                                    "Reservar asientos", JOptionPane.INFORMATION_MESSAGE);
    else
      {
      //Calculamos importe total de la reserva y pedimos confirmación
      StringBuilder reservados = new StringBuilder();
      int importe = 0;
      for (Asiento asi : reservasValidas) {
          reservados.append("[" + asi.getText() + "] ");
          importe += asi.VALOR;
       }
      confirmacion = String.format("Asientos a reservar: %s\nImporte total: %d\n"
                                     + "¿Confirmar reserva?", reservados.toString(), importe);
      respuesta = JOptionPane.showConfirmDialog(null, confirmacion,
    		                               "Reservar asientos", JOptionPane.YES_NO_OPTION);
      if (respuesta == JOptionPane.YES_OPTION) {
    	  for (Asiento asi: reservasValidas)//Reservamos asientos
    		  asi.reservar();
    	  }
      }
  }
}

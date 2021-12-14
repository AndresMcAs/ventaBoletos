
package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import control.PanelAsientos;
import control.PanelReservar;
import modelo.Asiento;


/**.
 *
 * @author Andres Mendoza
 * Class que realiza la reservacion de asientos  
 */
public class ReservaAsiento extends JFrame {

  private static final long serialVersionUID = 1L;
  
  
  public static void main(String []args) {
    SwingUtilities.invokeLater(new Runnable() {  
      @Override
  public void run() {
        ReservaAsiento thisClass = new ReservaAsiento();
          thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          thisClass.setVisible(true);
        }
      });
  }
  
  /**.
   * reserva algún asiento diponible
   */
  public ReservaAsiento() {
    
    super("Asignar Asiento");
    setSize(650, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridLayout gl = new GridLayout(8, 6, 2, 2); 
    //se muestran los asientos de la sala 
    PanelAsientos panelAsiento = new PanelAsientos(); 
    panelAsiento.setLayout(gl);
     
    PanelReservar panelReserva = new PanelReservar();
    GridLayout glr = new GridLayout(3, 3, 2, 2);
    glr.setRows(3);
    glr.setHgap(1);
    glr.setVgap(10);
    glr.setColumns(2);
    panelReserva.setLayout(glr);
      
    Container cp = getContentPane(); // para mostrar lo asientos de la sala 
    cp.setLayout(new FlowLayout());
    cp.add(panelAsiento, BorderLayout.SOUTH);
    cp.add(panelReserva, BorderLayout.NORTH);
    //eventos de los botones 
    panelReserva.btReservar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String confirmacion;
        int respuesta;
        String peticionReservas = panelReserva.getReservas();
        String[] reservas = peticionReservas.split(","); //comporvacion de los datos ingresados 
        /*
        * Comprobamos si existen los asientos solicitados
        * y si estan reservados o no. 
        */
        PanelAsientos asientos = new PanelAsientos();
        Asiento asiento = null;
        //En este arraylist anotamos los asientos solicitados que podran reservarse
        ArrayList<Asiento> reservasValidas = new ArrayList<Asiento>();
        for (int i = 0; i < reservas.length; i++) {
            asiento = asientos.compruebaAsiento(reservas[i]);
            if (asiento != null) {
            reservasValidas.add(asiento);
            }
        }
        
        if (reservasValidas.isEmpty()) {
          JOptionPane.showMessageDialog(null, "No hay asientos reservables en su peticion.\n" 
                         + "Indique nombres de asientos que se muestren disponibles en verde",
                         "Reservar asientos", JOptionPane.INFORMATION_MESSAGE);
        } else {
          //Calculamos importe total de la reserva y pedimos confirmacion
          StringBuilder reservados = new StringBuilder();
          int importe = 0;
          for (Asiento asi : reservasValidas) {
            if (asiento.estaReservado()) {
                  reservados.append("[" + asi.getText() + "] ");
                  importe += 50; // cambiar por el precio de los boletos 
            }
          }
          confirmacion = String.format("Asientos a reservar: %s\nImporte total: %d\n"
                                          + "¿Confirmar reserva?", reservados.toString(), importe);
          respuesta = JOptionPane.showConfirmDialog(null, confirmacion,
                                       "Reservar asientos", JOptionPane.YES_NO_OPTION);
          if (respuesta == JOptionPane.YES_OPTION) {
            //Reservamos asientos
            for (Asiento asi : reservasValidas) {
              if (asi.estaReservado()) {
                asi.reservar();
              
              }
            }
          }
          }
        }
    });
   
    
    panelReserva.btCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dispose(); 
        }
      });
    
  }
    
}

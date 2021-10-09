
package control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import modelo.AccionReservacion;
import modelo.PanelAsientos;
import modelo.PanelReservar;


/**
 *
 * @author Andres Mendoza
 * Class que realiza la reservacion de asientos  
 */
public class ReservaAsiento extends JFrame {

  private static final long serialVersionUID = 1L;
   
  
  public static void main (String []args) {
    SwingUtilities.invokeLater(new Runnable() {  
      @Override
  public void run() {
        ReservaAsiento thisClass = new ReservaAsiento();
          thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          thisClass.setVisible(true);
        }
      });
  }

  public ReservaAsiento() {
    
    super("Asignar Asiento");
    setSize(650, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridLayout gl = new GridLayout(8, 6, 2, 2); 
      
       
    PanelAsientos panelAsiento = new PanelAsientos(); //se muestran los asientos de la sala
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
      
    panelReserva. btReservar.addActionListener(new ActionListener() {
        @Override
         public void actionPerformed(ActionEvent e) {
          AccionReservacion res = new AccionReservacion();
          res.actionPerformed(e);
      }
        });
    
  }
    
}

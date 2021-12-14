package control;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * Limpia la pantalla de los datos ingresados 
 *
 */
public class Limpia {
  
  /**.
   * limpia el texto ingresado en cada uno de los componentes de 
   * los formularios 
   */
  public void limpiarTexto(JPanel panel) {
    for (int i = 0; panel.getComponents().length > i; i++) { 
      if (panel.getComponents()[i] instanceof JTextField) {
        ((JTextField) panel.getComponents()[i]).setText("");
      } else if (panel.getComponents()[i] instanceof JPasswordField) {
 
        ((JPasswordField) panel.getComponents()[i]).setText("");
        
      } else if (panel.getComponents()[i] instanceof JTextArea) {
        ((JTextArea) panel.getComponents()[i]).setText("");
      }  else if (panel.getComponents()[i] instanceof JComboBox) {
        ((JComboBox<?>) panel.getComponents()[i]).setSelectedIndex(0);
      }  else if (panel.getComponents()[i] instanceof  JDateChooser) {
        (( JDateChooser) panel.getComponents()[i]).setCalendar(null);
      }  else if (panel.getComponents()[i] instanceof  JLabel) {
        (( JLabel) panel.getComponents()[i]).setIcon(null);
      } 
    }
  }
}

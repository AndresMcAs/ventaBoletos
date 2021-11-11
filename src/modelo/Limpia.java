package modelo;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**.
 * Limpia la pantalla de los datos ingresados 
 *
 */
public class Limpia {
  
  /**.
   * limpia el testo ingresado
   */
  public void limpiarTexto(JPanel panel) {
    for (int i = 0; panel.getComponents().length > i; i++) { 
      if (panel.getComponents()[i] instanceof JTextField) {
        ((JTextField) panel.getComponents()[i]).setText("");
      } else if (panel.getComponents()[i] instanceof JPasswordField) {
        ((JPasswordField) panel.getComponents()[i]).setText("");
      } else if (panel.getComponents()[i] instanceof JTextArea) {
        ((JTextArea) panel.getComponents()[i]).setText("");
      }
            
    }
  }
}

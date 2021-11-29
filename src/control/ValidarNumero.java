package control;

/**.
 * Valida si es un numero o no 
 * @author HP
 *
 */
public class ValidarNumero {
	
  /**.
   *  
   * @param cadena validar si se trata de un numero o no
   * @return
   */
  public boolean validar(String cadena) {
    int m;
    try {
      m = Integer.parseInt(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}

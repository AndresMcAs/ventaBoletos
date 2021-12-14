package control;

/**
 * Valida si es un numero o no 
 * @author Andres Mendoza
 *
 */
public class ValidarNumero {
	
  /** 
   * valida un numero
   * @param cadena valida si se trata de un numero o no
   * @return boolean
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

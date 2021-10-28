
package modelo;

import java.util.ArrayList;
import javax.swing.JFrame;

/** 
 * 
 * clase cartelera que nos mostrar las peliculas que se proyectaran
 * en el cine 
 * @author Andres Mendoza
 *  @Version 1.0 , 2021/10/21
 */

public final class Cartelera extends JFrame {
    

  private static final long serialVersionUID = 1L;
	
  private final ArrayList<Pelicula> peliculas;
  
  /**
   * metodo constructor de la cartelera   
   */
  
  public Cartelera() {
        
    peliculas = new ArrayList<>(); 
    Pelicula pelicula = new Pelicula();
    setPelicula(pelicula);
  }

  public void setPelicula(Pelicula pelicula) {
    peliculas.add(pelicula);
  }
    
  public ArrayList<Pelicula> getPelicula() {
    return peliculas;
  }
  /**
	* este metodo puede cambiar pues se tiene los obejtos DAO 
    * para la consulta en la base de datos
    */  
  
  public Pelicula buscaPelicula(String nombre) {
    
  
    Pelicula pelicula = null;
    Pelicula peliculaEncontrada = null;
           
    for (int i = 0; i < peliculas.size(); i++) {
      pelicula = peliculas.get(i);
      if (nombre.equals(pelicula.getNombre())) {
        peliculaEncontrada = peliculas.get(i);
      }
    }
    return peliculaEncontrada;
  }
    
}

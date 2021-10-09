
package modelo;

import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author Andres Mendoza
 */

/* esta clase es la cartelera que sera visble para la busqueda de alguna pelicua*/
public final class Cartelera extends JFrame{
    
  private final ArrayList<Pelicula> peliculas;
    
  public Cartelera () {
        
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

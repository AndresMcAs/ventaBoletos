
package baseDatos;

import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author HP
 */
public interface PeliculaDao {
      
  public List<Pelicula> consultar();
  
  public void insertar(Pelicula pelicula);
  
  public int actualizar(Pelicula pelicula);
  
  public int borrar(Pelicula pelicula);
}

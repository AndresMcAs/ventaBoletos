
package basedatos;

import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author HP
 */
public interface PeliculaDao {
      
  public List<Pelicula> consultar();
  
  public boolean insertar(Pelicula pelicula);
  
  public int actualizar(Pelicula pelicula);
  
  public int borrar(Pelicula pelicula);
}

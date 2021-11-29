
package basedatos;

import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author HP
 */
public interface PeliculaDao {
      
  public List<Pelicula> consultar();
  
  public Pelicula buscarPeliculaHorario(String nombre);
  public Pelicula buscarPelicula(String nombre);
  
  public boolean insertar(Pelicula pelicula);
  
  public int actualizar(Pelicula pelicula);
  
  public int borrar(Pelicula pelicula);
  
  public int borrarPorNombre(int clave, String nombre);
}

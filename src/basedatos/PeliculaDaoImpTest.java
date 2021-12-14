package basedatos;

import modelo.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**.
 *
 * @author HP
 */
public class PeliculaDaoImpTest {
  @Test
  public void debeInsertar() {
    Pelicula pel = new Pelicula();
    pel.setNombre("No Respires 2");
    pel.setDirector("Rodo Sayagues");
    pel.setGenero("Terror");
    pel.setDuracion(120);
    pel.setIdioma("Espanol");
    pel.setFechaEstreno("13/08/2020");
    pel.setResumen("Un ciego que cuida de una niña, se enfrenta " 
          + "contra unos tipos que quieren hacerle daño");
    System.out.println("pureba de objeto peliculaDao");
    PeliculaDaoImp dao = new PeliculaDaoImp();
    boolean registro;
    registro = dao.insertar(pel);
    assertTrue(registro);
  }
  
  @Test 
  public void debeBuscar() {
    PeliculaDaoImp da = new PeliculaDaoImp();
    Pelicula peliculaHallada = da.buscarPelicula("No Respires");
    assertNotNull(peliculaHallada);
  }
  
  @Test
  public void debeBorrar() {
	PeliculaDaoImp da = new PeliculaDaoImp();
	int peliculaBorrar = da.borrarPorNombre(46,"No Respires");
    assertEquals(peliculaBorrar,1);
  }
 
}

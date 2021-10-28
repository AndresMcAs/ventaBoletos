package basedatos;

import modelo.Pelicula;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    pel.setFechaEstreno("13/08/2021");
    pel.setResumen("Un ciego que cuida de una niña, se enfrenta " 
          + "contra unos tipos que quieren hacerle daño");
    System.out.println("pureba de objeto peliculaDao");
    PeliculaDaoImp dao = new PeliculaDaoImp();
    boolean registro;
    registro = dao.insertar(pel);
    assertTrue(registro);
  }

}

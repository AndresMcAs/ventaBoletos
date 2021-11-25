package control;

import static org.junit.jupiter.api.Assertions.assertTrue;

import basedatos.SalaDao;
import modelo.Sala;
import org.junit.jupiter.api.Test;

/**.
 * prueba de registro de sala
 *
 */
public class RegistrarSalaTest {

  @Test
  public void debeInsertar() {
    Sala sala = new Sala();
    sala.setNombre("Sala 7"); 
    sala.setFila(6);
    sala.setColumna(6);
    System.out.print("prueba del objeto sala");

    SalaDao dao = new SalaDao();
    boolean registro;
    registro = dao.insertarSala(sala); 
    assertTrue(registro);
  }

  @Test 
  public void debeBuscar() {
    SalaDao dao = new SalaDao();
    dao.buscarSala("Sala 1");
  }

}

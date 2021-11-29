package basedatos;


import modelo.Horario;
import modelo.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**.
 * 
 * @author HP
 *
 */
public class HorarioDaoTest {
  
 @Test
  public void debeInsertar() {
    System.out.println("pureba de objeto peliculaDao");
    PeliculaDaoImp da = new PeliculaDaoImp();
    Pelicula peliculaHallada = da.buscarPeliculaHorario("prueba");
    Horario hor = new Horario();
    System.out.println(""+peliculaHallada.getIde());
    hor.setIdPelicula(peliculaHallada.getIde());
    hor.setDia("13");
    hor.setMes("05");
    hor.setAño("2021");
    hor.setHora("09");
    hor.setMinuto("00");
    hor.setIdSala(3);
    HorarioDao dao = new HorarioDao();
    boolean registro = dao.insertarHorario(hor, peliculaHallada);
    assertTrue(registro);
  }


  @Test
  public void debeBuscar() {

    PeliculaDaoImp dao2 =  new PeliculaDaoImp();
    Pelicula horarior = new Pelicula(); 
    HorarioDao horarioDao = new HorarioDao();
    horarior = horarioDao.buscarHorarioPelicula("prueba");
  }

}

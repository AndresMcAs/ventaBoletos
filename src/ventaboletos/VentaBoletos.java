
package ventaboletos;
 
import baseDatos.AdminBd;
import baseDatos.PeliculaDaoImp;
import control.ReservaAsiento;
import control.RegistrarSala;
import java.util.ArrayList;
import java.util.List;
import modelo.Pelicula;
import modelo.Sala;

/**
 *
 * @author HP
 */
public class VentaBoletos {

  /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        
    List<Pelicula> lista = new ArrayList<>();
    //pruebas del objeto pelicula 
    Pelicula pel = new Pelicula();
    pel.setNombre("No Respires 2");
    pel.setDirector("Rodo Sayagues");
    pel.setGenero("Terror");
    pel.setDuracion(132);
    pel.setIdioma("Español");
    pel.setFechaEstreno("13/08/2021");
    pel.setResumen("Hola");
        
    System.out.println("Pelicula:\n\n"+ pel.ToString());
        
    //AdminBD conexion = new AdminBD();
    //conexion.Conectar();
       
    PeliculaDaoImp pelicula = new PeliculaDaoImp();
    lista = pelicula.consultar();
       
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i).getNombre());
    }
    pelicula.insertar(pel);
     
       
       /*
       Sala sala = new Sala();
       sala.setNombre("Sala1");
       sala.setFila(10);
       sala.setColumna(10);
       
       Sala sala2 = new Sala();
       sala2.setNombre("Sala 2");
       sala2.setFila(20);
       sala2.setColumna(20);
       
       System.out.println(sala2.ToString());
     
       RegistrarSala r = new RegistrarSala(sala);  
       System.out.println(r.Tostring());*/
       //ReservaAsiento as= new ReservaAsiento();
       //as.setVisible(true);
      
    }
    
}

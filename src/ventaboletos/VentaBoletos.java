
package ventaboletos;

import java.util.ArrayList;
import java.util.List;
import basedatos.PeliculaDaoImp;
import modelo.Pelicula;

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
  
       
    PeliculaDaoImp pelicula = new PeliculaDaoImp();
    lista = pelicula.consultar();
       
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i).getNombre() +
    		             lista.get(i).getDirector()  );
    }
     
     

  
    }
    
}

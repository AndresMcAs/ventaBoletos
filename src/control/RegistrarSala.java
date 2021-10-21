
package control;

import modelo.Sala;

/**
 *
 * @author andres mendoza 
 */
public class RegistrarSala {
    
  private Sala sala;
    
  public  RegistrarSala(Sala sal) {
      
    sala = new Sala(sal);   
    sala.setNombre(sal.getNombre());
    sala.setFila(sal.getFila());
    sala.setColumna(sal.getColumna());
      
    // almacenar los datos e la base
    //metodo de inserccion de sala
    
  }
  
  public void ConstruirSala(Sala sal) {
        
      // construir una matriz con los parematros de las filas y columnas 
      // para imprimir la los asientos de la salas 
      
  }
  //metodo de prueba para el registro despues se puede consultar con obejtos dao
  
  public String Tostring() {
    
    String ca = sala.ToString();
    return ca;
  }

    public Sala getSala() {
    return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    
    
}


package modelo;


/**
 *
 * @author andres Mendoza
 * clase para las salas disponibles en el cine 
 */
public class Sala {
    
  private String nombre;
  private int fila;
  private int columna;
    
  public Sala(String nombre, int fila, int columna) {
    
    this.nombre = nombre;
    this.fila = fila;
    this.columna = columna;
     
  }
    
  public Sala(Sala sala) {
    
  }
  
  public Sala() {
   
  }
    
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getFila() {
    return fila;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public int getColumna() {
    return columna;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }
  
  public String ToString() {
      
    String sala = "Nombre: " +  getNombre() 
                    + "\nFilas: " + getFila() 
                    + "\nColumnas: " + getColumna();
    return sala;
    
  }
    
}

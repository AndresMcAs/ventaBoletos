
package modelo;

/**
 *
 * @author Andres Mendoza
 */
public final class Pelicula {
    
  private int ide;
  private String nombre;
  private String director;
  private int    duracion;
  private String idioma;
  private String genero;
  private String fechaEstreno;
  private String resumen;
  
  public Pelicula(String nombre, String dire, String idioma, 
      String genero, String fecha, int duracion) {
    this.ide = getIde();
    this.nombre = nombre;
    this.director = dire;
    this.duracion = duracion;
    this.idioma = idioma;
    this.genero = genero;
    this.fechaEstreno = fecha;
  }
    
  public Pelicula() {
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }
    
  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getFechaEstreno() {
    return fechaEstreno;
  }

  public void setFechaEstreno(String fechaEstreno) {
    this.fechaEstreno = fechaEstreno;
  }

  public int getIde() {
    return ide;
  }

  public void setIde(int ide) {
    this.ide = ide;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  public String getResumen() {
    return resumen;
  }

  public void setResumen(String resumen) {
    this.resumen = resumen;
  }
   
  public String ToString() {
        
    String pelicula = null;
        
    pelicula = "Nombre: " + getNombre() + "\n";
    pelicula = pelicula + "Director: " + getDirector() + "\n";
    pelicula = pelicula + "Idioma: " + getIdioma() + "\n";
    pelicula = pelicula + "Género: " + getGenero() + "\n";
    pelicula = pelicula + "Fecha Estreno: " + getFechaEstreno() + "\n";
        
    return pelicula;
  }
      
    
}

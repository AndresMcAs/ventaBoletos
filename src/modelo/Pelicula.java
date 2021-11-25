
package modelo;

import java.sql.Blob;

/**.
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
  private String imagen;
  /**.
   * clase pelicula hace referencia a todos los datos referentes 
   * a un apelicula 
   * @param nombre de la pelicula
   * @param dire   nombre del director
   * @param idioma idioma de la pelicula
   * @param genero genero al que pertenece la pelicula
   * @param fecha  fecha de estreno de la pelicula
   * @param duracion , tiempo de duracion
   */
  
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
  
  public Pelicula(String nombre, String director, int duracion, String idioma, 
                  String estreno, String genero, String resumen) {
    this.nombre = nombre;
    this.director = director;
    this.duracion = duracion;
    this.idioma = idioma;
    this.genero = genero;
    this.fechaEstreno = estreno; 
    this.resumen = resumen;
  }
  
  

  public Pelicula(int ide, String nombre, String director, int duracion, String idioma, String genero,
		String fechaEstreno, String resumen, String imagen) {
	super();
	this.ide = ide;
	this.nombre = nombre;
	this.director = director;
	this.duracion = duracion;
	this.idioma = idioma;
	this.genero = genero;
	this.fechaEstreno = fechaEstreno;
	this.resumen = resumen;
	this.imagen = imagen;
}

public Pelicula(String nom, String director2, int duracion2, String idioma2, String estreno, String genero2,
		String resumen2, byte [] imagen2) {
	// TODO Auto-generated constructor stub
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

  public void setFechaEstreno(String date) {
    this.fechaEstreno = date;
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
  
  public String getImagen() {
	return imagen;
  }

  public void setImagen(String imagen) {  
    this.imagen = imagen;
  }

public String ToString() {
        
    String pelicula = null;
        
    pelicula = "Nombre: " + getNombre() + "\n";
    pelicula = pelicula + "Director: " + getDirector() + "\n";
    pelicula = pelicula + "Idioma: " + getIdioma() + "\n";
    pelicula = pelicula + "Genero: " + getGenero() + "\n";
    pelicula = pelicula + "Fecha Estreno: " + getFechaEstreno() + "\n";
        
    return pelicula;
  }
      
    
}

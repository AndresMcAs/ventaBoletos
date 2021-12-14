
package modelo;


/**
 * Class pelicula
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
  
  /**
   * clase pelicula hace referencia a todos los datos referentes 
   * a una pelicula 
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
  
  /**
   * constructor de la clase pelicula
   * @param nombre
   * @param director
   * @param duracion
   * @param idioma
   * @param estreno
   * @param genero
   * @param resumen
   */
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
  
  
  /**
   * constructor principalmente para la caratelara 
   * @param ide identica a la pelicula 
   * @param nombre de la pelicula 
  * @param director  de la pelicula 
   * @param duracion  que tarda la pelicula
   * @param idioma  en qle que se encuentra la peliculas 
   * @param genero al que pertence 
   * @param fechaEstreno en la que se estreno
   * @param resumen de que trata la peliculas 
   * @param imagen relacionada con la pelicula 
   */
  public Pelicula(int ide, String nombre, String director, int duracion,
      String idioma, String genero,
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
  
  /**.
   * 
   * @param ide identificador de la peliculas 
   * @param nombre  de la pelicula
   * @param director  de la pelicula 
   * @param duracion  que tarda la pelicula
   * @param idioma  en qle que se encuentra la peliculas 
   * @param genero al que pertence 
   * @param fechaEstreno en la que se estreno
   * @param resumen de que trata la peliculas 
   */
  public Pelicula(int ide, String nombre, String director, int duracion, 
       String idioma, String genero,
       String fechaEstreno, String resumen) {
    super();
    this.ide = ide;
    this.nombre = nombre;
    this.director = director;
    this.duracion = duracion;
    this.idioma = idioma;
    this.genero = genero;
    this.fechaEstreno = fechaEstreno;
    this.resumen = resumen;
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

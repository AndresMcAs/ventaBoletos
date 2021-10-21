
package baseDatos;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andres mendoza
 */

public class AdminBd {

  private String url;
  private String usuario;
  private String contra;
  private String esquema;
  private String host;
  private String puerto;
  private String baseDatos;

  public AdminBd() {
    esquema = "jdbc:oracle:thin:@";
    host = "127.0.0.1";
    puerto = "1521";
    baseDatos = "XE";
    url = esquema + host + ":" + puerto + ":" + baseDatos;
    usuario = "cine";
    contra = "cine";
  }	

  public Connection Conectar() {
       
    Connection con = null;
    try {
      con = DriverManager.getConnection(url, usuario, contra);
      out.println("conexion establecida");
    } catch (SQLException esql) {
    	
    }
    return con;
  }
  
  /*
   * Metodos get y set de los atributos de la clase AdminBD
   */ 
  
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContra() {
    return contra;
  }

  public void setContra(String contra) {
    this.contra = contra;
  }

  public String getEsquema() {
    return esquema;
  }

  public void setEsquema(String esquema) {
    this.esquema = esquema;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getPuerto() {
    return puerto;
  }

  public void setPuerto(String puerto) {
    this.puerto = puerto;
  }

  public String getBaseDatos() {
    return baseDatos;
  }

  public void setBaseDatos(String baseDatos) {
    this.baseDatos = baseDatos;
  }
    
}
    



package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pelicula;

/**.
 *
 * @author HP
 */
public class PeliculaDaoImp implements PeliculaDao {
    
  private AdminBd admin;
  private Connection conexion;
  private boolean conexionTransferida;
    
  public PeliculaDaoImp() {
    admin = new AdminBd();
    conexion = null;
  }
    
  public PeliculaDaoImp(Connection conexion) {
    this.conexion = conexion;
    conexionTransferida = true;
  }
  
  /**.
     * metodo para visualizar la cartelera del cine  
     * en el cual se mostarran todas las peliculas disponibles 
     */
  
  @Override
  public List<Pelicula> consultar() {
    
    String sql;
    PreparedStatement ps = null;
    ResultSet rs;
    Pelicula pelicula = null;
    List<Pelicula> lista = new ArrayList<>();
        
    sql = "select nombre,director,idioma,genero,estreno from peliculas";
       
    try {
      conexion = admin.conectar();
      ps = conexion.prepareStatement(sql);
      rs = ps.executeQuery();
              
      while (rs.next()) {
        pelicula = new Pelicula();
        pelicula.setNombre(rs.getString("nombre"));
        pelicula.setDirector(rs.getString("director"));
        pelicula.setIdioma(rs.getString("idioma"));
        pelicula.setGenero(rs.getString("genero"));
        pelicula.setFechaEstreno(rs.getString("estreno"));
        lista.add(pelicula);
                  
      }
             
      rs.close();
      ps.close();
      conexion.close();
             
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }

  @Override
  public boolean insertar(Pelicula pelicula) {

    int resultInsert = 0;
    String sql;
    PreparedStatement ps = null;
        
        
    if (conexionTransferida == false) { 
      conexion = admin.conectar();
    }
    try {
      sql = "insert into peliculas (nombre,director,idioma,duracion,genero,estreno,resumen)"  
             + "values(?, ?, ?, ?, ?, ?, ?)";
                
      ps = conexion.prepareStatement(sql);
      ps.setString(1, pelicula.getNombre());
      ps.setString(2, pelicula.getDirector());
      ps.setString(3, pelicula.getIdioma());
      ps.setInt(4, pelicula.getDuracion());
      ps.setString(5, pelicula.getGenero());
      ps.setString(6, pelicula.getFechaEstreno());
      ps.setString(7, pelicula.getResumen());
      resultInsert = ps.executeUpdate();
      
      if (resultInsert != 0) {
      
        JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        conexion.close();
        return true;
      }  else {
        conexion.close();
        return false;
      } 
    } catch (SQLException e) { 
      JOptionPane.showMessageDialog(null, "Error no se inserto la pelicula:" + pelicula.getNombre() 
                                        + "\n" + e.getMessage());
      return false;   
    }
        
  }

  @Override
  public int actualizar(Pelicula pelicula) {
    int result = 0;
    String sql;
    PreparedStatement ps = null;
   
   
    sql = "Update peliculas "
        + "set nombre = ? "
        + "WHERE NOMBRE = ?";
    conexion = admin.conectar();
    try {
      ps = conexion.prepareStatement(sql);
      ps.setString(1, pelicula.getNombre());
      result = ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Se ha actualizado los datos ");
    } catch (SQLException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error no se actualizo la pelicula:" 
              + pelicula.getNombre()  + "\n" + e.getMessage());
    }
   
   
    return result;
  }

  @Override
  public int borrar(Pelicula pelicula) {
    int result = 0;
    String sql;
    PreparedStatement ps = null;
    
    sql = "delete from peliculas"
           + "WHERE NOMBRE = ?";
    conexion = admin.conectar();
    try {
      ps = conexion.prepareStatement(sql);
      ps.setString(1, pelicula.getNombre());
      result = ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Se borrado la pelicula con exito ");
    } catch (SQLException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error no se borro la pelicula:" + pelicula.getNombre() 
          + "\n" + e.getMessage());
    }
    return result;
     
  }

  

}

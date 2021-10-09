
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.Pelicula;

 /**
 *
 * @author andres mendoza 
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
  
    /**
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
      conexion = admin.Conectar();
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
  public void insertar(Pelicula pelicula) {
      
    String sql;
    PreparedStatement ps = null;
        
        
    if (conexionTransferida == false) { 
      conexion = admin.Conectar();
    }
    try {
      sql = "insert into peliculas (id_peli, nombre," 
                                     + " director, idioma, duracion, genero, estreno, + resumen) "
                                     + "values (seq_pelicula.NextVal,?,?,?,?,?,?,?);";
                
      ps = conexion.prepareStatement(sql);
      ps.setInt(1, pelicula.getIde());
      ps.setString(2, pelicula.getNombre());
      ps.setString(3, pelicula.getDirector());
      ps.setString(4, pelicula.getIdioma());
      ps.setInt(5, pelicula.getDuracion());
      ps.setString(6, pelicula.getGenero());
      ps.setString(7, pelicula.getFechaEstreno());
      ps.setString(8, pelicula.getResumen());
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        
    } catch (SQLException e) { 
      JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
    }
    try {
      ps.close();
      if (conexionTransferida == false) {
        conexion.close(); 
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
    }
        
  }

  @Override
  public int actualizar(Pelicula pelicula) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  @Override
  public int borrar(Pelicula pelicula) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

}

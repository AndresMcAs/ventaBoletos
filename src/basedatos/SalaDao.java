package basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Sala;

/**.
 * SalaDao  class que sirve para la gestion de las salas
 *
 */
public class SalaDao {

  private AdminBd admin;
  private Connection conexion;
  private boolean conexionTransferida;
  private Statement stm;

  public SalaDao() {
    admin = new AdminBd();
    conexion = null;
  }
  
  public SalaDao(Connection conexion) {
    this.conexion = conexion;
    conexionTransferida = true;
  }
  
  /**.
   * method que inserta un registro en BD
   * @param sala
   * @return
   */
  public boolean insertarSala(Sala sala) {
    int resultInsert = 0;
    String sql;
    PreparedStatement ps = null;

    if (conexionTransferida == false) { 
      conexion = admin.conectar();
    }
    try {
      sql = "insert into salas (nombre,filas,columnas)"  
            + "values(?, ?, ?)";
      ps = conexion.prepareStatement(sql);
      ps.setString(1, sala.getNombre());
      ps.setInt(2, sala.getFila());
      ps.setInt(3, sala.getColumna());
      resultInsert = ps.executeUpdate();
      if (resultInsert != 0) {
        JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        conexion.close();
        return true;
      } else {
        conexion.close();
        return false;
      } 
    } catch (SQLException e) { 
      JOptionPane.showMessageDialog(null, "Error no se registro la sala :" + sala.getNombre() 
               + "\n" + e.getMessage());
      return false;   
    }
  }
  
  /**.
   * 
   * @param nombre de la sala a buscar
   * @return regresa la sala buscada
   */
  public Sala buscarSala(String nombre) {

    ResultSet salaSet;
    try {
      conexion = admin.conectar();
      stm  = conexion.createStatement();
      Sala salaHallada; 
      salaSet = stm.executeQuery("select * from salas where nombre= '" + nombre.trim() + "'");
      if (!salaSet.next()) {
        JOptionPane.showMessageDialog(null, "Sala no encontrada");
        conexion.close();
        return null;
      } else {

        String nom = salaSet.getString("nombre");
        int filas = salaSet.getInt("filas");
        int columnas = salaSet.getInt("columnas");
        
        salaHallada = new Sala(nom, filas, columnas);
        return salaHallada;
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Error al consultar la BD" + e.getMessage());
      return null;
    }
  }

}

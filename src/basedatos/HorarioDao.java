package basedatos;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Horario;
import modelo.Pelicula;


/**.
 * Class para el almacenamiento de los horarios en la BD
 * @author andres
 *
 */
public class HorarioDao {

	
	  private AdminBd admin;
	  private Connection conexion;
	  private boolean conexionTransferida;
	  private Statement stm;
	  private int sala;

	  public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public HorarioDao() {
	    admin = new AdminBd();
	    conexion = null;
	  }
	  
	  public HorarioDao(Connection conexion) {
	    this.conexion = conexion;
	    conexionTransferida = true;
	  }
	  
	  /**.
	   * method que inserta un registro en BD
	   * @param sala
	   * @return
	   */
	  public boolean insertarHorario(Horario horario, Pelicula pelicula) {
	    
		int resultInsert = 0;
	    String sql;
	    PreparedStatement ps = null;

	    if (conexionTransferida == false) { 
	      conexion = admin.conectar();
	    }
	    try {
	      sql = "insert into horarios (id_pelicula,dia,mes, year, hora, minuto, ide_sala)"  
	            + "values(?, ?, ?, ?, ?, ?, ?)";
	      ps = conexion.prepareStatement(sql);
	      ps.setInt(1, pelicula.getIde());
	      ps.setString(2, horario.getDia());
	      ps.setString(3, horario.getMes());
	      ps.setString(4, horario.getAño());
	      ps.setString(5, horario.getHora());
	      ps.setString(6, horario.getMinuto());
	      ps.setInt(7, horario.getIdSala());
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
	      JOptionPane.showMessageDialog(null, "Error no se registro el horario para la pelicula"
	      	                          	+ " :" + pelicula.getNombre() 
	               + "\n" + e.getMessage());
	      return false;   
	    }
	  }
	  public Pelicula buscarHorarioPelicula(String nombre) {

		    ResultSet horarioSet;
		    Image ImgResp = null;
		    try {
		      conexion = admin.conectar();
		      stm  = conexion.createStatement();
		      horarioSet = stm.executeQuery("select nombre,idioma,director,duracion,genero,resumen,"
		      		                        + "dia,mes,year,hora,minuto,ide_sala"
		      		                        + " from peliculas,horarios where nombre = '" + nombre.trim() + "'"
		    		                        + "and id_peli = id_pelicula" );
		      if (!horarioSet.next()) {
		        JOptionPane.showMessageDialog(null, "Horario no encontrado");
		        conexion.close();
		        return null;
		      } else {
		        
		        String nom = horarioSet.getString("nombre");
		        String director = horarioSet.getString("director");
		        int    duracion = horarioSet.getInt("duracion");
		        String idioma = horarioSet.getString("idioma");
		        String genero = horarioSet.getString("genero");
		        String dia = horarioSet.getString("dia");
		        String resumen = horarioSet.getString("resumen");
		        String mes = horarioSet.getString("mes");
		        String year = horarioSet.getString("year");
		        String hora = horarioSet.getString("hora");
		        String minuto = horarioSet.getString("minuto");
		        sala = horarioSet.getInt("ide_sala");
		        String fecha = "Fecha: " + dia +"/" + mes +"/" + year + "  Hora: " +hora+":"+minuto + "hr";
		        Pelicula peliculaHallada = new Pelicula(nom, director, duracion, idioma, fecha,genero, resumen);
		        return peliculaHallada;
		      }
		    } catch (SQLException e) {
		      JOptionPane.showMessageDialog(null, "Error al consultar la BD" + "\n" + e.getMessage());
		      return null;
		    }
		  }
}

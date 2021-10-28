
package control;

import com.toedter.calendar.JDateChooser;
import basedatos.PeliculaDaoImp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import modelo.Pelicula;

/**
 *
 * @author  andres mendoza 
 */
public class RegistrarPelicula extends JFrame {

  private static final long serialVersionUID = 1L;
    
  // Area de texto para la obtencion de los datos de la pelicula 
  JTextField nombre;
  JTextField director;
  JTextField duracion;
  JTextField genero;
  JTextArea  resumen;
  JTextField idioma;
  JTextField estreno;
  JButton aceptar;
  JButton cancelar;
  int dia = 0;
  int mes = 0;
  int año = 0 ;
  String fecha;
  
  public RegistrarPelicula() {
    super("Registro de Peliculas"); 
    setSize(600, 500); // ancho/largo
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // panel de fecha 
    /* elementos para la fecha de estreno*/
    
    JDateChooser FechaEstreno = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
    
    FechaEstreno.getCalendar();
    FechaEstreno.getDate();
    JPanel panelFecha = new JPanel();
    panelFecha.setLayout(new FlowLayout());
    panelFecha.add(FechaEstreno);    
    /*
     * panel de datos 
     * datos que seran agregados a la BD
     */
    JPanel panelDatos = new JPanel();
    GridLayout gl = new GridLayout();
    gl.setRows(9); // numero de renglones 
    gl.setHgap(0); //separacion entre columnas
    gl.setColumns(1); //numero de columnas
    gl.setVgap(10); //separacion
    panelDatos.setLayout(gl);
    
    panelDatos.add(new JLabel("Nombre:"));
    panelDatos.add(nombre = new JTextField(25));
    panelDatos.add(new JLabel("Director:"));
    panelDatos.add(director = new JTextField(25));
    panelDatos.add(new JLabel("Idioma:"));
    panelDatos.add(idioma = new JTextField(15));
    panelDatos.add(new JLabel("Duracion:"));
    panelDatos.add(duracion = new JTextField(5));
    panelDatos.add(new JLabel("Genero:"));
    panelDatos.add(genero = new JTextField(15));
    panelDatos.add(new JLabel("Estreno:"));
    panelDatos.add(panelFecha);
    panelDatos.add(new JLabel("Resumen:"));
    panelDatos.add(resumen = new JTextArea());
    
    //panel de botones 
    JPanel panelBoton = new JPanel();
    aceptar = new JButton("Aceptar");
    cancelar = new JButton("Cancelar");
    panelBoton.setLayout(new FlowLayout());
    panelBoton.add(aceptar);
    panelBoton.add(cancelar);
    
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(panelDatos, BorderLayout.EAST);
    cp.add(panelBoton, BorderLayout.SOUTH);
    
    //agregar acciones para los botones
    aceptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombre.getText());
        pelicula.setDirector(director.getText());
        pelicula.setIdioma(idioma.getText());
        pelicula.setDuracion(Integer.parseInt(duracion.getText()));
        pelicula.setGenero(genero.getText());
        
        dia = FechaEstreno.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = FechaEstreno.getCalendar().get(Calendar.MONTH) + 1;
        año = FechaEstreno.getCalendar().get(Calendar.YEAR);
        fecha = dia  + "/" + mes + "/" + año ;
       
        pelicula.setFechaEstreno(fecha);
        pelicula.setResumen(resumen.getText());
         PeliculaDaoImp peliculaDAO = new PeliculaDaoImp();
        peliculaDAO.insertar(pelicula);
      }
    });
    cancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          String confirmacion = String.format("¿Deseas Salir?");
          int respuesta = JOptionPane.showConfirmDialog(null, confirmacion,
                            "Registrar Pelicula", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) { 
          dispose(); 
        }
      }
    }); 
    
    
  }

  public static void main(String []args) {
    SwingUtilities.invokeLater(() -> {
      RegistrarPelicula thisClass = new RegistrarPelicula();
      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      thisClass.setVisible(true);
    });
    
  }
  
}

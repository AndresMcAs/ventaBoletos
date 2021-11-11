
package control;

import com.toedter.calendar.JDateChooser;
import basedatos.PeliculaDaoImp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelo.Limpia;
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
  JButton salir;
  JButton selecion;
  JLabel LabelImagen = new JLabel();
  JDateChooser FechaEstreno;
  JPanel panelDatos = new JPanel();
  int dia = 0;
  int mes = 0;
  int año = 0 ;
  String fecha;
  
  public RegistrarPelicula() {
    super("Registro de Peliculas"); 
    setSize(600, 700); // ancho/largo
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // panel de fecha 
    /* elementos para la fecha de estreno*/
    
    FechaEstreno = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
    
    FechaEstreno.getCalendar();
    FechaEstreno.getDate();
    JPanel panelFecha = new JPanel();
    panelFecha.setLayout(new FlowLayout());
    panelFecha.add(FechaEstreno);    
    /*
     * panel de datos 
     * datos que seran agregados a la BD
     */
    GridLayout gl = new GridLayout();
    gl.setRows(16); // numero de renglones 
    gl.setHgap(0); //separacion entre columnas
    //gl.setColumns(1); //numero de columnas
    gl.setVgap(1); //separacion
    panelDatos.setLayout(gl);
    
    resumen = new JTextArea();
    selecion = new JButton("selecionar imagen");
    selecion.setSize(4,2);
    panelDatos.add(new JLabel(" * Campos Obligatorios "));  
    panelDatos.add(new JLabel("Nombre: *"));
    panelDatos.add(nombre = new JTextField(30));
    panelDatos.add(new JLabel("Director: *"));
    panelDatos.add(director = new JTextField(35));
    panelDatos.add(new JLabel("Idioma: *"));
    panelDatos.add(idioma = new JTextField(15));
    panelDatos.add(new JLabel("Duracion: *"));
    panelDatos.add(duracion = new JTextField(5));
    panelDatos.add(new JLabel("Genero: *"));
    panelDatos.add(genero = new JTextField(20));
    panelDatos.add(new JLabel("Estreno: *"));
    panelDatos.add(panelFecha);
    panelDatos.add(new JLabel("Resumen:"));
    panelDatos.add(resumen);
    /*
    JPanel panelImagen = new JPanel();
    panelImagen.setLayout(new FlowLayout(1,1,0));
    panelImagen.add(LabelImagen);
   */
    
    //panel de botones 
    JPanel panelBoton = new JPanel();
    aceptar = new JButton("Aceptar");
    cancelar = new JButton("Cancelar");
    salir = new JButton("Salir");
    panelBoton.setLayout(new FlowLayout(1,20,0));
    //panelBoton.add(selecion);
    panelBoton.add(aceptar);
    panelBoton.add(cancelar);
    panelBoton.add(salir);
    
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(panelDatos, BorderLayout.NORTH);
   // cp.add(panelImagen,BorderLayout.CENTER);
    cp.add(panelBoton, BorderLayout.SOUTH);
    
    //agregar acciones para los botone
   
    /*selecion.addActionListener(new ActionListener() {
    	  @Override
          public void actionPerformed(ActionEvent e) {
    		  
    		  eventoSelecionar(e);
    }
    }); */
    aceptar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	registrar();
      }
    });
    cancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
    	  String confirmacion = String.format("¿Deseas Cancelar el registro?");
          int respuesta = JOptionPane.showConfirmDialog(null, confirmacion,
                            "Registrar Pelicula", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) { 
           Limpia lim = new Limpia();
          lim.limpiarTexto(panelDatos);
        }
    	 
      }
    }); 
    
    salir.addActionListener(new ActionListener() {
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
  
  
  public void eventoSelecionar(java.awt.event.ActionEvent evt) {
	  
	  JFileChooser file = new JFileChooser();
	  file.showOpenDialog(this);
	  File archivo = file.getSelectedFile();
	  
	  if (archivo != null) {
		  
		  String origen = archivo.getPath();
		  ImageIcon imagen = new ImageIcon(origen);
		  this.LabelImagen.setIcon(imagen);
	  }else {
		   JOptionPane.showMessageDialog(null, "selecciona un archivo");
	  }
  }
  
  public boolean validar(String cadena) {
		int m;
		try {
			m=Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
  
  public void registrar() {
	  boolean EsNumero = validar(duracion.getText());
	  
      if ((nombre.getText().length() == 0 
    	  || duracion.getText().length() == 0	  
      	  || director.getText().length() == 0
      	  || idioma.getText().length() == 0 
      	  || genero.getText().length() == 0) 
          || FechaEstreno.getCalendar() == null) {
      	JOptionPane.showMessageDialog(null, "Ingresa los campos obligatorios");
      } else {
      Pelicula pelicula = new Pelicula();
      pelicula.setNombre(nombre.getText());
      pelicula.setDirector(director.getText());
      pelicula.setIdioma(idioma.getText());
      pelicula.setGenero(genero.getText());
      pelicula.setResumen(resumen.getText());
      
      dia = FechaEstreno.getCalendar().get(Calendar.DAY_OF_MONTH);
      mes = FechaEstreno.getCalendar().get(Calendar.MONTH) + 1;
      año = FechaEstreno.getCalendar().get(Calendar.YEAR);
      fecha = dia  + "/" + mes + "/" + año ;

      pelicula.setFechaEstreno(fecha);
       
      if (EsNumero == true) {
    	 
    	  int valido = Integer.parseInt(duracion.getText());
    		if (valido < 0 || valido > 300) {
        		if (valido <0) {
        		  JOptionPane.showMessageDialog(null, "Ingresa un numero entero");
        	    } else {
        			JOptionPane.showMessageDialog(null, "Duracion demasiado extensa"); 
        		}
            } else {
            	pelicula.setDuracion(Integer.parseInt(duracion.getText()));
            	PeliculaDaoImp peliculaDAO = new PeliculaDaoImp();
                peliculaDAO.insertar(pelicula);
                Limpia lim = new Limpia();
                lim.limpiarTexto(panelDatos);
            }
      
      
      }else {
    	 
    	  JOptionPane.showMessageDialog(null, "Solo numeros en el campo duracion");
      } 
    
      }
	  
  }
}

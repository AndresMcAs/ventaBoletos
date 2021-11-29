
package vistas;

import com.toedter.calendar.JDateChooser;
import basedatos.PeliculaDaoImp;
import control.Limpia;
import control.ValidarNumero;
import imagenes.Fondo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Color;

import modelo.Pelicula;

/**
 *
 * @author  andres mendoza 
 */
public class RegistrarPelicula extends JFrame implements ItemListener {

  private static final long serialVersionUID = 1L;
    
  // Datos de la pellicula 
  private JTextField nombre;
  private JTextField director;
  private JTextField duracion;
  private JComboBox<String> genero;
  private JTextArea  resumen;
  private JComboBox<String> idioma;
  JTextField estreno;
  JPanel panelImagen;
  //botones 
  JButton aceptar;
  JButton cancelar;
  JButton salir;
  JButton selecion;
  JLabel LabelImagen = new JLabel();
  JDateChooser FechaEstreno;
  JPanel panelFecha;
  JPanel panelDatos = new JPanel();
  int dia = 0;
  int mes = 0;
  int año = 0 ;
  String fecha;
  String origen;
   Fondo imagen = new Fondo("cine.jpg");
  // inicio 
  
  
  public RegistrarPelicula() {
    super("Registro de Peliculas"); 
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(new Dimension(700, 700));        
    this.setLocationRelativeTo(null);
    Color color = new Color(255, 248, 231);
    this.getContentPane().setBackground(color);
    
    // panel de fecha 
    /* elementos para la fecha de estreno*/
    
    FechaEstreno = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
    
    FechaEstreno.getCalendar();
    FechaEstreno.getDate();
    panelFecha = new JPanel();
    panelFecha.setLayout(new FlowLayout());
    panelFecha.add(FechaEstreno);    
    /*
     * panel de datos 
     * datos que seran agregados a la BD
     */
    GridLayout gl = new GridLayout();
    gl.setRows(16); // numero de renglones 
    gl.setHgap(0); //separacion entre columnas
    gl.setColumns(2); //numero de columnas
    gl.setVgap(1); //separacion
    panelDatos.setLayout(gl);
    // comboBox para los generos del las películas  
    
    genero=new JComboBox<String>();
    genero.setBounds(10,10,80,20);
    genero.setBackground(Color.WHITE);
    genero.addItem(null);
    genero.addItem("Terror");
    genero.addItem("Acción");
    genero.addItem("Comedia");
    genero.addItem("Ciencia Ficcion");
    genero.addItem("Anime");
    genero.addItem("Otro");
   
    // Combobox para el idoma de las peliculas 
    idioma = new JComboBox<String>();
    idioma.setBackground(Color.WHITE);
    idioma.setBounds(10,10,80,20);
    idioma.addItem(null);
    idioma.addItem("Español");
    idioma.addItem("Ingles");
    idioma.addItem("Frances");
    
    resumen = new JTextArea();
    selecion = new JButton("Selecionar imagen");
    selecion.setSize(4,2);
    panelDatos.add(imagen);
    panelDatos.add(new JLabel(" * Campos Obligatorios "));  
    panelDatos.add(new JLabel("Nombre: *"));
    panelDatos.add(nombre = new JTextField(30));
    panelDatos.add(new JLabel("Director: *"));
    panelDatos.add(director = new JTextField(35));
    panelDatos.add(new JLabel("Idioma: *"));
    panelDatos.add(idioma );
    panelDatos.add(new JLabel("Duracion: *"));
    panelDatos.add(duracion = new JTextField(5));
    panelDatos.add(new JLabel("Genero: *"));
    panelDatos.add(genero);
    panelDatos.add(new JLabel("Estreno: *"));
    panelDatos.add(panelFecha);
    panelDatos.add(new JLabel("Resumen:"));
    panelDatos.add(resumen);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(0);
    setLayout(null);
    panelDatos.setBounds(100, 100, 200, 50);
    panelDatos.setBackground(color);
    add(panelDatos);
    
    panelImagen = new JPanel();
    panelImagen.setLayout(new FlowLayout(1,1,0));
    panelImagen.setBackground(Color.WHITE);
    panelImagen.add(LabelImagen);
    
    //panel de botones 
    JPanel panelBoton = new JPanel();
    aceptar = new JButton("Aceptar");
    cancelar = new JButton("Cancelar");
    salir = new JButton("Salir");
    panelBoton.setLayout(new FlowLayout(1,20,0));
    panelBoton.add(selecion);
    panelBoton.add(aceptar);
    panelBoton.add(cancelar);
    panelBoton.add(salir);
    panelBoton.setBackground(color);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    
    cp.add(panelDatos, BorderLayout.NORTH);
    cp.add(panelImagen,BorderLayout.EAST);
    cp.add(panelBoton, BorderLayout.SOUTH);
    
   
    selecion.addActionListener(new ActionListener() {
    	  @Override
          public void actionPerformed(ActionEvent e) {
    		  try {
    
    			  eventoSelecionar(e);
    		  } catch (Exception ex ) {}
    }
    }); 
    
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
          lim.limpiarTexto(panelFecha);
          lim.limpiarTexto(panelImagen);
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
		  
		  origen = archivo.getPath();
		  ImageIcon imagen = new ImageIcon(origen);
		  Image escala = imagen.getImage().getScaledInstance(200,
	             200, Image.SCALE_SMOOTH);
		  Icon icono = new ImageIcon(escala);
		  LabelImagen.setIcon(icono);
		  
		  
	  }else {
		   JOptionPane.showMessageDialog(null, "selecciona un archivo");
	  }
  }
  
  ValidarNumero validar = new ValidarNumero();
  
  public void registrar() {
	  boolean EsNumero = validar.validar(duracion.getText());
	  
      if ((nombre.getText().length() == 0 
    	  || duracion.getText().length() == 0	  
      	  || director.getText().length() == 0
      	  || idioma.getSelectedItem() == null 
      	  || genero.getSelectedItem() == null 
      	  ) 
          || FechaEstreno.getCalendar() == null) {
      	JOptionPane.showMessageDialog(null, "Ingresa los campos obligatorios");
      } else {
      Pelicula pelicula = new Pelicula();
      pelicula.setNombre(nombre.getText());
      pelicula.setDirector(director.getText());
      String selectIdioma = (String)idioma.getSelectedItem();
      pelicula.setIdioma(selectIdioma);
      String seleccionado=(String)genero.getSelectedItem();
      pelicula.setGenero(seleccionado);
      pelicula.setResumen(resumen.getText());
      pelicula.setImagen(origen);
      
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
                lim.limpiarTexto(panelFecha);
                lim.limpiarTexto(panelImagen);
            }
      
      
      }else {
    	 
    	  JOptionPane.showMessageDialog(null, "Solo numeros en el campo duracion");
      } 
    
      }
	  
  }
  
  public void itemStateChanged(ItemEvent e) {
      if (e.getSource() == genero) {
          String seleccionado=(String)genero.getSelectedItem();
          setTitle(seleccionado);
      }
  }
  
}


package control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import basedatos.SalaDao;
import javax.swing.SwingUtilities;
import modelo.Limpia;
import modelo.Sala;

/**.
 *
 * @author andres mendoza 
 */
public class RegistrarSala extends JFrame {
  private static final long serialVersionUID = 1L;  
  private Sala sala;
  JTextField nombre;
  JTextField fila;
  JTextField columna;  
  JButton registrar;
  JButton cancelar;
  JButton salir;
  JPanel panelDatos = new JPanel();
  
  /**. 
   * method Para que se muestre la ventana RegistrarSala
   */
  public static void main(String []args) {
    SwingUtilities.invokeLater(new Runnable() {  
      @Override
  public void run() {
        RegistrarSala thisClass = new RegistrarSala();
          thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          thisClass.setVisible(true);
        }
      });
  }
  
  /**.
   *  Constructor RegistrarSala 
   */
  public RegistrarSala() {
    super("Registrar Sala ");
    setSize(450, 500); // ancho/largo
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    GridLayout gl = new GridLayout();
    gl.setRows(9); // numero de renglones 
    gl.setHgap(0); //separacion entre columnas
    gl.setColumns(1); //numero de columnas
    gl.setVgap(10); //separacion
    panelDatos.setLayout(gl);
    
    panelDatos.add(new JLabel("Nombre de la sala: *"));
    panelDatos.add(nombre = new JTextField(25));
    panelDatos.add(new JLabel("Filas: *"));
    panelDatos.add(fila = new JTextField(2));
    panelDatos.add(new JLabel("Columnas: *"));
    panelDatos.add(columna = new JTextField(2));
    
    JPanel panelBoton = new JPanel();
    registrar = new JButton("Registrar");
    cancelar = new JButton("Cancelar");
    salir = new JButton("Salir");
    panelBoton.setLayout(new FlowLayout());
    panelBoton.add(registrar);
    panelBoton.add(cancelar);
    panelBoton.add(salir);
    
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(panelDatos, BorderLayout.NORTH);
    cp.add(panelBoton, BorderLayout.SOUTH);
    
    registrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          construirSala();
          // lanzar el panelAsientos con la dimension de la sala y el nombre
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
    
    cancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Limpia lim = new Limpia();
          lim.limpiarTexto(panelDatos);
        }
      });
    
  }
  
  /**.
   *  metodo para registrar la sala 
   */
  public void construirSala() {
      
    boolean esNumero;
    boolean esNumero2;
    esNumero = validar(fila.getText());
    esNumero2 = validar(columna.getText()); 
    sala = new Sala();
    System.out.println("nomre" + nombre.getText());
    
    if (nombre.getText().length() == 0
    	|| fila.getText().length() == 0
    	|| columna.getText().length() == 0) {
      JOptionPane.showMessageDialog(null, "Ingresa los campos obligatorios");
    }
    if (esNumero == false || esNumero2 == false) {
      JOptionPane.showMessageDialog(null, "Se permiten solo numeros");
    } else {
      int filas = Integer.parseInt(fila.getText());
      int columnas = Integer.parseInt(columna.getText());
      if (filas <= 0 || columnas <= 0) {
        JOptionPane.showMessageDialog(null, "Solo valores positivos");
      }
      if (filas >= 10 && columnas >= 10) {
        JOptionPane.showMessageDialog(null, "Favor de no exeder al valor 9");
      }
      sala.setNombre(nombre.getText());
      sala.setFila(filas);
      sala.setColumna(columnas);
         
      SalaDao  salaDao = new SalaDao();
      salaDao.insertarSala(sala);
         
      Limpia limpia = new Limpia();
      limpia.limpiarTexto(panelDatos);
    }
      
  }
   
  /**.
   * metodo que valida si se trata de un numero o no
   * 
   */
  public boolean validar(String cadena) {
    int m;
    try {
      m = Integer.parseInt(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

    
}

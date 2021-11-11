
package control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import basedatos.PeliculaDaoImp;
import modelo.Limpia;
import modelo.ListaModelo;
import modelo.Pelicula;
/**.
 *
 * @author AMC
 * 
 */

public class Cartelera extends JFrame  {
    
  private static final long serialVersionUID = 1L;
  
  JTextField nombre;
  JTextField horario;
  JButton buscar;
  JButton cancelar;
  JButton agregar;
  
  List<Pelicula> lista = new ArrayList<>();
  ListaModelo listModel = new ListaModelo();
  PeliculaDaoImp pelicula = new PeliculaDaoImp();
  JList list = new JList();
  
  Container cp = getContentPane();
 

  
  public Cartelera() {
    super("Cartelera");
    inicializa();
  }
  
  /**.
   * 
   */
  public final void inicializa() {

    setSize(650, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    /*Panel para el jLabel y Textfield*/
    GridLayout gl = new GridLayout();
    gl.setRows(5); // numero de renglones 
    gl.setHgap(1); //separacion entre columnas
    gl.setColumns(1); //numero de columnas
    gl.setVgap(1); //separacion
    JPanel panelBuscar = new JPanel();
    panelBuscar.setLayout(gl);
    panelBuscar.add(new JLabel("Nombre de la película"));
    panelBuscar.add(nombre = new JTextField(25));
    panelBuscar.add(new JLabel("horario"));
    panelBuscar.add(horario = new JTextField(25));
    
    /*Panel para los botones*/
    JPanel panelBoton = new JPanel();
    buscar = new JButton("Buscar");
    cancelar = new JButton("Cancelar");
    agregar = new JButton("Agregar");
    panelBoton.setLayout(new FlowLayout(2, 3, 0));
    panelBoton.add(buscar);
    panelBoton.add(cancelar);
    panelBoton.add(agregar);
    
    /*panel para la JList*/
    JPanel panelPeliculas = new JPanel();
    list.setModel(listModel);
    mostrarLista();
    panelPeliculas.add(list);

    /* contenedor de los paneles */
    
    cp.setLayout(new FlowLayout());
    cp.add(panelPeliculas, BorderLayout.NORTH);
    cp.add(panelBuscar, BorderLayout.SOUTH);
    cp.add(panelBoton, BorderLayout.WEST);
      
    
    buscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          
          Pelicula pelicula = new Pelicula();
          Pelicula peliculaHallada = new Pelicula();
          pelicula.setNombre(nombre.getText());
         
          PeliculaDaoImp peliculaDao = new PeliculaDaoImp();
          peliculaHallada =  peliculaDao.buscarPelicula(pelicula.getNombre());
        }
      });
      
    cancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Limpia lim = new Limpia();
        lim.limpiarTexto(panelBuscar);
        }
      }); 
    
    list.addListSelectionListener((new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent evt) {
          if (!evt.getValueIsAdjusting()) { 
            eventoLista();
          }
        }
    }));
    
  }
  
  /**.
   *   mostrar la ventana cartelera
   */
  public static void main(String []args) {
    SwingUtilities.invokeLater(() -> {
      Cartelera thisClass = new Cartelera();
      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      thisClass.setVisible(true);
    });
  }
  
  /**.
   * metodo que crea la lista de la peliculas disponibles 
   */
  public void mostrarLista() {
    lista = pelicula.consultar();
    for (Pelicula pe : lista) {
      listModel.agregar(pe);

    }
  }
  
 
  private void eventoLista() {

    nombre.setText(list.getSelectedValue().toString()); 
    
    
    String pe = (String) list.getSelectedValue();
    PeliculaDaoImp dao =  new PeliculaDaoImp();
    Pelicula peli = new Pelicula();
    peli = dao.buscarPelicula(pe);
    
    JOptionPane.showMessageDialog(null, ""  + "Pelicula: " + peli.getNombre() + "\n"
                                            + "Duracion: " + peli.getDuracion() + " min \n"
                                            + "Genero: " + peli.getGenero()  + "\n"
                                            + "Estreno: " + peli.getFechaEstreno());
    /*
    JPanel panelInfo = new JPanel();
    Limpia lim = new Limpia();
    lim.limpiarTexto(panelInfo);
    panelInfo.setLayout(new GridLayout(1, 1));
    panelInfo.add(new JLabel("Nombre: " + objPelicula.getNombre()));
    panelInfo.add(new JLabel("Director: " + objPelicula.getDirector()));
    panelInfo.add(new JLabel("Duracion: " + objPelicula.getDuracion()));
   
    cp.add(panelInfo, BorderLayout.SOUTH);*/
    
  }
}

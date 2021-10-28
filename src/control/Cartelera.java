
package control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import basedatos.PeliculaDaoImp;
import modelo.Pelicula;
/**
 *
 * @author HP
 */

public class Cartelera extends JFrame  {
    
  private static final long serialVersionUID = 1L;

  JTextField nombre;
  JTextArea peliculas;
  JButton buscar;
  JButton cancelar;
  List<Pelicula> lista = new ArrayList<>();
  JPanel panelPeliculas = new JPanel();
  
  public Cartelera() {
    super("Cartelera ");
    inicializa();
  }

  public final void inicializa(){

    

    setSize(650, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    GridLayout glr = new GridLayout(3, 3, 2, 2);
    glr.setRows(3);
    glr.setHgap(1);
    glr.setVgap(10);
    glr.setColumns(2);
    // botones de buscar 
    JPanel panelBuscar = new JPanel();
    panelBuscar.setLayout(glr);
    panelBuscar.add(nombre = new JTextField(25));
    JPanel panelBoton = new JPanel();
    panelBoton.setLayout(glr);
    buscar = new JButton("Buscar");
    cancelar = new JButton("Cancelar");
    panelBoton.setLayout(new FlowLayout());
    panelBoton.add(buscar);
    panelBoton.add(cancelar);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(panelBuscar, BorderLayout.EAST);
    cp.add(panelBoton, BorderLayout.SOUTH);

    // textArea 
    // jlist 
    PeliculaDaoImp pelicula = new PeliculaDaoImp();
    lista = pelicula.consultar();
    // implemenatralo para unJList
    panelPeliculas.add(peliculas = new JTextArea());
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i).getNombre());
      System.out.println(lista.get(i).getDirector());
      System.out.println(lista.get(i).getGenero());
    }
  }
    
  public static void main(String []args) {
    SwingUtilities.invokeLater(() -> {
      Cartelera thisClass = new Cartelera();
      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      thisClass.setVisible(true);
    });
  }
}

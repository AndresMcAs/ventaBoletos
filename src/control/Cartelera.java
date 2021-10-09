
package control;

import baseDatos.PeliculaDaoImp;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import modelo.Pelicula;

/**
 *
 * @author HP
 */
public class Cartelera extends JFrame  {
    
  private static final long serialVersionUID = 1L;
    
  JTextArea  peliculas;
    
  public Cartelera () {
    
    super("Cartelera ");
    inicializa();
     
  }
    
  public final void inicializa() {
      
    setSize(650, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
   
    GridLayout glr = new GridLayout(3, 3, 2, 2);
    glr.setRows(3);
    glr.setHgap(1);
    glr.setVgap(10);
    glr.setColumns(2); 
    
    JPanel panelPeliculas = new JPanel();
    panelPeliculas.setLayout(glr);
    
    List<Pelicula> lista = new ArrayList<>();
     
    PeliculaDaoImp pelicula = new PeliculaDaoImp();
    lista = pelicula.consultar();
      
    panelPeliculas.add(peliculas = new JTextArea());
    for (int i = 0; i < lista.size(); i++) {
      System.out.println(lista.get(i).getNombre());
    }
  }
    
  public static void main (String []args) {
    SwingUtilities.invokeLater(() -> {
      Cartelera thisClass = new Cartelera();
      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      thisClass.setVisible(true);
    });
  }
}

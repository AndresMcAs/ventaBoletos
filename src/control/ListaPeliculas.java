package control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import basedatos.PeliculaDaoImp;
import modelo.ListaModelo;
import modelo.Pelicula;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;

public class ListaPeliculas extends JFrame {
    private JTextField nombre;
	private JPanel contentPane;
	List<Pelicula> lista = new ArrayList<>();
	  ListaModelo list_model = new ListaModelo();
	  PeliculaDaoImp pelicula = new PeliculaDaoImp();
	  JList list = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPeliculas frame = new ListaPeliculas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaPeliculas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	   
		
		 list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		  
	    list.setModel(list_model);
	    mostrarLista();
		JPanel panelLista = new JPanel();
		panelLista.add(list, BorderLayout.WEST);
		
		GridLayout glr = new GridLayout(3, 3);
		JPanel panelBuscar = new JPanel();
	    panelBuscar.setLayout(glr);
	    
	    panelBuscar.add(new JLabel("ingresa el nombre de la pelicula :"));
	    nombre = new JTextField(25);
	    panelBuscar.add(nombre,BorderLayout.NORTH);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
		btnBuscar.setPreferredSize(new Dimension(1, 1));
		panelBuscar.add(btnBuscar,BorderLayout.SOUTH);
		contentPane.add(panelBuscar,BorderLayout.WEST);
		contentPane.add(panelLista,BorderLayout.EAST);
	}

	  /**
	   * metodo que crea la lista de la peliculas disponibles 
	   */
	  public void mostrarLista() {
		  lista = pelicula.consultar();
		    
		     for ( Pelicula pe : lista) {
		    	list_model.agregar(pe);
		    	 
		     }
	  }

	  @SuppressWarnings("unused")
	private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
		    // TODO add your handling code here:
		 int index= list.getSelectedIndex();
		 Pelicula objPelicula=(Pelicula)list_model.getElementAt(index);
		 
		 JLabel nombre = null;
		 JLabel director = null;
		 JLabel duracion = null;
		 JLabel idioma = null;
		 JLabel genero = null;
		 JLabel resumen = null;
		 
		 nombre.setText("Nombre: "+objPelicula.getNombre());
		 director.setText("Director: "+objPelicula.getDirector());
		 duracion.setText("Duracion: "+objPelicula.getDuracion());
		 idioma.setText("Idioma: "+objPelicula.getIdioma());
		 genero.setText("Genero: "+objPelicula.getGenero());
		 resumen.setText("Resumen: "+objPelicula.getResumen());
		 
		}
	
}

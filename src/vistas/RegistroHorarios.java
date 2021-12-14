
package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import basedatos.HorarioDao;
import basedatos.PeliculaDaoImp;
import control.Limpia;
import control.ListaModelo;
import modelo.Horario;
import modelo.Pelicula;
import control.ValidarNumero;

/**.
 *
 * @author AMC
 * 
 */

public class RegistroHorarios extends JFrame implements ItemListener {
    
  private static final long serialVersionUID = 1L;
  
  JDateChooser fechaP;
  int dia = 0;
  int mes = 0;
  int año = 0 ;
  int min = 0;
  int hor = 0;
  String fecha;   
  
  private JButton aceptar;
  private JButton limpiar;
  private JButton salir;
  private JLabel horarioLabel;
  private JTextArea info;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JPanel jPanel1;
  private JScrollPane scrollPane;
  private JSeparator separator;
  private JLabel nombreP;
  private JTextField nombrePelicula;
  private JTextField hora;
  private JTextField minutos;
  private JComboBox<String> salas;
  private JPanel panelBoton;
  private JPanel panelBusqueda;
  private JPanel panelDatos;
  private JPanel panelLista;
  private JLabel jLabelhora;
  private JLabel jLabelminuto;
  private JLabel jLabelSala;
  private String pe;
  
  
  List<Pelicula> lista = new ArrayList<>();
  ListaModelo listModel = new ListaModelo();
  PeliculaDaoImp peliculadao = new PeliculaDaoImp(); 
  Pelicula peli = new Pelicula();
  
  JList list = new JList();
   
  public RegistroHorarios() {
	
    super("Asignacion de Horarios");
    inicializa();
  }
  
  /**.
   * 
   */
  public final void inicializa() {

    setSize(650, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    list.setModel(listModel);
    mostrarLista();
    
    panelLista = new JPanel();
    scrollPane = new JScrollPane();
    panelBusqueda = new JPanel();
    info = new JTextArea();
    jLabel3 = new JLabel();
    jLabel2 = new JLabel();
    jPanel1 = new JPanel();
    jLabel1 = new JLabel();
    separator = new JSeparator();
    panelDatos = new JPanel();
    nombrePelicula = new JTextField();
    hora = new JTextField();
    minutos = new JTextField();
    nombreP = new JLabel();
    horarioLabel = new JLabel();
    jLabelSala = new JLabel();
    jLabelhora = new JLabel();
    jLabelminuto = new JLabel();
    panelBoton = new JPanel();
    aceptar = new JButton();
    limpiar = new JButton();
    salir = new JButton("Salir");
    salas = new JComboBox<String>();
    salas.setBackground(Color.WHITE);
    salas.setBounds(10,10,80,20);
    salas.addItem(null);
    salas.addItem("1");
    salas.addItem("2");
    salas.addItem("3");
    salas.addItem("4");
    
    fechaP = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
    
    fechaP.getCalendar();
    fechaP.getDate();
     
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    list.setBackground(new java.awt.Color(231, 227, 227));
    scrollPane.setViewportView(list);

    jLabel3.setText("Info Pelicula ");

    javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
    panelBusqueda.setLayout(panelBusquedaLayout);
    panelBusquedaLayout.setHorizontalGroup(
        panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addContainerGap())
    );
    panelBusquedaLayout.setVerticalGroup(
        panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBusquedaLayout.createSequentialGroup()
            .addComponent(jLabel3)
            .addGap(8, 8, 8)
            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );

    jLabel2.setText("Peliculas Disponibles");

    javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
    panelLista.setLayout(panelListaLayout);
    panelListaLayout.setHorizontalGroup(
        panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListaLayout.createSequentialGroup()
            .addGroup(panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 
                		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelListaLayout.createSequentialGroup()
                    .addGroup(panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane , javax.swing.GroupLayout.PREFERRED_SIZE, 153, 
                        		javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGap(17, 17, 17)))
            .addContainerGap(39, Short.MAX_VALUE))
    );
    panelListaLayout.setVerticalGroup(
        panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelListaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 254, 
            		javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(35, Short.MAX_VALUE))
    );

    jLabel1.setFont(new java.awt.Font("Century", 1, 48)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 102, 255));
    jLabel1.setText("Horarios");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(143, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 528,
                    		javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(149, 149, 149))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(24, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addGap(2, 2, 2)
            .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, 
            		javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    nombreP.setText("Pelicula: *");

    horarioLabel.setText("Fecha: *");

    jLabelhora.setText("Hora: *");

    jLabelminuto.setText("Minuto: *");

    javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
    panelDatos.setLayout(panelDatosLayout);
    panelDatosLayout.setHorizontalGroup(
        panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelDatosLayout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreP)
                    .addComponent(horarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, 
                    		javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(fechaP   ))
                .addGroup(panelDatosLayout.createSequentialGroup()
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, 
                        		javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelhora))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelminuto)
                        .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, 
                        		javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(27, Short.MAX_VALUE))
    );
    panelDatosLayout.setVerticalGroup(
        panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelDatosLayout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(nombreP)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(nombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, 
            		javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(horarioLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelhora)
                .addComponent(jLabelminuto))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE,
                		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minutos, javax.swing.GroupLayout.PREFERRED_SIZE, 
                		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    aceptar.setText("Aceptar");

    limpiar.setText("Limpiar");

    javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
    panelBoton.setLayout(panelBotonLayout);
    panelBotonLayout.setHorizontalGroup(
        panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(aceptar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(limpiar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(salir)
            .addGap(6, 6, 6))
    );
    panelBotonLayout.setVerticalGroup(
        panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonLayout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(aceptar)
                .addComponent(limpiar)
                .addComponent(salir))
            .addContainerGap(39, Short.MAX_VALUE))
    );

    jLabelSala.setText("Sala: *");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(93, 93, 93)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(162, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(216, 216, 216))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 
                            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelSala)
                                .addComponent(salas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, 
                                		javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 
            		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(150, 150, 150))
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelSala)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(salas, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))))
    );


    pack();
    
    
    /* eventos de los botones */
    salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String confirmacion = String.format("¿Deseas Salir?");
            int respuesta = JOptionPane.showConfirmDialog(null, confirmacion,
                              "Registrar Horario", JOptionPane.YES_NO_OPTION);
          if (respuesta == JOptionPane.YES_OPTION) { 
            dispose(); 
          }
        }
      });
    
    limpiar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Limpia lim = new Limpia();
          lim.limpiarTexto(panelDatos);
          lim.limpiarTexto(panelBusqueda);
        }
      });
    
    aceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    	
    	registrarHorario();
        
        }
      });
    
    
    /* evento de la lista al seleccionar un elemento */
    list.addListSelectionListener((new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent evt) {
          if (!evt.getValueIsAdjusting()) { 
            eventoLista();
          }
        }
    }));
  }
  
  /**.
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            new RegistroHorarios().setVisible(true);
          }
      });
  }

  
  
  /**.
   * metodo que crea la lista de la peliculas disponibles 
   */
  public void mostrarLista() {
    lista = peliculadao.consultar();
    for (Pelicula pe : lista) {
      listModel.agregar(pe);

    }
  }
  
 
  private void eventoLista() {
	  pe = (String) list.getSelectedValue();
	  peli = peliculadao.buscarPelicula(pe);
	//llena el JText con el nombre de la pelicula
    nombrePelicula.setText(peli.getNombre()); 
    // muestra  info en JTextArea:info pelicula
    info.setText("Nombre: " + peli.getNombre() + "\n"
                 + "Duración: " + peli.getDuracion() + " min" + "\n"
                 + "Fecha Estreno: " + peli.getFechaEstreno()
    );

  }
  
  public void registrarHorario() {
	  
	  if ((hora.getText().length() == 0 
	    	  || minutos.getText().length() == 0	  
	      	  || nombrePelicula.getText().length() == 0
	      	  || salas.getSelectedItem() == null 
	      	  ) 
	          || fechaP.getCalendar() == null) {
	      	JOptionPane.showMessageDialog(null, "Ingresa los campos obligatorios *");
	  } else {
		  
	  ValidarNumero validar = new ValidarNumero();	
	  boolean EsNumero = validar.validar(hora.getText());
	  boolean esnumero = validar.validar(minutos.getText());
	  dia = fechaP.getCalendar().get(Calendar.DAY_OF_MONTH);
      mes = fechaP.getCalendar().get(Calendar.MONTH) + 1;
      año = fechaP.getCalendar().get(Calendar.YEAR);
      
      String selectSala=(String)salas.getSelectedItem();
      Pelicula pelihorario = new Pelicula();
      pelihorario = peliculadao.buscarPeliculaHorario(pe);
      int numeroSala = Integer.parseInt(selectSala);
      
      if (EsNumero == true || esnumero == true) {
    	  
      String diah =  String.valueOf(dia);
      String mesh = String.valueOf(mes);
      String year = String.valueOf(año);
      Horario hor = new Horario();
    
      hor.setIdPelicula(pelihorario.getIde());
      hor.setDia(diah);
      hor.setMes(mesh);
      hor.setAño(year);
      hor.setHora(hora.getText());
      hor.setMinuto(minutos.getText());
      hor.setIdSala(numeroSala);
      HorarioDao horariodao = new HorarioDao();
      horariodao.insertarHorario(hor, pelihorario);
      } else {
    	  JOptionPane.showMessageDialog(null, "Solo numeros en el campo hora o minuto");
      } 
	 } 
  }
  
  public void itemStateChanged(ItemEvent e) {
      if (e.getSource() == salas) {
          String seleccionado=(String)salas.getSelectedItem();
          setTitle(seleccionado);
      }
  }
  
 
}

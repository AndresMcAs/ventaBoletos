package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.ScrollPane;
import basedatos.HorarioDao;
import basedatos.PeliculaDaoImp;
import control.Limpia;
import control.ListaModelo;
import modelo.Pelicula;

/**.VentanaCartelera muestra las peliculas registradas 
* 
* @author  andres mendoza 
*/
public class VentanaCartelera extends JFrame {

  /**.
  * 
  */
  private static final long serialVersionUID = 1L;
  private JButton buscar;
  private JLabel duracion;
  private JLabel genero;
  private JLabel horario;
  private JLabel idioma;
  private JLabel imagenPelicula;
  private JLabel jLabel2;
  private JLabel nombreSala;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JScrollPane jScrollPane1;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JTextField nombre;
  private JPanel panelTitulo;
  private JLabel pelicula;
  private JLabel resumen;
  private JButton salir;
  private ScrollPane scrollPane1;
  private JLabel titulo;
  List<Pelicula> lista = new ArrayList<>();
  ListaModelo listModel = new ListaModelo();
  PeliculaDaoImp peliculadao = new PeliculaDaoImp();
  JList list = new JList();
	
  public VentanaCartelera() {
    super("Cartelera");
    inicializa();
  }
  
  /**.
   * inicializa la ventana cartelera
   */
  public final void inicializa() {
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();

    list.setModel(listModel);
    mostrarLista();
	
    scrollPane1 = new java.awt.ScrollPane();
    panelTitulo = new javax.swing.JPanel();
    titulo = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    nombre = new javax.swing.JTextField();
    buscar = new javax.swing.JButton();
    salir = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    imagenPelicula = new javax.swing.JLabel();
    pelicula = new javax.swing.JLabel();
    genero = new javax.swing.JLabel();
    idioma = new javax.swing.JLabel();
    duracion = new javax.swing.JLabel();
    nombreSala = new javax.swing.JLabel();
    horario = new javax.swing.JLabel();
    resumen = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jScrollPane1.setViewportView(list);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
                             javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                               15, Short.MAX_VALUE)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 
                              21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
    );
    
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
               .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 
                      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    
    titulo.setFont(new java.awt.Font("Century", 1, 48)); // NOI18N
    titulo.setForeground(new java.awt.Color(51, 102, 255));
    titulo.setText("Cartelera");

    javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
    panelTitulo.setLayout(panelTituloLayout);
    panelTituloLayout.setHorizontalGroup(
        panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, 
                  panelTituloLayout.createSequentialGroup()
                  .addContainerGap(77, Short.MAX_VALUE)
                  .addComponent(titulo)
                    .addGap(58, 58, 58))
    );
  
    panelTituloLayout.setVerticalGroup(
        panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                  panelTituloLayout.createSequentialGroup()
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(titulo)
                  .addGap(21, 21, 21))
    );

    buscar.setText("Buscar");
    salir.setText("Salir");
    imagenPelicula.setForeground(new java.awt.Color(255, 255, 255));
    pelicula.setText("Pelicula: ");
    genero.setText("Genero:");
    idioma.setText("Idioma:");
    duracion.setText("Duración:");
    horario.setText("Horario:");
    resumen.setText("Resumen:");
    nombreSala.setText("Sala:");
    
    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
          .addGap(23, 23, 23)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(pelicula)
            .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(jPanel2Layout.createSequentialGroup()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
               .addComponent(resumen)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  )
               .addComponent(nombreSala)
               .addComponent(genero)
               .addComponent(idioma)
               .addComponent(duracion)
               .addComponent(horario))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                               264, Short.MAX_VALUE)
              .addComponent(imagenPelicula, javax.swing.GroupLayout.PREFERRED_SIZE,
                            201, javax.swing.GroupLayout.PREFERRED_SIZE))))
    );
    
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
             .addComponent(imagenPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 
                           194, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(0, 0, Short.MAX_VALUE))
             .addGroup(jPanel2Layout.createSequentialGroup()
               .addGap(60, 60, 60)
               .addComponent(pelicula)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(genero)
               .addGap(18, 18, 18)
               .addComponent(idioma)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(duracion)
               .addGap(18, 18, 18)
               .addComponent(horario)
               .addGap(17, 17, 17)
               .addComponent(resumen)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(nombreSala)
               .addContainerGap(68, Short.MAX_VALUE))
    );

    jLabel2.setText("Todas las Películas ");
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
           .addGap(0, 0, Short.MAX_VALUE)
           .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, 
                         javax.swing.GroupLayout.PREFERRED_SIZE)
           .addGap(139, 139, 139))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addGap(288, 288, 288)
               .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
               javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
              .addGap(21, 21, 21)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel2)
              .addGap(3, 3, 3)
             .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                           javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 
                       javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
               .addGap(222, 222, 222)
               .addComponent(buscar)
               .addGap(52, 52, 52)
               .addComponent(salir))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addGap(47, 47, 47)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
               .addGap(188, 188, 188)
               .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 277, 
                             javax.swing.GroupLayout.PREFERRED_SIZE)))))))
               .addContainerGap(61, Short.MAX_VALUE))
    );

    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(4, 4, 4)
        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, 
                      javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14,
                      javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        .addComponent(jLabel2))
        .addGroup(layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 
                     javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 
                     javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 
                     javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(30, 30, 30)
        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 
                     javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(salir)
          .addComponent(buscar))))
          .addGap(53, 53, 53))
    );

    pack();

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

    buscar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (nombre.getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "Ingresa un nombre " + "\n"
                                        + "para buscar la pelicula");
        } else {
          try {
            String pe = nombre.getText();
            PeliculaDaoImp dao =  new PeliculaDaoImp();
            Pelicula peli = new Pelicula();
            peli = dao.buscarPelicula(pe);
            Pelicula horariorPelicula = new Pelicula(); 
            HorarioDao horarioDao = new HorarioDao();
            horariorPelicula = horarioDao.buscarHorarioPelicula(pe);
            pelicula.setText("Pelicula: " + peli.getNombre());
              genero.setText("Genero: " + peli.getGenero());  
              idioma.setText("Idioma: " + peli.getIdioma());
              duracion.setText("Duración: " + peli.getDuracion());
              horario.setText(" Horario: " + horariorPelicula.getFechaEstreno());
              nombreSala.setText("sala: " + horarioDao.getSala());
              if (peli.getResumen() == null) {
              resumen.setText("Resumen:"); 
              } else {
                resumen.setText("Resumen: " + peli.getResumen());
              }
            } catch (Exception ex) {
            Limpia limpia = new Limpia();
            limpia.limpiarTexto(jPanel1);
              }
            } 
            Limpia lim = new Limpia();
            lim.limpiarTexto(jPanel2);
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
   * Carga la ventana cartelera
   * @param args
   */
  public static void main(String []args) {
    SwingUtilities.invokeLater(() -> {
      VentanaCartelera thisClass = new VentanaCartelera();
      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      thisClass.setVisible(true);
    });
  }

  /**.
   * funcion que realiza el evento cuando se selecciona un objeto de la
   * lista de peliculas
   */
  private void eventoLista() {

    String pe = (String) list.getSelectedValue();
    PeliculaDaoImp dao =  new PeliculaDaoImp();
    Pelicula peli = new Pelicula();
    peli = dao.buscarPelicula(pe);
    Pelicula horarior = new Pelicula(); 
    HorarioDao horarioDao = new HorarioDao();
    horarior = horarioDao.buscarHorarioPelicula(pe);
    
    
    pelicula.setText("Pelicula: " + peli.getNombre());
    genero.setText("Genero: " + peli.getGenero());  
    idioma.setText("Idioma: " + peli.getIdioma());
    duracion.setText("Duración: " + peli.getDuracion());
    if (horarior != null) {
      horario.setText(" Horario: "  + horarior.getFechaEstreno());
      nombreSala.setText("sala: " + horarioDao.getSala());
    } else {
      horario.setText(" Horario:");
      nombreSala.setText("sala: ");
    }
    if (peli.getResumen() == null) { 
      resumen.setText("Resumen:");
    } else {
      resumen.setText("Resumen: " + peli.getResumen());
    }
  }

  /**.
   * muestra la lista de peliculas disponibles 
   */
  public void mostrarLista() {
    lista = peliculadao.consultar();
    for (Pelicula pe : lista) {
      listModel.agregar(pe);

    }
  }
}

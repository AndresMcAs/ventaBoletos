package ventaboletos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Horarios;
import control.RegistrarPelicula;
import control.RegistrarSala;
import control.ReservaAsiento;

public class Cine extends javax.swing.JFrame {
  
	 
  /**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	private JButton registroPelicula;
	private JButton registroSala;
	private JButton cartelera;
	private JButton horarios;
	private JButton resAsientos;
	private javax.swing.JSeparator jSeparator1;
	

 public Cine() {
    super("Cine Lumiere");
  
	inicializa();
  }
	  
	  /**.
	   * 
	   */
  public final void inicializa() {

	    setSize(750, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panelTitulo = new JPanel();
	    JLabel titulo = new JLabel();
	    titulo.setFont(new java.awt.Font("Century", 1, 55));
	    titulo.setForeground(java.awt.SystemColor.activeCaption);
	    titulo.setText("Cine Lumiere ");
	    registroPelicula = new JButton("Registrar Pelicula");
		registroPelicula.setFont(new java.awt.Font("Century", 1, 12));   
	    registroSala = new JButton("Registrar Sala");
	    registroSala.setFont(new java.awt.Font("Century", 1, 12));
	    cartelera = new JButton("Cartelear");
	    cartelera.setFont(new java.awt.Font("Century", 1, 12));
	    horarios = new JButton("Asignar Horarios");
	    horarios.setFont(new java.awt.Font("Century", 1, 12));
	    resAsientos = new JButton("Reservar Asientos");
	    resAsientos.setFont(new java.awt.Font("Century", 1, 12));
	    jSeparator1 = new javax.swing.JSeparator();
	    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelTitulo);
	    panelTitulo.setLayout(jPanel1Layout);
	    jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addComponent(cartelera, javax.swing.GroupLayout.DEFAULT_SIZE, 
	                        		      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(registroPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 
	                            		      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(registroSala, javax.swing.GroupLayout.DEFAULT_SIZE,
	                            		       javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(horarios, javax.swing.GroupLayout.DEFAULT_SIZE, 
	                            		       javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(resAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, 
	                            		       javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                    .addContainerGap(69, Short.MAX_VALUE)
	                )
	            );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(registroPelicula)
                .addGap(34, 34, 34)
                .addComponent(registroSala)
                .addGap(30, 30, 30)
                .addComponent(horarios)
                .addGap(38, 38, 38)
                .addComponent(cartelera)
                .addGap(34, 34, 34)
                .addComponent(resAsientos)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                            		      javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, 
                            		       javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(197, 197, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(titulo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                    		         javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                    		      javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		      javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50))
            );
        
        registroPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	RegistrarPelicula p = new RegistrarPelicula();
          	p.setVisible(true);
            }
          });
        
        registroSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	RegistrarSala sala = new RegistrarSala();
          	sala.setVisible(true);
            }
          });
        cartelera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	 
            }
          });
        horarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	 Horarios cartelera = new Horarios();
          	 cartelera.setVisible(true);
            }
          });
        resAsientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	ReservaAsiento reservacion = new ReservaAsiento();
          	reservacion.setVisible(true);
            }
          });
	    
  }
  
  public static void main(String []args) {
	    SwingUtilities.invokeLater(() -> {
	      Cine thisClass = new Cine();
	      thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      thisClass.setVisible(true);
	    });
	  }
}

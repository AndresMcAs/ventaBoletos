package modelo;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelReservar extends JPanel{

  private static final long serialVersionUID = 1L;
  
  private final JTextField campoReservas;
  public JButton btReservar;
  public JButton btCancelar;
	
  public PanelReservar() {

    campoReservas = new JTextField(25); 
    campoReservas.setFont(new Font("Verdana", Font.PLAIN, 12));
    btReservar = new JButton("Reservar");
    btReservar.setFont(new Font("Verdana", Font.PLAIN, 12));
    btCancelar = new JButton("Cancelar");
    btCancelar.setFont(new Font("Verdana", Font.PLAIN, 12));
    
    JPanel pnSuperior = new JPanel();
    JLabel etiq = new JLabel("Indique codigos de asiento separados por comas ");
    etiq.setFont(new Font("Verdana", Font.BOLD, 12));
    pnSuperior.setLayout(new BoxLayout(pnSuperior, BoxLayout.Y_AXIS));
    JPanel pnEtiq = new JPanel();
    pnEtiq.add(etiq);
    pnSuperior.add(pnEtiq);
    JPanel pnCampo = new JPanel();
    pnCampo.add(campoReservas);
    pnSuperior.add(pnCampo);
    pnSuperior.setBorder(new EmptyBorder(5, 6, 1, 1));
    
    JPanel pnBotones = new JPanel();
    pnBotones.setLayout(new BoxLayout(pnBotones, BoxLayout.X_AXIS));
    JPanel pnIzq = new JPanel();
    pnIzq.add(btReservar);
    JPanel pnDer = new JPanel();
    pnDer.add(btCancelar);
    pnBotones.add(pnIzq);
    pnBotones.add(pnDer);
    pnBotones.setBorder(new EmptyBorder(5, 6, 1, 1));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(pnSuperior);
    add(new JSeparator());
    add(pnBotones);
    
  }
  
  public String getReservas() {
    return campoReservas.getText().toUpperCase();
  }
  
  public void reset() {
    campoReservas.setText(null);
  }
}
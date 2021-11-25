package imagenes;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Graphics;

public class Fondo extends javax.swing.JPanel{
	private String imagen;
	
	public Fondo( String ima) {
		this.imagen =ima;
		
	}
	
	
	@Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource(imagen));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paint(g);
    }
	


public String getImagen() {
	return imagen;
}


public void setImagen(String imagen) {
	this.imagen = imagen;
}
  

}

package control;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import modelo.Pelicula;

public class ListaModelo  extends AbstractListModel<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ArrayList<Pelicula> list =  new ArrayList<>();
    
    @Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Object getElementAt(int index) {
		Pelicula p =  list.get(index);
		return p.getNombre();
	}
	
	public Pelicula getPelicula(int index) {
		return  list.get(index);
	}
    
	public void agregar (Pelicula p) {
		
		list.add(p);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public void eliminarPelicula(int index) {
		
		list.remove(index);
		this.fireContentsChanged(index, getSize(), getSize()+1);
	}
	

}

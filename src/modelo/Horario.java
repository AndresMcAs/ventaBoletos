package modelo;


public class Horario {

  
  private int idPelicula;
  private String dia;
  private String mes;
  private String a�o;
  private String hora;
  private String minuto;
  private int idSala;
  
  public Horario() {
	  
  }
   
  public Horario(String dia, String mes, String a�o, String hora, 
		         String minuto, int idSala) {
	super();
	this.dia = dia;
	this.mes = mes;
	this.a�o = a�o;
	this.hora = hora;
	this.minuto = minuto;
	this.idSala = idSala;
  }



 public Horario(int idPelicula, String dia, String mes, String a�o, String hora, 
		        String minuto, int idSala) {
	super();
	this.idPelicula = idPelicula;
	this.dia = dia;
	this.mes = mes;
	this.a�o = a�o;
	this.hora = hora;
	this.minuto = minuto;
	this.idSala = idSala;
}

public int getIdPelicula() {
	return idPelicula;
  }

  public void setIdPelicula(int idPelicula) {
	this.idPelicula = idPelicula;
  }

  public String getDia() {
	return dia;
  }

  public void setDia(String dia) {
	this.dia = dia;
  }

  public String getMes() {
	return mes;
  }

  public void setMes(String mes) {
	this.mes = mes;
  }

  public String getA�o() {
	return a�o;
  }

  public void setA�o(String a�o) {
	this.a�o = a�o;
  }

  public String getMinuto() {
	return minuto;
  }

  public void setMinuto(String minuto) {
	this.minuto = minuto;
  }

  public int getIdSala() {
	return idSala;
  }

  public void setIdSala(int idSala) {
	this.idSala = idSala;
  }

public String getHora() {
	return hora;
}

public void setHora(String hora) {
	this.hora = hora;
}
  
  
}

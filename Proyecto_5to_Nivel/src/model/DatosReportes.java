package model;

public class DatosReportes {
	private int contador;
	private String datos;
	
	public DatosReportes() {
		
	}
	
	public DatosReportes(int contador, String datos) {
		this.contador = contador;
		this.datos = datos;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	

}

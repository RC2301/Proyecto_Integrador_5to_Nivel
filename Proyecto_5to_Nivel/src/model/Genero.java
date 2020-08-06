package model;


import java.util.Date;


public class Genero {
	
	private int sk_genero;
	private int pk_genero;
	private String genero;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	
	public Genero() {
		
	}
	
	public Genero(int sk, int pk, String genero, Date vd, Date vh, int version) {
		this.sk_genero = sk;
		this.pk_genero = pk;
		this.genero = genero;
		this.valido_desde = vd;
		this.valido_hasta = vh;
		this.version = version;
	}

	public int getSk_genero() {
		return sk_genero;
	}

	public void setSk_genero(int sk_genero) {
		this.sk_genero = sk_genero;
	}

	public int getPk_genero() {
		return pk_genero;
	}

	public void setPk_genero(int pk_genero) {
		this.pk_genero = pk_genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getValido_desde() {
		return valido_desde;
	}

	public void setValido_desde(Date valido_desde) {
		this.valido_desde = valido_desde;
	}

	public Date getValido_hasta() {
		return valido_hasta;
	}

	public void setValido_hasta(Date valido_hasta) {
		this.valido_hasta = valido_hasta;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

}

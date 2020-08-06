package model;


import java.util.Date;





public class Etnia  {
	
	private int sk_etnia;
	private int pk_etnia;
	private String etnia;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	
	public Etnia() {
		
	}
	
	public Etnia(int sk, int pk, String etnia, Date vd, Date vh, int version) {
		this.sk_etnia = sk;
		this.pk_etnia = pk;
		this.etnia = etnia;
		this.valido_desde = vd;
		this.valido_hasta = vh;
		this.version = version;
	}

	public int getSk_etnia() {
		return sk_etnia;
	}

	public void setSk_etnia(int sk_etnia) {
		this.sk_etnia = sk_etnia;
	}

	public int getPk_etnia() {
		return pk_etnia;
	}

	public void setPk_etnia(int pk_etnia) {
		this.pk_etnia = pk_etnia;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
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

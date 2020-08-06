package model;


import java.util.Date;




public class Provincia {
	
	private int sk_provincia;
	private int pk_provincia;
	private String provincia;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
    
    public Provincia() {
    	
    }
	
    public Provincia(int sk, int pk, String provincia, Date vd, Date vh, int version) {
		this.sk_provincia = sk;
		this.pk_provincia = pk;
		this.provincia = provincia;
		this.valido_desde = vd;
		this.valido_hasta = vh;
		this.version = version;
	}

	public int getSk_provincia() {
		return sk_provincia;
	}

	public void setSk_provincia(int sk_provincia) {
		this.sk_provincia = sk_provincia;
	}

	public int getPk_provincia() {
		return pk_provincia;
	}

	public void setPk_provincia(int pk_provincia) {
		this.pk_provincia = pk_provincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

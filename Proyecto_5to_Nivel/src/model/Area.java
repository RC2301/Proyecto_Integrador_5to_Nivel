package model;


import java.util.Date;




public class Area {
	
	
	private int sk_area;
	private int pk_area;
	private String area;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	
	public Area() {
		
	}
	
	public Area(int sk, int pk, String genero, Date vd, Date vh, int version) {
		this.sk_area = sk;
		this.pk_area = pk;
		this.area = genero;
		this.valido_desde = vd;
		this.valido_hasta = vh;
		this.version = version;
	}

	public int getSk_area() {
		return sk_area;
	}

	public void setSk_area(int sk_area) {
		this.sk_area = sk_area;
	}

	public int getPk_area() {
		return pk_area;
	}

	public void setPk_area(int pk_area) {
		this.pk_area = pk_area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

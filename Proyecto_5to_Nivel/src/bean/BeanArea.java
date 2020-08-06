package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import control.ControllerArea;
import model.Area;


@Named(value = "beanArea")
@SessionScoped
public class BeanArea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int sk_area;
	private int pk_area;
	private String area;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	private Area cls_area;
	
	
	public BeanArea() {
		
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


	public Area getCls_area() {
		return cls_area;
	}


	public void setCls_area(Area cls_area) {
		this.cls_area = cls_area;
	}
	
	public ArrayList<Area> listaArea() throws SQLException {
		ControllerArea controller = new ControllerArea();
		return controller.ImprimeArea();
	}
	
	public ArrayList<String> listaAreas() throws SQLException {
		ControllerArea controller = new ControllerArea();
		return controller.ImprimeAreas();
	}

}

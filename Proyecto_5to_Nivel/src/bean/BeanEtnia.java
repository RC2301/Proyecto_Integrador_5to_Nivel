package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import control.ControllerEtnia;

import model.Etnia;


@Named(value = "beanEtnia")
@SessionScoped
public class BeanEtnia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sk_etnia;
	private int pk_etnia;
	private String etnia;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	private Etnia cls_etnia;
	
	public BeanEtnia() {
		
	}

	
	
	public Etnia getCls_etnia() {
		return cls_etnia;
	}



	public void setCls_etnia(Etnia cls_etnia) {
		this.cls_etnia = cls_etnia;
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
	
	public ArrayList<Etnia> listaEtnia() throws SQLException {
		ControllerEtnia controller = new ControllerEtnia();
		return controller.ImprimeEtnia();
	}
	
	public ArrayList<String> listaEtnias() throws SQLException {
		ControllerEtnia controller = new ControllerEtnia();
		return controller.ImprimeEtnias();
	}

	
	
	
}

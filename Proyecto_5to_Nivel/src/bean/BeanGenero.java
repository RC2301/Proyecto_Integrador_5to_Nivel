package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import control.ControllerGenero;

import model.Genero;


@Named(value = "beanGenero" )
@SessionScoped
public class BeanGenero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sk_genero;
	private int pk_genero;
	private String genero;
	private Date valido_desde;
	private Date valido_hasta;
	private int version;
	private Genero cls_genero;
	List<String> generos;
	
	public BeanGenero() {
		
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

	public Genero getCls_genero() {
		return cls_genero;
	}

	public void setCls_genero(Genero cls_genero) {
		this.cls_genero = cls_genero;
	}
	
	
	public ArrayList<Genero> listaGenero() throws SQLException {
		ControllerGenero controller = new ControllerGenero();
		return controller.ImprimeGenero();
	}
	
	public ArrayList<String> listaGeneros() throws SQLException {
		ControllerGenero controller = new ControllerGenero();
		return controller.ImprimeGeneros();
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
	
	
	

}

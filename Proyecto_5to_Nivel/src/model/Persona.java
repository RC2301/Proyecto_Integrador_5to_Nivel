package model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Persona;
import java.io.Serializable;


@Named(value="persona")
@SessionScoped

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_persona;
	private String nombre;
    private String apellido;
    private String doc_identidad;
    private String correo_electronico;
    private String clave;
    private int id_tipo;
    private String descripcion;
    
    public Persona() {
    	
    }
    
    public Persona(int id_persona,String nombre, String apellido, String doc_identidad, String correo, String clave, int id_tipo, String descripcion) {
    	this.id_persona = id_persona;
    	this.nombre= nombre;
    	this.apellido = apellido;
    	this.doc_identidad= doc_identidad;
    	this.correo_electronico = correo;
    	this.clave=clave;
    	this.id_tipo = id_tipo;
    	this.descripcion = descripcion;
    }
    
    public Persona(String cedula) {
    	this.doc_identidad = cedula;
    	
    }

    
	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDoc_identidad() {
		return doc_identidad;
	}

	public void setDoc_identidad(String doc_identidad) {
		this.doc_identidad = doc_identidad;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
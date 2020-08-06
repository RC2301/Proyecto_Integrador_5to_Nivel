package bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import control.ControllerPersona;
import model.Cls_conexion;
import model.Persona;



@Named(value = "beanRegistroPersona")
@SessionScoped
public class BeanRegistroPersona implements Serializable {

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
	private String temp;
	private Persona persona = new Persona();

	public BeanRegistroPersona() {

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
	
	public String getTemp() {
		return temp;
	}

	public String setTemp(String temp) {
		return this.temp = temp;
	}

	public Persona getPersona() {
		return persona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String almaceneDatosPersona() throws SQLException {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();

		String respuesta = controller.enviaDatoEstudiante(id_persona, nombre, apellido, doc_identidad,
				correo_electronico, clave, perfil, descripcion);

		return respuesta;
	}

	public String almacenarPersona() {
		int perfil = 2;
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.agregarPersona(id_persona, nombre, apellido, doc_identidad, correo_electronico,
				clave, perfil);
		clear();
		return respuesta;
	}

	public String addPersona() {
		int perfil = 2;
		String r2 = "";
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.agregarPersona(id_persona, nombre, apellido, doc_identidad, correo_electronico,
				clave, perfil);
		clear();
		if (respuesta == "RegCor")
			r2 = "AddCor";
		return r2;
	}

	public void clear() {
		setNombre(null);
		setApellido(null);
		setDoc_identidad(null);
		setCorreo_electronico(null);
		setClave(null);

	}// end clear`
	
	public void clearLogin() {
		
		setCorreo_electronico(null);
		setClave(null);

	}
	
	

	public ArrayList<Persona> listaPersona() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimePersona();
	}
	
	/*public ArrayList<Persona> listaCedula() throws SQLException {
		ControllerPersona controller = new ControllerPersona();
		return controller.ImprimeCedula();
	}
	*/
	

	public String irEdicion() {
		return "editar_user";
	}

	public String irMenu() {
		return "menuadmin";
	}

	public String irLogin() {
		return "login";
	}

	public String irRegistro() {
		return "volReg";
	}

    public void EliminarDatosPersona(Persona persona) throws SQLException{
        
    	ControllerPersona controller = new ControllerPersona();
        controller.eliminarPersona(persona);
       
    }

	public void ModificaDatosPersona() throws SQLException {

		ControllerPersona controller = new ControllerPersona();
		controller.modificarPersona(persona);

	}
	
	public String leerId(Persona persona) throws Exception {
	      
		ControllerPersona controller = new ControllerPersona();
        Persona per;
        
        per = controller.leerIDPersona(persona);
        
        if (per != null) {
            this.persona = per;
        }
        return "editar_user";
    }
	
	public String ingresoAlSistema() throws SQLException {
		ControllerPersona controller = new ControllerPersona();

        int valor = controller.login(correo_electronico, clave);

        if (valor != 0) {
        	        	
            if (valor == 1) {
            	clearLogin();
                return "" + valor;           

            }

            if (valor == 2) {
            	clearLogin();
                return "" + valor;
            }

            
        } else {
        	clearLogin();
            return "no";
        }
        clearLogin();
        return "no";
    }
	public String eliminarPer(String ced) {
		String result = "";
		PreparedStatement st = null;
		Cls_conexion cl = new Cls_conexion();
		try {
			st = cl.getConexion().prepareStatement("delete from persona where doc_identidad = ?");
			st.setString(1, ced);
			if (st.executeUpdate() == 1) {
				result = "eliminado";
			} else {
				result = "noelim";
			}
		} catch (Exception ex) {
			result = ex.getMessage();
		} finally {
			try {
				st.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}
		return result;

	}
	
	public String ingr(String cedu) {
		temp=setTemp(cedu);
		return "cambioContra.xhtml";
	}
	
	public String almCedu() {
		ControllerPersona controller = new ControllerPersona();
		String respuesta = controller.mclave(clave, temp);
		clear();
		return respuesta;
	}
	
	public String ind() {
		return "listadoUsuarios.xhtml";
	}
	/*
    public void modificarPer() throws SQLException {
    	
        Cls_conexion cl = new Cls_conexion();
        PreparedStatement st = cl.getConexion().prepareStatement("UPDATE persona SET clave = ? where doc_identidad = ? ");
        st.setString(1, clave);
        st.setString(2, temp);
        st.executeUpdate();
        
    }*/
    
    public String modificarPer() {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "UPDATE persona SET clave = ? where doc_identidad = ? ";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, clave);
			pr.setString(2, temp);
			if (pr.executeUpdate() == 1) {
				result = "listadoUsuarios.xhtml";
			} else {
				result = "listadoUsuarios.xhtml";
			}
		} catch (Exception ex) {
			result = ex.getMessage();
		} finally {
			try {
				pr.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}

		return result;
	}
}

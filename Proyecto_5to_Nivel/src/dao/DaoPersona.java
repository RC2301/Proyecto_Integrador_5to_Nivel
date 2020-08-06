package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cls_conexion;
import model.Persona;


public class DaoPersona {

	public ArrayList<Persona> FindAllPersonas() throws SQLException {
		ArrayList<Persona> persona = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select id_persona, nombre, apellido, doc_identidad, correo_electronico, clave, persona.id_tipo, descripcion from persona,tipo_usuario where persona.id_tipo=tipo_usuario.id_tipo");
		int id_persona;
		String nombre;
		String apellido;
		String doc_identidad;
		String correo_electronico;
		String clave;
		int id_tipo;
		String descripcion;
		while (re.next()) {
			id_persona = re.getInt(1);
			nombre = re.getString(2);
			apellido = re.getString(3);
			doc_identidad = re.getString(4);
			correo_electronico = re.getString(5);
			clave = re.getString(6);
			id_tipo = re.getInt(7);
			descripcion = re.getString(8);
			persona.add(new Persona(id_persona, nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo, descripcion));
		}
		return persona;
	}

	public ArrayList<Persona> envioPersona(int id_persona, String nombre, String apellido, String doc_identidad,
			String correo, String clave, int id_tipo, String descripcion) throws SQLException {
		Persona persona = new Persona(id_persona, nombre, apellido, doc_identidad, correo, clave, 2, descripcion);
		persona.setId_persona(id_persona);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDoc_identidad(doc_identidad);
		persona.setCorreo_electronico(correo);
		persona.setClave(clave);
		persona.setId_tipo(id_tipo);

		Cls_conexion cl = new Cls_conexion();
		cl.ejecutar(
				"insert into persona (nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo) values ('"
						+ nombre + "','" + apellido + "','" + doc_identidad + "','" + correo + "','" + clave + "','" + 2
						+ "');");
		return this.FindAllPersonas();

	}

	public String RegistrarUsuario(int id_persona, String nombre, String apellido, String doc_identidad, String correo,
			String clave, int id_tipo) {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "INSERT INTO persona(nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo)";
		sql += "VALUES(?,?,?,?,?,?)";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, nombre);
			pr.setString(2, apellido);
			pr.setString(3, doc_identidad);
			pr.setString(4, correo);
			pr.setString(5, clave);
			pr.setInt(6, 2);

			if (pr.executeUpdate() == 1) {
				result = "RegCor";
			} else {
				result = "no";
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
	
	public String actClave(String clave, String cedd) {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "UPDATE persona SET clave = ? where doc_identidad = ? ";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, clave);
			pr.setString(2, cedd);
			if (pr.executeUpdate() == 1) {
				result = "";
			} else {
				result = "";
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

	public String eliminarPer(Persona persona) {
		String result = "";
		PreparedStatement st = null;
		Cls_conexion cl = new Cls_conexion();
		try {
			st = cl.getConexion().prepareStatement("delete from persona where doc_identidad = ? ");
			st.setString(1, persona.getDoc_identidad());
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
	
    public void modificarPer(Persona persona) throws SQLException {

        Cls_conexion cl = new Cls_conexion();
        PreparedStatement st = cl.getConexion().prepareStatement("UPDATE persona SET clave = ? where doc_identidad = ? ");
        st.setString(1, persona.getClave());
        st.setString(2, persona.getDoc_identidad());
        st.executeUpdate();

    }
    
    
    public Persona LeerID(Persona persona) throws Exception {

        Persona per = new Persona();
        ResultSet re;
        Cls_conexion cl = new Cls_conexion();
        re = cl.consulta("select * from public.persona where cedula = '" + persona.getDoc_identidad() + "'");

        while (re.next()) {

            per.setDoc_identidad(re.getString("doc_identidad"));
            per.setClave(re.getString("clave"));
            per.setCorreo_electronico(re.getString("correo_electronico"));
        }
        return per;
    }
    
    
 /*   public ArrayList<Persona> FindAllCedulas() throws SQLException {
		ArrayList<Persona> persona = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select cedula,clave from persona");
		
		String doc_identidad;
		
		
		while (re.next()) {
			
			doc_identidad = re.getString(1);
			
			
			persona.add(new Persona(doc_identidad));
		}
		return persona;
	} */
    

}
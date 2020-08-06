package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import model.Cls_conexion;
import model.Provincia;

public class DaoProvincia {
	
	public ArrayList<Provincia> FindAllProvincias() throws SQLException {
		ArrayList<Provincia> pr = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_provincia");
		int sk_provincia;
		int pk_provincia;
		String provincia;
		Date valido_desde;
		Date valido_hasta;
		int version;
		while (re.next()) {
			sk_provincia = re.getInt(1);
			pk_provincia = re.getInt(2);
			provincia = re.getString(3);
			valido_desde = re.getDate(4);
			valido_hasta = re.getDate(5);
			version = re.getInt(6);
			pr.add(new Provincia(sk_provincia,pk_provincia,provincia,valido_desde,valido_hasta,version));
		}
		return pr;
	}
	
	public ArrayList<String> getProvincias()	{
		ArrayList<String> lista_provincias = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select * from dim_provincia");
			
			while (re.next()) {
				
				lista_provincias.add(re.getString(3));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			try {
				
				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_provincias;
	}
	
	public List<SelectItem> obtenerProvincias()	{
		Cls_conexion cl = new Cls_conexion();
		List<SelectItem> lista=new ArrayList<>();
		lista.add(new SelectItem(null, "Seleccione"));
		try {
			ResultSet re;
			re = cl.consulta("select * from dim_provincia");
			
			while (re.next()) {
				lista.add(new SelectItem(re.getInt(1),re.getString(3)));
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			try {
				
				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista;
	}

}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Area;
import model.Cls_conexion;


public class DaoArea {
	
	public ArrayList<Area> FindAllAreas() throws SQLException {
		ArrayList<Area> ar = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_area");
		int sk_area;
		int pk_area;
		String area;
		Date valido_desde;
		Date valido_hasta;
		int version;
		while (re.next()) {
			sk_area = re.getInt(1);
			pk_area = re.getInt(2);
			area = re.getString(3);
			valido_desde = re.getDate(4);
			valido_hasta = re.getDate(5);
			version = re.getInt(6);
			ar.add(new Area(sk_area,pk_area,area,valido_desde,valido_hasta,version));
		}
		return ar;
	}
	
	public ArrayList<String> getAreas(){
		ArrayList<String> lista_areas = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select * from dim_area");
			
			while (re.next()) {
				
				lista_areas.add(re.getString(3));
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
		return lista_areas;
	}

}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Cls_conexion;
import model.Genero;


public class DaoGenero {
	
	
	
	public ArrayList<Genero> FindAllGeneros() throws SQLException {
		ArrayList<Genero> gen = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_genero");
		int sk_genero;
		int pk_genero;
		String genero;
		Date valido_desde;
		Date valido_hasta;
		int version;
		while (re.next()) {
			sk_genero = re.getInt(1);
			pk_genero = re.getInt(2);
			genero = re.getString(3);
			valido_desde = re.getDate(4);
			valido_hasta = re.getDate(5);
			version = re.getInt(6);
			gen.add(new Genero(sk_genero,pk_genero,genero,valido_desde,valido_hasta,version));
		}
		return gen;
	}
	
	public ArrayList<String> getGeneros(){
		ArrayList<String> lista_generos = new ArrayList<>();
		try {
			ResultSet re;
			Cls_conexion cl = new Cls_conexion();
			re = cl.consulta("select * from dim_genero");
			//String genero;
			while (re.next()) {
				
				lista_generos.add(re.getString(3));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return lista_generos;
	}

}

package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cls_conexion;
import model.DatosReportes;
import model.ReportesInt;

public class DaoReportes {
	
	public List<DatosReportes>consultaPxAnioTotal(int fechain, int fechafin,String provincia) {
		String sql = "select count (*) as numero_personas, dim_provincia.provincia\r\n" + 
				"from fact_nacimientos,dim_provincia,dim_fecha\r\n" + 
				"where dim_fecha.anio >= " + fechain + " and dim_fecha.anio <= "+fechafin+ "\r\n" + 
				"and dim_fecha.sk_fecha = fact_nacimientos.sk_fecha\r\n" + 
				"and fact_nacimientos.sk_provincia = dim_provincia.sk_provincia \r\n" + 
				"group by fact_nacimientos.sk_provincia, dim_provincia.provincia \r\n" + 
				"order by dim_provincia.provincia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosReportes>consultaPxAnio(int fechain, int fechafin, String provincia) {
		String sql = "select count (*) as numero_personas, dim_provincia.provincia\r\n" + 
				"from fact_nacimientos,dim_provincia,dim_fecha\r\n" + 
				"where dim_fecha.anio >= " + fechain + " and dim_fecha.anio <= "+fechafin+ "\r\n" + 
				"and dim_fecha.sk_fecha = fact_nacimientos.sk_fecha\r\n" + 
				"and dim_provincia.sk_provincia = '"+ provincia + "' \r\n" + 
				"and fact_nacimientos.sk_provincia = dim_provincia.sk_provincia \r\n" + 
				"group by fact_nacimientos.sk_provincia, dim_provincia.provincia \r\n" + 
				"order by dim_provincia.provincia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosReportes>consultaPxAnio(int fechain, int fechafin) {
		String sql = "select count (*) as numero_personas, dim_provincia.provincia\r\n" + 
				"from fact_nacimientos,dim_provincia,dim_fecha\r\n" + 
				"where dim_fecha.anio >= " + fechain + " and dim_fecha.anio <= "+fechafin+ "\r\n" + 
				"and dim_fecha.sk_fecha = fact_nacimientos.sk_fecha\r\n" +  
				"and fact_nacimientos.sk_provincia = dim_provincia.sk_provincia \r\n" + 
				"group by fact_nacimientos.sk_provincia, dim_provincia.provincia \r\n" + 
				"order by dim_provincia.provincia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	
	public List<DatosReportes>pruebaPxAnio() {
		String sql = "select count (*) as numero_personas, dim_provincia.provincia\r\n" + 
				"from fact_nacimientos,dim_provincia,dim_fecha\r\n" + 
				"where dim_fecha.anio >= 1950 and dim_fecha.anio <= 2000\r\n" + 
				"and dim_fecha.sk_fecha = fact_nacimientos.sk_fecha\r\n" + 
				"and fact_nacimientos.sk_provincia = dim_provincia.sk_provincia \r\n" + 
				"group by fact_nacimientos.sk_provincia, dim_provincia.provincia \r\n" + 
				"order by dim_provincia.provincia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	
	public List<DatosReportes>prxurbano() {
		String sql = "select count (*) as numero_personas ,dp.provincia, da.area from dim_provincia \r\n" + 
				"as dp, dim_area as da, fact_nacimientos as fn\r\n" + 
				"where dp.sk_provincia = fn.sk_provincia \r\n" + 
				"and da.sk_area = fn.sk_area \r\n" + 
				"and da.area = 'URBANO'\r\n" + 
				"group by dp.provincia, da.area order by dp.provincia;";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosReportes>prxrural() {
		String sql = "select count (*) as numero_personas ,dp.provincia, da.area from dim_provincia \r\n" + 
				"as dp, dim_area as da, fact_nacimientos as fn\r\n" + 
				"where dp.sk_provincia = fn.sk_provincia \r\n" + 
				"and da.sk_area = fn.sk_area \r\n" + 
				"and da.area = 'RURAL'\r\n" + 
				"group by dp.provincia, da.area order by dp.provincia;";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;
	}
	
	
	public List<DatosReportes>mesxan(int fechain, int fechafin, String mes) {
		String sql = "	select count(*) as numero_personas, df.nombre_mes\r\n" + 
				"	from dim_fecha as df, fact_nacimientos as fn\r\n" + 
				"	where df.sk_fecha = fn.sk_fecha\r\n" + 
				"	and df.anio >= "+fechain+ " and df.anio <= "+fechafin+" \r\n" + 
				"	and df.mes = '"+ mes + "'\r\n" + 
				"	group by df.nombre_mes, df.mes order by df.nombre_mes, df.mes";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;
	}
	
	public List<DatosReportes>mesxan(int fechain, int fechafin) {
		String sql = "	select count(*) as numero_personas, df.nombre_mes\r\n" + 
				"	from dim_fecha as df, fact_nacimientos as fn\r\n" + 
				"	where df.sk_fecha = fn.sk_fecha\r\n" + 
				"	and df.anio >= "+fechain+ " and df.anio <= "+fechafin+" \r\n" + 				
				"	group by df.nombre_mes, df.mes order by df.mes";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;
	}
	
	public List<ReportesInt>hombrexanio(int fechain, int fechafin){
		String sql = "	select count(*) as numero_personas, dg.genero , df.anio\r\n" + 
				"from dim_genero as dg, dim_fecha as df, fact_nacimientos as fn\r\n" + 
				"where dg.sk_genero = fn.sk_genero and df.sk_fecha = fn.sk_fecha\r\n" + 
				"and dg.genero = 'HOMBRE'\r\n" + 
				"and df.anio >= "+fechain+ " and df.anio <= "+fechafin+" \r\n" + 
				"group by df.anio, dg.genero order by df.anio ";		
		ResultSet rs = null;
		List<ReportesInt> datos = new ArrayList<ReportesInt>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				ReportesInt ri = new ReportesInt();
				ri.setContador(rs.getInt(1));
				ri.setYear(rs.getInt(3));
				datos.add(ri);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;
		
	}
	
	public List<ReportesInt>mujerxanio(int fechain, int fechafin){
		String sql = "	select count(*) as numero_personas, dg.genero , df.anio\r\n" + 
				"from dim_genero as dg, dim_fecha as df, fact_nacimientos as fn\r\n" + 
				"where dg.sk_genero = fn.sk_genero and df.sk_fecha = fn.sk_fecha\r\n" + 
				"and dg.genero = 'MUJER'\r\n" + 
				"and df.anio >= "+fechain+ " and df.anio <= "+fechafin+" \r\n" + 
				"group by df.anio, dg.genero order by df.anio ";		
		ResultSet rs = null;
		List<ReportesInt> datos = new ArrayList<ReportesInt>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				ReportesInt ri = new ReportesInt();
				ri.setContador(rs.getInt(1));
				ri.setYear(rs.getInt(3));
				datos.add(ri);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;
		
	}
	
	public List<DatosReportes>etniaxAnio(int fechain, int fechafin, String etnia) {
		String sql = "select count(*) as Cantidad, etinia \r\n" + 
				"from fact_nacimientos, dim_etnia, dim_fecha \r\n" + 
				"where fact_nacimientos.sk_etnia=dim_etnia.sk_etnia \r\n" + 
				"and dim_fecha.sk_fecha=fact_nacimientos.sk_fecha\r\n" + 
				"and anio between "+ fechain+ " and "+ fechafin+"\r\n" + 
				"and dim_etnia.sk_etnia = '"+ etnia + "'\r\n" + 
				"group by dim_etnia.sk_etnia order by etinia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	
	public List<DatosReportes>etniaxAnio(int fechain, int fechafin) {
		String sql = "select count(*) as Cantidad, etinia \r\n" + 
				"from fact_nacimientos, dim_etnia, dim_fecha \r\n" + 
				"where fact_nacimientos.sk_etnia=dim_etnia.sk_etnia \r\n" + 
				"and dim_fecha.sk_fecha=fact_nacimientos.sk_fecha\r\n" + 
				"and anio between "+ fechain+ " and "+ fechafin+"\r\n" + 
				"group by dim_etnia.sk_etnia order by etinia";
		
		ResultSet rs = null;
		List<DatosReportes> datos = new ArrayList<DatosReportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				DatosReportes dr= new DatosReportes();
				dr.setContador(rs.getInt(1));
				dr.setDatos(rs.getString(2));

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
	


}

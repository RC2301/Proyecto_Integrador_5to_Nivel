package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import model.Cls_conexion;
import model.Fecha;

public class DaoFecha {

	public ArrayList<Fecha> FindAllFechas() throws SQLException {
		ArrayList<Fecha> fe = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_fecha");
		int sk_fecha;
		int pk_fecha;
		int anio;
		int semestre;
		String nombre_semestre;
		int trimestre;
		String nombre_trimestre;
		int mes;
		String nombre_mes;
		int dia;
		Date fecha;
		while (re.next()) {
			sk_fecha = re.getInt(1);
			pk_fecha = re.getInt(2);
			anio = re.getInt(3);
			semestre = re.getInt(4);
			nombre_semestre = re.getString(5);
			trimestre = re.getInt(6);
			nombre_trimestre = re.getString(7);
			mes = re.getInt(8);
			nombre_mes = re.getString(9);
			dia = re.getInt(10);
			fecha = re.getDate(5);

			fe.add(new Fecha(sk_fecha, pk_fecha, anio, semestre, nombre_semestre, trimestre, nombre_trimestre, mes,
					nombre_mes, dia, fecha));
		}
		return fe;
	}

	public ArrayList<String> getMeses() {
		ArrayList<String> lista_fechas = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select mes, nombre_mes  from dim_fecha group by mes, nombre_mes order by mes");

			while (re.next()) {

				lista_fechas.add(re.getString(2));
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_fechas;
	}
	
	public List<SelectItem> ObtenerMeses() {
		List<SelectItem> lista_fechas=new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		lista_fechas.add(new SelectItem(null, "Seleccione"));
		try {
			ResultSet re;
			re = cl.consulta("select mes, nombre_mes  from dim_fecha group by mes, nombre_mes order by mes");

			while (re.next()) {

				lista_fechas.add(new SelectItem(re.getInt(1),re.getString(2)));
			}
			lista_fechas.add(new SelectItem(13, "TODOS LOS MESES"));	

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_fechas;
	}
	

	public ArrayList<String> getYears() {
		ArrayList<String> lista_anios = new ArrayList<>();
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select anio  from dim_fecha where anio >= 1950 group by anio order by anio");

			while (re.next()) {

				lista_anios.add(re.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_anios;
	}

	public List<SelectItem> obtenerYears() {
		List<SelectItem> lista_anios = new ArrayList<>();
		lista_anios.add(new SelectItem(null, "Seleccione"));
		Cls_conexion cl = new Cls_conexion();
		try {
			ResultSet re;
			re = cl.consulta("select anio  from dim_fecha where anio >= 1915 group by anio order by anio");

			while (re.next()) {
				lista_anios.add(new SelectItem(re.getString(1), re.getString(1)));
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {

				cl.getConexion().close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return lista_anios;
	}

}

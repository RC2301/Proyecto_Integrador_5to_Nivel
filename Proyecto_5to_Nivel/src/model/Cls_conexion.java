/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;

public final class Cls_conexion {

	private Connection con;
	private Statement St;
	private ResultSet rs;
	private String driver;
	private String user;
	private String pwd;
	private String cadena;
	
	
	public String getDriver()
	{
		return this.driver;
	}
	String getUser()
	{
		return this.user;
	}
	String getPwd()
	{
		return this.pwd;
	}
	String getCadena()
	{
		return this.cadena;
	}
	public Connection getConexion()
	{ 
		return this.con; 
	}
	
	public Cls_conexion() {
		
		this.driver ="org.postgresql.Driver";
		this.user="postgres";
		this.pwd="RC2301";
		this.cadena="jdbc:postgresql://localhost:5432/Dimensional_Nacimientos";
		this.con=this.crearConexion();
		
	}
	
	Connection crearConexion(){
		try {
			Class.forName("org.postgresql.Driver");
			}
			catch (ClassNotFoundException e) {
			
			}
		
		try{
			Class.forName(getDriver()).newInstance();
 			Connection con = DriverManager.getConnection(getCadena(),getUser(),getPwd());
			return con;
		}
	catch(Exception ee)
	{
		System.out.println("Error: " + ee.getMessage());
		return null;
	}
	}
	

	public String ejecutar(String sql)
	{
	String error="";
	try
	{
	St=(Statement) getConexion().createStatement();
	St.execute(sql);
	error="Datos insertados";
	}
	catch(Exception ex)
	{
	error = ex.getMessage();
	}
	return(error);
	}



	public ResultSet consulta(String sql)
	{
	String error="";
	ResultSet reg=null;
	
	try
	{
	St=(Statement) getConexion().createStatement();
	reg=St.executeQuery(sql);
	
	
	}
	catch(Exception ee)
	{
	error = ee.getMessage();
	}
	return(reg);

	
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    // }
}

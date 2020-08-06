package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoGenero;
import model.Genero;

public class ControllerGenero {
	
	public ArrayList<Genero> ImprimeGenero() throws SQLException {
		DaoGenero daogenero;
		daogenero = new DaoGenero();
		return daogenero.FindAllGeneros();
	}
	
	public ArrayList<String> ImprimeGeneros() throws SQLException {
		DaoGenero daogenero;
		daogenero = new DaoGenero();
		return daogenero.getGeneros();
	}
	
	


}

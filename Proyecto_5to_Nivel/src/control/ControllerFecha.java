package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoFecha;
import model.Fecha;

public class ControllerFecha {
	
	public ArrayList<Fecha> ImprimeFechas() throws SQLException {
		DaoFecha daofecha;
		daofecha = new DaoFecha();
		return daofecha.FindAllFechas();
	}
	
	public ArrayList<String> ImprimeMeses() throws SQLException {
		DaoFecha daofecha;
		daofecha = new DaoFecha();
		return daofecha.getMeses();
	}
	
	public ArrayList<String> ImprimeAnios() throws SQLException {
		DaoFecha daofecha;
		daofecha = new DaoFecha();
		return daofecha.getYears();
	}

}

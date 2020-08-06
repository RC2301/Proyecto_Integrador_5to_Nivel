package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoProvincia;
import model.Provincia;

public class ControllerProvincia {
	
	public ArrayList<Provincia> ImprimeProvincia() throws SQLException {
		DaoProvincia daoprov;
		daoprov = new DaoProvincia();
		return daoprov.FindAllProvincias();
	}
	
	public ArrayList<String> ImprimeProvincias() throws SQLException {
		DaoProvincia daoprov;
		daoprov = new DaoProvincia();
		return daoprov.getProvincias();
	}

}

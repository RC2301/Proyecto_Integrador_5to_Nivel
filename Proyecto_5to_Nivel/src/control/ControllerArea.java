package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoArea;
import model.Area;


public class ControllerArea {
	
	public ArrayList<Area> ImprimeArea() throws SQLException {
		DaoArea daoarea;
		daoarea = new DaoArea();
		return daoarea.FindAllAreas();
	}
	
	public ArrayList<String> ImprimeAreas() throws SQLException {
		DaoArea daoarea;
		daoarea = new DaoArea();
		return daoarea.getAreas();
	}

}

package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoEtnia;
import model.Etnia;


public class ControllerEtnia {
	
	public ArrayList<Etnia> ImprimeEtnia() throws SQLException {
		DaoEtnia daoetnia;
		daoetnia = new DaoEtnia();
		return daoetnia.FindAllEtnias();
	}
	
	public ArrayList<String> ImprimeEtnias() throws SQLException {
		DaoEtnia daoetnia;
		daoetnia = new DaoEtnia();
		return daoetnia.getEtnias();
	}

}

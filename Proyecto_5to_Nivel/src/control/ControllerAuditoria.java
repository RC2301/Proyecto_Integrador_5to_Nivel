package control;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.DaoAuditoria;
import model.Auditoria;


public class ControllerAuditoria {

	public ArrayList<Auditoria> ImprimeTb_Auditoria() throws SQLException {
		DaoAuditoria daoauditoria;
		daoauditoria= new DaoAuditoria();
		return daoauditoria.FindAllAuditoria();
	}

}

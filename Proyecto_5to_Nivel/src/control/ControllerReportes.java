package control;

import java.sql.SQLException;
import java.util.List;
import dao.DaoReportes;
import model.DatosReportes;


public class ControllerReportes {
	
	public List<DatosReportes> ImprimePaisxTotalA(int fechain,int fechafin,String provincia) throws SQLException {
		DaoReportes daoreportes;
		daoreportes = new DaoReportes();
		return daoreportes.consultaPxAnioTotal(fechain, fechafin, provincia);
	}
	
	public List<DatosReportes> ImprimePaisxAnio(int fechain,int fechafin,String provincia) throws SQLException {
		DaoReportes daoreportes;
		daoreportes = new DaoReportes();
		return daoreportes.consultaPxAnio(fechain, fechafin, provincia);
	}

}

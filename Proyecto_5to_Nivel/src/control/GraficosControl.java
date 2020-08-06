package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

import dao.DaoEtnia;
import dao.DaoFecha;
import dao.DaoProvincia;
import dao.DaoReportes;
import model.DatosReportes;
import model.ReportesInt;

@Named("graficosControl")
@ViewScoped
public class GraficosControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codProvincia;
	private String codMes;
	private String codEtnia;
	private String resultado;
	private Integer anio1;
	private Integer anio2;
	private List<SelectItem> listaProvincia;
	private List<SelectItem> listaAnios;
	private List<SelectItem> listaMes;
	private List<SelectItem> listaEtnia;
	private PieChartModel torta;
	private PieChartModel torta2;
	private BarChartModel barra;
	private HorizontalBarChartModel horizontalBarModel;
	private List<DatosReportes> lista;
	List<DatosReportes> reporte;
	List<DatosReportes> reportecron;
	List<ReportesInt> reportegen;
	List<DatosReportes> reporteetnia;
	private List<ReportesInt> hombrexan;
	private List<ReportesInt> mujerxan;

	@PostConstruct
	private void init() {
		listaProvincia = new ArrayList<SelectItem>();
		listaMes = new ArrayList<SelectItem>();
		listaEtnia = new ArrayList<SelectItem>();
		listaAnios = new ArrayList<>();
		DaoProvincia daoProvincia = new DaoProvincia();
		DaoFecha daoFecha = new DaoFecha();
		DaoEtnia daoEtnia = new DaoEtnia();
		listaProvincia = daoProvincia.obtenerProvincias();
		listaAnios = daoFecha.obtenerYears();
		listaMes = daoFecha.ObtenerMeses();
		listaEtnia = daoEtnia.obtenerEtnias();

	}

	public void buscar() {
		try {
			DaoReportes daoReportes = new DaoReportes();
			reporte = daoReportes.consultaPxAnio(anio1, anio2, codProvincia);
			if (codProvincia.equalsIgnoreCase("25")) {
				reporte = daoReportes.consultaPxAnio(anio1, anio2);
				graficar();
			}
			resultado = "Proceso ejecutado";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarCron() {
		try {
			DaoReportes daoReportes = new DaoReportes();
			reportecron = daoReportes.mesxan(anio1, anio2, codMes);
			if (codMes.equalsIgnoreCase("13")) {
				reportecron = daoReportes.mesxan(anio1, anio2);
				graficarBarra();
			}
			resultado = "Proceso ejecutado";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarGen() {
		resultado = "Proceso ejecutado";
		graficarGenero();
	}
	
	public void buscarEtnia() {
		try {
			DaoReportes daoReportes = new DaoReportes();
			reporteetnia = daoReportes.etniaxAnio(anio1, anio2, codEtnia);
			if (codEtnia.equalsIgnoreCase("10")) {
				reporteetnia = daoReportes.etniaxAnio(anio1, anio2);
				graficarEtnia();
			}
			resultado = "Proceso ejecutado";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void graficar() {
		torta = new PieChartModel();
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaPxAnio(anio1, anio2);

		for (DatosReportes dr : lista) {
			torta.set(dr.getDatos(), dr.getContador());
		}

		torta.setTitle("Provincias vs Años");
		torta.setLegendPosition("e");
		torta.setFill(true);
		torta.setShowDataLabels(true);
		torta.setDiameter(300);

	}
	
	public void graficarEtnia() {
		torta2 = new PieChartModel();
		DaoReportes dao = new DaoReportes();
		lista = dao.etniaxAnio(anio1, anio2);

		for (DatosReportes dr : lista) {
			torta2.set(dr.getDatos(), dr.getContador());
		}

		torta2.setTitle("Etnia vs Años");
		torta2.setLegendPosition("e");
		torta2.setFill(true);
		torta2.setShowDataLabels(true);
		torta2.setDiameter(300);
	}
	

	public void graficarBarra() {
		DaoReportes dao = new DaoReportes();
		lista = dao.mesxan(anio1, anio2);
		barra = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set(lista.get(i).getDatos(), lista.get(i).getContador());
			barra.addSeries(serie);
			
		}
		
		barra.setTitle("Nacimientos por Meses y Año");
		barra.setLegendPosition("ne");
		Axis x = barra.getAxis(AxisType.X);
		x.setLabel("Meses");
		Axis y = barra.getAxis(AxisType.Y);
		y.setLabel("Número de Nacimientos");
		y.setMin(0);
		y.setMax(4000);

	}

	public void graficarGenero() {
		DaoReportes dao = new DaoReportes();
		horizontalBarModel = new HorizontalBarChartModel();
		ChartSeries boys = new ChartSeries();
		hombrexan = dao.hombrexanio(anio1, anio2);
		mujerxan = dao.mujerxanio(anio1, anio2);
		boys.setLabel("Hombres");
		for (int i = 0; i < hombrexan.size(); i++) {

			boys.set(hombrexan.get(i).getYear(), hombrexan.get(i).getContador());
		}

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Mujeres");
		for (int i = 0; i < mujerxan.size(); i++) {

			girls.set(mujerxan.get(i).getYear(), mujerxan.get(i).getContador());
		}

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);

		horizontalBarModel.setTitle("Género Vs Años");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Nacimientos");
		xAxis.setMin(0);
		xAxis.setMax(2000);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Género");

	}

	public List<SelectItem> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<SelectItem> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public GraficosControl() {
		// TODO Auto-generated constructor stub
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<SelectItem> getListaAnios() {
		return listaAnios;
	}

	public void setListaAnios(List<SelectItem> listaAnios) {
		this.listaAnios = listaAnios;
	}

	public Integer getAnio1() {
		return anio1;
	}

	public void setAnio1(Integer anio1) {
		this.anio1 = anio1;
	}

	public Integer getAnio2() {
		return anio2;
	}

	public void setAnio2(Integer anio2) {
		this.anio2 = anio2;
	}

	public List<DatosReportes> getReporte() {
		return reporte;
	}

	public void setReporte(List<DatosReportes> reporte) {
		this.reporte = reporte;
	}

	public PieChartModel getTorta() {
		return torta;
	}

	public void setTorta(PieChartModel torta) {
		this.torta = torta;
	}

	public List<DatosReportes> getLista() {
		return lista;
	}

	public void setLista(List<DatosReportes> lista) {
		this.lista = lista;
	}

	public List<SelectItem> getListaMes() {
		return listaMes;
	}

	public void setListaMes(List<SelectItem> listaMes) {
		this.listaMes = listaMes;
	}

	public String getCodMes() {
		return codMes;
	}

	public void setCodMes(String codMes) {
		this.codMes = codMes;
	}

	public List<DatosReportes> getReportecron() {
		return reportecron;
	}

	public void setReportecron(List<DatosReportes> reportecron) {
		this.reportecron = reportecron;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	public List<ReportesInt> getHombrexan() {
		return hombrexan;
	}

	public void setHombrexan(List<ReportesInt> hombrexan) {
		this.hombrexan = hombrexan;
	}

	public List<ReportesInt> getMujerxan() {
		return mujerxan;
	}

	public void setMujerxan(List<ReportesInt> mujerxan) {
		this.mujerxan = mujerxan;
	}

	public List<ReportesInt> getReportegen() {
		return reportegen;
	}

	public void setReportegen(List<ReportesInt> reportegen) {
		this.reportegen = reportegen;
	}

	public List<SelectItem> getListaEtnia() {
		return listaEtnia;
	}

	public void setListaEtnia(List<SelectItem> listaEtnia) {
		this.listaEtnia = listaEtnia;
	}

	public String getCodEtnia() {
		return codEtnia;
	}

	public void setCodEtnia(String codEtnia) {
		this.codEtnia = codEtnia;
	}

	public List<DatosReportes> getReporteetnia() {
		return reporteetnia;
	}

	public void setReporteetnia(List<DatosReportes> reporteetnia) {
		this.reporteetnia = reporteetnia;
	}

	public PieChartModel getTorta2() {
		return torta2;
	}

	public void setTorta2(PieChartModel torta2) {
		this.torta2 = torta2;
	}

}

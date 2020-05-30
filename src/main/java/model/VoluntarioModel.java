package model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import bussines.IVoluntarioService;
import data.Voluntario;

@ManagedBean
@ViewScoped
public class VoluntarioModel {

	@EJB
	private IVoluntarioService iVoluntarioService;	


	private List<Voluntario> voluntarios;
	private MapModel markerModel;
	private MapModel markersModel;
	private long id;
	private Voluntario voluntario;
	private String Nombre;
	private String Celular;
	private String Email;
	private String Latitud;
	private String Longitud;
	private Boolean Vehiculo;
	private String TipoVehiculo;
	private String PicoPlaca;
	private String PicoCedula;

	@PostConstruct
	public void init() {

		try {
			this.voluntarios = this.iVoluntarioService.getList();

			markersModel = new DefaultMapModel();

			//Shared coordinates

			for(int i=0; i<this.voluntarios.size();i++) {
				double lat = Double.parseDouble(this.voluntarios.get(i).getLatitud());
				double lon = Double.parseDouble(this.voluntarios.get(i).getLongitud());

				LatLng coord1 = new LatLng(lat, lon);
				markersModel.addOverlay(new Marker(coord1, this.voluntarios.get(i).getNombre()));
			}

		} catch(Exception e) {}
	}

	public void postLoad() {
		try {
			//Voluntario voluntario = new Voluntario();

			this.voluntario = this.iVoluntarioService.get(id);

			markerModel = new DefaultMapModel();

			double lat = Double.parseDouble(this.voluntario.getLatitud());
			double lon = Double.parseDouble(this.voluntario.getLongitud());

			LatLng coord1 = new LatLng(lat, lon);

			markerModel.addOverlay(new Marker(coord1, this.voluntario.getNombre()));


		} catch(Exception e) {}
	}



	public List<Voluntario> getVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(List<Voluntario> voluntarios) {
		this.voluntarios = voluntarios;
	}


	public MapModel getMarkerModel() {
		return markerModel;
	}


	public void setMarkerModel(MapModel markerModel) {
		this.markerModel = markerModel;
	}




	public MapModel getMarkersModel() {
		return markersModel;
	}

	public void setMarkersModel(MapModel markersModel) {
		this.markersModel = markersModel;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

	public IVoluntarioService getiVoluntarioService() {
		return iVoluntarioService;
	}

	public void setiVoluntarioService(IVoluntarioService iVoluntarioService) {
		this.iVoluntarioService = iVoluntarioService;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLatitud() {
		return Latitud;
	}

	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public void setLongitud(String longitud) {
		Longitud = longitud;
	}

	public Boolean getVehiculo() {
		return Vehiculo;
	}

	public void setVehiculo(Boolean vehiculo) {
		Vehiculo = vehiculo;
	}

	public String getTipoVehiculo() {
		return TipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}

	public String getPicoPlaca() {
		return PicoPlaca;
	}

	public void setPicoPlaca(String picoPlaca) {
		PicoPlaca = picoPlaca;
	}

	public String getPicoCedula() {
		return PicoCedula;
	}

	public void setPicoCedula(String picoCedula) {
		PicoCedula = picoCedula;
	}

}

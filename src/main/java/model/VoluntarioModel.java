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
	private long id;

	@PostConstruct
	public void init() {

		try {
			this.voluntarios = this.iVoluntarioService.getList();

		} catch(Exception e) {}
	}

	public void postLoad() {
		try {
			Voluntario voluntario = new Voluntario();

			voluntario = this.iVoluntarioService.get(id);

			markerModel = new DefaultMapModel();

			LatLng coord1 = new LatLng(Integer.parseInt(voluntario.getLatitud()), Integer.parseInt(voluntario.getLongitud()));


			markerModel.addOverlay(new Marker(coord1, voluntario.getNombre()));


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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}




}

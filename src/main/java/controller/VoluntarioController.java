package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bussines.IVoluntarioService;
import model.VoluntarioModel;
import data.Voluntario;

@ManagedBean
@ViewScoped
public class VoluntarioController {
	
	@ManagedProperty(value="#{voluntarioModel}")
	private VoluntarioModel model;
	
	@EJB
	IVoluntarioService iVolunatarioService;

	
	public String save() {
		
		Voluntario voluntario = new Voluntario();
		voluntario.setNombre(model.getNombre());
		voluntario.setCelular(model.getCelular());
		voluntario.setEmail(model.getEmail());
		voluntario.setTipoVehiculo(model.getTipoVehiculo());
		voluntario.setLatitud(model.getLatitud());
		voluntario.setLongitud(model.getLongitud());
		
		
		try {
			iVolunatarioService.save(voluntario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "index";
		
		
	}


	public VoluntarioModel getModel() {
		return model;
	}


	public void setModel(VoluntarioModel model) {
		this.model = model;
	}
	
	
	
}

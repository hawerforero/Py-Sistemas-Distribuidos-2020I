package bussines;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import data.Voluntario;
import data.VoluntarioDAO;

/**
 * Session Bean implementation class VoluntarioService
 */
@Stateless
@LocalBean
public class VoluntarioService implements IVoluntarioService {
	
	
	@Inject
	private VoluntarioDAO voluntarioDAO;
	
    public VoluntarioService() {
       
    }

	public List<Voluntario> getList() {
		
		return voluntarioDAO.findAll();
	}

	@Override
	public Voluntario get(long id) {

		return voluntarioDAO.find(id);
	}

	@Override
	public void save(Voluntario voluntario) {
		voluntarioDAO.save(voluntario);
	}

}

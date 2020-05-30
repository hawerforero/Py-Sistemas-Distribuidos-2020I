package bussines;

import java.util.List;

import javax.ejb.Local;

import data.Voluntario;

@Local
public interface IVoluntarioService {
	
	public List<Voluntario> getList();
	public Voluntario get(long id);
	public void save(Voluntario voluntario);

}

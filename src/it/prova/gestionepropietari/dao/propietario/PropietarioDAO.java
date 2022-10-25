package it.prova.gestionepropietari.dao.propietario;


import it.prova.gestionepropietari.dao.IBaseDAO;
import it.prova.gestionepropietari.model.Propietario;


public interface PropietarioDAO extends IBaseDAO<Propietario>{
	
	public Propietario getEagerPropietari(Long id) throws Exception;
	
	public int contAllPropietariWhereAnnoImmatricolazioneFrom(int input)throws Exception;
}

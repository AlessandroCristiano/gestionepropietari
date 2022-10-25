package it.prova.gestionepropietari.dao.automobile;

import java.util.List;

import it.prova.gestionepropietari.dao.IBaseDAO;
import it.prova.gestionepropietari.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile>{
	
	public List<Automobile> giveAutomobiliProprietariWhoseCodiceStartWhit(String input) throws Exception;
	public List<Automobile> allAutomobiliWhitErrors()throws Exception;

}

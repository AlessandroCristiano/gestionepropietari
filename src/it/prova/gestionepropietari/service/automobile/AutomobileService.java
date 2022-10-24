package it.prova.gestionepropietari.service.automobile;

import java.util.List;

import it.prova.gestionepropietari.dao.automobile.AutomobileDAO;
import it.prova.gestionepropietari.model.Automobile;


public interface AutomobileService {

	public List<Automobile> listAllAbitanti() throws Exception;

	public Automobile caricaSingolaAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;
	
	
	
	//#############################
	
	
	public void setAbitanteDAO(AutomobileDAO automobileDAO);
}
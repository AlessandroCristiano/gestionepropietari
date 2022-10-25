package it.prova.gestionepropietari.service.propietario;

import java.util.List;

import it.prova.gestionepropietari.model.Propietario;
import it.prova.gestionepropietari.dao.propietario.PropietarioDAO;



public interface PropietarioService {
	
	public List<Propietario> listAllPropietari() throws Exception;

	public Propietario caricaSingoloPropietario(Long id) throws Exception;
	
	public Propietario caricaSingoloPropietarioConAutomobili(Long id) throws Exception;

	public void aggiorna(Propietario propietarioInstance) throws Exception;

	public void inserisciNuovo(Propietario propietarioInstance) throws Exception;

	public void rimuovi(Propietario propietarioInstance) throws Exception;
	
	public int contaQuantiProprietariHannoAutoImmatricolateDal(int input) throws Exception;
	
	public void setPropietarioDAO(PropietarioDAO propietarioDAO);

}

package it.prova.gestionepropietari.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepropietari.dao.automobile.AutomobileDAO;
import it.prova.gestionepropietari.model.Automobile;
import it.prova.municipioabitantejpa.dao.EntityManagerUtil;

public class AutomobileServiceImpl implements AutomobileService{

	@Override
	public List<Automobile> listAllAbitanti() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAbitanteDAO(AutomobileDAO automobileDAO) {
		// TODO Auto-generated method stub
		
	}

}

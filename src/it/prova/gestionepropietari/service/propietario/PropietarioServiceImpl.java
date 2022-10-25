package it.prova.gestionepropietari.service.propietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepropietari.dao.EntityManagerUtil;
import it.prova.gestionepropietari.dao.propietario.PropietarioDAO;
import it.prova.gestionepropietari.model.Propietario;

public class PropietarioServiceImpl implements PropietarioService{
	
	private PropietarioDAO propietarioDAO;

	@Override
	public void setPropietarioDAO(PropietarioDAO propietarioDAO) {
		this.propietarioDAO=propietarioDAO;
	}

	@Override
	public List<Propietario> listAllPropietari() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return propietarioDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Propietario caricaSingoloPropietario(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return propietarioDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Propietario caricaSingoloPropietarioConAutomobili(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return propietarioDAO.getEagerPropietari(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Propietario propietarioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			propietarioDAO.update(propietarioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Propietario propietarioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			propietarioDAO.insert(propietarioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Propietario propietarioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			propietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			propietarioDAO.delete(propietarioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public int contaQuantiProprietariHannoAutoImmatricolateDal(int input) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					propietarioDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return propietarioDAO.contAllPropietariWhereAnnoImmatricolazioneFrom(input);
							
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}
}

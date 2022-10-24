package it.prova.gestionepropietari.dao.propietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepropietari.model.Propietario;

public class PropietarioDAOImpl implements PropietarioDAO {
	private EntityManager entityManager;

	@Override
	public List<Propietario> list() throws Exception {
		return entityManager.createQuery("from Propietario", Propietario.class).getResultList();
	}

	@Override
	public Propietario get(Long id) throws Exception {
		return entityManager.find(Propietario.class, id);
	}

	@Override
	public void update(Propietario propietarioIstance) throws Exception {
		if (propietarioIstance == null) {
			throw new Exception("Problema valore in input");
		}

		propietarioIstance = entityManager.merge(propietarioIstance);

	}

	@Override
	public void insert(Propietario propietarioIstance) throws Exception {
		if (propietarioIstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(propietarioIstance);
	}

	@Override
	public void delete(Propietario propietarioIstance) throws Exception {
		if (propietarioIstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(propietarioIstance));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

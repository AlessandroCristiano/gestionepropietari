package it.prova.gestionepropietari.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionepropietari.model.Automobile;


public class AutomobileDAOImpl implements AutomobileDAO {
	private EntityManager entityManager;

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile automobileIstance) throws Exception {
		if (automobileIstance == null) {
			throw new Exception("Problema valore in input");
		}

		automobileIstance = entityManager.merge(automobileIstance);
	}

	@Override
	public void insert(Automobile automobileIstance) throws Exception {
		if (automobileIstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(automobileIstance);

	}

	@Override
	public void delete(Automobile automobileIstance) throws Exception {
		if (automobileIstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(automobileIstance));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Automobile> giveAutomobiliProprietariWhoseCodiceStartWhit(String input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<Automobile> query = entityManager.createQuery(
				"from Automobile a left join fetch a.propietario where codicefiscale like ?1", Automobile.class);
		query.setParameter(1, input + "%");

		return query.getResultList();
	}

	@Override
	public List<Automobile> allAutomobiliWhitErrors() throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery(
				"from Automobile a left join fetch a.propietario where year(current_date()) - year(datadinascita) <= 18", Automobile.class);
		return query.getResultList();
	}
}

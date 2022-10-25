package it.prova.gestionepropietari.dao.propietario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionepropietari.model.Automobile;
import it.prova.gestionepropietari.model.Propietario;


public class PropietarioDAOImpl implements PropietarioDAO {
	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
	public Propietario getEagerPropietari(Long id) throws Exception {
		// join restituirebbe solo i municipi con abitanti (LAZY)
		// join fetch come sopra ma valorizza anche la lista di abitanti (EAGER)
		// left join fetch come sopra ma cerca anche tra i municipi privi di abitanti
		// (EAGER)
		TypedQuery<Propietario> query = entityManager
				.createQuery("from Propietario p left join fetch p.automobili where p.id = ?1", Propietario.class);
		query.setParameter(1, id);

		// return query.getSingleResult() ha il problema che se non trova elementi
		// lancia NoResultException
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public int contAllPropietariWhereAnnoImmatricolazioneFrom(int input) throws Exception {
		if(input<0) 
			throw new Exception("Valore input non valido");
		TypedQuery<Long> query = entityManager.createQuery("select count(distinct propietario_id) from Automobile where annoimmatricolazione >= ?1", Long.class);
		query.setParameter(1, input);
		return query.getSingleResult().intValue();
		
	}
}

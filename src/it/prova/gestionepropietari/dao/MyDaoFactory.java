package it.prova.gestionepropietari.dao;

import it.prova.gestionepropietari.dao.automobile.AutomobileDAO;
import it.prova.gestionepropietari.dao.automobile.AutomobileDAOImpl;
import it.prova.gestionepropietari.dao.propietario.PropietarioDAO;
import it.prova.gestionepropietari.dao.propietario.PropietarioDAOImpl;
import it.prova.gestionepropietari.service.automobile.AutomobileService;
import it.prova.gestionepropietari.service.propietario.PropietarioService;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static AutomobileDAO  automobileDAOInstance = null;
	private static PropietarioDAO propietarioDAOInstance = null;
	

	public static AutomobileDAO getAutomobileDAOInstance() {
		if (automobileDAOInstance == null)
			automobileDAOInstance = new AutomobileDAOImpl();
		return automobileDAOInstance;
	}

	public static PropietarioDAO getPropietarioDAOInstance(){
		if(propietarioDAOInstance == null)
			propietarioDAOInstance= new PropietarioDAOImpl();
		return propietarioDAOInstance;
	}

}

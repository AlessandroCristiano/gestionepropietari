package it.prova.gestionepropietari.service;

import it.prova.gestionepropietari.dao.MyDaoFactory;
import it.prova.gestionepropietari.service.automobile.AutomobileService;
import it.prova.gestionepropietari.service.automobile.AutomobileServiceImpl;
import it.prova.gestionepropietari.service.propietario.PropietarioService;
import it.prova.gestionepropietari.service.propietario.PropietarioServiceImpl;

public class MyServiceFactory {
	
	// rendiamo le istanze restituite SINGLETON
	private static AutomobileService automobileServiceInstance = null;
	private static PropietarioService propietarioServiceInstance = null;

	public static AutomobileService getAutomobileServiceInstance() {
		if (automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
			automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
		}
		return automobileServiceInstance;
	}

	public static PropietarioService getPropietarioServiceInstance() {
		if (propietarioServiceInstance == null) {
			propietarioServiceInstance = new PropietarioServiceImpl();
			propietarioServiceInstance.setPropietarioDAO(MyDaoFactory.getPropietarioDAOInstance());
		}
		return propietarioServiceInstance;
	}

}

package it.prova.gestionepropietari.test;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import it.prova.gestionepropietari.dao.EntityManagerUtil;
import it.prova.gestionepropietari.model.Automobile;
import it.prova.gestionepropietari.model.Propietario;
import it.prova.gestionepropietari.service.MyServiceFactory;
import it.prova.gestionepropietari.service.automobile.AutomobileService;
import it.prova.gestionepropietari.service.propietario.PropietarioService;



public class TestPropietarioAutomobile {

	public static void main(String[] args) {

		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		PropietarioService propietarioService = MyServiceFactory.getPropietarioServiceInstance();

		try {

//			System.out.println(
//					"In tabella Propietario ci sono " + propietarioService.listAllPropietari() + " elementi.");
//			System.out.println(
//					"In tabella Automobile ci sono " + automobileService.listAllAutomobili() + " elementi.");
//			testInserisciAutomobile(automobileService);
//			testInserisciPropietario(propietarioService);
//			testAggiornaAutomobile(automobileService);
//			testAggiornapropietario(propietarioService);
//			testRimuoviAutomobile(automobileService);
//			testRimuoviPropietario(propietarioService);
//			testContaQuantiProprietariPossiedonoAutomobiliImmatricolateDa(propietarioService, automobileService);
//			testListaAutomobiliProprietariCodiceFiscaleIniziaCon(automobileService, propietarioService);
			testListaAllErrori(automobileService, propietarioService);
			

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
	
	private static void testInserisciAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");
		// creo una nuova automobile
		Automobile nuovaAutomobile = new Automobile("Nissan", "Gtr", "Fb827d", 2022);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente ");

		// salvo
		automobileService.inserisciNuovo(nuovaAutomobile);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}
	private static void testInserisciPropietario(PropietarioService propietarioService) throws Exception {
		System.out.println(".......testInserisciPropietario inizio.............");
		// creo un nuovo propietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2022");
		Propietario nuovoPropietario = new Propietario("Luca", "Benigno", "FgBDRT125", dataNascita);
	
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");
		List<Propietario> listaElementi = propietarioService.listAllPropietari();
		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");

		System.out.println(".......testInserisciPropietario fine: PASSED.............");
	}
	
//	private static void testCaricaSingolaAutomobile(AutomobileService automobileService) throws Exception {
//		System.out.println(".......testCaricaSingolaAutomobile inizio.............");
//		
//	
//
//		System.out.println(".......testCaricaSingolaAutomobile fine: PASSED.............");
//	}
	
	
	private static void testAggiornaAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testAggiornaAutomobile inizio.............");
		// creo una nuova automobile
		Automobile nuovaAutomobile = new Automobile("Nissan", "Gtr", "Fb827d", 2022);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente ");

		// salvo
		automobileService.inserisciNuovo(nuovaAutomobile);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		 System.out.println("Before");
		 System.out.println(automobileService.listAllAutomobili());
		 nuovaAutomobile.setMarca("ferrari");
		 automobileService.aggiorna(nuovaAutomobile);
		
		 System.out.println("After");
		 System.out.println(automobileService.listAllAutomobili());
		 automobileService.rimuovi(nuovaAutomobile);

		System.out.println(".......testAggiornaAutomobile fine: PASSED.............");

	}
	
	private static void testAggiornapropietario(PropietarioService propietarioService) throws Exception {
		System.out.println(".......testAggiornapropietario inizio.............");
		// creo un nuovo propietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2022");
		Propietario nuovoPropietario = new Propietario("Luca", "Benigno", "FgBDRT125", dataNascita);
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");

		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");

		System.out.println("Before");
		//System.out.println(propietarioService.listAllPropietari());
		nuovoPropietario.setNome("Franco");
		propietarioService.aggiorna(nuovoPropietario);

		System.out.println("After");
		//System.out.println(propietarioService.listAllPropietari());
		propietarioService.rimuovi(nuovoPropietario);

		System.out.println(".......testAggiornapropietario fine: PASSED.............");

	}
	
	private static void testRimuoviAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testRimuoviAutomobile inizio.............");
		// creo una nuova automobile
		Automobile nuovaAutomobile = new Automobile("ford", "jhg", "SADWFG", 2017);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testRimuoviAutomobile fallito: record già presente ");

		// salvo
		automobileService.inserisciNuovo(nuovaAutomobile);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testRimuoviAutomobile fallito ");
		System.out.println("BEFORE");
		System.out.println(automobileService.listAllAutomobili());
		
		automobileService.rimuovi(nuovaAutomobile);
		System.out.println("AFTER");
		System.out.println(automobileService.listAllAutomobili());

		System.out.println(".......testRimuoviAutomobile fine: PASSED.............");
	}
	
	private static void testRimuoviPropietario(PropietarioService propietarioService) throws Exception {
		System.out.println(".......testRimuoviPropietario inizio.............");
		// creo un nuovo propietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2022");
		Propietario nuovoPropietario = new Propietario("Luca", "Benigno", "FgBDRT125", dataNascita);
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");

		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");
		System.out.println("BEFORE");
		System.out.println(propietarioService.listAllPropietari());

		propietarioService.rimuovi(nuovoPropietario);
		System.out.println("AFTER");
		System.out.println(propietarioService.listAllPropietari());

		System.out.println(".......testRimuoviPropietario fine: PASSED.............");
	}	
	
	private static void testContaQuantiProprietariPossiedonoAutomobiliImmatricolateDa(PropietarioService propietarioService, AutomobileService automobileService) throws Exception{
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2022");
		Propietario nuovoPropietario = new Propietario("Luca", "Benigno", "FgBDRT125", dataNascita);
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");

		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");
		
		Automobile nuovaAutomobile = new Automobile("ford", "jhg", "SADWFG", 2017);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testRimuoviAutomobile fallito: record già presente ");
		
		nuovaAutomobile.setPropietario(nuovoPropietario);
	
		automobileService.inserisciNuovo(nuovaAutomobile);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testRimuoviAutomobile fallito ");
		
		int result = propietarioService.contaQuantiProprietariHannoAutoImmatricolateDal(2000);
		if(result!=1)
			throw new RuntimeException("Test fallito ");
		automobileService.rimuovi(nuovaAutomobile);
		propietarioService.rimuovi(nuovoPropietario);
	}
	private static void testListaAutomobiliProprietariCodiceFiscaleIniziaCon(AutomobileService automobileService, PropietarioService propietarioService) throws Exception{
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2022");
		Propietario nuovoPropietario = new Propietario("Luca", "Benigno", "DgBDRT125", dataNascita);
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");

		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");
		
		List<Propietario> listaPropietari= propietarioService.listAllPropietari();
		if (listaPropietari.isEmpty())
			throw new RuntimeException("testi fallito: non ci sono proprietari a cui collegarci ");
		
		
		
		Automobile nuovaAutomobile = new Automobile("ford", "jhg", "SADWFG", 2017);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testRimuoviAutomobile fallito: record già presente ");
		
		nuovaAutomobile.setPropietario(listaPropietari.get(0));
		
		automobileService.inserisciNuovo(nuovaAutomobile);
		
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testRimuoviAutomobile fallito ");
		
		List<Automobile> listaAuto = automobileService.listaAutomobiliProprietariCodiceFiscaleIniziaCon("D");
		if(listaAuto.size()!=1)
			throw new RuntimeException("testAutomobileConPropietario fallito ");
		
		automobileService.rimuovi(nuovaAutomobile);
		propietarioService.rimuovi(nuovoPropietario);
	}
	
	private static void testListaAllErrori(AutomobileService automobileService, PropietarioService propietarioService) throws Exception{
		
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-10-2012");
		Propietario nuovoPropietario = new Propietario("laura", "piccolo", "SDWOASC", dataNascita);
		if (nuovoPropietario.getId() != null)
			throw new RuntimeException("testInserisciPropietario fallito: record già presente ");

		// salvo
		propietarioService.inserisciNuovo(nuovoPropietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovoPropietario.getId() == null)
			throw new RuntimeException("testInserisciPropietario fallito ");
		
		List<Propietario> listaPropietari= propietarioService.listAllPropietari();
		if (listaPropietari.isEmpty())
			throw new RuntimeException("testi fallito: non ci sono proprietari a cui collegarci ");
		
		
		Automobile nuovaAutomobile = new Automobile("Ferrari", "Faster", "SADWFG", 2000);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testRimuoviAutomobile fallito: record già presente ");
		
		nuovaAutomobile.setPropietario(listaPropietari.get(0));
		
		automobileService.inserisciNuovo(nuovaAutomobile);
		
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testRimuoviAutomobile fallito ");
		
		List<Automobile> listaAuto = automobileService.listaAllErrori();
		if(listaAuto.size()!=1)
			throw new RuntimeException("testAutomobileConErrori fallito ");
		
		automobileService.rimuovi(nuovaAutomobile);
		propietarioService.rimuovi(nuovoPropietario);
	}
	
}

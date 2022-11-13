package org.sebaoune.Main;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.sebaoune.model.Commune;
import org.sebaoune.service.imlementation.CommuneImporterImpl;
import org.sebaoune.service.imlementation.DepartementImportImpl;
import org.sebaoune.service.imlementation.MaireImporterImpl;

public class Main {
	private static final String PATH = "data/communes.csv";
	private static final String PATH_DEPARTEMENT = "data/departement.csv";
	private static final String PATH_MAIRE = "data/maires-17-06-2014.csv";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-jpa-pu");
		EntityManager em = emf.createEntityManager();
/*
		MaireImporterImpl MIImpl = new MaireImporterImpl(em);
		MIImpl.MaireImport(PATH_MAIRE);

		DepartementImportImpl DIImpl = new DepartementImportImpl(em);
		DIImpl.DepartementImport(PATH_DEPARTEMENT);

		CommuneImporterImpl CIImpl = new CommuneImporterImpl(em);
		CIImpl.importCommunes(PATH);

		String jpql = "SELECT count(*) FROM Commune ";
		Query query = (Query) em.createQuery(jpql);
		Long resultatCountCommune = (Long) query.getSingleResult();
		System.out.println(resultatCountCommune);
		

		String jpql1 = "Select f from Maire as f order by f.naissance";
		Query query1 = (Query) em.createQuery(jpql1);
		List<Object[]> resultatOlderMair =  query1.getResultList();
			System.out.println(resultatOlderMair.get(0));*/
		
		String jpql2 = "SELECT count(*) FROM Maire";
		String jpql3 = "SELECT nompsn FROM Maire WHERE civility = 'F'";
		Query query2 = (Query) em.createQuery(jpql2);
		Query query3 = (Query) em.createQuery(jpql3);

		Long resultatCountMaire =(Long)  query2.getSingleResult();
		List<Object[]> ListFemme = query3.getResultList();
		
		int resultatCountFemme = ListFemme.size();
		System.out.println(resultatCountMaire);
		System.out.println(resultatCountFemme);
		var pocentagefemme = resultatCountFemme/resultatCountMaire.floatValue()*100;
		System.out.println("pocentagefemme :"+pocentagefemme+"%");
		
		
		
		System.out.println("j'ai tout terminer");

		

	}

}

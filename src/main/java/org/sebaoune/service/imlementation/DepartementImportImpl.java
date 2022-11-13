package org.sebaoune.service.imlementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;

import org.sebaoune.model.Commune;
import org.sebaoune.model.Departement;
import org.sebaoune.model.Maire;
import org.sebaoune.service.ImportDepartement;
import org.sebaoune.utils.DepartementUtils;
import org.sebaoune.utils.MaireUtils;

public class DepartementImportImpl implements ImportDepartement {

	private EntityManager em;

	public DepartementImportImpl(EntityManager em) {
		this.em = em;
	}

	List<Commune> Collcom = new ArrayList<Commune>();

	public static final String delimiter = ";";
	Departement d = new Departement();
	public static HashMap<String, Departement> DeparteentwithoutD = new HashMap<String, Departement>();

	@Override
	public void DepartementImport(String path) {
		// TODO Auto-generated method stub

		DepartementUtils DU = new DepartementUtils();
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			line = br.readLine();
			line = br.readLine();

			while ((line = br.readLine()) != null) {
				if (line.length() != 0) {
					d = DU.convertLineToDepartement.apply(line);
					DeparteentwithoutD.put(d.getCode_du_département(), d);
				}
			}

			for (Departement name : DeparteentwithoutD.values()) {
				em.getTransaction().begin();
				em.persist(name);
				em.getTransaction().commit();
			}
			/*CommuneImporterImpl.comununnewithoutD.forEach((key, value) -> {
				// Maire m1=MaireUtils.MaireINSEE.get(key);
				String key2 = key.substring(0, 2);
				System.out.println(key2);

				
				  DeparteentwithoutD.forEach( (k,v) -> {System.out.println(v);});
				  System.out.println(key);
				 

				Departement d1 = DeparteentwithoutD.get(key2);

				// System.out.println(key.charAt(0));

				if (key.startsWith(key2)) {
					System.out.println("je suis la ");
					Collcom.add(value);
				}

				
				 Collcom.forEach(name -> { System.out.println(name.getCodePostal()); });
				 
				em.getTransaction().begin();
				em.persist(new Commune(value.getCodeINSEE(), value.getNomCommune(), value.getCodePostal(),
						value.getLibelleAcheminement(), d1));
				em.getTransaction().commit();
			});*/
			// System.out.println(comununnewithoutD.size());

			br.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}

package org.sebaoune.service.imlementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.persistence.EntityManager;
import org.sebaoune.model.Commune;
import org.sebaoune.model.Departement;
import org.sebaoune.model.Maire;
import org.sebaoune.service.CommuneImporter;
import org.sebaoune.utils.CommuneUtils;
import org.sebaoune.utils.DepartementUtils;
import org.sebaoune.utils.MaireUtils;

public class CommuneImporterImpl implements CommuneImporter {

	public CommuneImporterImpl(EntityManager em) {
		this.em = em;
	}

	public static final String delimiter = ";";
	Commune c = new Commune();
	EntityManager em;
	public static HashMap<String, Commune> comununnewithoutD = new HashMap<String, Commune>();

	public void importCommunes(String path) {
		// TODO Auto-generated method stub
		CommuneUtils CU = new CommuneUtils();
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			line = br.readLine();
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				if (line.length() != 0) {
					c = CU.convertLineToCommune.apply(line);
					comununnewithoutD.put(c.getCodeINSEE(), c);
				}
			}

			comununnewithoutD.forEach((key, value) -> {
				// System.out.println(key);
				Maire m1 = MaireUtils.MaireINSEE.get(key);
				String key2 = key.substring(0, 2);
				//System.out.println(key2);
				Departement d1 = DepartementImportImpl.DeparteentwithoutD.get(key2);
				//Departement d1 = DepartementUtils.departementwithoutD.get(key);
				em.getTransaction().begin();
				em.persist(new Commune(value.getCodeINSEE(), value.getNomCommune(), value.getCodePostal(),
						value.getLibelleAcheminement(), m1, d1));
				em.getTransaction().commit();
			});
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

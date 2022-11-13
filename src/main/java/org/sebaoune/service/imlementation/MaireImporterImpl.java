package org.sebaoune.service.imlementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.persistence.*;
import org.sebaoune.model.Maire;
import org.sebaoune.service.ImportMaire;
import org.sebaoune.utils.CommuneUtils;
import org.sebaoune.utils.MaireUtils;

public class MaireImporterImpl implements ImportMaire {
	private EntityManager em;

	public MaireImporterImpl(EntityManager em) {
		this.em = em;
	}

	public static final String delimiter = ";";
	Maire d = new Maire();
	public HashMap<String, Maire> MairetwithoutD = new HashMap<String, Maire>();
	MaireUtils MU = new MaireUtils();
	CommuneUtils CU = new CommuneUtils();

	@Override
	public void MaireImport(String path) {
		// TODO Auto-generated method stub
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			line = br.readLine();
			line = br.readLine();

			while ((line = br.readLine()) != null) {
				if (line.length() != 0) {
					d = MU.convertLineToMaire.apply(line);
					MairetwithoutD.put(d.getNompsn(), d);
				}
			}

			for (Maire name : MairetwithoutD.values()) {
				em.getTransaction().begin();
				em.persist(name);
				em.getTransaction().commit();
			}
			// System.out.println(comununnewithoutD.size());

			br.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}

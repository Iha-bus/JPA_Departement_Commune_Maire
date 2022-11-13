package org.sebaoune.utils;

import org.sebaoune.model.Commune;
import java.util.HashMap;
import java.util.function.Function;

public class CommuneUtils {
	public static HashMap<String, Commune> CommuneINSEE = new HashMap<>();

	public Function<String, Commune> convertLineToCommune = line -> {

		String[] tabString = line.split(";");
		if (tabString[0].length() == 4)
			tabString[0] = "0" + tabString[0];
		// System.out.println("j'ai ajouter 0");
		String codeInsee = tabString[0];
		String nomCommune = tabString[1];
		String codePostal = tabString[2];
		String libelleAchivement = tabString[4];

		Commune com = new Commune(codeInsee, nomCommune, codePostal, libelleAchivement);
		CommuneINSEE.put(codeInsee, com);
		return com;
	};

}

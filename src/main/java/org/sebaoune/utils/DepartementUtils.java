package org.sebaoune.utils;

import java.util.HashMap;
import java.util.function.Function;
import org.sebaoune.model.Departement;

public class DepartementUtils {
	public static HashMap<String, Departement> departementwithoutD = new HashMap<String, Departement>();
	public Function<String, Departement> convertLineToDepartement = line -> {
		String[] tabString = line.split(";");
		if (tabString[0].length() == 1)
			tabString[0] = "0" + tabString[0];
		String Code_du_département = tabString[0];
		String Libellé_de_département = tabString[1];
		Departement dep = new Departement(Code_du_département, Libellé_de_département);
		departementwithoutD.put(tabString[0], dep);
		return dep;
	};

}

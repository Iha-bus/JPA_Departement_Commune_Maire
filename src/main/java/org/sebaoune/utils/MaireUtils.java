package org.sebaoune.utils;

import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import org.sebaoune.model.Civility;
import org.sebaoune.model.Maire;

public class MaireUtils {
	public static HashMap<String, Maire> MaireINSEE = new HashMap<String, Maire>();

	public Function<String, Maire> convertLineToMaire = line -> {
		line = line.replaceAll("\"", " ");

		String[] tabString = line.split(";");
		/*
		 * for(String s :tabString) s=s.trim();
		 */

		tabString[6] = tabString[6].trim();

		
		 //for(String s :tabString) System.out.println(s.toString());
		 

		String Code_du_d�partement = tabString[4];
		String Libell�_de_d�partement = tabString[5];

		Civility civility = Civility.valueOf(tabString[6]);
		//System.out.println(civility);
		LocalDate naissance = null;
		naissance = LocalDate.parse(tabString[7], DateTimeFormatter.ISO_DATE);
		Maire mair = new Maire(Code_du_d�partement, Libell�_de_d�partement, civility, naissance);
		
		MaireINSEE.put(tabString[0].replace(" ", ""), mair);
		//System.out.println(tabString[0].replace(" ", ""));
		return mair;
	};

}

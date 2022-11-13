package org.sebaoune.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;

	String Code_du_département;
	String Libellé_de_département;

	@OneToMany(mappedBy = "departement")
	private Collection<Commune> Collcommune;

	public Departement(String code_du_département, String libellé_de_département) {
		super();
		Code_du_département = code_du_département;
		Libellé_de_département = libellé_de_département;
	}

	public Departement() {
		super();

	}

	public String getCode_du_département() {
		return Code_du_département;
	}

	public void setCode_du_département(String code_du_département) {
		Code_du_département = code_du_département;
	}

	public String getLibellé_de_département() {
		return Libellé_de_département;
	}

	public void setLibellé_de_département(String libellé_de_département) {
		Libellé_de_département = libellé_de_département;
	}

	@Override
	public String toString() {
		return "Departement [Code_du_département=" + Code_du_département + ", Libellé_de_département="
				+ Libellé_de_département + "]";
	}

}

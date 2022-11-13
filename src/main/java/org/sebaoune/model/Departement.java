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

	String Code_du_d�partement;
	String Libell�_de_d�partement;

	@OneToMany(mappedBy = "departement")
	private Collection<Commune> Collcommune;

	public Departement(String code_du_d�partement, String libell�_de_d�partement) {
		super();
		Code_du_d�partement = code_du_d�partement;
		Libell�_de_d�partement = libell�_de_d�partement;
	}

	public Departement() {
		super();

	}

	public String getCode_du_d�partement() {
		return Code_du_d�partement;
	}

	public void setCode_du_d�partement(String code_du_d�partement) {
		Code_du_d�partement = code_du_d�partement;
	}

	public String getLibell�_de_d�partement() {
		return Libell�_de_d�partement;
	}

	public void setLibell�_de_d�partement(String libell�_de_d�partement) {
		Libell�_de_d�partement = libell�_de_d�partement;
	}

	@Override
	public String toString() {
		return "Departement [Code_du_d�partement=" + Code_du_d�partement + ", Libell�_de_d�partement="
				+ Libell�_de_d�partement + "]";
	}

}

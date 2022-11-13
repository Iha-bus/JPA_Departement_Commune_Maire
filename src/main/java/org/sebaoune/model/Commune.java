package org.sebaoune.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "commune")
public class Commune implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "codeINSEE")
	String codeINSEE;

	@Column(name = "nomCommune")
	String nomCommune;

	@Column(name = "codePostal")
	String codePostal;

	@Column(name = "libelleAcheminement")
	String libelleAcheminement;

	@ManyToOne
	private Departement departement;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Maire maire;

	public String getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public Commune(String codeINSEE, String nomCommune, String codePostal, String libelleAcheminement) {
		super();
		this.codeINSEE = codeINSEE;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
	}

	@Override
	public String toString() {
		return "commune [id=" + id + ", codeINSEE=" + codeINSEE + ", nomCommune=" + nomCommune + ", codePostal="
				+ codePostal + ", libelleAcheminement=" + libelleAcheminement + "]" + "maire " + maire.toString();
	}

	public Commune() {
	}

	public Commune(String codeINSEE, String nomCommune, String codePostal, String libelleAcheminement, Maire m1,
			Departement d1) {
		super();
		this.codeINSEE = codeINSEE;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.maire = m1;
		this.departement = d1;

	}

	public void setMaire(Maire m) {
		// TODO Auto-generated method stub
		this.maire = m;
	}

}

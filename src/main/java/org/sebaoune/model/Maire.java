package org.sebaoune.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Table(name = "maire")
@Entity
public class Maire implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	String nompsn;
	String prepsn;
	@Enumerated(EnumType.STRING)
	Civility civility;
	LocalDate naissance;

	@OneToOne (mappedBy= "maire")
	Commune commune;

	public String getNompsn() {
		return nompsn;
	}

	public void setNompsn(String nompsn) {
		this.nompsn = nompsn;
	}

	public String getPrepsn() {
		return prepsn;
	}

	public void setPrepsn(String prepsn) {
		this.prepsn = prepsn;
	}

	public Civility getCivility() {
		return civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "Maire [nompsn=" + nompsn + ", prepsn=" + prepsn + ", civility=" + civility + ", naissance=" + naissance
				+ "]";
	}

	public Maire(String nompsn, String prepsn, Civility civility, LocalDate naissance) {
		super();
		this.nompsn = nompsn;
		this.prepsn = prepsn;
		this.civility = civility;
		this.naissance = naissance;
	}

	public Maire() {
		super();
	}

}

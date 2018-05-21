package co.simplon.assoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saisons")
public class Saison implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String libelle;
	@Column
	private double cotisationClub;
	@Column
	private double montantLicencePoussin;
	@Column
	private double montantLicenceBenjamin;
	@Column
	private double montantLicenceCadet;
	@Column
	private double montantLicenceJunior;
	@Column
	private double montantLicenceSenior;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getCotisationClub() {
		return cotisationClub;
	}
	public void setCotisationClub(double cotisationClub) {
		this.cotisationClub = cotisationClub;
	}
	public double getMontantLicencePoussin() {
		return montantLicencePoussin;
	}
	public void setMontantLicencePoussin(double montantLicencePoussin) {
		this.montantLicencePoussin = montantLicencePoussin;
	}
	public double getMontantLicenceBenjamin() {
		return montantLicenceBenjamin;
	}
	public void setMontantLicenceBenjamin(double montantLicenceBenjamin) {
		this.montantLicenceBenjamin = montantLicenceBenjamin;
	}
	public double getMontantLicenceCadet() {
		return montantLicenceCadet;
	}
	public void setMontantLicenceCadet(double montantLicenceCadet) {
		this.montantLicenceCadet = montantLicenceCadet;
	}
	public double getMontantLicenceJunior() {
		return montantLicenceJunior;
	}
	public void setMontantLicenceJunior(double montantLicenceJunior) {
		this.montantLicenceJunior = montantLicenceJunior;
	}
	public double getMontantLicenceSenior() {
		return montantLicenceSenior;
	}
	public void setMontantLicenceSenior(double montantLicenceSenior) {
		this.montantLicenceSenior = montantLicenceSenior;
	}
}

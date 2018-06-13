package co.simplon.assoc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="saison")
public class Saison implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="saison", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Adhesion> listeAdhesions;
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
	public Set<Adhesion> getListeAdhesions() {
		return listeAdhesions;
	}
	public void setListeAdhesions(Set<Adhesion> listeAdhesions) {
		this.listeAdhesions = listeAdhesions;
	}
}

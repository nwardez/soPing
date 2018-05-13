package co.simplon.assoc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="adherents")
public class Adherent implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String noLicence;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeNaissance;
	@Column
	private String categorie;
	@Column
	private String adresse;
	@Column
	@Pattern(regexp="^[0-9]{5}$")
	private String codePostal;
	@Column
	private String commune;
	@Column
	private String telDomicile;
	@Column
	private String telPortable;
	@Column
	private String mail;
	@Column
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdhesion;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getTelDomicile() {
		return telDomicile;
	}
	public void setTelDomicile(String telDomicile) {
		this.telDomicile = telDomicile;
	}
	public String getTelPortable() {
		return telPortable;
	}
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNoLicence() {
		return noLicence;
	}
	public void setNoLicence(String noLicence) {
		this.noLicence = noLicence;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Date getDateAdhesion() {
		return dateAdhesion;
	}
	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}
	

}
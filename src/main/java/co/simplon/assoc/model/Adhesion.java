package co.simplon.assoc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="adhesion")
@EntityListeners(AuditingEntityListener.class)
public class Adhesion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="adhesion_id")
	private Long id;
	
	@OneToMany(mappedBy="adhesion",fetch=FetchType.EAGER)
	private Set<Paiement> paiements;
	
	@ManyToOne
	@JoinColumn(name="adherent_id",nullable=false)
	private Adherent adherent;
	
	@ManyToOne
	@JoinColumn(name="categorie_id",nullable=false)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="saison_id",nullable=false)
	private Saison saison;
	
	@ManyToOne
	@JoinColumn(name="typelicence_id",nullable=false)
	private TypeLicence typeLicence;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(Set<Paiement> paiements) {
		this.paiements = paiements;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Saison getSaison() {
		return saison;
	}
	public void setSaison(Saison saison) {
		this.saison = saison;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public TypeLicence getTypeLicence() {
		return typeLicence;
	}
	public void setTypeLicence(TypeLicence typeLicence) {
		this.typeLicence = typeLicence;
	}
	
	

}

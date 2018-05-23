package co.simplon.assoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Paiement {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String moyenPaiement;
	@Column
	private double montantPaiement;
	@ManyToOne
	@JoinColumn(name="adhesion_id",nullable=false)
	private Adhesion adhesion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMoyenPaiement() {
		return moyenPaiement;
	}
	public void setMoyenPaiement(String moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}
	public double getMontantPaiement() {
		return montantPaiement;
	}
	public void setMontantPaiement(double montantPaiement) {
		this.montantPaiement = montantPaiement;
	}
	public Adhesion getAdhesion() {
		return adhesion;
	}
	public void setAdhesion(Adhesion adhesion) {
		this.adhesion = adhesion;
	}

}

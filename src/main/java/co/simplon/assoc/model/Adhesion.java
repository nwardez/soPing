package co.simplon.assoc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adhesion")
public class Adhesion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToMany(mappedBy="adhesion",fetch=FetchType.EAGER)
	private Set<Paiement> paiements;
	
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
	
	

}

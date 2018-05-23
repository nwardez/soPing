package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Paiement;
import co.simplon.assoc.repository.IPaiement;

@Service
public class PaiementService {
	
	@Autowired
	private IPaiement iPaiement;
	
	public List<Paiement> listerPaiements() {
		return iPaiement.findAll();
	}
	
	public Paiement creerPaiement(Paiement paiement) {
		return iPaiement.save(paiement);
	}
	
	public Paiement recupererPaiementParId(Long paiementId) {
		return iPaiement.findOne(paiementId);
	}
	
	public void supprimerPaiement(Long paiementId) {
		iPaiement.delete(paiementId);
	}
	
	public Paiement editerPaiement(Long paiementId, Paiement paiement) {
		return iPaiement.save(paiement);
	}

}

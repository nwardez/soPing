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
	
	/**
	 * 
	 * @return liste des paiements
	 */
	public List<Paiement> listerPaiements() {
		return iPaiement.findAll();
	}
	
	/**
	 * 
	 * @param paiement
	 * @return
	 */
	public Paiement creerPaiement(Paiement paiement) {
		return iPaiement.save(paiement);
	}
	
	/**
	 * 
	 * @param paiementId
	 * @return
	 */
	public Paiement recupererPaiementParId(Long paiementId) {
		return iPaiement.findOne(paiementId);
	}
	
	/**
	 * 
	 * @param paiementId
	 */
	public void supprimerPaiement(Long paiementId) {
		iPaiement.delete(paiementId);
	}
	
	/**
	 * 
	 * @param paiementId
	 * @param paiement
	 * @return
	 */
	public Paiement editerPaiement(Long paiementId, Paiement paiement) {
		return iPaiement.save(paiement);
	}

}

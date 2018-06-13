package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.model.Adhesion;
import co.simplon.assoc.repository.IAdhesion;

/**
 * 
 * @author Yann COLLET
 *
 */
@Service
public class AdhesionService {
	
	/**
	 * Instance de IAdhesion
	 */
	@Autowired
	private IAdhesion iAdhesion;
	
	/**
	 * 
	 * @return liste des adhésions
	 */
	public List<Adhesion> listerAdhesions() {
		return iAdhesion.findAll();
	}
	
	/**
	 * 
	 * @param adhesion
	 * @return l'adhésion créée
	 */
	public Adhesion creerAdhesion(Adhesion adhesion) {
		return iAdhesion.save(adhesion);
	}
	
	/**
	 * 
	 * @param adhesionId
	 * @return Adhesion par Id
	 */
	public Adhesion recupererAdhesionParId(Long adhesionId) {
		return iAdhesion.findOne(adhesionId);
	}
	
	/**
	 * Supprime l'adhésion selon Id
	 * @param adhesionId
	 */
	public void supprimerAdhesion(Long adhesionId) {
		iAdhesion.delete(adhesionId);
	}
	
	/**
	 * 
	 * @param adhesionId
	 * @param adhesion
	 * @return l'adhésion éditée
	 */
	public Adhesion editerAdhesion(Long adhesionId, Adhesion adhesion) {
		return iAdhesion.save(adhesion);
	}
	


}

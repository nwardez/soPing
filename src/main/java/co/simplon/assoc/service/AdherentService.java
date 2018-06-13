package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.repository.IAdherent;

@Service
public class AdherentService {

	// Injection de dépendance: accès à une instance de l'interface IAdherent
	@Autowired
	private IAdherent iAdherent;
	
	/**
	 * 
	 * @return Liste des adhérents
	 */
	public List<Adherent> listerAdherents() {
		return iAdherent.findAll();
	}
	
	/**
	 * 
	 * @param adherent
	 * @return Adhérent créé
	 */
	public Adherent creerAdherent(Adherent adherent) {
		return iAdherent.save(adherent);
	}
	
	/**
	 * 
	 * @param adherentId
	 * @return adherent par son Id
	 */
	public Adherent recupererAdherentParId(Long adherentId) {
		return iAdherent.findOne(adherentId);
	}
	
	/**
	 * Supression d'un adhérent selon son id
	 * @param adherentId
	 */
	public void supprimerAdherent(Long adherentId) {
		iAdherent.delete(adherentId);
	}
	
	/**
	 * 
	 * @param adherentId
	 * @param adherent
	 * @return l'adhérent édité
	 */
	public Adherent editerAdherent(Long adherentId, Adherent adherent) {
		return iAdherent.save(adherent);
	}
}

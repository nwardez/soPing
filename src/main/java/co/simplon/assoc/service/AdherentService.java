package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.repository.IAdherent;

@Service
public class AdherentService {

	@Autowired
	private IAdherent iAdherent;
	
	public List<Adherent> listerAdherents() {
		return iAdherent.findAll();
	}
	
	public Adherent creerAdherent(Adherent adherent) {
		return iAdherent.save(adherent);
	}
	
	public Adherent recupererAdherentParId(Long adherentId) {
		return iAdherent.findOne(adherentId);
	}
	
	public void supprimerAdherent(Long adherentId) {
		iAdherent.delete(adherentId);
	}
	
	public Adherent editerAdherent(Long adherentId, Adherent adherent) {
		return iAdherent.save(adherent);
	}
}

package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Saison;
import co.simplon.assoc.repository.ISaison;

@Service
public class SaisonService {
	
	@Autowired
	private ISaison iSaison;
	
	public List<Saison> listerSaisons() {
		return iSaison.findAll();
	}
	
	public Saison creerSaison(Saison saison) {
		return iSaison.save(saison);
	}
	
	public Saison recupererSaisonParId(Long saisonId) {
		return iSaison.findOne(saisonId);
	}
	
	public void supprimerSaison(Long saisonId) {
		iSaison.delete(saisonId);
	}
	
	public Saison editerSaison(Long saisonId, Saison saison) {
		return iSaison.save(saison);
	}

}

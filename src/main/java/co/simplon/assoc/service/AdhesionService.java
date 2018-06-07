package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.model.Adhesion;
import co.simplon.assoc.repository.IAdhesion;

@Service
public class AdhesionService {
	
	@Autowired
	private IAdhesion iAdhesion;
	
	public List<Adhesion> listerAdhesions() {
		return iAdhesion.findAll();
	}
	
	public Adhesion creerAdhesion(Adhesion adhesion) {
		return iAdhesion.save(adhesion);
	}
	
	public Adhesion recupererAdhesionParId(Long adhesionId) {
		return iAdhesion.findOne(adhesionId);
	}
	
	public void supprimerAdhesion(Long adhesionId) {
		iAdhesion.delete(adhesionId);
	}
	
	public Adhesion editerAdhesion(Long adhesionId, Adhesion adhesion) {
		return iAdhesion.save(adhesion);
	}
	


}

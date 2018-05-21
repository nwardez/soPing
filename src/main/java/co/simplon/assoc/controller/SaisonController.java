package co.simplon.assoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.simplon.assoc.model.Saison;
import co.simplon.assoc.repository.ISaison;
import co.simplon.assoc.service.SaisonService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class SaisonController {
	
	@Autowired
	private ISaison iSaison;
	
	@Autowired
	private SaisonService saisonService;
	
	@GetMapping("saisons")
	public List<Saison> getAllSaisons() {
		return saisonService.listerSaisons();
	}
	
	@PostMapping("/saison")
	public Saison createSaison(@RequestBody Saison saison) {
		return saisonService.creerSaison(saison);
	}
	
	@GetMapping("/saison/{id}")
	public ResponseEntity<Saison> getSaisonById(@PathVariable(value="id") Long saisonId) {
		Saison saison= saisonService.recupererSaisonParId(saisonId);
		if (saison == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(saison);
	}
	
	@DeleteMapping("/saison/delete/{id}")
	public ResponseEntity<Saison> deleteSaison(@PathVariable(value="id") Long saisonId) {
		Saison saison =saisonService.recupererSaisonParId(saisonId);
		if (saison == null) {
			return ResponseEntity.notFound().build();
		}
		iSaison.delete(saison);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/saison/{id}")
	public ResponseEntity<Saison> updateSaison(@PathVariable(value="id") Long saisonId, @RequestBody Saison detailSaison) {
		Saison saison = saisonService.recupererSaisonParId(saisonId);
		
		if (saison == null) {
			return ResponseEntity.notFound().build();
		}
		saison.setCotisationClub(detailSaison.getCotisationClub());
		saison.setLibelle(detailSaison.getLibelle());
		saison.setMontantLicenceBenjamin(detailSaison.getMontantLicenceBenjamin());
		saison.setMontantLicenceCadet(detailSaison.getMontantLicenceCadet());
		saison.setMontantLicenceJunior(detailSaison.getMontantLicenceJunior());
		saison.setMontantLicencePoussin(detailSaison.getMontantLicencePoussin());
		saison.setMontantLicenceSenior(detailSaison.getMontantLicenceSenior());
		
		
		Saison majSaison = saisonService.editerSaison(saisonId, saison);
		
		return ResponseEntity.ok(majSaison);
		
	}

}

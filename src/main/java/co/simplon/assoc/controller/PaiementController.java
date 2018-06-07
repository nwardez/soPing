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

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.model.Paiement;
import co.simplon.assoc.repository.IAdherent;
import co.simplon.assoc.repository.IPaiement;
import co.simplon.assoc.service.AdherentService;
import co.simplon.assoc.service.PaiementService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class PaiementController {
	
	@Autowired
	private IPaiement iPaiement;
	
	@Autowired
	private PaiementService paiementService;
	
	@GetMapping("paiements")
	public List<Paiement> getAllPaiements() {
		return paiementService.listerPaiements();
	}
	
	@PostMapping("/paiement")
	public Paiement createPaiement(@RequestBody Paiement paiement) {
		return paiementService.creerPaiement(paiement);
	}
	
	@GetMapping("/paiment/{id}")
	public ResponseEntity<Paiement> getPaiementById(@PathVariable(value="id") Long paiementId) {
		Paiement paiement= paiementService.recupererPaiementParId(paiementId);
		if (paiement == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(paiement);
	}
	
	@DeleteMapping("/paiement/delete/{id}")
	public ResponseEntity<Paiement> deletePaiement(@PathVariable(value="id") Long paiementId) {
		Paiement paiement =paiementService.recupererPaiementParId(paiementId);
		if (paiement == null) {
			return ResponseEntity.notFound().build();
		}
		iPaiement.delete(paiement);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/paiement/{id}")
	public ResponseEntity<Paiement> updatePaiement(@PathVariable(value="id") Long paiementId, @RequestBody Paiement detailPaiement) {
		Paiement paiement = paiementService.recupererPaiementParId(paiementId);
		
		if (paiement == null) {
			return ResponseEntity.notFound().build();
		}
		paiement.setMontantPaiement(detailPaiement.getMontantPaiement());
		paiement.setMoyenPaiement(detailPaiement.getMoyenPaiement());
		
		
		
		Paiement majPaiement = paiementService.editerPaiement(paiementId, paiement);
		
		return ResponseEntity.ok(majPaiement);
		
	}


}

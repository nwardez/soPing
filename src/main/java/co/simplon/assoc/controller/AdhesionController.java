package co.simplon.assoc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.assoc.model.Adhesion;
import co.simplon.assoc.model.Paiement;
import co.simplon.assoc.repository.IAdhesion;
import co.simplon.assoc.repository.IPaiement;
import co.simplon.assoc.service.AdhesionService;
import co.simplon.assoc.service.PaiementService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class AdhesionController {
	
	@Autowired
	private IAdhesion iAdhesion;
	
	@Autowired
	private AdhesionService adhesionService;
	
	@GetMapping("adhesions")
	public List<Adhesion> getAllAdhesions() {
		return adhesionService.listerAdhesions();
	}
	
	@PostMapping("/adhesion")
	public Adhesion createAdhesion(@Valid @RequestBody Adhesion adhesion) {
		return adhesionService.creerAdhesion(adhesion);
	}
	
	@GetMapping("/adhesion/{id}")
	public ResponseEntity<Adhesion> getAdhesionById(@PathVariable(value="id") Long adhesionId) {
		Adhesion adhesion= adhesionService.recupererAdhesionParId(adhesionId);
		if (adhesion == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(adhesion);
	}
	
	@DeleteMapping("/adhesion/delete/{id}")
	public ResponseEntity<Adhesion> deleteAdhesion(@PathVariable(value="id") Long adhesionId) {
		Adhesion adhesion =adhesionService.recupererAdhesionParId(adhesionId);
		if (adhesion == null) {
			return ResponseEntity.notFound().build();
		}
		iAdhesion.delete(adhesion);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/adhesion/{id}")
	public ResponseEntity<Adhesion> updateAdhesion(@PathVariable(value="id") Long adhesionId, @RequestBody Adhesion detailAdhesion) {
		Adhesion adhesion = adhesionService.recupererAdhesionParId(adhesionId);
		
		if (adhesion == null) {
			return ResponseEntity.notFound().build();
		}
		adhesion.setAdherent(detailAdhesion.getAdherent());
		
		
		
		
		Adhesion majAdhesion = adhesionService.editerAdhesion(adhesionId, adhesion);
		
		return ResponseEntity.ok(majAdhesion);
		
	}
	
	
	


}

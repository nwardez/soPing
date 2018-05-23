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
import co.simplon.assoc.repository.IAdherent;
import co.simplon.assoc.service.AdherentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class AdherentController {
	
	@Autowired
	private IAdherent iAdherent;
	
	@Autowired
	private AdherentService adherentService;
	
	@GetMapping("adherents")
	public List<Adherent> getAllAdherents() {
		return adherentService.listerAdherents();
	}
	
	@PostMapping("/adherent")
	public Adherent createAdherent(@RequestBody Adherent adherent) {
		return adherentService.creerAdherent(adherent);
	}
	
	@GetMapping("/adherent/{id}")
	public ResponseEntity<Adherent> getAdherentById(@PathVariable(value="id") Long adherentId) {
		Adherent adherent= adherentService.recupererAdherentParId(adherentId);
		if (adherent == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(adherent);
	}
	
	@DeleteMapping("/adherent/delete/{id}")
	public ResponseEntity<Adherent> deleteAdherent(@PathVariable(value="id") Long adherentId) {
		Adherent adherent =adherentService.recupererAdherentParId(adherentId);
		if (adherent == null) {
			return ResponseEntity.notFound().build();
		}
		iAdherent.delete(adherent);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/adherent/{id}")
	public ResponseEntity<Adherent> updateAdherent(@PathVariable(value="id") Long adherentId, @RequestBody Adherent detailAdherent) {
		Adherent adherent = adherentService.recupererAdherentParId(adherentId);
		
		if (adherent == null) {
			return ResponseEntity.notFound().build();
		}
		adherent.setAdresse(detailAdherent.getAdresse());
		adherent.setCodePostal(detailAdherent.getCodePostal());
		adherent.setCommune(detailAdherent.getCommune());
		adherent.setDateDeNaissance(detailAdherent.getDateDeNaissance());
		adherent.setMail(detailAdherent.getMail());
		adherent.setNom(detailAdherent.getNom());
		adherent.setPrenom(detailAdherent.getPrenom());
		adherent.setTelDomicile(detailAdherent.getTelDomicile());
		adherent.setTelPortable(detailAdherent.getTelPortable());
		adherent.setNoLicence(detailAdherent.getNoLicence());
		
		
		Adherent majAdherent = adherentService.editerAdherent(adherentId, adherent);
		
		return ResponseEntity.ok(majAdherent);
		
	}

}

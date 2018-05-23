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


import co.simplon.assoc.model.TypeLicence;
import co.simplon.assoc.repository.ITypeLicence;
import co.simplon.assoc.service.TypeLicenceService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class TypeLicenceController {
	
	@Autowired
	private ITypeLicence iTypeLicence;
	
	@Autowired
	private TypeLicenceService typeLicenceService;
	
	@GetMapping("typeLicences")
	public List<TypeLicence> getAllTypeOfLicences() {
		return typeLicenceService.listerTypeLicence();
	}
	
	@PostMapping("/typeLicence")
	public TypeLicence createTypeOfLicence(@RequestBody TypeLicence typeLicence) {
		return typeLicenceService.creerTypeLicence(typeLicence);
	}
	
	@GetMapping("/typeLicence/{id}")
	public ResponseEntity<TypeLicence> getTypeOfLicenceById(@PathVariable(value="id") Long typeLicenceId) {
		TypeLicence typeLicence= typeLicenceService.recupererTypeLicenceParId(typeLicenceId);
		if (typeLicence == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(typeLicence);
	}
	
	@DeleteMapping("/typeLicence/delete/{id}")
	public ResponseEntity<TypeLicence> deleteTypeOfLicence(@PathVariable(value="id") Long typeLicenceId) {
		TypeLicence typeLicence =typeLicenceService.recupererTypeLicenceParId(typeLicenceId);
		if (typeLicence == null) {
			return ResponseEntity.notFound().build();
		}
		iTypeLicence.delete(typeLicence);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/typeLicence/{id}")
	public ResponseEntity<TypeLicence> updateTypeOfLicence(@PathVariable(value="id") Long typeLicenceId, @RequestBody TypeLicence detailTypeLicence) {
		TypeLicence typeLicence = typeLicenceService.recupererTypeLicenceParId(typeLicenceId);
		
		if (typeLicence == null) {
			return ResponseEntity.notFound().build();
		}
		typeLicence.setLibelle(detailTypeLicence.getLibelle());
		typeLicence.setCommentaire(detailTypeLicence.getCommentaire());
		
		
		
		TypeLicence majTypeLicence = typeLicenceService.editerTypeLicence(typeLicenceId, typeLicence);
		
		return ResponseEntity.ok(majTypeLicence);
		
	}


}

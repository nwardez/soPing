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

import co.simplon.assoc.model.Categorie;
import co.simplon.assoc.repository.ICategorie;
import co.simplon.assoc.service.CategorieService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")
public class CategorieController {
	
	@Autowired
	private ICategorie iCategorie;
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("categories")
	public List<Categorie> getAllCategories() {
		return categorieService.listerCategories();
	}
	
	@PostMapping("/categorie")
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieService.creerCategorie(categorie);
	}
	
	@GetMapping("/categorie/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable(value="id") Long categorieId) {
		Categorie categorie= categorieService.recupererCategorieParId(categorieId);
		if (categorie == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(categorie);
	}
	
	@DeleteMapping("/categorie/delete/{id}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable(value="id") Long categorieId) {
		Categorie categorie =categorieService.recupererCategorieParId(categorieId);
		if (categorie == null) {
			return ResponseEntity.notFound().build();
		}
		iCategorie.delete(categorie);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/categorie/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable(value="id") Long categorieId, @RequestBody Categorie detailCategorie) {
		Categorie categorie = categorieService.recupererCategorieParId(categorieId);
		
		if (categorie == null) {
			return ResponseEntity.notFound().build();
		}
		categorie.setLibelle(detailCategorie.getLibelle());
		categorie.setCommentaire(detailCategorie.getCommentaire());
		
		
		Categorie majCategorie = categorieService.editerCategorie(categorieId, categorie);
		
		return ResponseEntity.ok(majCategorie);
		
	}

}

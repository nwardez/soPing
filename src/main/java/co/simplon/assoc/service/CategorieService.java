package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Categorie;
import co.simplon.assoc.repository.ICategorie;

@Service
public class CategorieService {
	
	@Autowired
	private ICategorie iCategorie;
	
	public List<Categorie> listerCategories() {
		return iCategorie.findAll();
	}
	
	public Categorie creerCategorie(Categorie categorie) {
		return iCategorie.save(categorie);
	}
	
	public Categorie recupererCategorieParId(Long categorieId) {
		return iCategorie.findOne(categorieId);
	}
	
	public void supprimerCategorie(Long categorieId) {
		iCategorie.delete(categorieId);
	}
	
	public Categorie editerCategorie(Long categorieId, Categorie categorie) {
		return iCategorie.save(categorie);
	}

}

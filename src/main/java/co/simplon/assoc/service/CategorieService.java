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
	
	/**
	 * 
	 * @return liste des catégories
	 */
	public List<Categorie> listerCategories() {
		return iCategorie.findAll();
	}
	
	/**
	 * 
	 * @param categorie
	 * @return la catégorie créée
	 */
	public Categorie creerCategorie(Categorie categorie) {
		return iCategorie.save(categorie);
	}
	
	/**
	 * 
	 * @param categorieId
	 * @return
	 */
	public Categorie recupererCategorieParId(Long categorieId) {
		return iCategorie.findOne(categorieId);
	}
	
	/**
	 * 
	 * @param categorieId
	 */
	public void supprimerCategorie(Long categorieId) {
		iCategorie.delete(categorieId);
	}
	
	/**
	 * 
	 * @param categorieId
	 * @param categorie
	 * @return la catégorie éditée
	 */
	public Categorie editerCategorie(Long categorieId, Categorie categorie) {
		return iCategorie.save(categorie);
	}

}

package co.simplon.assoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.model.TypeLicence;
import co.simplon.assoc.repository.IAdherent;
import co.simplon.assoc.repository.ITypeLicence;

@Service
public class TypeLicenceService {
	
	@Autowired
	private ITypeLicence iTypeLicence;
	
	public List<TypeLicence> listerTypeLicence() {
		return iTypeLicence.findAll();
	}
	
	public TypeLicence creerTypeLicence(TypeLicence typeLicence) {
		return iTypeLicence.save(typeLicence);
	}
	
	public TypeLicence recupererTypeLicenceParId(Long typeLicenceId) {
		return iTypeLicence.findOne(typeLicenceId);
	}
	
	public void supprimerTypeLicence(Long typeLicenceId) {
		iTypeLicence.delete(typeLicenceId);
	}
	
	public TypeLicence editerTypeLicence(Long typeLicenceId, TypeLicence typeLicence) {
		return iTypeLicence.save(typeLicence);
	}

}

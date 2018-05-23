package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Categorie;

@Repository
public interface ICategorie extends JpaRepository<Categorie, Long>{

}

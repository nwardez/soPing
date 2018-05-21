package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Saison;


@Repository
public interface ISaison extends JpaRepository<Saison, Long >{

}

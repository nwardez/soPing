package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Adherent;

@Repository
public interface IAdherent extends JpaRepository<Adherent, Long >{

}

package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Paiement;

@Repository
public interface IPaiement extends JpaRepository<Paiement, Long >{

}

package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Cotisation;

@Repository
public interface ICotisation extends JpaRepository<Cotisation, Long>{

}

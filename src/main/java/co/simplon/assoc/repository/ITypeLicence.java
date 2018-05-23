package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.TypeLicence;

@Repository
public interface ITypeLicence extends JpaRepository<TypeLicence, Long >{

}

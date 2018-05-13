package co.simplon.assoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Licence;

@Repository
public interface ILicence extends JpaRepository<Licence, Long>{

}

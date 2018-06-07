package co.simplon.assoc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.model.Adhesion;

@Repository
public interface IAdhesion extends JpaRepository<Adhesion, Long >{

	
}

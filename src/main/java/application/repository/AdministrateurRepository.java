package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Administrateur;

public interface AdministrateurRepository extends JpaRepository <Administrateur,Long>{

}

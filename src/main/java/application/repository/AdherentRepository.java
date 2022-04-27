package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import application.model.Adherent;
@RepositoryRestResource

public interface AdherentRepository extends JpaRepository <Adherent,Long>{
public List<Adherent> findByNom(String nom);
public List <Adherent> findByEmail (String email);
public List <Adherent> findByPrenom (String Prenom);
public List <Adherent> findByNomAndPrenom (String Nom,String prenom);
@Query ("select count(a)from Adherent a")
int affichernbadherent();

}

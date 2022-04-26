package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import application.model.Livre;

public interface LivreRepository extends JpaRepository <Livre,Long> {
public List <Livre> findByAuteur (String auteur);
public List <Livre> findByDateedition (String dateedition);
public List <Livre> findByLibelle (String Libelle);
public List <Livre> findByLibelleAndAuteur (String Libelle,String Auteur);
@Modifying 
@Transactional
	@Query ("delete from Livre l where l.numIsbn=?1")
public void supprimer (long id);
}

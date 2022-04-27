package application.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.model.*;
import application.repository.*;

@Service

public class LivreService {
@Autowired 
LivreRepository repository;
public void ajouter (Livre l) 
{
repository.save(l);
}
public List <Livre> affichertout()
{
return repository.findAll();	
}
public void supprimer (Long id)
{
System.out.println("adherent"+repository.findById(id).get().toString());
repository.supprimer(id);
}
public Livre rechercherparid(Long id) 
{
return repository.findById(id).get();
}
public List<Livre> rechercherparLibelle (String libelle)
{
return repository.findByLibelle(libelle);	
}
public List<Livre> rechercherparauteur (String auteur)
{
return repository.findByAuteur(auteur);
}
public List<Livre> rechercherpardateedition (String dateedition)
{
return repository.findByDateedition(dateedition);
}
public List<Livre> rechercherparlibelleetauteur (String libelle,String auteur)
{
return repository.findByLibelleAndAuteur(libelle, auteur);
}
public int affichernblivre ()
{
return repository.affichernblivre();	
}
}
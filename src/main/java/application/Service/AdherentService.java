package application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.*;
import application.repository.*;

@Service
public class AdherentService {
@Autowired
AdherentRepository repository;
public List<Adherent> affichertout () 
{
return repository.findAll();
}
public void ajouter (Adherent adh)
{
System.out.println(adh.toString());
repository.save(adh);	
}
public void supprimer (Long id)
{
repository.deleteById(id);	
}
public List<Adherent> rechercherparnom ( String nom)
{
return repository.findByNom(nom);	
}
public Adherent rechercherparid ( Long id)
{

return repository.findById(id).get();	
}
public List<Adherent> rechercherparprenom ( String prenom)
{
return repository.findByPrenom(prenom);	
}
public List<Adherent> rechercherparemail ( String email)
{
return repository.findByEmail(email);	
}
public List<Adherent> rechercherparnometprenom ( String nom,String prenom)
{
return repository.findByNomAndPrenom(nom, prenom);	
}
public int affichernbadherent() 
{
return repository.affichernbadherent();	
}
}

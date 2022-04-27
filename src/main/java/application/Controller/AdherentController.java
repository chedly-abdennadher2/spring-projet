package application.Controller;
import application.Service.AdherentService;
import application.model.*;
import net.minidev.json.JSONObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
@RestController
@RequestMapping("/adherent")
public class AdherentController {
@Autowired
AdherentService service;
public static final Logger log=Logger.getLogger(AdherentController.class);
public AdherentController(AdherentService service)
{
this.service=service;
}

@GetMapping("/affichertoutadherent")	
@CrossOrigin(origins="http://localhost:4200")

public List<Adherent> affichertout () 
{
	log.info("afficher tous les adherents");
	return service.affichertout();
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/ajouteradh")

public void ajouter (@RequestBody Adherent adh)
{
System.out.println(adh.toString());
if (adh.getId()==0) // j'ai supposé que les id commence par 1
{log.error("impossible adherent NULL");	
}
else 
{
service.ajouter(adh);
log.info("adherent ajouté avec succès");

}
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/supprimeradh")

public void supprimer (@RequestBody JSONObject data)
{
String id=(String)(data.get("id"));
try {
Adherent a=service.rechercherparid(Long.parseLong(id));
if (a==null)
{
System.out.println("adherent introuvable");	
}
else 
{service.supprimer(Long.parseLong(id));
log.info("adherent supprimé avec succès");}
}
catch (java.lang.NumberFormatException e)
{
log.error("adherent id NULL");
}
catch (java.util.NoSuchElementException e)
{
	
	log.error("adherent id introuvable");
}
}
@GetMapping("/afficherparnom/{nom}")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> rechercherparnom (@PathVariable String nom)
{
System.out.println(nom);
log.info(" rechercher adherent par nom ");
return service.rechercherparnom(nom);

}
@GetMapping("/afficherparid/{id}")	
@CrossOrigin(origins="http://localhost:4200")
public Adherent rechercherparid (@PathVariable String id)
{
try
{return service.rechercherparid(Long.parseLong(id));}
catch (java.util.NoSuchElementException e)
{
log.error("introuvable");	
return null;
}
}
@GetMapping("/afficherparprenom/{prenom}")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> rechercherparprenom (@PathVariable String prenom)
{
return service.rechercherparprenom(prenom);
}
@GetMapping("/afficherparemail/{email}")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> rechercherparemail (@PathVariable String email)
{
return service.rechercherparemail(email);
}
@GetMapping("/afficherparnometprenom/{nom}/{prenom}")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> rechercherparnometprenom (@PathVariable String nom,@PathVariable String prenom)
{
return service.rechercherparnometprenom(nom, prenom);
}
@GetMapping("/affichernbadherent")	
@CrossOrigin(origins="http://localhost:4200")
public int affichernbadherent()
{
return service.affichernbadherent();	
}
}

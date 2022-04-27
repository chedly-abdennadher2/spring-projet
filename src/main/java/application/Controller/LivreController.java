package application.Controller;
import application.Service.*;
import application.Service.LivreService;
import application.model.*;
import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/livre")

public class LivreController {
@Autowired
LivreService service;
public static final Logger log=Logger.getLogger(LivreController.class);

public LivreController(LivreService service) {
	super();
	this.service = service;
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/ajouterlivre")
public void ajouter(@RequestBody Livre l)
{
if (l.getNumIsbn()==0)
{
log.error("livre null impossible a ajouter");	
}
else 
{service.ajouter(l);
log.info("livre ajoute avec success");
}
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/supprimerlivre")

public void supprimer (@RequestBody JSONObject data)
{ 
	String id=(String)(data.get("id"));
	try {
	Livre l=service.rechercherparid(Long.parseLong(id));
	if (l==null)
	{
		System.out.println("livre introuvable");		
	}
	else 
	{service.supprimer(Long.parseLong(id));
	log.info("livre supprime avec succes");}
	}
	catch (java.lang.NumberFormatException e)
	{
	log.error("livre id null impossible a supprimer");		
	}
catch (java.util.NoSuchElementException e)
{
	log.error("livre id introuvable a supprimer");		
	
	}
}
@GetMapping("/affichertoutlivre")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> affichertout()
{
log.info("afficher tous les livres");
return service.affichertout();	
}
@GetMapping("/afficherlivreparid/{id}")
@CrossOrigin(origins="http://localhost:4200")
public Livre rechercherparid(@PathVariable String id)
{
try 
{return service.rechercherparid(Long.parseLong(id));}
catch (java.util.NoSuchElementException e)
{
return null;	
}
}
@GetMapping("/afficherlivreparLibelle/{Libelle}")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> rechercherparLibelle(@PathVariable String Libelle)
{
return service.rechercherparLibelle(Libelle);
}
@GetMapping("/afficherlivreparauteur/{auteur}")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> rechercherparauteur(@PathVariable String auteur)
{
return service.rechercherparauteur(auteur);
}
@GetMapping("/afficherlivrepardateedition/{dateedition}")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> rechercherpardateedition(@PathVariable String dateedition)
{
return service.rechercherpardateedition(dateedition);
}
@GetMapping("/afficherlivreparlibelleetauteur/{libelle}/{auteur}")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> rechercherparlibelleetauteur(@PathVariable String libelle,@PathVariable String auteur)
{
return service.rechercherparlibelleetauteur(libelle, auteur);
	
}
@GetMapping("/affichernblivre")
@CrossOrigin(origins="http://localhost:4200")
public int affichernblivre()
{
return service.affichernblivre();	
}
}

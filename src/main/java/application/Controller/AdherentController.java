package application.Controller;
import application.Service.AdherentService;
import application.model.*;
import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adherent")
public class AdherentController {
@Autowired
AdherentService service;

public AdherentController(AdherentService service)
{
this.service=service;
}
@GetMapping("/affichertoutadherent")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> affichertout () 
{
return service.affichertout();
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/ajouteradh")

public void ajouter (@RequestBody Adherent adh)
{
service.ajouter(adh);	
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/supprimeradh")

public void supprimer (@RequestBody JSONObject data)
{
String id=(String)(data.get("id"));
service.supprimer(Long.parseLong(id));	
}
@GetMapping("/afficherparnom/{nom}")	
@CrossOrigin(origins="http://localhost:4200")
public List<Adherent> rechercherparnom (@PathVariable String nom)
{
	System.out.println(nom);
return service.rechercherparnom(nom);
}
@GetMapping("/afficherparid/{id}")	
@CrossOrigin(origins="http://localhost:4200")
public Adherent rechercherparid (@PathVariable String id)
{
return service.rechercherparid(Long.parseLong(id));
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

}

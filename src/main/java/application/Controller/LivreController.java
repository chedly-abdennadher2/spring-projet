package application.Controller;
import application.Service.*;
import application.Service.LivreService;
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
@RequestMapping("/livre")

public class LivreController {
@Autowired
LivreService service;

public LivreController(LivreService service) {
	super();
	this.service = service;
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/ajouterlivre")
public void ajouter(@RequestBody Livre l)
{
service.ajouter(l);	
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/supprimerlivre")

public void supprimer (@RequestBody JSONObject data)
{

	String id=(String)(data.get("id"));
	System.out.println("id"+id);

	service.supprimer(Long.parseLong(id));
}
@GetMapping("/affichertoutlivre")
@CrossOrigin(origins="http://localhost:4200")
public List<Livre> affichertout()
{
return service.affichertout();	
}
@GetMapping("/afficherlivreparid/{id}")
@CrossOrigin(origins="http://localhost:4200")
public Livre rechercherparid(@PathVariable String id)
{
return service.rechercherparid(Long.parseLong(id));
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
}

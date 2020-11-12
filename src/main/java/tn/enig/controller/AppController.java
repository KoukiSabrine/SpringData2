package tn.enig.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IDepartementDeo;
import tn.enig.dao.IEmployeDao;
import tn.enig.dao.IProjetDeo;
import tn.enig.model.Departement;
import tn.enig.model.Employe;
import tn.enig.model.Projet;

@Controller
public class AppController {

	@Autowired
	IDepartementDeo daod;
	
	@Autowired
	IProjetDeo daop;
	
	@Autowired
	IEmployeDao daoe;
	
	public void SetDaoD(IDepartementDeo daod) {this.daod=daod;}
	public void SetDaoP(IProjetDeo daop) {this.daop=daop;}
	public void SetDaoE(IEmployeDao daoe) {this.daoe=daoe;}
	
	
	@GetMapping("/home")
	public String get1(Model m) {
		List<Departement> liste1=daod.findAll();
		m.addAttribute("liste",liste1);
		return "home";
	}
	
	@GetMapping("/projet/{id}")
	public String get2(Model m, @PathVariable("id") int id) {
		List<Projet>liste2=daop.getAllProjetsById(id);
		m.addAttribute("liste",liste2);
		return "projets";
	}
	

	@GetMapping("/employe/{id}")
	public String get3(Model m, @PathVariable("id") int id) {
		List<Employe>liste3=daoe.getAllEmployeByIdDep(id);
		m.addAttribute("liste",liste3);
		return "employes";
	}
	
	@GetMapping("/employePr/{id}")
	public String get9(Model m, @PathVariable("id") int id) {
		List<Employe>liste4=daoe.getAllEmployeByProjet(id);
		m.addAttribute("liste",liste4);
		return "employesPr";
	}
	
	
	 @GetMapping("/ajoutProjet")
 	public String get4(Model m) {
 	Projet p=new Projet();
 	List<Departement> listedep= daod.findAll();
 	List<String> listeEtats=new ArrayList<String>();
 	listeEtats.add("active");
 	listeEtats.add("achevé");
 	listeEtats.add("non lancé");
 	m.addAttribute("listeEtats", listeEtats);
 	m.addAttribute("p",p);
 	m.addAttribute("listedep", listedep);
 	
		return "ajoutp";
	}
	 
	@PostMapping("/saveProjet") 
	public String get5(Model m ,@ModelAttribute("p") Projet p) {
		daop.save(p);
		return "redirect:/home";
	 
	}
	 
	
	 @GetMapping("/ajoutEmploye")
	 	public String get6(Model m) {
	 	Employe e=new Employe();
	 	List<Departement> listedep= daod.findAll();
	 	List<Projet> listepr= daop.findAll();
	 	
	 	List<String> listeFonctions=new ArrayList<String>();
	 	listeFonctions.add("manager");
	 	listeFonctions.add("ingénieur");
	 	listeFonctions.add("technicien");
	 	
	 	m.addAttribute("listeFonctions", listeFonctions);
	 	m.addAttribute("e",e);
	 	m.addAttribute("listedep", listedep);
	 	m.addAttribute("listepr", listepr);
	 	
			return "ajoutE";
		}
	 
	 
	
		 
		@PostMapping("/saveEmploye") 
		public String get7(Model m ,@ModelAttribute("e") Employe e) {
			daoe.save(e);
			return "redirect:/home";
		 
		}
		 
	 
	 
	 
	 
	 
	 
	 
	
}

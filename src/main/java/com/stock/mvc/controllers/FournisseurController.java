package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.entites.Fournisseur;
import com.stock.mvc.services.IFlickrService;
import com.stock.mvc.services.IFournisseurService;

@Controller
@RequestMapping(value = "/fournisseur")
public class FournisseurController {
	
	//@autowired pour indiquer à spring qu'on veut faire de l'injection de dépendance automatiquement
	
	@Autowired
	private IFournisseurService fournisseurService;	
	@Autowired
	private IFlickrService flickrService;
	
	@RequestMapping(value = "/")
	public String fournisseur(Model model) {
		
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs == null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs", fournisseurs);
		return "fournisseur/fournisseur";
		
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterFournisseur(Model model) {
		
		Fournisseur fournisseur = new Fournisseur();
		//fournisseur.setNom("ZABS");
		model.addAttribute("fournisseur", fournisseur);
		return "/fournisseur/ajouterFournisseur";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerFournisseur(Model model, Fournisseur fournisseur, MultipartFile file) {
		String photoUrl = null;
		if(fournisseur != null) {
			
			if(file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, fournisseur.getNom());
					fournisseur.setPhoto(photoUrl);
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					System.out.println("Cool photo url: "+photoUrl);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			
			if(fournisseur.getIdFournisseur() != null) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool fournisseur ID UPDATE: "+fournisseur.getIdFournisseur());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				
				fournisseurService.update(fournisseur);
			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool fournisseur ID INSERT: "+ fournisseur.getIdFournisseur());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Cool fournisseur nom INSERT: "+fournisseur.getNom());
				
				fournisseurService.save(fournisseur);
			}
		}

		return "redirect:/fournisseur/";
	}
	
	@RequestMapping(value = "/modifier/{idFournisseur}")
	public String modifierFournisseur(Model model, @PathVariable Long idFournisseur) {
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null) {
				model.addAttribute("fournisseur", fournisseur);
			}
		}
		
		return "/fournisseur/ajouterFournisseur";
	}
	
	@RequestMapping(value = "/supprimer/{idFournisseur}")
	public String supprimerFournisseur(Model model, @PathVariable Long idFournisseur) {
		
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null) {
				//TODO Verification avant suppression
				fournisseurService.remove(idFournisseur);
			}
		}
		
		return "redirect:/fournisseur/";
	}
}

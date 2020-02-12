package com.stock.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.stock.mvc.entites.Category;
import com.stock.mvc.services.ICategoryService;

@Controller
@RequestMapping(value ="/category")
public class CategoryController {
	//@autowired pour indiquer à spring qu'on veut faire de l'injection de dépendance automatiquement
	
	@Autowired
	private ICategoryService categoryService;	

	
	@RequestMapping(value = "/")
	public String category(Model model) {
		
		List<Category> categories = categoryService.selectAll();
		if(categories == null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("categories", categories);
		return "category/category";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCategory(Model model) {
		
		Category category = new Category();
		//category.setCode("ZABS");
		model.addAttribute("category", category);
		return "/category/ajouterCategory";
	}


	@RequestMapping(value = "/enregistrer")
	public String enregistrerCategory(Model model, Category category) {
		//String photoUrl = null;
		if(category != null) {
			
			/*if(file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, category.getCode());
					category.setPhoto(photoUrl);
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

			}*/
			
			if(category.getIdCategory() != null) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool category ID UPDATE: "+category.getIdCategory());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				
				categoryService.update(category);
			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool category ID INSERT: "+ category.getIdCategory());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Cool category code INSERT: "+category.getDesignation());
				
				categoryService.save(category);
			}
		}

		return "redirect:/category/";
	}
	
	@RequestMapping(value = "/modifier/{IdCategory}")
	public String modifierCategory(Model model, @PathVariable Long IdCategory) {
		if(IdCategory != null) {
			Category category = categoryService.getById(IdCategory);
			if(category != null) {
				model.addAttribute("category", category);
			}
		}
		
		return "/category/ajouterCategory";
	}
	
	@RequestMapping(value = "/supprimer/{idCategory}")
	public String supprimerCategory(Model model, @PathVariable Long idCategory) {
		
		if(idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if(category != null) {
				//TODO Verification avant suppression
				categoryService.remove(idCategory);
			}
		}
		
		return "redirect:/category/";
	}

}

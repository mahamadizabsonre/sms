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

import com.stock.mvc.entites.Article;
import com.stock.mvc.entites.Category;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.ICategoryService;
import com.stock.mvc.services.IFlickrService;


@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	//@autowired pour indiquer à spring qu'on veut faire de l'injection de dépendance automatiquement
	
	@Autowired
	private IArticleService articleService;	
	@Autowired
	private IFlickrService flickrService;
	
	@Autowired
	private ICategoryService catService;
	
	@RequestMapping(value = "/")
	public String article(Model model) {
		
		List<Article> articles = articleService.selectAll();
		if(articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles", articles);
		return "article/article";
		
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterArticle(Model model) {
		
		Article article = new Article();
		List<Category> categories = catService.selectAll();
		if(categories == null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("article", article);
		model.addAttribute("categories", categories);
		return "/article/ajouterArticle";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrerArticle(Model model, Article article, MultipartFile file) {
		String photoUrl = null;
		if(article != null) {
			if(file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, article.getCodeArticle());
					article.setPhoto(photoUrl);
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
			
			if(article.getIdArticle() != null) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool article ID UPDATE: "+article.getIdArticle());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				
				articleService.update(article);
			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("Cool article ID INSERT: "+ article.getIdArticle());
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Cool article code INSERT: "+article.getCodeArticle());
				
				articleService.save(article);
			}
		}

		return "redirect:/article/";
	}
	
	@RequestMapping(value = "/modifier/{idArticle}")
	public String modifierArticle(Model model, @PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			List<Category> categories = catService.selectAll();
			if(categories == null) {
				categories = new ArrayList<Category>();
			}
			model.addAttribute("categories", categories);
			if(article != null) {
				model.addAttribute("article", article);
			}
		}
		
		return "/article/ajouterArticle";
	}
	
	@RequestMapping(value = "/supprimer/{idArticle}")
	public String supprimerArticle(Model model, @PathVariable Long idArticle) {
		
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			if(article != null) {
				//TODO Verification avant suppression
				articleService.remove(idArticle);
			}
		}
		
		return "redirect:/article/";
	}
	
}

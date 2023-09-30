package com.artShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.artShop.entity.Art;
import com.artShop.entity.MyArtList;
import com.artShop.service.ArtService;
import com.artShop.service.MyArtListService;

@Controller
public class ArtController {
	
	@Autowired
	private ArtService service;
	
	@Autowired
	private MyArtListService myArtService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/art_register")
	public String artRegister() {
		return "artRegister";
	}
	
	@GetMapping("/available_arts")
	public ModelAndView getAllArts() {
		List<Art>list=service.getAllArts();
		return new ModelAndView("artList","art",list);
	}
	
	@PostMapping("/save")
	public String addArt(@ModelAttribute Art a) {
		service.save(a);
		return "redirect:/available_arts";
	}
	
	@GetMapping("/my_arts")
	public String getMyArts(Model model) {
		List<MyArtList>list=myArtService.getAllMyArts();
		model.addAttribute("art",list);
		return "myArts";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Art a=service.getArtById(id);
		MyArtList ma=new MyArtList(a.getId(),a.getName(),a.getArtist(),a.getPrice());
		myArtService.saveMyArts(ma);
		return "redirect:/my_arts";
	}
	
	@RequestMapping("/editArt/{id}")
	public String editArt(@PathVariable("id") int id,Model model) {
		Art a=service.getArtById(id);
		model.addAttribute("art",a);
		return "artEdit";
	}
	
	@RequestMapping("/deleteArt/{id}")
	public String deleteArt(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_arts";
	}
	

	

}

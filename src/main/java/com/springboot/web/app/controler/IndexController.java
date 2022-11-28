package com.springboot.web.app.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
 @GetMapping({"/","","/index","/home"})
	public String index(Model model) {
	 model.addAttribute("titulo", "Hola Mundo!");
		return "index";
	}
	
	@RequestMapping("/perfil")
 public String perfil(Model model) {
	 Usuario usuario = new Usuario("Andrés","Perez");
	 model.addAttribute("usuario", usuario);
	 model.addAttribute("titulo", "Perfil Usuario: ".concat(usuario.getNombre()));
	 return "perfil";
 }
}

package com.springboot.web.app.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/", "", "/index", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Mundo!");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Andrés", "Perez","correo@falso.es");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
		
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios= Arrays.asList(new Usuario("Andrés", "Perez","correo@falso.es"),
				new Usuario("Lucho", "Garcia","correo@test.com"),
				new Usuario("Josito", "Ruiz","eljosete@falso.es"),
				new Usuario("Pepe", "Lopez","email@ejemplo.com")); 
		return usuarios;
	}
	
}

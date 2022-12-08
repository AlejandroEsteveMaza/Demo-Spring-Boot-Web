package com.springboot.web.app.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Usuario> usuarios= new ArrayList<>(); 
		
		usuarios.add(new Usuario("Andrés", "Perez","correo@falso.es"));
		usuarios.add(new Usuario("Lucho", "Garcia","correo@test.com"));
		usuarios.add(new Usuario("Josito", "Ruiz","eljosete@falso.es"));
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios",usuarios);
		return "listar";
		
	}
}

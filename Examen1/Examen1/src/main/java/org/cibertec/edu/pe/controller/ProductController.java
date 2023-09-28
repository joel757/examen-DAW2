package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.InterfaceService.IProductService;
import org.cibertec.edu.pe.interfaces.IProductRepository;
import org.cibertec.edu.pe.modelo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping
public class ProductController {
	@Autowired
	private IProductService servicio;
	
	// Método  Listar
	@GetMapping("/listar")	// http://localhost:8080/listar
	public String Listado(Model m) {
		List<Product> lista = servicio.Listar();
		m.addAttribute("colaboradores", lista);
		return "listado";	// listado.html
	}
	
	// Método  Buscar
	@GetMapping("/ver/{id}") 
	public String Buscar(@PathVariable String id,Model m) {
		Optional<Product> ObjC = servicio.Buscar(id);
		m.addAttribute("colaborador", ObjC);
		return "ver";		
	}
	
	// Método  insertar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("colaborador",new Product());
		return "form";		
	}
	
	// Método  grabar
	@PostMapping("/salvar")
	public String grabar(@Validated Product ObjC, Model m) {
		servicio.grabar(ObjC);
		return "redirect:/listar";
	}
	
	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model m) {
		Optional<Product> ObjC = servicio.Buscar(id);
		m.addAttribute("colaborador", ObjC);
		return "form";		
	}
	
	// Método para eliminar
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable String id, Model m) {
		servicio.Eliminar(id);
		return "redirect:/listar";	
	}
}

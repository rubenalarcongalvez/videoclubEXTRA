package org.iesvdm.controller;

import java.util.List;

import org.iesvdm.domain.Categoria;
import org.iesvdm.dto.CategoriaDTO;
import org.iesvdm.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaController {

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}

	@GetMapping("/detalle-categoria/{id}")
	public String verDetalleCategoria(@PathVariable("id") Long id, Model model) {
		
		//Categoria categoria = categoriaService.one(id);
		CategoriaDTO categoriaDTO = categoriaService.oneDTO(id);
		List<Integer> totalAlmacen = categoriaService.totalPorAlmacen(id);
		
		model.addAttribute("categoriaDTO", categoriaDTO);
		model.addAttribute("totalAlmacen", totalAlmacen);
		return "detalle-categoria";
	}
	
}

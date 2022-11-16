package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("api/categoria")
public class CategoriaControllers {
	
	@Autowired
	private CategoriaServices categoriaServices;
	
	@ApiOperation(value = "Crea todas las Categorias", notes = "Devuelve un listado con todas las Categorias.")
	@PostMapping
	private ResponseEntity<Categoria> guardar (@RequestBody Categoria categoria){
		Categoria temporal = categoriaServices.create(categoria);
		
		try {
			
			return ResponseEntity.created(new URI("/api/categoria"+temporal.getIdCategoria())).body(temporal);
			
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
	}
	
	
	@ApiOperation(value = "Busca todas las Categorias.", notes = "Devuelve un listado con todas las Categorias.")
	@GetMapping
	private ResponseEntity<List<Categoria>> listarTodasLasCategorias(){
		
			return ResponseEntity.ok(categoriaServices.getAllCategoria());
			
	}
	
	
	@ApiOperation(value = "Busca las categorias por id.", notes = "Devuelve un listado las Categorias")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Categoria>> listarCategoria (@PathVariable("id") Long id){
		
			return ResponseEntity.ok(categoriaServices.findById(id));
			
	}
	
	
	@ApiOperation(value = "elimina todas las categorias.", notes = "elimina las categorias.")
	@DeleteMapping
	private ResponseEntity<Void> eliminarCategoria (@RequestBody Categoria categoria){
		categoriaServices.delete(categoria);
			return ResponseEntity.ok().build();
			
	}
	
	
	

}

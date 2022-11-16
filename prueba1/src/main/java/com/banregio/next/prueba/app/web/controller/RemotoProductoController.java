package com.banregio.next.prueba.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.prueba.app.service.RemotoProductoService;
import com.banregio.next.prueba.remoto.dto.VentasDto;

import io.swagger.annotations.ApiOperation;

	@RestController
	@RequestMapping(value = "/remoto-ventas")
	public class RemotoProductoController {

		
		@Autowired
		private RemotoProductoService remotoProductoService;
		
		@ApiOperation(value = "Buscar todos los productos remotos", notes = "Devuelve un listado de todos los registros.")
		@GetMapping(value = "/")
		public List<VentasDto> findAllProducto() {
			return remotoProductoService.findProducto();
		}
		
}

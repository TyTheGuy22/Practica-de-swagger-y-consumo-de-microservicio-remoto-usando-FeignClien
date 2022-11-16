package com.banregio.next.prueba.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.prueba.remoto.dto.VentasDto;
import com.banregio.next.prueba.remoto.service.ProductoRemotoService;

@Service
public class RemotoProductoService {

	@Autowired
	private ProductoRemotoService productoRemotoService;
	
	public List<VentasDto> findProducto(){
		
		return productoRemotoService.findProducto();
		
	}
}

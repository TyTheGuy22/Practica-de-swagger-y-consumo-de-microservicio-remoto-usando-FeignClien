package com.banregio.next.prueba.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.banregio.next.prueba.remoto.dto.VentasDto;

@FeignClient("${producto.uri}")
public interface RemotoProductoRepository {

		@GetMapping(value = "/api/producto")
		List<VentasDto> findProducto();
		
	}

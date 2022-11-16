package com.banregio.next.prueba.remoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.base.exception.NextError500;
import com.banregio.next.base.feign.exception.NextFeignExceptionNoOpenCircuit;
import com.banregio.next.prueba.remoto.dto.VentasDto;
import com.banregio.next.prueba.remoto.repository.RemotoProductoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ProductoRemotoService {

	@Autowired
	private RemotoProductoRepository remotoProductoRepository;
	
	@HystrixCommand(fallbackMethod = "callFindProductoFallback",	ignoreExceptions = { NextFeignExceptionNoOpenCircuit.class })
	public List<VentasDto> findProducto()
	{
		return remotoProductoRepository.findProducto();
	}
	
	protected List<VentasDto> callFindProductoFallback(Throwable e) {

		log.error("callFindProductoFallback error al buscar producto",e);
		throw new NextError500(e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
	}
	
}

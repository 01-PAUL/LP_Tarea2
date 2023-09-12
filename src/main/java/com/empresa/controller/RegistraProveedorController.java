package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Pais;
import com.empresa.entity.Proveedor;
import com.empresa.entity.Tipo;
import com.empresa.service.PaisService;
import com.empresa.service.ProveedorService;
import com.empresa.service.TipoService;

@Controller
public class RegistraProveedorController {

	@Autowired
	public TipoService tipoService;
	
	@Autowired
	public PaisService paisService;
	
	@Autowired
	public ProveedorService proveedorService;
	
	@GetMapping(value = "/verRegistraProveedor" )
	public String verProveedor() {return "registraProveedor";}

	@ResponseBody
	@GetMapping(value = "/listaTipo")
	public List<Tipo> listaTipo(){
		return tipoService.listaTipo();
	}
	
	@ResponseBody
	@GetMapping(value = "/listaPais")
	public List<Pais> listaPais(){
		return paisService.listaPais();
	}
	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public Map<?, ?> registra(Proveedor obj){
		HashMap<String, String> map = new HashMap<String, String>();
		Proveedor objSalida = proveedorService.insertaProveedor(obj);
		if (objSalida == null) {
			map.put("MENSAJE", "Error en el registro");
		}else {
			map.put("MENSAJE", "Registro exitoso");
		}
		return map;
	}
	
	@GetMapping("/buscaPorNombreProveedor" )
	@ResponseBody
	public String validaNombre(String nombre){
		List<Proveedor> lstProveedor = proveedorService.listaPorNombre(nombre);
		if (CollectionUtils.isEmpty(lstProveedor)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
	
	@GetMapping("/buscaPorDniProveedor" )
	@ResponseBody
	public String validaDni(String dni){
		List<Proveedor> lstModalidad = proveedorService.listaPorDni(dni);
		if (CollectionUtils.isEmpty(lstModalidad)) {
			return "{\"valid\" : true }";
		} else {
			return "{\"valid\" : false }";
		}
	}
}

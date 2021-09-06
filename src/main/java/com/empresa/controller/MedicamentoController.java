package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMedicamento() {
		List<Medicamento> lista = service.listarMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> registrarMedicamento(@RequestBody Medicamento obj) {
		Medicamento objSalida = service.registrarMedicamento(obj);
		return ResponseEntity.ok(objSalida);
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Optional<Medicamento>> buscarPorId(@PathVariable("paramId") Integer idMedicamento) {
		if (idMedicamento == null) {
			return ResponseEntity.badRequest().build();
		} else {
			Optional<Medicamento> optMedicamento = service.buscarPorId(idMedicamento);
			if (optMedicamento.isPresent()) {
				return ResponseEntity.ok(optMedicamento);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@GetMapping("/nombre/{paramNom}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorNombre(@PathVariable("paramNom") String nombre) {
		List<Medicamento> lista = service.buscarPorNombre(nombre);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/stock/{paramStock}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorStock(@PathVariable("paramStock") int stock) {
		List<Medicamento> lista = service.buscarPorStock(stock);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}

}

package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	public Medicamento registrarMedicamento(Medicamento m) {
		return repository.save(m);
	}

	@Override
	public List<Medicamento> listarMedicamento() {
		return repository.findAll();
	}

	@Override
	public Optional<Medicamento> buscarPorId(int idMedicamento) {
		return repository.findById(idMedicamento);
	}

	@Override
	public List<Medicamento> buscarPorNombre(String nombre) {
		return repository.findByNombreStartingWith(nombre);
	}

	@Override
	public List<Medicamento> buscarPorStock(int stock) {
		return repository.findByStock(stock);
	}

}

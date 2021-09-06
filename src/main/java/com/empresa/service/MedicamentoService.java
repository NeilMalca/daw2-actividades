package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {

	public Medicamento registrarMedicamento(Medicamento m);
	public List<Medicamento> listarMedicamento();
	public Optional<Medicamento> buscarPorId(int idMedicamento);
	public List<Medicamento> buscarPorNombre(String nombre);
	public List<Medicamento> buscarPorStock(int stock);
	
}

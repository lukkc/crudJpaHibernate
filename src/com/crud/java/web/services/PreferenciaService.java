package com.crud.java.web.services;

import java.util.List;

import com.crud.java.web.models.Preferencia;
import com.crud.java.web.repository.PreferenciaRepository;

public class PreferenciaService {
	PreferenciaRepository preferenciaRepository = new PreferenciaRepository();
	
	public void createMany(List<Preferencia> preferencias) {	
		preferenciaRepository.createMany(preferencias);
	}
	
}

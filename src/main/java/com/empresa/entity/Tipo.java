package com.empresa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	
}

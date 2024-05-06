package com.curso.java;

import java.util.ArrayList;
import java.util.List;

public class PersonaCursos {

	private String nombre;
	private String apellido;
	private String tlf;
	private List<String> listaCursos;

	public PersonaCursos(String nombre, String apellido, String tlf) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tlf = tlf;
		this.listaCursos = new ArrayList<String>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public List<String> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(String curso) {
		this.listaCursos.add(curso);
	}

}

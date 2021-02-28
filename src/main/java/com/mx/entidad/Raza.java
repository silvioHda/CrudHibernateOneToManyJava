package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RAZA")
public class Raza {

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER")
	int id;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)")
	String nombre;
	@Column(name = "PAIS_ORIGEN", columnDefinition = "NVARCHAR(100)")
	String pais;
	@Column(name = "ANIOS", columnDefinition = "NUMBER")
	int anios;

	@OneToMany(mappedBy = "raza", cascade = CascadeType.ALL)
	private List<Perro> lista = new ArrayList<Perro>();

	public Raza() {

	}

	public Raza(int id) {
		this.id = id;
	}

	public Raza(int id, String nombre, String pais, int anios) {

		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.anios = anios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	@Override
	public String toString() {
		return "Raza [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", anios=" + anios + "] \n";
	}

}

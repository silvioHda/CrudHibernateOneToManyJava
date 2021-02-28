package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERRO5")
public class Perro {

	@Id
	@Column(name = "ID_PERRO", columnDefinition = "NUMBER")
	int id;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)")
	String nombre;
	@Column()
	int edad;
	@Column(name = "ESTATURA", columnDefinition = "NUMBER")
	double estatura;

	@ManyToOne(fetch = FetchType.EAGER)//RAPIDO ... LAZY LENTO
	@JoinColumn(name = "ID_RAZA")
	Raza raza;

	public Perro() {

	}

	public Perro(int id) {
		this.id = id;
	}

	public Perro(int id, String nombre, int edad, double estatura, Raza raza) {

		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.estatura = estatura;
		this.raza = raza;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + ", raza=" + raza
				+ "] \n";
	}

}

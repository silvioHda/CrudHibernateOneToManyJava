package com.mx.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Perro;
import com.mx.entidad.Raza;

public class Principal {

	//static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Animales");
	//static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {

		// insertar();
		//insertarPR();
		//editar();
		//mostrar();
		System.out.println("javapoit"+10+20);
		System.out.println(10+20+"javapoit");
	}
/*
	public static void mostrar() {

		List<Perro> lista = em.createQuery("from Perro order by id").getResultList();
		System.out.println("lista perro:");
		System.out.println(lista);

	}// cierra mostrar

	public static void insertar() {
		em.getTransaction().begin();
		Raza raza = new Raza(1);
		raza = em.find(Raza.class, raza.getId());
		Perro perro = new Perro(2, "firulais", 8, 1.6, raza);
		try {
			em.persist(perro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR INSERTAR->" + e.getMessage());
			em.getTransaction().rollback();
		}
	}// cierra insertar
	public static void insertarPR() {
		em.getTransaction().begin();
		try {
			Raza raza = new Raza(2, "Chihuahua", "México", 100);
			em.persist(raza);

			Perro perro = new Perro(3, "Corraje", 4, .7, raza);
			em.persist(perro);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR INSERTAR->" + e.getMessage());
			em.getTransaction().rollback();
		}
	}// cierra insertar
	
	
	public static void eliminar() {
		em.getTransaction().begin();
		try {
			
			Perro p = new Perro(3);
			p = em.find(Perro.class, p.getId());
			em.remove(p);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR eliminar->" + e.getMessage());
			em.getTransaction().rollback();
		}
	}// cierra insertar
	
	public static void editar() {
		em.getTransaction().begin();
		try {
			Raza raza = new Raza(2);
			raza = em.find(Raza.class, raza.getId());
			
			Perro p = new Perro(2, "firulais", 3, 6, raza);
			em.merge(p);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR editar->" + e.getMessage());
			em.getTransaction().rollback();
		}
	}// cierra insertar
	
	/*
	 * ESTE EJERCICIO TERMINARLO COMO CLIENTE-SERVIDOR
	 * DAO SERVI
	 * FRONT
	 * */
	

}
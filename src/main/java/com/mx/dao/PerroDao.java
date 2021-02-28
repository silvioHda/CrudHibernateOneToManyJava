package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Perro;
import com.mx.entidad.Raza;
import com.mx.general.Metodos;

public class PerroDao implements Metodos{
	EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
	EntityManager en = enf.createEntityManager();
	
	@Override
	public String guardar(Object o) {
		// TODO Auto-generated method stub
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
		EntityManager en = enf.createEntityManager();
		en.getTransaction().begin();
		
		Perro vg = (Perro)o;
		String respuesta =null;
		
		

		


		try {
			Raza raza = en.find(Raza.class, vg.getRaza().getId());
			
			vg.setRaza(raza);
			en.persist(vg);
			
			en.getTransaction().commit();
			respuesta = "Ingreso corretamente";
		}catch(Exception ex) {
			System.out.println("Error insertar -> "+ex.getMessage());
			en.getTransaction().rollback();
			respuesta = ex.getMessage();
		}
		return respuesta;
	}


	@Override
	public String eliminar(Object o) {
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
		EntityManager en = enf.createEntityManager();
		en.getTransaction().begin();
		String respuesta =null;
		Perro vg = (Perro)o;
		vg = en.find(Perro.class, vg.getId());
		try {
			en.remove(vg);
			en.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Error insertar -> "+ex.getMessage());
			en.getTransaction().rollback();
			respuesta = ex.getMessage();
		}
		return respuesta;
	}


	@Override
	public String editar(Object o) {
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
		EntityManager en = enf.createEntityManager();
		en.getTransaction().begin();
		String respuesta = null;
		Perro vg = (Perro)o;
		vg = en.find(Perro.class, vg.getId());
		
		try {
			en.merge(vg);
			en.getTransaction().commit();
			
			respuesta = "realizado";
		}catch(Exception ex) {
			System.out.println("Error insertar -> "+ex.getMessage());
			en.getTransaction().rollback();
			respuesta = ex.getMessage();
		}
		return respuesta;
	}


	@Override
	public Object buscar(Object o) {
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
		EntityManager en = enf.createEntityManager();
		en.getTransaction().begin();
		String respuesta = null;
		Perro vg = (Perro)o;
		vg = en.find(Perro.class, vg.getId());
		System.out.println("vg encontrado-> "+vg);
		return vg;
	}


	@Override
	public List mostrar() {
		List<Perro>lista = en.createQuery("From Perro").getResultList();
		System.out.println(lista);
		return lista;
	}
}

package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Raza;
import com.mx.general.Metodos;

public class RazaDao implements Metodos{
	EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
	EntityManager en = enf.createEntityManager();
	
	@Override
	public String guardar(Object o) {
		// TODO Auto-generated method stub
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("Goku");
		EntityManager en = enf.createEntityManager();
		en.getTransaction().begin();
		
		Raza vg = (Raza)o;
		String respuesta =null;
		try {
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
		Raza vg = (Raza)o;
		vg = en.find(Raza.class, vg.getId());
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
		Raza vg = (Raza)o;
		vg = en.find(Raza.class, vg.getId());
		
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
		Raza vg = (Raza)o;
		vg = en.find(Raza.class, vg.getId());
		System.out.println("vg encontrado-> "+vg);
		return vg;
	}


	@Override
	public List mostrar() {
		List<Raza>lista = en.createQuery("From Raza").getResultList();
		System.out.println(lista);
		return lista;
	}
}

package com.mx.servicios;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.RazaDao;
import com.mx.entidad.Raza;
import com.mx.general.Estatus;
@Path("Raza")
public class RazaServ {
RazaDao dao = null;
	
	@Path("datos")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})	
	public List<Raza> mostrar() {
		dao = new RazaDao();
		List<Raza>lista = dao.mostrar();
		return lista;
	}
	
	
	
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Raza e) {
		Estatus estatus = new Estatus();
		estatus.setObjecto(e);
		
		dao = new RazaDao();
		String res=dao.guardar(e);
		
		if (res.equals("1")) {
			estatus.setRespuesta("Guardado");
			estatus.setMensaje(res);
		}
		else 
		{
			estatus.setRespuesta("error");
			estatus.setMensaje(res);
		}
		
		return estatus;
	}
	
	@Path("eliminar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Raza e) {
		Estatus estatus = new Estatus();
		
		dao = new RazaDao();
		e=(Raza) dao.buscar(e);
		estatus.setObjecto(e);
		String res=dao.eliminar(e);
		
		if (res.equals("1")) {
			estatus.setRespuesta("eliminar");
			estatus.setMensaje(res);
		}
		else 
		{
			estatus.setRespuesta("error");
			estatus.setMensaje(res);
		}
		
		return estatus;
	}
	
	@Path("editar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Raza e) {
		Estatus estatus = new Estatus();
		
		dao = new RazaDao();
		//e=(Raza) dao.buscar(e);
		estatus.setObjecto(e);
		String res=dao.editar(e);
		
		if (res.equals("1")) {
			estatus.setRespuesta("editar");
			estatus.setMensaje(res);
		}
		else 
		{
			estatus.setRespuesta("error");
			estatus.setMensaje(res);
		}
		
		return estatus;
	}
	@Path("buscar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Raza buscar(Raza e) {
		dao = new RazaDao();
		e = (Raza)dao.buscar(e);
		return e;
	}
}

package com.mx.general;

import java.util.List;

public interface Metodos {

	public String guardar(Object o);

	public String editar(Object o);

	public String eliminar(Object o);

	public Object buscar(Object o);

	public List mostrar();
}

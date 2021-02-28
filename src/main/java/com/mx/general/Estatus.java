package com.mx.general;

public class Estatus {
	String respuesta;
	String mensaje;
	Object objecto;
	
	public Estatus() {
		
	}

	public Estatus(String respuesta, String mensaje, Object objecto) {
		this.respuesta = respuesta;
		this.mensaje = mensaje;
		this.objecto = objecto;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getObjecto() {
		return objecto;
	}

	public void setObjecto(Object objecto) {
		this.objecto = objecto;
	}
}

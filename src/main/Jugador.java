package main;

public class Jugador {
	String identificador;
	int puntuacion;
	boolean esAlta;
	
	public Jugador(String identificador) {
		this.identificador = identificador;
		puntuacion = 0;
		esAlta = false;
	}
	
	public String getCodigo() {
		return identificador;
	}
	
	public void muestra() {
		System.out.println("Jugador con Identificador: " + identificador + "\nPuntuacion: " + puntuacion);
	}
	
	
}
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
	
	public int getCodigo() {
		int aux = Integer.parseInt(identificador); 
		return aux;
	}
	
	public void muestra() {
		System.out.println("Jugador con Identificador: " + identificador + "\nPuntuacion: " + puntuacion);
	}
	
	
}
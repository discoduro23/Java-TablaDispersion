package main;

public class Main {

	public static void main(String[] args) {
		GameManager Juego = new GameManager();
		
		//System.out.println("TAMTABLE = " + Juego.tablaJugadores.TAMTABLA);
		//Juego.mostrarMenu();

		Jugador Player1 = new Jugador("Jefrey1", 12);
		Jugador Player2 = new Jugador("Jefre1", 44);
		Jugador Player3 = new Jugador("Jefr1", 78);
		Jugador Player4 = new Jugador("Jef1", 1);
		Jugador Player5 = new Jugador("Je1", 4);
		Jugador Player6 = new Jugador("J1", 6);
		Jugador Player7 = new Jugador("nothing1", 3);
		
		Juego.addJugador(Player1);
		Juego.addJugador(Player2);
		Juego.addJugador(Player3);
		Juego.addJugador(Player4);
		Juego.addJugador(Player5);
		Juego.addJugador(Player6);
		Juego.addJugador(Player7);
		
		Juego.visualizarRonda();
	}

}

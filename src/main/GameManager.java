package main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
	TablaDispersa tablaJugadores;

	public GameManager() {
		tablaJugadores = new TablaDispersa(15);
	}
	
	public void addJugador(Jugador jugadorMeter) {
		tablaJugadores.insertar(jugadorMeter);
	}
	
	
	
	public void mostrarMenu() {
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){
        	System.out.println("=========Selecciona una opción el menú=========");
            System.out.println("1. Insertar jugador");
            System.out.println("2. Añadir puntos a jugador");
            System.out.println("3. Visualizar ronda");
            System.out.println("4. Eliminar puntos a jugador");
            System.out.println("5. Eliminar jugador");
            System.out.println("6. Ver puntuaciones");
            System.out.println("7. Salir\n");
        

            try {
            	opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> System.out.println("Has seleccionado la opcion 1");
                    case 2 -> System.out.println("Has seleccionado la opcion 2");
                    case 3 -> System.out.println("Has seleccionado la opcion 3");
                    case 4 -> System.out.println("Has seleccionado la opcion 4");
                    case 5 -> System.out.println("Has seleccionado la opcion 5");
                    case 6 -> System.out.println("Has seleccionado la opcion 6");
                    case 7 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 7");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Debes insertar un número");
                sn.nextLine();
            }
        }
        sn.close();
    }
	
	
	public boolean jugadorYaEnTabla(Jugador comprobarJugador) {
		for(int i=0;  i<tablaJugadores.TAMTABLA; i++) {
			if((tablaJugadores.tabla[i].esAlta) && tablaJugadores.tabla[i].identificador == comprobarJugador.identificador)
				return true;
		}
		return false;
	}
	
	public boolean identificadorYaEnTabla(String identificador) {
		for(int i=0;  i<tablaJugadores.TAMTABLA; i++) {
			if((tablaJugadores.tabla[i].esAlta) && tablaJugadores.tabla[i].identificador == identificador)
				return true;
		}
		return false;
	}
	
	
	/*
	
	public boolean yaEnTabla(Object objComprobar) {
		if(objComprobar.getClass() == String.class) {	//Es una string
			if(tablaJugadores.tabla[tablaJugadores.direccion((String) objComprobar)].esAlta && (tablaJugadores.tabla[tablaJugadores.direccion((String) objComprobar)].identificador == objComprobar)) { //Esta activa, y el identificador es igual
				return true;
			
			} 
		} else { //Hemos metido el Jugador
			if(tablaJugadores.tabla[tablaJugadores.direccion((Jugador) objComprobar.identificador)].esAlta && (tablaJugadores.tabla[tablaJugadores.direccion((String) objComprobar)].identificador == objComprobar))
		}
		*/
	
	
	
	public void agregarPuntuacion(String identificador, int puntosSumar) {
		if(identificadorYaEnTabla(identificador)) {
			int aux = Integer.parseInt(identificador); 
			tablaJugadores.buscar(aux).puntuacion += puntosSumar;
		}
			
		else
			System.out.println("Error al aumentar la puntuacion, no esta en la tabla ese identificador");
	}
	
	public void visualizarRonda() {
				
		Jugador[] aux = tablaJugadores.devolverTabla();
		QuickShort quickAux = new QuickShort(aux, 0, tablaJugadores.getNumElementos() - 1);
		quickAux.mostrar(aux);
	}
	
	
	
}
	
	
	


	
	
	


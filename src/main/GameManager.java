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
        	
        	
        	System.out.println("\n=========Selecciona una opción el menú=========");
            System.out.println("1. Insertar jugador");
            System.out.println("2. Añadir puntos a jugador");
            System.out.println("3. Visualizar ronda"); //HECHO
            System.out.println("4. Eliminar puntos a jugador");
            System.out.println("5. Eliminar jugador");
            System.out.println("6. Ver puntuaciones");
            System.out.println("7. Salir\n");
        

            try {
            	opcion = sn.nextInt();
                switch (opcion) {
                    case 1: 
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion 1");
                    	break;
                    case 2:
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion 2");
                    	break;
                    case 3: 
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion \"Visualizar ronda\"");
                    	visualizarRonda();
                    	break;
                    case 4: 
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion 4");
                    	break;
                    case 5: 
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion 5");
                    	break;
                    case 6: 
                    	clearConsole();
                    	System.out.println("\nHas seleccionado la opcion 6");
                    	break;
                    case 7: 
                    	clearConsole();
                    	salir = true;
                    	break;
                    case 99: 
                    	clearConsole();
                    	rellenarTablaParaPruebas();
                    	break;
                    default: 
                    	clearConsole();
                    	System.out.println("\nSolo números entre 1 y 7");
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
				
		int numElementos = tablaJugadores.getNumElementos();
		
		if(tablaJugadores.getNumElementos() <= 0) System.out.println("No tenemos corredores!\nSelecciona 99 para rellenar con corredores de prueba");
		else {
			System.out.println("En la siguiente ronda compiten: ");
			Jugador[] aux = tablaJugadores.devolverTabla();
			QuickShort quickAux = new QuickShort(aux, 0, tablaJugadores.getNumElementos() - 1);
		
			
			int j = 0;
			for(int i = numElementos - 1; 0 <= i; i--) {
				if(j%2 == 0)
				System.out.print(aux[i].identificador + " vs "); //Print normal no salta de linea !!
				if(j%2 == 1)
					System.out.println(aux[i].identificador + "\n");
				j++;
			}
			
			if(numElementos%2 == 1) System.out.println("computer");
			
		}
		
	}
	
	public void rellenarTablaParaPruebas() {
		System.out.println("\nCorredores de testeo introducidos"); 
		//El nombre va relacionado con su puntaucion para ver mejor los fallos
		
		
		Jugador Player1 = new Jugador("J13", 13);
		Jugador Player2 = new Jugador("J25", 25);
		Jugador Player3 = new Jugador("J35", 35);
		Jugador Player4 = new Jugador("J4", 4);
		Jugador Player5 = new Jugador("J56", 56);
		Jugador Player6 = new Jugador("J68", 68);
		Jugador Player7 = new Jugador("J7", 7);
		
		addJugador(Player1);
		addJugador(Player2);
		addJugador(Player3);
		addJugador(Player4);
		addJugador(Player5);
		addJugador(Player6);
		addJugador(Player7);
	}
	
	public void clearConsole() {
        for(int i = 0; i < 60; i++)
        	{
        		System.out.println("\n");
        	}
	}
	
}
	
	
	


	
	
	


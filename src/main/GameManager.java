package main;
import java.util.InputMismatchException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameManager {
    TablaDispersa tablaJugadores;

    public GameManager() {
        tablaJugadores = new TablaDispersa(15);
    }
    public void pedirdatosjugador(){
        System.out.println("Escribe el identificador del jugador: ");
        Scanner in = new Scanner(System.in);
        String identificador = in.nextLine();

            if (identificadorYaEnTabla(identificador)){
                System.out.println("El identificador "+identificador+" ya se encuentra en la tabla, escribe uno nuevo");
            }
            else{
                Jugador nuevo =new Jugador(identificador);
                nuevo.puntuacion = 0;
                tablaJugadores.insertar(nuevo);
                System.out.println("El jugador con identificador "+identificador+" ha sido añadido con exito");
            }
    }
                //esta mierda no la he usado

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
                        System.out.println("\nHas seleccionado la opcion 1 \"Insertar Jugador\"");
                        pedirdatosjugador();
                        break;
                    case 2:
                    	clearConsole();
                        System.out.println("\nHas seleccionado la opcion 2 \"Añadir puntos a jugador\"");
                        pedirpuntosjugador();
                        break;
                    case 3:
                    	clearConsole();
                        System.out.println("\nHas seleccionado la opcion \"Visualizar ronda\"");
                        visualizarRonda();
                        break;
                    case 4:
                    	clearConsole();
                        System.out.println("\nHas seleccionado la opcion 4 \"Eliminar puntos a jugador\"");
                        pedirpuntosjugadorresta();
                        break;
                    case 5:
                    	clearConsole();
                        System.out.println("\nHas seleccionado la opcion 5 \"Eliminar Jugador\"");
                        borrarjugador();
                        break;
                    case 6:
                    	clearConsole();
                        System.out.println("\nHas seleccionado la opcion 6 \"Ver Puntuaciones\"");
                        verpuntuaciones();
                        break;
                    case 7:
                    	clearConsole();
                        System.out.println("\nGracias por usar nuestro sistema, hasta luego :)");
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

    public boolean comprobarstring(String np, String np2){
        if (np.contains(np2) && np2.length()==np.length()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean identificadorYaEnTabla(String identificador) {
        String comprueba;
        for(int i=0;  i<tablaJugadores.TAMTABLA; i++) {
            //puse una comprobacion por si la tabla es null, hemos quitado lo de es alta, no se que es y con eso nos da error
            if (tablaJugadores.tabla[i] != null){
                comprueba=tablaJugadores.tabla[i].identificador;
                if(comprobarstring(identificador,comprueba) && tablaJugadores.tabla[i].esAlta){
                    return true;
                }
            }
        }
        return false;
    }


    public void pedirpuntosjugador(){
        System.out.println("Escribe el identificador del jugador al que desee añadir puntos: ");
        Scanner in = new Scanner(System.in);
        String identificador = in.nextLine();

        if (!identificadorYaEnTabla(identificador)){
            System.out.println("El identificador "+identificador+" no se encuentra en la tabla, escribe uno nuevo");
        }
        else{
            System.out.println("Escribe el numero de puntos que desee añadir: ");
            Scanner reader = new Scanner(System.in);
            int puntos = 0;
            puntos = reader.nextInt();
            if(puntos >= 0) {
                agregarPuntuacion(identificador,puntos);
                System.out.println("Se han sumado "+puntos+" puntos con exito al jugador con identificador "+identificador);
            
            }
            else {
            	System.out.println("Oops! Parece que has intentado meter un numero negativo. Solo se aceptan numeros positivos \n");
            }
        }
    }
    public void pedirpuntosjugadorresta(){
        System.out.println("Escribe el identificador del jugador al que desee restar puntos: ");
        Scanner in = new Scanner(System.in);
        String identificador = in.nextLine();

        if (!identificadorYaEnTabla(identificador)){
            System.out.println("El identificador "+identificador+" no se encuentra en la tabla, escribe uno nuevo");
        }
        else{
            System.out.println("Escribe el numero de puntos que desee restar (en positivo): ");
            Scanner reader = new Scanner(System.in);
            int puntos = 0;
            puntos = reader.nextInt();
            if(puntos >= 0) {
            restarPuntuacion(identificador, puntos);
            }
            else {
            	System.out.println("Oops! Parece que has intentado meter un numero negativo. Solo se aceptan numeros positivos \n");
            }
        }
    }

    public void restarPuntuacion(String identificador, int puntosRestar){
        int resta = buscarindentificador(identificador);
        if (tablaJugadores.buscar(resta).puntuacion < puntosRestar || puntosRestar == 0) {
            System.out.println("Los puntos del jugador con identificador "+ identificador + " son: "+tablaJugadores.buscar(resta).puntuacion+"\n");
            if (puntosRestar == 0){ System.out.println("El numero a restar es 0 no se restara nada");}
            else {
                System.out.println("El numero que desea restar es mas grande que la puntuacion actual del jugador, ingrese un numero menor");
            }
        } else {
        	tablaJugadores.buscar(resta).puntuacion -= puntosRestar;

            System.out.println("Se han restado " + puntosRestar + " puntos con exito al jugador con identificador " + identificador);
            System.out.println("Los puntos del jugador con identificador "+ identificador + " son: "+tablaJugadores.buscar(resta).puntuacion+"\n");
        }

    }

    public void agregarPuntuacion(String identificador, int puntosSumar) {
        int sum = buscarindentificador(identificador);
        tablaJugadores.buscar(sum).puntuacion += puntosSumar;
        System.out.println("Los puntos del jugador con identificador "+ identificador + " son: "+tablaJugadores.buscar(sum).puntuacion+"\n");

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
        Jugador Player2 = new Jugador("J7", 7);
        Jugador Player3 = new Jugador("J35", 35);
        Jugador Player4 = new Jugador("J4", 4);
        Jugador Player5 = new Jugador("J56", 56);
        Jugador Player6 = new Jugador("J68", 68);
        Jugador Player7 = new Jugador("J25a", 25);
        Jugador Player8 = new Jugador("J25b", 25);
        Jugador Player9 = new Jugador("J25c", 25);
        
        addJugador(Player1);
        addJugador(Player2);
        addJugador(Player3);
        addJugador(Player4);
        addJugador(Player5);
        addJugador(Player6);
        addJugador(Player7);
        addJugador(Player8);
        addJugador(Player9);
    }

    public void borrarjugador() {
        System.out.println("Escribe el identificador del jugador: ");
        Scanner in = new Scanner(System.in);
        String identificador = in.nextLine();

        if (!identificadorYaEnTabla(identificador)){
            System.out.println("El identificador "+identificador+" no se encuentra en la tabla, escribe uno nuevo");
        }
        else{
            int sum = buscarindentificador(identificador);
            int indpj = tablaJugadores.buscar(sum).getCodigo();
            tablaJugadores.eliminar(indpj);
            System.out.println("El jugador con identificador "+identificador+" ha sido eliminado con exito");
        }
    }

    public int buscarindentificador(String identificador) {
        char ch[] = identificador.toCharArray();
        int sum = 0;
        int zeroAscii = (int)'0';
        for (char c:ch) {
            int tmpAscii = (int)c;
            sum = (sum*100)+(tmpAscii-zeroAscii);
        }
        return sum;
    }

    public void verpuntuaciones() {
    	int numElementos = tablaJugadores.getNumElementos();
		
		if(tablaJugadores.getNumElementos() <= 0) System.out.println("No tenemos corredores!\nSelecciona 99 para rellenar con corredores de prueba");
		else {
			System.out.println("A continuacion se muestran las puntuaciones: \n");
			Jugador[] aux = tablaJugadores.devolverTabla();
			
			MergeShortAlgorythm mergeAux = new MergeShortAlgorythm();
			aux = mergeAux.MergeOrdenacion(aux);
		
			for(int i = numElementos - 1; 0 <= i; i--) {
				System.out.println(aux[i].identificador + ", " + aux[i].puntuacion);
			}
			
			
		}
    }
    
    public void clearConsole() {
        for(int i = 0; i < 60; i++) {
        	System.out.println("\n");
        }
	}

}
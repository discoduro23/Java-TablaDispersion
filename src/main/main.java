package main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){
            mostrarMenu();

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
                System.out.println("Debes insertar un número entero");
                sn.nextLine();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("=========Selecciona una opción el menú=========");
        System.out.println("1. Insertar jugador");
        System.out.println("2. Añadir puntos a jugador");
        System.out.println("3. Visualizar ronda");
        System.out.println("4. Eliminar puntos a jugador");
        System.out.println("5. Eliminar jugador");
        System.out.println("6. Ver puntuaciones");
        System.out.println("7. Salir\n");
    }
}

package main;

public class Jugador {
    String identificador;
    int puntuacion;
    boolean esAlta;

    public Jugador(String identificador) {
        this.identificador = identificador;
        puntuacion = 0;
        esAlta = true;
    }

    public Jugador(String identificador, int punt) {
        this.identificador = identificador;
        puntuacion = punt;
        esAlta = true;
    }

    public int getCodigo() {
        char ch[] = identificador.toCharArray();
        int sum = 0;
        int zeroAscii = (int)'0';
        for (char c:ch) {
            int tmpAscii = (int)c;
            sum = (sum*10)+(tmpAscii-zeroAscii);
        }
        return sum;
    }

    public void muestra() {
        System.out.println("Jugador con Identificador: " + identificador + "\nPuntuacion: " + puntuacion);
    }


}

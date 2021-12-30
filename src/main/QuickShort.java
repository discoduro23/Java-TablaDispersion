package main;

public class QuickShort {
    QuickShort(){
    }

    QuickShort(Jugador[] array, int i, int j){
        QuickShortOrdenacion(array, i, j);
    }

    public void QuickShortOrdenacion(Jugador[] array, int i, int j) {
        Jugador pivote= array[i];
        int jaux=j, iaux=i;
        Jugador aux;
        while(iaux < jaux)  {
            while (array[iaux].puntuacion <= pivote.puntuacion && iaux < jaux){
                iaux++;
            }
            while (array[jaux].puntuacion > pivote.puntuacion) {
                jaux--;
            }
            if(iaux < jaux){
                aux = array[iaux];
                array[iaux] = array[jaux];
                array[jaux] = aux;
            }

        }

        array[i] = array[jaux];
        array[jaux] = pivote;

        if(i < jaux-1) QuickShortOrdenacion(array, i, jaux - 1);
        if(jaux + 1 < j) QuickShortOrdenacion(array, jaux + 1, j);
    }



	/*
	public int[] combinar(int[] array1, int[] array2, int pivote) {
		int length = array1.length + array2.length;
		int[] newArray = new int[length];
		int j = 1;
		int i = 0;
		int iteracion=0;
		while (iteracion<length) {

			while (i<array1.length-1) {
				newArray[i] = array2[i];
				i++;
			}
			i++;
			newArray[i] = pivote;
			while (j<array2.length) {
				newArray[i+j] = array1[j];
				j++;
			}
			iteracion++;
		}

		return newArray;
	}
	*/


    public void mostrar(Jugador[] array){
        for(int i=0; i<array.length;i++) {
            System.out.println(array[i].puntuacion);
        }
    }


    public boolean comprobarOrdenacion(Jugador[] array) {
        for(int i = 0; i<array.length-1; i++) {
            if (array[i].puntuacion >= array[i+1].puntuacion) return false;
        }
        return true;
    }

}

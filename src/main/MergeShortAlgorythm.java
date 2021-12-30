package main;

public class MergeShortAlgorythm {
    int numarray=0;
    public MergeShortAlgorythm() {
    }
    MergeShortAlgorythm(Jugador[] array){
    	array = MergeOrdenacion(array);
    }


    public Jugador[] MergeOrdenacion(Jugador[] array) {
        if(!comprobarOrdenacion(array)) {
            if(array.length <= 2) array = ordenar(array);
            else {
                Jugador[] array1 = null;

                Jugador[] array2 = null;


                int length = array.length;
                if ((float) length/2 > (int) length/2) {
                    length++;
                    array1 = new Jugador[length/2];
                    array2 = new Jugador[length/2-1];
                    for (int i=0; i<length-1;i++) {
                        if(i<length/2) array1[i] = array[i];
                        else array2[i-(length/2)] = array[i];
                    }
                    length--;
                }
                else {

                    array1 = new Jugador[length/2];
                    array2 = new Jugador[length/2];
                    for (int i=0; i<length;i++) {
                        if(i<length/2) array1[i] = array[i];
                        else array2[i-(length/2)] = array[i];
                    }
                }


                array1 = MergeOrdenacion(array1);
                array2 = MergeOrdenacion(array2);
                array = combinar(array1, array2);
            }
        }
        return array;
    }


    public Jugador[] combinar(Jugador[] array1, Jugador[] array2) {
        int length = array1.length + array2.length;
        Jugador[] newArray = new Jugador[length];
        int j = 0;
        int i = 0;
        int iteracion=0;
        while (iteracion<length) {
            if(i<array1.length && j<array2.length) {
                if (array1[i].puntuacion < array2[j].puntuacion) {
                    newArray[i+j] = array1[i];
                    i++;
                }
                else if (array1[i].puntuacion > array2[j].puntuacion) {
                    newArray[i+j] = array2[j];
                    j++;
                }

            }
            else if (i>=array1.length) {
                newArray[i+j] = array2[j];
                j++;
            }
            else if (j>=array2.length) {
                newArray[i+j] = array1[i];
                i++;
            }
            iteracion++;
        }

        return newArray;
    }



    public Jugador[] ordenar(Jugador[] array) {
        if(array.length <=1) {
            return array;
        }
        else if(array.length==2) {
            if(array[0].puntuacion > array[1].puntuacion) {
                Jugador aux = array[0];
                array[0] = array[1];
                array[1] = aux;
            }
        }

        return array;
    }

    public void partirArray(int[] array,int[] array1,int[] array2) {
        int length = array.length;
        if ((float) length/2 > (int) length/2) {
            length++;
            array1 = new int[length/2];
            array2 = new int[length/2];
            for (int i=0; i<length-1;i++) {
                if(i<length/2) array1[i] = array[i];
                else array2[i-(length/2)] = array[i];
            }
        }
        else {

            array1 = new int[length/2];
            array2 = new int[length/2];
            for (int i=0; i<length;i++) {
                if(i<length/2) array1[i] = array[i];
                else array2[i-(length/2)] = array[i];
            }
        }

    }

    public boolean comprobarOrdenacion(Jugador[] array) {
        for(int i = 0; i<array.length-1; i++) {
            if (array[i].puntuacion>array[i+1].puntuacion) return false;
        }
        return true;
    }

}

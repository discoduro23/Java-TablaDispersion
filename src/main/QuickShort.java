package main;

public class QuickShort {
	QuickShort(){
	}
	public void QuickShortOrdenacion(int[] array, int i, int j) {
		int pivote=0;
		if((float) ((i+j)/2) > (int) ((i+j)/2)) pivote = (int) ((i+j)/2)+1;
		else pivote=(int) ((i+j)/2);
			int aux = 0, jaux=j, iaux=i;
			do  {
				while (array[iaux] < array[pivote]){
					iaux++;
				}
				while (array[jaux] > array[pivote]) {
					jaux--;
				}
				if(iaux <= jaux){
					aux = array[iaux];
					array[iaux] = array[jaux];
					array[jaux] = aux;
					iaux++;
					jaux--;
				}
					
			}while(iaux<=jaux);
			if(jaux>i) QuickShortOrdenacion(array, i, jaux);
			if(iaux<j) QuickShortOrdenacion(array, iaux, j);
		
	}

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
	
	
	
	public void mostrar(int[] array){
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	public boolean comprobarOrdenacion(int[] array) {
		for(int i = 0; i<array.length-1; i++) {
			if (array[i]>array[i+1]) return false;
		}
		return true;
	}

}

package main;



public class TablaDispersa {

	public int TAMTABLA;
	private int numElementos;
	private double factorCarga;
	public Jugador[] tabla;	
	
	
	public TablaDispersa(int valorActualizarTAM) {
		//se inicializa la tabla y sus elementos a NULL
		
		//se inicializan los atributos a 0
		numElementos = 0;
		factorCarga = 0;
		
		calcularTama�oTabla(valorActualizarTAM);
		
		tabla = new Jugador[TAMTABLA];
		for(int i=0; i<TAMTABLA; i++) {
			tabla[i] = null;
		}
	}
	
	
	
	
	//devuelve la posici�n o �ndice de la tabla libre para insertar
	public int direccion(String clave) {
		int i = 0, p;
		long d;
		//como la clave de dispersion es de tipo cadena, primero se convierte a un valor entero
		d = transformaCadena(clave);
		
		//aplica aritmetica modular para obtener la direcci�n base
		
		p = (int)(d%TAMTABLA);
		
		//bucle de exploraci�n cuadratica
		
		while(tabla[p]!=null && !tabla[p].getCodigo().equals(clave)) {
			i++;
			p = p+i*i;
			p = p%TAMTABLA;//considera el array como circular
		}
		return p;
	}

	
	
	
	private long transformaCadena(String clave) {
		//m�todo de multiplicaci�n para realizar la transformaci�n. 
		//detalles de c�mo se obtiene, queda fuera del �mbito del tema
		long d = 0;
		 for(int j=0;j<Math.min(10, clave.length());j++) {
			 d = d*27+(int)clave.charAt(j);
		 }
		 
		 if(d<0) d=-d;
		return d;
	}
	
	
	
	
	public void insertar(Jugador r) {
		int posicion = direccion(r.getCodigo());
		tabla[posicion] = r;
		numElementos++;
		factorCarga = (double)(numElementos)/TAMTABLA;
		if(factorCarga > 0.8) System.out.println("\n#### EL FACTOR DE CARGA SUPERA EL 80%, conviene aumentar el tama�o");
		
	}
	
	
	
	
	//devuelve una referencia a un elemento di lo encuentra en la tabla y devuelve NULL si no lo encuentra o fue dado de baja
	public Jugador buscar(String clave) {
		
		int posicion = direccion(clave);
		Jugador pr = tabla[posicion];
		if(pr!=null)
			if(!pr.esAlta)	 pr = null;
		
		return pr;
	}
	
	
	
	
	//para dar de baja se siguen los mismos pasos que para buscar y se pone a false el atributo esAlta
	public void eliminar(String clave) {
		int posicion = direccion(clave);
		if(tabla[posicion]!=null)
			tabla[posicion].esAlta = false;
		
	}
	
	
	public void mostrarTabla() {
		for(int i=0; i<tabla.length; i++) {
			if(tabla[i] != null) {
				System.out.println("Posicion " + i + ":");
				tabla[i].muestra();
			} else
				System.out.println("Posicion " + i + " vacia.");
		}
	}
	
	
	
	
	private void calcularTama�oTabla(int valor) {
		TAMTABLA = calcularSiguientePrimo((int)(valor / 0.8));	
	}
	
	
	
	private boolean esPrimo(int valor) {
		int m = 2;
		boolean b = true;
		
		while(b && m<valor) {
			if((valor % m) == 0) b = false;
			else m++;
						
		}
		return b;
	}
	
	
	
	private int calcularSiguientePrimo(int valor) {
		while(true) {
			if(esPrimo(valor))	return valor;
			else	valor++;
		}
	}
}

package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TablaDispersa {

	int TAMTABLA = 0;
	int elementosIntroducir;
	int numElementos;
	double factorCarga;
	Jugador[] tabla;
	
	public TablaDispersa(int tam)
	{
		//se inicializa la tabla y sus elementos a NULL
		TAMTABLA = tamtablaEstatico(tam);
		tabla=new Jugador[TAMTABLA];
		for(int i=0; i<TAMTABLA;i++)
		{
			tabla[i]=null;
		}
		//se inicializan los atributos a 0
		numElementos=0;
		factorCarga=0;
	}
	
	public TablaDispersa()
	{
		//se inicializa la tabla y sus elementos a NULL
		TAMTABLA = tamtablaDinamico();
		tabla=new Jugador[TAMTABLA];
		for(int i=0; i<TAMTABLA;i++)
		{
			tabla[i]=null;
		}
		//se inicializan los atributos a 0
		numElementos=0;
		factorCarga=0;
	}
	
	public int tamtablaEstatico(int tam) {
		int resultado;
		
		resultado = (int) (tam / 0.8);
		resultado = nextPrime(resultado);
		System.out.println("El tamaño total de la tabla sera: " + resultado);
		return resultado;
	}
	
	
	public int tamtablaDinamico() {
		int resultado;
		BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("\n Introduzca numero de elementos: ");
			elementosIntroducir=Integer.parseInt(entrada.readLine());
		}
		catch(Exception e)
		{
			System.out.println("Excepción de entrada de datos, no se crea tabla");
			tamtablaDinamico();
		}
		
		resultado = (int) (elementosIntroducir / 0.8);
		resultado = nextPrime(resultado);
		System.out.println("El tamaño total de la tabla sera: " + resultado);
		return resultado;
	}
	//------------------------------
	// Function that returns true if n
    // is prime else returns false
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;
         
        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;
         
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
            return false;
         
        return true;
    }
     
    // Function to return the smallest
    // prime number greater than N
    static int nextPrime(int N)
    {
     
        // Base case
        if (N <= 1)
            return 2;
     
        int prime = N;
        boolean found = false;
     
        // Loop continuously until isPrime returns
        // true for a number greater than n
        while (!found)
        {
            prime++;
     
            if (isPrime(prime))
                found = true;
        }
     
        return prime;
    }
	
	//------------------------------
    
    public int GetelementosIntroducir() {
		return elementosIntroducir;
    }
	//devuelve la posición o índice de la tabla libre para insertar
	public int direccion(int identificador)
	{
		int i=0,p;
		long d;
		//como la clave de dispersion es de tipo cadena, primero se convierte a un valor entero
		d=identificador;
		
		//aplica aritmetica modular para obtener la dirección base
		
		p=(int)(d%TAMTABLA);
		
		//bucle de exploración cuadratica
		
		while(tabla[p]!=null && !(tabla[p].getCodigo() == identificador))
		{
			i++;
			p=p+i*i;
			p=p%TAMTABLA;//considera el array como circular
		}
		return p;
	}
	
	public void insertar(Jugador r)
	{
		int posicion=direccion(r.getCodigo());
		tabla[posicion]=r;
		numElementos++;
		factorCarga=(double)(numElementos)/TAMTABLA;
		if(factorCarga>0.8) System.out.println("\n#### EL FACTOR DE CARGA SUPERA EL 80%, conviene aumentar el tamaño");
		
	}
	
	//devuelve una referencia a un elemento di lo encuentra en la tabla y devuelve NULL si no lo encuentra o fue dado de baja
	public Jugador buscar(int identificador)
	{
		
		int posicion=direccion(identificador);
		Jugador pr=tabla[posicion];
		if(pr!=null)
			if(!pr.esAlta) pr=null;
		
		return pr;
	}
	
	//para dar de baja se siguen los mismos pasos que para buscar y se pone a false el atributo esAlta
	public void eliminar(int identificador)
	{
		int posicion=direccion(identificador);
		if(tabla[posicion]!=null)
			tabla[posicion].esAlta=false;
		
	}
	
	public Jugador[] devolverTabla() //Devuelve tabla SIN CEROS. Esencial para los algoritmos de ordenacion
	{
		Jugador[] aux = new Jugador[numElementos];
		
		int j = 0;
		for(int i = 0; i < TAMTABLA; i++)
		{
			if(tabla[i] != null) 
				{
				aux[j] = tabla[i];
				j++;
				}
		}
		
		return aux;
	}
	
	public int getNumElementos()
	{
		return numElementos;
	}
	
}

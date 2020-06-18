
import java.util.Random;


import Lectura.Leer;

public class JuegoAdivinarNumero implements InterfazJuego {

	private static final int ValorM�ximo = 100;
	/**
	 * Variables de clase
	 */
	private static Random obRandom;  // Objeto para poder generar n�meros aleatorios 
	private static byte contJuegos;  // Variable que contar� cuantos objetos de tipo juego se han creado
	
	/**
	 * Variables de instancia
	 */
	private byte numIntentos; // N�mero de intentos
	private byte numSecreto;  // N�mero secreto
	private byte m�nimo, m�ximo;    // Intervalo por el que "anda" el n�mero secreto
	
	
	/**
	 * Inicializador
	 */
	static {
		obRandom = new Random();
		contJuegos = 0;
	}
	

	public JuegoAdivinarNumero(byte numIntentos, byte numSecreto) {
		super();
		this.numIntentos = numIntentos;
		this.numSecreto = numSecreto;
		this.m�nimo = 1;
		this.m�ximo = ValorM�ximo;
	}
	

	public JuegoAdivinarNumero(byte numIntentos) {
		this(numIntentos, (byte)(obRandom.nextInt(100)+1));
	}
	
	public JuegoAdivinarNumero() {
		this((byte)5);
	}
	
	

	public static byte getContJuegos() {return contJuegos;}
	public static void setContJuegos(byte contJuegos) {JuegoAdivinarNumero.contJuegos = contJuegos;}


	public byte getNumIntentos() {return numIntentos;}
	public byte getNumSecreto() {return numSecreto;}
	public byte getMin() {return m�nimo;}
	public byte getMax() {return m�ximo;}
	
	public void setNumIntentos(byte numIntentos) {this.numIntentos = numIntentos;}
	public void setNumSecreto(byte numSecreto) {this.numSecreto = numSecreto;}
	public void setMin(byte min) {this.m�nimo = min;}
	public void setMax(byte max) {this.m�ximo = max;}



	@Override
	public boolean validarNumero(byte num) {
		return num == this.numSecreto;
	}
	

	@Override
	public void decrementarIntentos() {
		this.numIntentos--;
	}
	

	public boolean quedanIntentos() {
		return numIntentos>0;
	}
	

	@Override
	public void actualizarIntervalo(byte num) {
		if (num>numSecreto)
			m�ximo = (byte)(num-1);
		else if (num<numSecreto)
			m�nimo = (byte)(num+1);
	}
	

	@Override
	public String toString() {
		return "Quedan " + this.numIntentos + 
			   ", en el intervalo "+this.m�nimo+ ".."+this.m�ximo;
	}
	

	
	/**
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Crear un objeto tipo Juego
		JuegoAdivinarNumero obJuego=null;

		char resp;
		
		do {
			// Crear un objeto juego
			 obJuego = new JuegoAdivinarNumero();
			 
			
			// LLamar al metodo que realiza el Juego
			jugar(obJuego);
		
			
			System.out.println("Desea volver a jugar(S/N)? ");
			resp = Leer.leeChar();
		}
		while (resp=='S');
	}
	
	/**
	 * M�todo que realiza un juego
	 * @return TODO
	 */
	public static String jugar(JuegoAdivinarNumero obJuego) {
		byte numero;

		do {
			System.out.println("Introduzca numero: ");
			numero = Leer.leeByte();

			if (!obJuego.validarNumero(numero)) {
				obJuego.decrementarIntentos();
				obJuego.actualizarIntervalo(numero);
				System.out.println(obJuego.toString()); // se puede ver como traza
			}
		} while (obJuego.quedanIntentos() && !obJuego.validarNumero(numero) );

		if (obJuego.validarNumero(numero )) {
			System.out.println("Enhorabuena has acertado con: " + numero);
		}
		else
		{
			System.out.println("Lo siento el numero secreto es: " + obJuego.getNumSecreto());
		}
		return null;
	}

	
	
	}





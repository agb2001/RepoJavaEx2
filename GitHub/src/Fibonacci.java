
public class Fibonacci {
	
	
	/**
	 * Método que calcula el valor de la serie de fibonacci para el termino indicado
	 * Serie de Fibonacci 1 1 2 3 5 8 13 ...
	 * @param num
	 * @return
	 */
	public static int calculoTermino(int num) {
		int aux1=1, aux2=1, fib=1;

		for (int i=2; i<=num; i++) {
			fib=aux1+aux2;
			aux1=aux2;
			aux2=fib;
		}

		return fib;
	}
}

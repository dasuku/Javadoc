package JAVADOC;
import java.util.Scanner;

/**
 * El programa se basa en asignar una prima a los trabajadores en función de diferentes parámetros
 * 
 * @version 1.01
 * @author Jose Luis Alperi Cabeza
 * 
 */

public class PrimaMainMetodos {

	static Scanner  teclado=new Scanner(System.in);

	public static void main(String[] args) {

		/** Definimos las variables a usar
		 * -Número del empleado es un campo de números enteros positivos de 3 dígitos.
		-Nombre del empleado es un campo alfanumérico de 10 caracteres.
		-Meses de trabajo es un campo que indica el número de meses que lleva trabajando el empleado. Es un entero positivo.
		-Directivo es un campo de un solo carácter que puede ser «+» para indicar que el empleado es un directivo y «-» para indicar que no lo es.
		*/
		
		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;
		
		/**
		 * Desarrollamos un bucle para pedir todos los datos y llamamos a los diferentes métodos
		 */
		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			
			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');		
	}


	/**
	 * 
	 * @param esDirectivo El puesto que ocupa en la empresa, si es directivo o no
	 * @param meses Los meses que lleva trabajando en la empresa
	 * @return Asigna un tipo de prima P (que se muestra por pantalla) a cada empleado según las normas siguientes:
		P1 a los directivos con, al menos, 12 meses de antigüedad
		P2 a los no directivos con, al menos, 12 meses de antigüedad
		P3 a los directivos sin un mínimo de 12 meses de antigüedad
		P4 a los no directivos sin un mínimo de 12 meses de antigüedad
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

	/**
	 * Leemos el número de empleado para saber si está en el rango correcto
	 * @return un int con el número válido de empleado/a
	 */
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	/**
	 * Leemos el nombre del empleado para ver si la entrada es correcta
	 * @return un String con el nombre válido de empleado/a
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	
	/**
	 * Leemos los meses que lleva trabajando el empleado. No puede ser negativo
	 * @return - devuelve un entero con los meses de trabajo
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	
	/**
	 * Comprobamos si es directivo con los 2 valores aceptados: + -
	 * @return - devuelve el valor + ó - en función de si es directivo o no
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}

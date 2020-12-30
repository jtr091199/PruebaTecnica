package pe.com.eai.money.parts;

import java.util.ArrayList;

public class MoneyParts {

	public static void main(String[] args) {
		build(Double.parseDouble(args[0]));
	}

	public static void build(double monto) {
		// Iniciar Variables
		ArrayList<Double> numeros = new ArrayList<>();
		ArrayList<Double> denominaciones = new ArrayList<>();
		double suma = 0;
		// Denominaciones
		denominaciones.add(0.05);
		denominaciones.add(0.1);
		denominaciones.add(0.2);
		denominaciones.add(0.5);
		denominaciones.add(1.0);
		denominaciones.add(2.0);
		denominaciones.add(5.0);
		denominaciones.add(10.0);
		denominaciones.add(20.0);
		denominaciones.add(50.0);
		denominaciones.add(100.0);
		denominaciones.add(200.0);

		Implementation(monto, numeros, suma, denominaciones);

	}


	public static void Implementation(double monto, ArrayList<Double> numeros, double suma,
			ArrayList<Double> denominaciones) {

		if ((suma == monto)) {
			System.out.println("entrada:" + monto+" salida:"+numeros);
		} else {

			for (int i = 0; i < denominaciones.size(); i++) {

				suma += denominaciones.get(i);

				if (suma <= monto) {

					numeros.add(denominaciones.get(i));

					Implementation(monto, numeros, suma, denominaciones);

					numeros.remove(numeros.indexOf(denominaciones.get(i)));

				}

				suma -= denominaciones.get(i);

			}
		}
	}
}

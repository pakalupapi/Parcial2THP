package examen;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vuelo vuelo=new Vuelo("AA3313", 180);
		
		System.out.println(vuelo.reservarAsiento(11111111, 1234567890, "primera", "A", 1));
		System.out.println(vuelo.reservarAsiento(22222222, 1234567891, "turista", "F", 6));
		System.out.println(vuelo.reservarAsiento(33333333, 1234567892, "primera", "A", 2));
		System.out.println(vuelo.reservarAsiento(44444444, 1234567894, "turista", "F", 5));
		System.out.println(vuelo.reservarAsiento(55555555, 1234567895, "primera", "A", 1));
		
		vuelo.mostrarRecaudadoPorClase(Clase.PRIMERA);
		vuelo.mostrarRecaudadoPorClase(Clase.BUSINESS);
		vuelo.mostrarRecaudadoPorClase(Clase.TURISTA);
	}
}

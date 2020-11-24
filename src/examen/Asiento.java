package examen;

public class Asiento {
	private final double PRECIO_PRIMERA = 150000;
	private final double PRECIO_BUSINESS = 100000;
	private final double PRECIO_TURISTA = 50000;
	private Pasajero pasajero;
	private Clase clase;
	private double precio;
	private String fila;
	private int numero;
	
	public Asiento(String clase, String fila, int numero) {
		this.setClase(clase);
		this.setPrecioSegunClase();
		this.setFila(fila);
		this.setNumero(numero);
	}

	public void setPasajero(int dni, int telefono) {
		this.pasajero = new Pasajero(dni, telefono);
	}
	public int getDniPasajero() {
		return this.pasajero.getDni();
	}
	private void setClase(String clase) {
		if (clase.equalsIgnoreCase("primera")) {
			this.clase = Clase.PRIMERA;
		}
		else if(clase.equalsIgnoreCase("business")) {
			this.clase = Clase.BUSINESS;
		}
		else if (clase.equalsIgnoreCase("turista")) {
			this.clase = Clase.TURISTA;
		}
	}
	public Clase getClase() {
		return clase;
	}
	private void setPrecioSegunClase() {
		Clase clase = this.clase;
		if (clase == Clase.PRIMERA) {
			this.precio = PRECIO_PRIMERA;
		}
		else if (clase == Clase.BUSINESS) {
			this.precio = PRECIO_BUSINESS;
		}
		else {
			this.precio = PRECIO_TURISTA;
		}
	}
	public double getPrecio() {
		return precio;
	}
	private void setFila(String fila) {
		this.fila = fila;
	}
	public String getFila() {
		return this.fila;
	}
	private void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return this.numero;
	}
	@Override
	public String toString() {
		return "Asiento [PRECIO_PRIMERA=" + PRECIO_PRIMERA + ", PRECIO_BUSINESS=" + PRECIO_BUSINESS
				+ ", PRECIO_TURISTA=" + PRECIO_TURISTA + ", pasajero=" + pasajero + ", clase=" + clase + ", precio="
				+ precio + ", fila=" + fila + ", numero=" + numero + "]";
	}
}

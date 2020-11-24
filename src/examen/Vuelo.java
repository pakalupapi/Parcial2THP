package examen;
import java.util.ArrayList;	
public class Vuelo {
	private String numero;
	private int asientosTotales;
	private ArrayList<Asiento> asientosReservados;
	private double totalRecaudado;
	
	public Vuelo(String numero, int asientosTotales) {
		this.setNumero(numero);
		this.setAsientosTotales(asientosTotales);
		this.asientosReservados=new ArrayList<Asiento>();
		this.setTotalRecaudado(0);
	}
	private void setNumero(String numero) {
		this.numero = numero;
	}
	private void setAsientosTotales(int asientosTotales) {
		this.asientosTotales = asientosTotales;
	}
	private void setTotalRecaudado(double totalRecaudado) {
		this.totalRecaudado = totalRecaudado;
	}
	private double getTotalRecaudado() {
		return this.totalRecaudado;
	}
	private Asiento buscarAsientoReservado(String fila, int numero) {
		int i = 0;
		Asiento asientoEncontrado = null;
		Asiento asiento;
		
		while (i < this.asientosReservados.size() && asientoEncontrado == null) {
			asiento = this.asientosReservados.get(i);
			if (asiento.getFila().equalsIgnoreCase(fila) && asiento.getNumero() == numero) {
				asientoEncontrado = asiento;
			}
			i++;
		}
		return asientoEncontrado;
	}
	private boolean verDistanciamiento(String fila, int numero) {
		boolean resul = false;
		Asiento asientoDer;
		Asiento asientoIzq;
		
		if (numero ==1) {
			asientoDer = this.buscarAsientoReservado(fila, numero + 1);
			if (asientoDer == null) {
				resul = true;
			}
		}
		else if (numero == 6) {
				asientoIzq = this.buscarAsientoReservado(fila, numero - 1);
				if (asientoIzq == null) {
					resul = true;
				}
		}
		else {
			asientoIzq = this.buscarAsientoReservado(fila, numero - 1);
			asientoDer = this.buscarAsientoReservado(fila, numero + 1);
			if (asientoDer == null && asientoIzq == null) {
				resul = true;
			}
		}
		
		return resul;
	}
	private boolean hayAsientos() {
		return this.asientosReservados.size() < (this.asientosTotales / 2);
	}
	public ResultadoReservarBoleto reservarAsiento(int dni, int telefono, String clase, String fila, int numero) {
		Asiento asiento;
		ResultadoReservarBoleto resul = ResultadoReservarBoleto.AVION_COMPLETO;
		
		if(this.hayAsientos()) {
			asiento = this.buscarAsientoReservado(fila, numero);
			if (asiento != null) {
				resul = ResultadoReservarBoleto.TIENE_PASAJE;
			}
			else {
				if (this.verDistanciamiento(fila, numero)) {
					asiento=new Asiento(clase, fila, numero);
					asiento.setPasajero(dni, telefono);
					this.agregarAsientoReservado(asiento);
					this.setTotalRecaudado(this.getTotalRecaudado() + asiento.getPrecio());
					resul = ResultadoReservarBoleto.RESERVA_CONFIRMADA;
					}
				else {
					resul = ResultadoReservarBoleto.ASIENTO_LADO_OCUPADO;
				}
			}
		}
		return resul;
	}
	private void agregarAsientoReservado(Asiento asiento) {
		this.asientosReservados.add(asiento);
	}
	private double obtenerAcumuladoPorClase(Clase clase) {
		double resul = 0;
		for (Asiento asiento: this.asientosReservados) {
			if (asiento.getClase() == clase) {
				resul += asiento.getPrecio();
			}
		}
		return resul;
	}
	public void mostrarRecaudadoPorClase(Clase clase) {
		double monto;
		
		if (this.getTotalRecaudado() == 0) {
			System.out.println("No hay asientos reservados en ninguna clase");
		}
		else {
			monto = this.obtenerAcumuladoPorClase(clase);
			if (monto == 0) {
				System.out.println("No hay asientos reservados para la clase "+ clase);
			}
			else {
				System.out.println("El acumulado hasta el momento de la clase "+ clase+ " es: $"+ monto);
			}
		}
	}
}

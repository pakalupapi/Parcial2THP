package examen;

public class Pasajero {
	private int dni;
	private int telefono;
	
	public Pasajero(int dni, int telefono) {
		this.setDni(dni);
		this.setTelefono(telefono);
	}
	private void setDni(int dni) {
		this.dni = dni;
	}
	public int getDni() {
		return dni;
	}
	private void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", telefono=" + telefono + "]";
	}
}

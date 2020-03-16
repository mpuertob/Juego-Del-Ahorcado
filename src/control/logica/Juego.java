package control.logica;

import modelo.Palabra;

public class Juego {
	private int fallos = 0;
	private final int limiteFallos = 6;
	private Palabra palabra;

	public Juego() {
		super();
	}

	public Palabra crearPalabra(String palabrita) {
		Palabra palabra = new Palabra(palabrita);
		this.setPalabra(palabra);
		return null;
	}

	public void setPalabra(Palabra palabra) {
		this.palabra = palabra;
	}

	public int getFallos() {
		return fallos;
	}

	public void reiniciarPartida() {
		this.fallos = 0;
	}

	public void aumentarFallos() {
		this.fallos += 1;
	}

	public int getLimiteFallos() {
		return limiteFallos;
	}

	public Palabra getPalabra() {
		return palabra;
	}

	public boolean isPerdido() {
		boolean respuesta = false;
		if (this.getFallos() == this.getLimiteFallos()) {
			respuesta = true;
		}
		return respuesta;
	}

	public boolean isPalabraAcertada() {
		boolean respuesta = true;
		int i = 0;
		do {
			respuesta = true;
			if (this.palabra.getPalabraEscondida()[i] != this.palabra.getPalabreja().toCharArray()[i]) {
				respuesta = false;
			}
			i++;
		} while (i < this.palabra.getLongitud() && respuesta);
		return respuesta;
	}
}

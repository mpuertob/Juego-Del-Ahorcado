package modelo;

public class Palabra {
	private String palabreja = new String();
	private int longitud;
	private char[] palabraEscondida;

	public Palabra(String palabreja) {
		super();
		this.palabreja = palabreja.toLowerCase();
		this.longitud = palabreja.length();
		this.palabraEscondida = ocultarPalabra();
	}

	public char[] getPalabraEscondida() {
		return palabraEscondida;
	}

	public void setPalabreja(String palabreja) {
		this.palabreja = palabreja;
	}

	public String getPalabreja() {
		return palabreja;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setPalabraEscondida(char[] palabraEscondida) {
		this.palabraEscondida = palabraEscondida;
	}

	public char[] ocultarPalabra() {
		char caracter = '-';
		char[] palabraEscondida = new char[this.getLongitud()];
		for (int i = 0; i < palabraEscondida.length; i++) {
			palabraEscondida[i] = (caracter);
		}
		return palabraEscondida;
	}

	public boolean isAcierto(char letra) {
		boolean respuesta = false;
		letra = Character.toLowerCase(letra);
		for (int i = 0; i < this.getLongitud(); i++) {
			if (Character.valueOf(this.palabreja.toCharArray()[i]) == letra) {
				this.palabraEscondida[i] = letra;
				respuesta = true;
				this.setPalabraEscondida(palabraEscondida);
			}
		}
		return respuesta;
	}
}

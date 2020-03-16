package control.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.logica.Juego;
import modelo.Palabra;
import vista.UI;

public class ParaUI extends UI {
	Juego juego = new Juego();

	public ParaUI() {
		super();
		getBtnYa().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!getTxtPalabraSecreta().getText().isEmpty()) {
					hideSecretDialog(false);
					juego.crearPalabra(getTxtPalabraSecreta().getText());
					getTxtFallos().setText(String.valueOf(juego.getFallos()));
				}
			}
		});
		getTxtLetra().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!juego.isPerdido()) {

					if (testLetter()) {
						if (!juego.getPalabra().isAcierto(getLetter())) {
							juego.aumentarFallos();
							getTxtFallos().setText(String.valueOf(juego.getFallos()));
						} else {
							getTxtAciertos().setText(String.valueOf(juego.getPalabra().getPalabraEscondida()));
						}
					}
					if (juego.isPalabraAcertada() || juego.isPerdido()) {
						terminarPartida(juego.isPerdido());
						getBtnReiniciar().setVisible(true);
					}
				}
				getTxtLetra().setText("");
			}

		});
		getBtnReiniciar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideSecretDialog(true);
				reiniciar();
				juego.reiniciarPartida();
			}
		});
	}

}

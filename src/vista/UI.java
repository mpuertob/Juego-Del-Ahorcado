package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class UI extends JFrame {

	private JTextField txtPalabraSecreta;
	private JTextField txtLetra;
	private JTextField txtAciertos;
	private JTextField txtFallos;
	private JTextField txtMensaje;
	private JPanel contentPane;
	private JButton btnYa;
	private JLabel lblPalabraSecreta;
	private JLabel lblTitulo;
	private JButton btnReiniciar;

	public JButton getBtnYa() {
		return btnYa;
	}

	public JTextField getTxtAciertos() {
		return txtAciertos;
	}

	public JTextField getTxtLetra() {
		return txtLetra;
	}

	public JTextField getTxtPalabraSecreta() {
		return txtPalabraSecreta;
	}

	public JTextField getTxtFallos() {
		return txtFallos;
	}

	protected boolean testLetter() {
		return !txtLetra.getText().isEmpty() && txtLetra.getText().length() == 1
				&& Character.isLetter(txtLetra.getText().charAt(0));
	}

	protected char getLetter() {
		return txtLetra.getText().charAt(0);
	}

	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}

	protected void hideSecretDialog(boolean respuesta) {
		lblPalabraSecreta.setVisible(respuesta);
		txtPalabraSecreta.setVisible(respuesta);
		btnYa.setVisible(respuesta);
		txtLetra.setEditable(!respuesta);
		lblTitulo.setVisible(!respuesta);
		btnReiniciar.setVisible(respuesta);

	}

	protected void reiniciar() {
		txtFallos.setText("");
		txtMensaje.setText("");
		txtAciertos.setText("");
		txtPalabraSecreta.setText("");
	}

	protected void terminarPartida(boolean ganar) {
		txtLetra.setEditable(false);
		String fallos = txtFallos.getText();
		if (fallos.isEmpty()) {
			fallos = "0";
		}
		if (!ganar) {
			txtMensaje.setText("Enhorabuena has ganado con: " + fallos + " fallos");
		} else {
			txtMensaje.setText("Has perdido con: " + fallos + " fallos");
		}
		txtFallos.setText("");
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcos\\eclipse-workspace\\03 AhorcadoMVCMio\\iconoAhorcado.png"));
		setResizable(false);
		setTitle("El juego del Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LeerPalabra
		lblPalabraSecreta = new JLabel("Palabra Secreta");
		lblPalabraSecreta.setBounds(10, 11, 94, 14);
		contentPane.add(lblPalabraSecreta);

		txtPalabraSecreta = new JTextField();
		txtPalabraSecreta.setBounds(111, 8, 252, 20);
		contentPane.add(txtPalabraSecreta);
		txtPalabraSecreta.setColumns(10);

		btnYa = new JButton("Ya!");
		btnYa.setBounds(368, 7, 56, 23);
		contentPane.add(btnYa);

		// LeerLetra
		JLabel lblLetra = new JLabel("letra");
		lblLetra.setBounds(26, 84, 36, 14);
		contentPane.add(lblLetra);

		txtLetra = new JTextField();

		txtLetra.setEditable(false);
		txtLetra.setBounds(69, 81, 49, 20);
		contentPane.add(txtLetra);
		txtLetra.setColumns(1);

		// MostrarAciertos
		txtAciertos = new JTextField();
		txtAciertos.setEditable(false);
		txtAciertos.setBounds(69, 156, 302, 20);
		contentPane.add(txtAciertos);
		txtAciertos.setColumns(10);

		JLabel lblAciertos = new JLabel("Aciertos");
		lblAciertos.setBounds(69, 131, 56, 14);
		contentPane.add(lblAciertos);

		JLabel lblFallos = new JLabel("Fallos");
		lblFallos.setBounds(69, 187, 46, 14);
		contentPane.add(lblFallos);

		txtFallos = new JTextField();
		txtFallos.setEditable(false);
		txtFallos.setBounds(125, 187, 56, 20);
		contentPane.add(txtFallos);
		txtFallos.setColumns(10);

		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(16, 237, 64, 14);
		contentPane.add(lblMensaje);

		txtMensaje = new JTextField();
		txtMensaje.setEditable(false);
		txtMensaje.setBounds(79, 234, 345, 20);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);

		lblTitulo = new JLabel("El juego del Ahorcado");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(96, 36, 302, 46);
		lblTitulo.setVisible(false);
		contentPane.add(lblTitulo);

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setVisible(false);
		btnReiniciar.setBounds(173, 93, 89, 23);
		contentPane.add(btnReiniciar);
	}

}

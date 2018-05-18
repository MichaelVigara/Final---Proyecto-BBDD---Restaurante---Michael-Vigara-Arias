package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class AñadirComII {

	private JFrame frame;
	private JTextField textNMesa;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirComII window = new AñadirComII();
					window.frame.setVisible(true);
					window.frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AñadirComII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa");
		lblNumeroDeMesa.setBounds(10, 23, 93, 14);
		frame.getContentPane().add(lblNumeroDeMesa);
		
		textNMesa = new JTextField();
		textNMesa.setBounds(113, 20, 86, 20);
		frame.getContentPane().add(textNMesa);
		textNMesa.setColumns(10);
		
		JLabel label = new JLabel("Numero de Mesa");
		label.setBounds(10, 54, 93, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(113, 51, 86, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo8.jpg"));
		lblFondo.setBounds(0, -11, 969, 533);
		frame.getContentPane().add(lblFondo);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre Del Producto");
		lblNombreDelProducto.setBounds(10, 79, 46, 14);
		frame.getContentPane().add(lblNombreDelProducto);
	}
}

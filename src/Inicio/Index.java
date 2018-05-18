package Inicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import InicioSesion.InicioAdminI;
import Restaurante.InicioRestauranteI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
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
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Administracion");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InicioAdminI inicioAdmin = new InicioAdminI();
					inicioAdmin.frame.setVisible(true);
					
			}
		});
		button.setBounds(48, 417, 127, 48);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Restaurante");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioRestauranteI iniciorest = new InicioRestauranteI();
				iniciorest.frame.setVisible(true);
			}
		});
		button_1.setBounds(556, 417, 127, 48);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes\\fondo.jpg"));
		lblNewLabel.setBounds(0, 0, 734, 510);
		frame.getContentPane().add(lblNewLabel);
	}
}

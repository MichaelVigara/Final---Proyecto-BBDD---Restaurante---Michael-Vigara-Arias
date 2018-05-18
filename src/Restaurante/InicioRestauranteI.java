package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioRestauranteI {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioRestauranteI window = new InicioRestauranteI();
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
	public InicioRestauranteI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 469, 198);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Calcular Importe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketsII ticket = new TicketsII();
				ticket.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 71, 138, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 11, 72, 23);
		frame.getContentPane().add(btnAtras);
		
		JButton btnComandas = new JButton("Comandas");
		btnComandas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandasI comandas = new ComandasI();
				comandas.frame.setVisible(true);
			}
		});
		btnComandas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComandas.setBounds(158, 71, 138, 62);
		frame.getContentPane().add(btnComandas);
		
		JButton btnTicket = new JButton("Ticket");
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketsII ticket = new TicketsII();
				ticket.frame.setVisible(true);
			}
		});
		btnTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTicket.setBounds(306, 71, 138, 62);
		frame.getContentPane().add(btnTicket);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo8.jpg"));
		lblFondo.setBounds(0, 0, 464, 158);
		frame.getContentPane().add(lblFondo);
	}

}

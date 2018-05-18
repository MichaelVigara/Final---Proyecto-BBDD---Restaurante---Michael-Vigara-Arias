package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComandasI {

	JFrame frame;
	private JTable ComandasMesaComProdCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComandasI window = new ComandasI();
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
	public ComandasI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(8, 11, 67, 23);
		frame.getContentPane().add(btnAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 45, 599, 215);
		frame.getContentPane().add(scrollPane);
		
		ComandasMesaComProdCant = new JTable();
		ComandasMesaComProdCant.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero de Mesa", "Numero de Comandas", "Productos", "Cantidad"
			}
		));
		scrollPane.setViewportView(ComandasMesaComProdCant);
		
		ConexionBBDD Prueba = new ConexionBBDD();
		ComandasMesaComProdCant.setModel(Prueba.Comandas());
		
		JComboBox comboBoxMesas = new JComboBox();

		comboBoxMesas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxMesas.setModel(new DefaultComboBoxModel(new String[] {"Todas las Mesas", "Mesa 01", "Mesa 02", "Mesa 03", "Mesa 04", "Mesa 05", "Mesa 06", "Mesa 07", "Mesa 08", "Mesa 09", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15"}));
		comboBoxMesas.setBounds(18, 271, 163, 40);
		frame.getContentPane().add(comboBoxMesas);
		
		
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirProductosII añadirprod = new AñadirProductosII();
				añadirprod.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(453, 271, 150, 43);
		frame.getContentPane().add(btnNewButton);
		

		
		comboBoxMesas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String nomb_mesa =  (String) comboBoxMesas.getSelectedItem();
				if(nomb_mesa != "") {
					if(nomb_mesa.equals("Todas las Mesas")) {
						ComandasMesaComProdCant.setModel(Prueba.Comandas());

					}else {
						ComandasMesaComProdCant.setModel(Prueba.BuscarMesa(nomb_mesa));
					}
									
			}
				}
			
		});
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo8.jpg"));
		lblFondo.setBounds(0, 0, 675, 325);
		frame.getContentPane().add(lblFondo);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("A\u00F1adir");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPedido = new JMenuItem("Pedido");
		mnNewMenu.add(mntmPedido);
		
		mntmPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AñadirProductosII añadirprod = new AñadirProductosII();
				añadirprod.frame.setVisible(true);
			}

		});
		
	}
}

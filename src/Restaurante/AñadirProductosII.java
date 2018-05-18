package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class AñadirProductosII {

	JFrame frame;
	private JTextField textNombreProd;
	private JTable AñadirProductoProdCateg;
	private JTextField textFieldCantidad;
	private JTextField textFieldIDPed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirProductosII window = new AñadirProductosII();
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
	public AñadirProductosII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 335, 313);
		frame.getContentPane().add(scrollPane);
		
		AñadirProductoProdCateg = new JTable();
		AñadirProductoProdCateg.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del Producto", "Categoria"
			}
		));
		scrollPane.setViewportView(AñadirProductoProdCateg);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(357, 180, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombreProd = new JTextField();

		textNombreProd.setBounds(465, 177, 100, 20);
		frame.getContentPane().add(textNombreProd);
		textNombreProd.setColumns(10);
		
		JComboBox Categoria = new JComboBox();

		Categoria.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		Categoria.setBounds(10, 11, 148, 20);
		frame.getContentPane().add(Categoria);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 380, 65, 23);
		frame.getContentPane().add(btnAtras);
		
		ConexionBBDD Prueba = new ConexionBBDD();
		AñadirProductoProdCateg.setModel(Prueba.AñadirProd());
		
		JComboBox ComboBoxmesa = new JComboBox();

		ComboBoxmesa.setModel(new DefaultComboBoxModel(new String[] {"Mesa 01", "Mesa 02", "Mesa 03", "Mesa 04", "Mesa 05", "Mesa 06", "Mesa 07", "Mesa 08", "Mesa 09", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15"}));
		ComboBoxmesa.setBounds(465, 92, 100, 20);
		frame.getContentPane().add(ComboBoxmesa);

		
		textNombreProd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nomb_producto = textNombreProd.getText();
				Prueba.BuscarProdRestAñadProd(nomb_producto);
				AñadirProductoProdCateg.setModel(Prueba.BuscarProdRestAñadProd(nomb_producto));

			}
		});
		
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa");
		lblNumeroDeMesa.setBounds(358, 95, 100, 14);
		frame.getContentPane().add(lblNumeroDeMesa);
		

		
		Categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String nomb_producto = textNombreProd.getText();
				String nomb_categoria =  (String) Categoria.getSelectedItem();
				if(nomb_producto != "" || nomb_categoria != "") {
					if(nomb_categoria.equals("Todas las Categorias")) {
						AñadirProductoProdCateg.setModel(Prueba.AñadirProd());

					}else {
						AñadirProductoProdCateg.setModel(Prueba.BuscarCateRestAñadProd(nomb_categoria));
					}
										
			}
				}
		});
		
		JLabel labelCantidad = new JLabel("Cantidad");
		labelCantidad.setBounds(358, 224, 81, 14);
		frame.getContentPane().add(labelCantidad);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAadir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAadir.setBounds(429, 334, 139, 68);
		frame.getContentPane().add(btnAadir);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(465, 220, 46, 22);
		frame.getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblIdPedido = new JLabel("ID Pedido");
		lblIdPedido.setBounds(358, 139, 65, 16);
		frame.getContentPane().add(lblIdPedido);
		
		textFieldIDPed = new JTextField();
		textFieldIDPed.setBounds(462, 136, 53, 22);
		frame.getContentPane().add(textFieldIDPed);
		textFieldIDPed.setColumns(10);
			
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo8.jpg"));
		lblFondo.setBounds(-40, 0, 618, 506);
		frame.getContentPane().add(lblFondo);
		
		AñadirProductoProdCateg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			int row = AñadirProductoProdCateg.getSelectedRow();
			String nomb_producto=AñadirProductoProdCateg.getValueAt(row, 0).toString();
			textNombreProd.setText(nomb_producto);
		}
	});
	}
}

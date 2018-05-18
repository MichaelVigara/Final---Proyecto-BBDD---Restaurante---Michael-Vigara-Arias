package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarProd {

	JFrame frame;
	private JTable ModProd;
	private JTextField textID;
	private JTextField textProducto;
	private JTextField textPrecio;
	private JButton btnActualizar;
	private JLabel lblFondo;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProd window = new ModificarProd();
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
	public ModificarProd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 336, 302);
		frame.getContentPane().add(scrollPane);
		
		ModProd = new JTable();
		
		ModProd.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID Producto", "Nombre del Producto", "Precio", "Categoria"
			}
		));
		scrollPane.setViewportView(ModProd);
		
		ConexionBBDD Prueba = new ConexionBBDD();
		ModProd.setModel(Prueba.ModificarProd());
		
		JLabel lblIdProducto = new JLabel("ID Producto");
		lblIdProducto.setBounds(366, 94, 82, 16);
		frame.getContentPane().add(lblIdProducto);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(458, 91, 41, 22);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(376, 121, 82, 28);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(376, 163, 82, 16);
		frame.getContentPane().add(lblPrecio);
		
		textProducto = new JTextField();
		textProducto.setBounds(458, 124, 116, 22);
		frame.getContentPane().add(textProducto);
		textProducto.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(458, 160, 41, 22);
		frame.getContentPane().add(textPrecio);

		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id_producto = textID.getText();
				String nomb_producto = textProducto.getText();
				String precio = textPrecio.getText();
				Prueba.ModificarProd(id_producto, nomb_producto, precio);
				ModProd.setModel(Prueba.ModificarProd());
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(442, 317, 135, 69);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 363, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		ModProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = ModProd.getSelectedRow();
				String id_producto=ModProd.getValueAt(row, 0).toString();
				String nomb_producto=ModProd.getValueAt(row, 1).toString();
				String precio=ModProd.getValueAt(row, 2).toString();
				textID.setText(id_producto);
				textProducto.setText(nomb_producto);
				textPrecio.setText(precio);
				
				
			}
		});
		
		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		comboBox.setBounds(10, 19, 135, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String nomb_categoria =  (String) comboBox.getSelectedItem();
				if( nomb_categoria != "") {
					if(nomb_categoria.equals("Todas las Categorias")) {
						ModProd.setModel(Prueba.ModificarProd());

					}else {
						ModProd.setModel(Prueba.BuscarModProdCat(nomb_categoria));
					}
										
			}
				}
		});
		
		label = new JLabel("\u20AC");
		label.setBounds(507, 164, 46, 14);
		frame.getContentPane().add(label);
		
		lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo3.jpg"));
		lblFondo.setBounds(-99, 0, 709, 511);
		frame.getContentPane().add(lblFondo);
	}
}

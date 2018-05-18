package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ConexionBBDD.ConexionBBDD;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AñadProductoIIAdmin {

	public JFrame frame;
	private JTextField textNombre;
	private JTextField textPrecio;
	ConexionBBDD Prueba;
	private JTextField textID;
	private JTable IDNombProdPrecioCateg;
	private JTextField textIDCateg;
	private JTable IDCate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadProductoIIAdmin window = new AñadProductoIIAdmin();
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
	public AñadProductoIIAdmin() {
		initialize();
		Prueba = new ConexionBBDD();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 389, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(78, 386, 116, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(218, 356, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(276, 353, 46, 20);
		frame.getContentPane().add(textPrecio);
		

		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_producto = textID.getText();
				String producto = textNombre.getText();
				String precio = textPrecio.getText();
				String id_categoria = textIDCateg.getText();
				Prueba.AñadirProd(id_producto, producto, precio, id_categoria);
				IDNombProdPrecioCateg.setModel(Prueba.AñadirProdAdm());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(572, 368, 127, 83);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 428, 70, 23);
		frame.getContentPane().add(btnAtras);
		
		textID = new JTextField();
		textID.setBounds(77, 353, 31, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblIdID = new JLabel("ID");
		lblIdID.setBounds(10, 362, 46, 14);
		frame.getContentPane().add(lblIdID);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(334, 356, 46, 14);
		frame.getContentPane().add(label);
		
		textIDCateg = new JTextField();
		textIDCateg.setEnabled(false);
		textIDCateg.setColumns(10);
		textIDCateg.setBounds(309, 386, 46, 20);
		frame.getContentPane().add(textIDCateg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(385, 316, 167, 124);
		frame.getContentPane().add(scrollPane_1);
		
		IDCate = new JTable();
		IDCate.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categoria"
			}
		));
		scrollPane_1.setViewportView(IDCate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 677, 292);
		frame.getContentPane().add(scrollPane);
		
		IDNombProdPrecioCateg = new JTable();
		IDNombProdPrecioCateg.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Producto", "Nombre Producto", "Precio", "Categoria"
			}
		));
		scrollPane.setViewportView(IDNombProdPrecioCateg);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = IDNombProdPrecioCateg.getSelectedRow();
				String nomb_producto=IDNombProdPrecioCateg.getValueAt(row, 1).toString();
				Prueba.EliminarAñadProdAdmin(nomb_producto);
				IDNombProdPrecioCateg.setModel(Prueba.AñadirProdAdm());
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(572, 320, 115, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblIdCategoria = new JLabel("ID Categoria");
		lblIdCategoria.setBounds(218, 389, 93, 14);
		frame.getContentPane().add(lblIdCategoria);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("imagenes\\fondo3.jpg"));
		lblFondo.setBounds(-477, -50, 1276, 567);
		frame.getContentPane().add(lblFondo);
		

		ConexionBBDD Prueba = new ConexionBBDD();
		IDNombProdPrecioCateg.setModel(Prueba.AñadirProdAdm());
		
		IDCate.setModel(Prueba.SeleccIdCateg());
		
		IDCate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = IDCate.getSelectedRow();
				String id_categoria=IDCate.getValueAt(row, 0).toString();
				textIDCateg.setText(id_categoria);
				
				
			}
		});
	}
}

package hotel.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hotel.controller.HuespedController;
import hotel.controller.ReservaController;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservaController reservaController;
	private HuespedController huespedController;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		this.reservaController = new ReservaController();
		this.huespedController = new HuespedController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		cargarTablaReservas();
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		cargarTablaHespedes();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component componenteSeleccionado = panel.getSelectedComponent();

				if (componenteSeleccionado == scroll_tableHuespedes) {
					if(!txtBuscar.getText().isBlank()) {
						buscarEnHuesped();
					}else {
						JOptionPane.showMessageDialog(null, "Debes llenar el id o apellido a buscar");
					}
				} else if (componenteSeleccionado == scroll_table) {
					if(!txtBuscar.getText().isBlank()) {
						buscarEnReserva();
					}else {
						JOptionPane.showMessageDialog(null, "Debes llenar el id a buscar");
					}
				}
				
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component componenteSeleccionado = panel.getSelectedComponent();
				if (componenteSeleccionado == scroll_tableHuespedes) {
					modificarHuesped();
				} else if (componenteSeleccionado == scroll_table) {
					modificarReserva();
				}
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component componenteSeleccionado = panel.getSelectedComponent();
				if (componenteSeleccionado == scroll_tableHuespedes) {
					eliminarHuesped();
					limpiarTablaHuesped();
					cargarTablaHespedes();
				} else if (componenteSeleccionado == scroll_table) {
					eliminarReserva();
					limpiarTablaReservas();
					cargarTablaReservas();
				}
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		
	}
	
	private void limpiarTablaHuesped() {
		modeloHuesped.getDataVector().clear();
	}
	private void limpiarTablaReservas() {
		modelo.getDataVector().clear();
	}
	private boolean tieneFilaElegidaReservas() {
		return tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
	}
	private boolean tieneFilaElegidaHuespedes() {
		return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
	}
	
	private void cargarTablaReservas() {
		var reservas = this.reservaController.listar();
		reservas.forEach(reserva -> {
			if(reserva.isActivo() == true) {
				modelo.addRow(
					new Object[] {
						reserva.getId(),
						reserva.getFechaEntrada(),
						reserva.getFechaSalida(),
						reserva.getValor(),
						reserva.getFormaPago()
					});
			}
		});
	}
	
	private void cargarTablaHespedes() {
		var huespedes = this.huespedController.listar();
		huespedes.forEach(huesped -> {
			if(huesped.isActivo() == true) {
				modeloHuesped.addRow(
						new Object[] {
							huesped.getId(),
							huesped.getNombre(),
							huesped.getApellido(),
							huesped.getFechaNacimiento(),
							huesped.getNacionalidad(),
							huesped.getTelefono(),
							huesped.getCodigoReserva()
						});
			}
		});
	}
	
	private void buscarEnHuesped() {
		Integer id;
		try {
			id = Integer.parseInt(txtBuscar.getText());
			var datosHuesped = this.huespedController.buscarPorId(id);
			if(!datosHuesped.isEmpty()) {
				limpiarTablaHuesped();
				datosHuesped.forEach(huesped -> modeloHuesped.addRow(
						new Object[] {
							huesped.getId(),
							huesped.getNombre(),
							huesped.getApellido(),
							huesped.getFechaNacimiento(),
							huesped.getNacionalidad(),
							huesped.getTelefono(),
							huesped.getCodigoReserva()
						}));
			}
			else {
				JOptionPane.showMessageDialog(null, "No se encontraron datos");
			}
		} catch (NumberFormatException e) {
			String apellido = txtBuscar.getText();
			var datos = this.huespedController.buscarPorApellido(apellido);
			if(!datos.isEmpty()) {
				limpiarTablaHuesped();
				datos.forEach(huesped -> modeloHuesped.addRow(
						new Object[] {
							huesped.getId(),
							huesped.getNombre(),
							huesped.getApellido(),
							huesped.getFechaNacimiento(),
							huesped.getNacionalidad(),
							huesped.getTelefono(),
							huesped.getCodigoReserva()
						}));
			}
			else {
				JOptionPane.showMessageDialog(null, "No se encontraron datos");
			}
		}
			
	}
	
	private void buscarEnReserva() {
		Integer id;
		try {
				id = Integer.parseInt(txtBuscar.getText());
				var datosReserva = this.reservaController.buscarPorId(id);
				if(!datosReserva.isEmpty()) {
					limpiarTablaReservas();
					datosReserva.forEach(huesped -> modelo.addRow(
							new Object[] {
								huesped.getId(),
								huesped.getFechaEntrada(),
								huesped.getFechaSalida(),
								huesped.getValor(),
								huesped.getFormaPago()
							}));
				}
				else { 
					JOptionPane.showMessageDialog(null, "No se encontraron datos");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ingrese un id");
			}
			
	}
	
	private void modificarReserva() {
		if (tieneFilaElegidaReservas()) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}
		
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
			String fechaEntradaStr = modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString();
			SimpleDateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaIngreso;
			try {
			    fechaIngreso = dateFormat0.parse(fechaEntradaStr);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(this, "formato de fecha Ingreso invalido");
			    e.printStackTrace();
			    return;
			}
			String fechaSalidaStr = modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaSalida;
			try {
			    fechaSalida = dateFormat.parse(fechaSalidaStr);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(this, "formato de fecha Salida invalido");
			    e.printStackTrace();
			    return;
			}
			Integer valor = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
			String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
			int cantidadEliminada;
			cantidadEliminada = this.reservaController.modificar(fechaIngreso, fechaSalida, valor, formaPago, id);
			
			JOptionPane.showMessageDialog(this, cantidadEliminada + " item actualizado con éxito!");
		}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void modificarHuesped() {
		if (tieneFilaElegidaHuespedes()) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
			String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
			String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
			String fechaNaciminetoStr = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNacimineto;
			try {
			    fechaNacimineto = dateFormat.parse(fechaNaciminetoStr);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(this, "formato de fecha de nacimineto invalido");
			    e.printStackTrace();
			    return;
			}
			String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
			String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);
			
			int cantidadEliminada;
			cantidadEliminada = this.huespedController.modificar(nombre,apellido,fechaNacimineto,nacionalidad,telefono,id);
			
			JOptionPane.showMessageDialog(this, cantidadEliminada + " item actualizado con éxito!");
		}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void eliminarReserva() {
		if (tieneFilaElegidaReservas()) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
			var cantidadEliminada = this.reservaController.eliminar(id);

			modelo.removeRow(tbReservas.getSelectedRow());

			JOptionPane.showMessageDialog(this, cantidadEliminada + " item eliminado con éxito!");
		}, () -> JOptionPane.showMessageDialog(this, "actualizando tabla"));
	}
	
	private void eliminarHuesped() {
		if (tieneFilaElegidaHuespedes()) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		.ifPresentOrElse(fila -> {
			Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
			var cantidadEliminada = this.huespedController.eliminar(id);

			modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

			JOptionPane.showMessageDialog(this, cantidadEliminada + " item eliminado con éxito!");
		}, () -> JOptionPane.showMessageDialog(this, "actualizando tabla"));
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}

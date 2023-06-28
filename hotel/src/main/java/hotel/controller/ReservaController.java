package hotel.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import hotel.dao.ReservaDao;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Reserva;

public class ReservaController {
	private ReservaDao reservaDao;
	private Connection connection;
	
	public ReservaController() {
		var factory = ConnectionFactory.getInstance();
        try {
			connection = factory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.reservaDao = new ReservaDao(connection);
	}
	public void guardar(Reserva reserva) {
		reservaDao.guardar(reserva);
	}
	public List<Reserva> listar() {
		return reservaDao.listar();
	}
	public int modificar(Date fechaIngreso, Date fechaSalida, Integer valor, String formaPago, Integer id) {
		return reservaDao.modificar(fechaIngreso,fechaSalida,valor,formaPago,id);
	}
	public int eliminar(Integer id) {
		return reservaDao.eliminar(id);
	}
	public int ultimoResgistro() {
		return reservaDao.ultimoResgistro();
		
	}
	public List<Reserva> buscarPorId(Integer id) {
		return reservaDao.buscarPorId(id);
	}
	
}

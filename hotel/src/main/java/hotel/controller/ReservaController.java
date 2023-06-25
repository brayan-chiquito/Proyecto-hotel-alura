package hotel.controller;

import java.util.Date;
import java.util.List;

import hotel.dao.ReservaDao;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Huesped;
import hotel.modelo.Reserva;

public class ReservaController {
	private ReservaDao reservaDao;
	
	
	public ReservaController() {
		var factory = ConnectionFactory.getInstance();
		this.reservaDao = new ReservaDao(factory.recuperaConexion());
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
	public void eliminar() {
		
	}
	public int ultimoResgistro() {
		return reservaDao.ultimoResgistro();
		
	}
	public List<Reserva> buscarPorId(Integer id) {
		return reservaDao.buscarPorId(id);
	}
}

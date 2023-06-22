package hotel.controller;

import java.util.List;

import hotel.dao.ReservaDao;
import hotel.factory.ConnectionFactory;
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
	public void modificar() {
		
	}
	public void eliminar() {
		
	}
	public int ultimoResgistro() {
		return reservaDao.ultimoResgistro();
		
	}
}

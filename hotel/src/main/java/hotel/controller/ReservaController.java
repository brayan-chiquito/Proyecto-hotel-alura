package hotel.controller;

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
	public void listar() {
		
	}
	public void modificar() {
		
	}
	public void eliminar() {
		
	}
}

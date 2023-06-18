package hotel.controller;

import hotel.dao.HuespedDao;
import hotel.dao.ReservaDao;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Huesped;
import hotel.modelo.Reserva;

public class HuespedController {
	private HuespedDao huespedDao;
	private ReservaDao reservaDao;
	
	
	public HuespedController() {
		var factory = ConnectionFactory.getInstance();
		this.reservaDao = new ReservaDao(factory.recuperaConexion());
		var factory1 = ConnectionFactory.getInstance();
		this.huespedDao = new HuespedDao(factory1.recuperaConexion());
	}
	public void guardar(Huesped huesped, Reserva reserva) {
		reservaDao.guardar(reserva);
		huespedDao.guardar(huesped);
	}
	public void listar() {
		
	}
	public void modificar() {
		
	}
	public void eliminar() {
		
	}
}

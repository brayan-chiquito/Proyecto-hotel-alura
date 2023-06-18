package hotel.controller;

import hotel.dao.HuespedDao;
import hotel.dao.ReservaDao;
import hotel.factory.ConnectionFactory;
import hotel.modelo.Huesped;
import hotel.modelo.Reserva;

public class HuespedController {
	private HuespedDao huespedDao;
	
	
	public HuespedController() {
		var factory = ConnectionFactory.getInstance();
		this.huespedDao = new HuespedDao(factory.recuperaConexion());
	}
	public void guardar(Huesped huesped) {
		huespedDao.guardar(huesped);
	}
	public void listar() {
		
	}
	public void modificar() {
		
	}
	public void eliminar() {
		
	}
}

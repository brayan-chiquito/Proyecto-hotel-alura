package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hotel.modelo.Reserva;

public class ReservaDao {
	private Connection con;

	public ReservaDao(Connection con) {
		this.con = con;
	}
	private void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // Manejar la excepción de cierre de conexión si es necesario
            }
        }
    }
	
	public void guardar(Reserva reserva) {
		try {
			con.setAutoCommit(false);
			PreparedStatement statement = con.prepareStatement("INSERT INTO RESERVAS (fechaEntrada, fechaSalida, valor, formaPago)"
			+ "VALUE (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement) {
				ejecutarRejistro(reserva, statement);
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK de la transaccion");
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ejecutarRejistro(Reserva reserva, PreparedStatement statement) throws SQLException {
		java.util.Date fechaEntrada = reserva.getFechaEntrada();
		java.util.Date fechaSalida = reserva.getFechaSalida();
		java.sql.Date fechaSqlEntrada = new java.sql.Date(fechaEntrada.getTime());
		java.sql.Date fechaSqlSalida = new java.sql.Date(fechaSalida.getTime());
		
		statement.setDate(1, fechaSqlEntrada);
		statement.setDate(2, fechaSqlSalida);
		statement.setInt(3, reserva.getValor());
		statement.setString(4, reserva.getFormaPago());
		statement.execute();
		final ResultSet resultSet = statement.getGeneratedKeys();
    	try(resultSet){
	    	while(resultSet.next()) {
	    		reserva.setId(resultSet.getInt(1));
	    		System.out.println(String.format("Fue insertado el producto %s", reserva));
	    	}
    	}
	}
	
	public int ultimoResgistro() {
		Integer resultado;
		try {
			var querySelect = "SELECT * FROM RESERVAS ORDER BY ID DESC LIMIT 1";
			System.out.println(querySelect);
			final PreparedStatement statement = con.prepareStatement(
					querySelect);
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					
					if (resultSet.next()) {
						resultado = resultSet.getInt("ID");
				        
				    } else {
				        resultado = 1;
				    }
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
}
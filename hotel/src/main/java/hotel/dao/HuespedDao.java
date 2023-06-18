package hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hotel.modelo.Huesped;
import hotel.modelo.Reserva;

public class HuespedDao {
	private Connection con;

	public HuespedDao(Connection con) {
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
	
	public void guardar(Huesped huesped) {
		try {
			con.setAutoCommit(false);
			PreparedStatement statement = con.prepareStatement("INSERT INTO HUESPEDES (nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva)"
			+ "VALUE (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement) {
				ejecutarRejistro(huesped, statement);
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

	private void ejecutarRejistro(Huesped huesped, PreparedStatement statement) throws SQLException {
		java.util.Date fechaNacimineto = huesped.getFechaNacimiento();
		java.sql.Date fechaSqlNacimineto = new java.sql.Date(fechaNacimineto.getTime());
		
		statement.setString(1, huesped.getNombre());
		statement.setString(2, huesped.getApellido());
		statement.setDate(3, fechaSqlNacimineto);
		statement.setString(4, huesped.getNacionalidad());
		statement.setString(5, huesped.getTelefono());
		statement.setInt(6, huesped.getCodigoReserva());
		statement.execute();
		final ResultSet resultSet = statement.getGeneratedKeys();
    	try(resultSet){
	    	while(resultSet.next()) {
	    		huesped.setId(resultSet.getInt(1));
	    		System.out.println(String.format("Fue insertado el producto %s", huesped));
	    	}
    	}
	}
	
}

package hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConenectionFactory {
	private static ConenectionFactory instance;
	private DataSource dataSource;

	public ConenectionFactory() {
		
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel-alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("9785pp");
		pooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = pooledDataSource;
	}
	
	public static synchronized ConenectionFactory getInstance() {
        if (instance == null) {
            instance = new ConenectionFactory();
        }
        return instance;
    }
	
	public Connection recuperaConexion(){
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}

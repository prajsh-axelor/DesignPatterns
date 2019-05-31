package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
	
	private static volatile DbSingleton instance = null;
	private static volatile Connection conn = null;
	
	private DbSingleton() {
		
//		try {
//			
//			String jdbcurl = "jdbc:postgresql://localhost:5432/design_pattern_db";
//			String user = "axelor";
//			String password = "axelor";
//			
//			conn = DriverManager.getConnection(jdbcurl,user,password);
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		if(conn != null)
			throw new RuntimeException("use getConnection method to create");
		
		if(instance != null)
			throw new RuntimeException("use getInstance method to create");
	}
	
	public Connection getConnection() {
		if(conn == null) {
			synchronized(DbSingleton.class) {
				if(conn == null){
					try {
						String jdbcurl = "jdbc:postgresql://localhost:5432/design_pattern_db";
						String user = "axelor";
						String password = "axelor";
						
						conn = DriverManager.getConnection(jdbcurl,user,password);
						System.out.println("Connection Successful");
						
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
	
	public static DbSingleton getInstance() {
		if(instance == null) {
			synchronized(DbSingleton.class) {
				if(instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}
}

/*
//this is an example of lazily loaded design pattern
public class DbSingleton {
	private static DbSingleton instance = null;
	private DbSingleton() {}
	
	public static DbSingleton getInstance() {
		if(instance == null) {
			instance = new DbSingleton();
		}
		return instance;
	}
}


/*

//this is an example of eagerly loaded design pattern
public class DbSingleton {
	private static DbSingleton instance = new DbSingleton();
	
	private DbSingleton() {}
	
	public static DbSingleton getInstance() {
		return instance;
	}
}

*/

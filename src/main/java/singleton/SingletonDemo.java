package singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//this is an example of lazily loaded design pattern
public class SingletonDemo {
	public static void main(String [] args) {
	
		DbSingleton objInstance = DbSingleton.getInstance();
		
		Connection conn = objInstance.getConnection();
		
		Statement sta;
		try {
			sta = conn.createStatement();
			int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
			System.out.println("table created");
			sta.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}


/*
//this is an example of eagerly loaded desing pattern
public class SingletonDemo {
	public static void main(String [] args) {
	
		//DbSingleton objInstance = new DbSingleton(); //can't instanciate like this because of the private constructor
		
		DbSingleton objInstance = DbSingleton.getInstance();
		System.out.println(objInstance);
		
		objInstance = null;
		
		DbSingleton objInstance2 = DbSingleton.getInstance();
		System.out.println(objInstance2);	
	}
}
*/
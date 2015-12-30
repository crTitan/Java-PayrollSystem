/** 
 * BD_Connect.java
 * 
 * Purpose: connects and executes queries on the database.
 * 
 * @author     Paul Rodriguez Hernandez
 * @version     %I%, %G%
 * @since       1.0
 */

package Hernandez.bcs345.payroll.helperclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Connect {

	private static final String dbName = "payroll_system";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/" + dbName;
	private static final String USER = "root";
	private static final String PASS = "";
	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	/* Returns a ResultSet resulting from executing
	 * the query that is passed in as a String
	 * 
	 * @param sql the query to be execute on the database
	 * 
	 * @return a ResultSet return by the query or null if the query failed
	 * 
	 * @see ResultSet
	 * */
	public ResultSet returnResultSet(String sql) {

		

		try {

			// register the database class //ensure that the class is loaded
			Class.forName("com.mysql.jdbc.Driver");

			// connects to the database using the provided log in information
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			
			// prepared statement is much better than statement
			// pre-compile some stuff before hand
			preparedStatement = connection.prepareStatement(sql);
			
			// stores the result from the query
			resultSet = preparedStatement.executeQuery();
			  
		} catch (SQLException | ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// returns a resultSet or null in the query failed
		return resultSet;
	}// method end
	
	
	/*
	 * Closes the Connection, PreparedStatement, and ResultSet
	*/
	public void closeConn()
	{
		try{
			
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		}catch(SQLException exec){
		
			exec.printStackTrace();
		}
	}

}// class end

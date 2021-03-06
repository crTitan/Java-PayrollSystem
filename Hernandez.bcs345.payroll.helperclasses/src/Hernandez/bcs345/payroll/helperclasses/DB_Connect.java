/**
 * DB_Connect.java --- Connect the tot he database and also
 * 						runs the queries that are passed in.
 * 
 *  @author   Paul A. Rodriguez Hernandez
 * 
 *  @version %I%* 
 *  
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
	private Connection connection = null;

	private static final String USER = "root";
	private static final String PASS = "";
	

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

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

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

}// class end

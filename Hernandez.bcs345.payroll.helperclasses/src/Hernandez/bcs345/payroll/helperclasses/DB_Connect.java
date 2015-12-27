package Hernandez.bcs345.payroll.helperclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB_Connect {

	private static final String dbName = "payroll_system";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "";
	
	private static final String USER = "root";
	private static final String PASSS = "";
	
	
	public ResultSet returnResultSet(PreparedStatement ps) {
		ResultSet rs = null;
		
		return rs;
	}
	
}

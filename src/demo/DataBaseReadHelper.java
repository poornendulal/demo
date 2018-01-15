package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;
/*\\myserver\TNSNAMES_DIR\tnsnames.oraMYORCL =(DESCRIPTION =  (ADDRESS_LIST =    (ADDRESS = (PROTOCOL = TCP)(HOST = orcltest.local)(PORT = 1521))  )  (CONNECT_DATA = (SERVICE_NAME = orcl)(INSTANCE_ROLE=ANY)))*/
public class DataBaseReadHelper {
	private String connectionString;
	private String queryString;
	private String username;
	private String password;
	 public String[] rowContent;
	public static void main(String[] args) {
		//DataBaseReadHelper d = new DataBaseReadHelper();
	}
	public DataBaseReadHelper(String connectionString, String queryString, String username, String password)
	{
		this.connectionString=connectionString;
		this.queryString=queryString;
		this.username=username;
		this.password=password;
		try {
			printCompleteRow();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void printCompleteRow() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn =
		       DriverManager.getConnection(connectionString,username,password);
		  conn.setAutoCommit(false);
		  Statement stmt = conn.createStatement();
		  ResultSet rset =
		       stmt.executeQuery(queryString);
		  int i =0;
		  while (rset.next()) {
			  this.rowContent[i]=rset.getString(i);
			  i++;
		  }
		  stmt.close();
		  System.out.println ("DataBaseReadHelper.printCompleteRow() Test Case Passed");
	}
	public DataBaseReadHelper() {
		System.setProperty("oracle.net.tns_admin","\\\\myserver\\TNSNAMES_DIR");
        // or        //  java.exe -Doracle.net.tns_admin=\\myserver\TNSNAMES_DIR TestOra ...        //
	}

	
	public String getFromOracle (String pUserName, String pPassword, String pDatabase, String pQuery) throws SQLException {
        String usr = pUserName;
        String pwd = pPassword;
        String url = "jdbc:oracle:thin:@"+pDatabase;
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(url,usr,pwd);
        String sql = pQuery;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        String returnString = rs.getString(1);
//        while (rs.next())//        {//            System.out.println("results: " + rs.getString(1));//        }
        conn.close();
        return returnString;
    }

}

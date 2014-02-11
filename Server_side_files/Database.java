package uk.ac.cam.ss2099.fjava.tick5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import uk.ac.cam.cl.fjava.messages.RelayMessage;

public class Database {

	private Connection connection;

	public Database(String databasePath) throws SQLException, ClassNotFoundException { 
		
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager.getConnection("jdbc:hsqldb:file:"+databasePath,"SA","");
		Statement delayStmt = connection.createStatement();
		try {delayStmt.execute("SET WRITE_DELAY FALSE");}  
		finally {delayStmt.close();}
		
		connection.setAutoCommit(false);
		
		Statement sqlStmt = connection.createStatement();
		try {
		sqlStmt.execute("CREATE TABLE messages(nick VARCHAR(255) NOT NULL,"+
				"message VARCHAR(4096) NOT NULL,timeposted BIGINT NOT NULL)");
		sqlStmt.close();
		} catch (SQLException e){
			System.out.println("Warning: Database table \"messages\" already exists.");
		} finally {
			sqlStmt.close();
		}
		
		//create statistics_database
		Statement sqlStmt2 = connection.createStatement();
		try {
		sqlStmt2.execute("CREATE TABLE statistics(key VARCHAR(255),"+"value INT)");

		} catch (SQLException e){
			System.out.println("Warning: Database table \"statistics\" already exists.");
		} finally {	
			sqlStmt2.close();
		}
		
		//Initialize statistic_database
		String stmt = "INSERT INTO STATISTICS(key,value) VALUES (?,?)";
		PreparedStatement insertMessage = connection.prepareStatement(stmt);
		try {
			insertMessage.setString(1, "Total messages"); 
			insertMessage.setLong(2, 0);
			insertMessage.executeUpdate();
			insertMessage.setString(1, "Total logins"); 
			insertMessage.setLong(2, 0);
		} finally {
			insertMessage.close();
		}
		connection.commit();
	}

	public void close() throws SQLException {
		connection.close();
	}
	
	public void incrementLogins() throws SQLException { 
		String stmt = "UPDATE statistics SET value = value+1 WHERE key = 'Total logins'";
		PreparedStatement incrementLogins = connection.prepareStatement(stmt);
		incrementLogins.executeUpdate();
		incrementLogins.close();
		connection.commit();
	}
	
	public void addMessage(RelayMessage m) throws SQLException {
		String stmt = "INSERT INTO MESSAGES(nick,message,timeposted) VALUES (?,?,?)";
		String stmt1 = "UPDATE statistics SET value = value+1 WHERE key = 'Total messages'";
		PreparedStatement insertMessage = connection.prepareStatement(stmt);
		PreparedStatement incrementStatistics = connection.prepareStatement(stmt1);
		try {
			insertMessage.setString(1, m.getFrom()); 
			insertMessage.setString(2, m.getMessage());
			insertMessage.setLong(3, m.getCreationTime().getTime());

			insertMessage.executeUpdate();
			incrementStatistics.executeUpdate();
		} finally { 
			insertMessage.close();
			incrementStatistics.close();
		}
		connection.commit();
	}
	
	public List<RelayMessage> getRecent() throws SQLException {
		String stmt = "SELECT nick,message,timeposted FROM messages "+
				"ORDER BY timeposted DESC LIMIT 10";
		LinkedList<RelayMessage> output = new LinkedList<RelayMessage>();
		PreparedStatement recentMessages = connection.prepareStatement(stmt);
		try {
			ResultSet rs = recentMessages.executeQuery();
			try {
				while (rs.next())
					output.addFirst(new RelayMessage(rs.getString(1),rs.getString(2),new Date(rs.getLong(3))));
			} finally {
				rs.close();
			}
		} finally {
			recentMessages.close();
		}
		return output; 
	}

	public static void main(String [] args) throws SQLException, ClassNotFoundException{
		String path = null;
		try {
			path = args[0];
		} catch (ArrayIndexOutOfBoundsException e){
			System.err.println("Usage: java uk.ac.cam.ss2099.fjava.tick5.Database <database name>");
			return;
		}
		Class.forName("org.hsqldb.jdbcDriver");
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:"+path,"SA","");

		Statement delayStmt = connection.createStatement();
		try {delayStmt.execute("SET WRITE_DELAY FALSE");}  //Always update data on disk
		finally {delayStmt.close();}

		connection.setAutoCommit(false);

		Statement sqlStmt = connection.createStatement();
		try {
			sqlStmt.execute("CREATE TABLE messages(nick VARCHAR(255) NOT NULL,"+
					"message VARCHAR(4096) NOT NULL,timeposted BIGINT NOT NULL)");
		} catch (SQLException e) {
			System.out.println("Warning: Database table \"messages\" already exists.");
		} finally {
			sqlStmt.close();
		}

		String stmt = "INSERT INTO MESSAGES(nick,message,timeposted) VALUES (?,?,?)";
		PreparedStatement insertMessage = connection.prepareStatement(stmt);
		try {
			insertMessage.setString(1, "Alastair"); 
			insertMessage.setString(2, "Hello, Andy");
			insertMessage.setLong(3, System.currentTimeMillis());
			insertMessage.executeUpdate();
		} finally { 
			insertMessage.close();
		}

		connection.commit();

		stmt = "SELECT nick,message,timeposted FROM messages "+
				"ORDER BY timeposted DESC LIMIT 10";
		PreparedStatement recentMessages = connection.prepareStatement(stmt);
		try {
			ResultSet rs = recentMessages.executeQuery();
			try {
				while (rs.next())
					System.out.println(rs.getString(1)+": "+rs.getString(2)+
							" ["+rs.getLong(3)+"]");
			} finally {
				rs.close();
			}
		} finally {
			recentMessages.close();
		}
		connection.close();
	}
}

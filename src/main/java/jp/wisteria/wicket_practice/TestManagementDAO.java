package jp.wisteria.wicket_practice;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestManagementDAO implements Serializable {
	private static final long serialVersionUID = -3675765952535426498L;

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/isdWicket";
	private static String dbUser = "root";
	private static String dbPass = "mysql";

	/**
	 * @param accountId
	 * @param password
	 * @return DB上に入力されたアカウント情報があればtrue,なければfalseを返す
	 */
	public boolean loginConfirm(String accountId, String password) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, dbUser, dbPass);

			String sql = "select * from account where account_id = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			return rs.next();// 該当結果があればtrue,なければfalseを返す
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}
	
	public Account selectAccount(String accountId,String password){
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, dbUser, dbPass);

			String sql = "select * from account where account_id = ? and password = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			
//			System.out.println(rs.getString("name")); //SQLexception...なぜ
			
			return new Account(rs.getString("account_id"),
								rs.getString("name"),
								rs.getString("department")); //SQLexception...なぜ
			
//			return new Account("a","a","a"); //通った...
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}

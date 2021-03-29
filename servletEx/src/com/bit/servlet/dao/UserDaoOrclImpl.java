package com.bit.servlet.dao;
import java.sql.*;
public class UserDaoOrclImpl implements UserDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##jm","1234");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public int insert(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int insertCnt = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO users" +
			"(no, name, password, email, gender)" + 
			"VALUES(seq_users_pk.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			
			insertCnt = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCnt;
	}

	@Override
	public UserVo getUserByEmailAndPassword(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo vo = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM users" +
			"WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			// 만약에 레코드 있으면
			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
// 위변수 충돌		String password = rs.getString(3);
				String pw = rs.getString(3);
				String eml = rs.getString(4);
				String gender = rs.getString(5);
				Date createdAt = rs.getDate(6);
				
				// 사용자 객체 생성
				vo = new UserVo(no,name,pw,eml,gender,createdAt);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}

}

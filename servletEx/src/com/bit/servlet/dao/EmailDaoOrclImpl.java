package com.bit.servlet.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmailDaoOrclImpl implements EmailDao {
	// 커넥션 접속부 분리
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##jm","1234");
		}catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
		}
		return conn;
	}
	
	
	
	@Override
	public List<EmailVo> getList() {
		List<EmailVo> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM emaillist ORDER BY created_at DESC";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Long no = rs.getLong(1);
				String last_name = rs.getString(2);
				String first_name = rs.getString(3);
				String email = rs.getString(4);
				Date created_at = rs.getDate(5);
				
				EmailVo vo = new EmailVo(no, last_name, first_name, email, created_at);
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int insert(EmailVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertcnt = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO emaillist (no, last_name, first_name, email)" +
			"VALUES(seq_emaillist_pk.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			
			insertcnt = pstmt.executeUpdate();
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
		return insertcnt;
	}

	@Override
	public int delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletecnt = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM emaillist where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			deletecnt = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return deletecnt;
	}

}

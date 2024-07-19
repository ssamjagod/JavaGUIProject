package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.Guest;

public class GuestDAO {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	public GuestDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			// getConnection(); //테스팅용도
		} catch (Exception e) {
			System.out.println("로드 실패");
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, "system", "1111");
			return conn;
		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return null;
	}

	public void reservation(Guest g) {
		PreparedStatement psmt = null;
		if (getConnection() != null) {
			try {
				String sql = "update guest set name = ?, inDate = ?, outDate = ?, rType = ?, perNum = ?, rNum = ? where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, g.getName());
				psmt.setString(2, g.getInDate());
				psmt.setString(3, g.getOutDate());
				psmt.setString(4, g.getrType());
				psmt.setString(5, g.getPerNum());
				psmt.setString(6, g.getrNum());
				psmt.setString(7, g.getId());
				
				psmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("입력작업에서 예외 발생");
			}

		}
	}
	
	public boolean insert(Guest ut) {
		PreparedStatement psmt = null;
		if (getConnection() != null) {
			try {
				String sql = "insert into guest values (?,?,null,null,null,null,null,null)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, ut.getId());
				psmt.setString(2, ut.getPw());
				psmt.executeUpdate();
				return true;
			} catch (Exception e) {
				System.out.println("입력작업에서 예외 발생");
			}

		}
		return false;
	}
	
	public JScrollPane detail(String id) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		DefaultTableModel model = new DefaultTableModel();
		JScrollPane sc = null;
		
		if (getConnection() != null) {
			try {
				
				String sql = "select * from guest where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.executeUpdate();
				rs = psmt.executeQuery(sql);
				while (rs.next()) {
					String name = rs.getString("name");
					String indate = rs.getString("indate");
					String outdate = rs.getString("outdate");
					String rType = rs.getString("rType");
					String rNum = rs.getString("rNum");
					String perNum = rs.getString("perNum");
					model.addColumn("이름");
					model.addColumn("입실 날짜");
					model.addColumn("퇴실 날짜");
					model.addColumn("룸 타입");
					model.addColumn("룸 번호");
					model.addColumn("인원");
					model.addRow(new Object[] {name, indate, outdate, rType, rNum, perNum});
					JTable detail = new JTable(model);
					sc = new JScrollPane(detail);
				}
				
				
			} catch (Exception e) {
				System.out.println("입력작업에서 예외 발생");
			}
			
		}
		return sc;
	}
	
	

	public String chkuser(String id, String pw) {
		if (getConnection() != null) {
			try {
				Statement stmt = null;
				ResultSet rs = null; // DB에서 결과
				String sql = "select * from guest";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String cid = rs.getString("id");
					String cpw = rs.getString("pw");
					if (cid.equals(id) && cpw.equals(pw)) {
						System.out.println(id + "님 로그인하셨습니다. ");
						return id;
					}
				}

			} catch (Exception e) {
				return null;
			}

		}
		return null;
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.RoomDTO;

public class RoomDAO {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	public RoomDAO() {
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
	
	public void ing(String rn) {
		PreparedStatement psmt = null;
		if (getConnection() != null) {
			try {
				
				ResultSet rs = null; // DB에서 결과
				String sql = "update room set available = 1 where rNum = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, rn);
				psmt.executeUpdate();
			}

			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<String> getrNum(ArrayList<String> roomNumber, String rType) {
		PreparedStatement psmt = null;
		if (getConnection() != null) {
			try {
				
				ResultSet rs = null; // DB에서 결과
				String sql = "select * from Room where rType = ? and available = 0";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, rType);
				psmt.executeUpdate();
				rs = psmt.executeQuery(sql);
				roomNumber.clear();
				while (rs.next()) {
					String rNum = rs.getString("rNum");
					roomNumber.add(rNum);

				}
			}

			catch (Exception e) {
				// TODO: handle exception
			}

		}
		return roomNumber;
	}
}

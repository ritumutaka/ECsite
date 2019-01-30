package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	public Map<String, Object> session;
	
	//履歴取得メソッド 戻り値はmyPageDTO(リスト型の履歴)
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException  {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
		String sql = "select  ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date "
				+ "from user_buy_item_transaction ubit "
				+ "left join item_info_transaction iit "
				+ "on ubit.item_transaction_id = iit.id "
				+ "where ubit.item_transaction_id = ? and ubit.user_master_id = ? "
				+ "order by insert_date DESC";
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
				i ++;
			}
			if ( i <= 0 ) {
				myPageDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return myPageDTO;
	}
	
	//履歴削除メソッド
	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException {
		String sql = "delete from user_buy_item_transaction where item_transaction_id = ? and user_master_id =?";
		PreparedStatement ps;
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}

package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {

	/**
	 * 로그인 DAO
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return
	 */
	public int selectCheckLogin(Connection conn, String memberId, String memberPw) {
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = 1;
			}
			pstmt.close();
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		String query ="INSERT INTO MEMBER VALUES(?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			result = pstmt.executeUpdate();			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}




	
}

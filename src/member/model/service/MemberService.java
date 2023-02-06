package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	
	/**
	 * 회원 로그인
	 * @param memberId
	 * @param memberPw
	 * @return result
	 */
	public int selectCheckLogin(String memberId, String memberPw) {  // member객체로도 가능
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.selectCheckLogin(conn, memberId, memberPw);
		return result;
	}
	/**
	 * 회원가입 Service
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.insertMember(conn, member);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	
	
}

package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/member/enrollView.kh")
public class EnrollServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(request, response);
		
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		Member member = new Member(memberId, memberPw, memberName, memberEmail, memberPhone);
		
		MemberService mService = new MemberService();
		int result = mService.registerMember(member);
		System.out.println(result);
		if(result > 0) {
			//가입성공
			response.sendRedirect("/miniproject/index2.html");
		} else {
			//가입실패
			request.setAttribute("title", "회원 가입 실패");
			request.setAttribute("msg", "회원가입이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
		
	}

}

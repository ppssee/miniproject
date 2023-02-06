package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import product.model.service.ProductService;


@WebServlet("/product/remove.kh")
public class RemoveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/product/remove.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String productName = request.getParameter("product-name");
		ProductService pService = new ProductService();
		int result = pService.deleteProduct(productName);
		if(result > 0) {
			response.sendRedirect("/miniproject/index.jsp");
		} else {
			request.setAttribute("title", "상품 삭제 실패");
			request.setAttribute("msg", "상품 삭제가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}
}

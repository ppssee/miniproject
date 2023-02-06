package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
import product.model.service.ProductService;
import product.model.vo.Product;

@WebServlet("/product/update.kh")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/product/update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String productName = request.getParameter("product-name");
		int productPrice = Integer.parseInt(request.getParameter("product-price"));
		int productCount = Integer.parseInt(request.getParameter("product-count"));

		Product product = new Product(productName, productPrice, productCount); 
		ProductService pService = new ProductService();
		int result = pService.updateProduct(product);
		if(result>0) {
			response.sendRedirect("/miniproject/index.jsp");
		} else {
			request.setAttribute("title", "정보 수정 실패");
			request.setAttribute("msg", "상품 정보 수정을 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}

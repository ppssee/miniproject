package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;
import product.model.vo.Product;

@WebServlet("/product/printName.kh")
public class PrintName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/product/printName.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String productName = request.getParameter("product-name");
		ProductService pService = new ProductService();
		Product product = pService.printNameProduct(productName);
		if(product != null) {
			request.setAttribute("product", product);
			request.getRequestDispatcher("/WEB-INF/views/product/printName2.jsp").forward(request, response);
		} else {
			//가입실패
			request.setAttribute("title", "조회 실패");
			request.setAttribute("msg", "조회가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}

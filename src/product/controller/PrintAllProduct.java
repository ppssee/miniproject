package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.service.ProductService;
import product.model.vo.Product;
@WebServlet("/product/printAllProduct.kh")
public class PrintAllProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pService = new ProductService();
		List<Product> pList = pService.printAllProduct();
		if(pList.size() > 0) {
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/WEB-INF/views/product/printAllProduct.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "전체 조회 실패");
			request.setAttribute("msg", "전체조회가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
		
	}
}

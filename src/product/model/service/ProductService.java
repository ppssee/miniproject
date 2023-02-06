package product.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import product.model.dao.ProductDAO;
import product.model.vo.Product;

public class ProductService {
private ProductDAO pDao;
	
	public ProductService() {
		pDao = new ProductDAO();
	}

	/**
	 * 상품등록 Service
	 * @param member
	 * @return
	 */
	public int registerProduct(Product product) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = pDao.insertProduct(conn, product);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	/**
	 * 상품정보 수정
	 * @param member
	 * @return result
	 */
	public int updateProduct(Product product) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = pDao.updateProduct(conn, product);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	/**
	 * 상품삭제
	 * @param memberId
	 * @return result
	 */
	public int deleteProduct(String productName) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = pDao.deleteProduct(conn, productName);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public Product printNameProduct(String productName) {
		Product product = null;
		Connection conn = JDBCTemplate.getConnection();
		product = pDao.printNameProduct(conn, productName);
		
		return product;
	}
	public List<Product> printAllProduct() {
		Connection conn = JDBCTemplate.getConnection();
		List<Product> pList = pDao.printAllProduct(conn);
		return pList;
	}
}

package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.model.vo.Product;


public class ProductDAO {



	/**
	 * 상품등록 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertProduct(Connection conn, Product product) {
		String query ="INSERT INTO PRODUCT VALUES(?,?,?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductCount());
			result = pstmt.executeUpdate();			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 상품정보수정
	 * @param conn
	 * @param member
	 * @return 
	 */
	public int updateProduct(Connection conn, Product product) {
		String query ="UPDATE PRODUCT SET PRODUCT_NAME=?, PRODUCT_PRICE=?, PRODUCT_COUNT=? WHERE PRODUCT_NAME = ?";
		int result = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductCount());
			pstmt.setString(4, product.getProductName());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteProduct(Connection conn, String productName) {
		String query="DELETE FROM PRODUCT WHERE PRODUCT_NAME = ?";
		int result = 0;
		System.out.println(productName);
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productName);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Product printNameProduct(Connection conn, String productName) {
		String query ="SELECT * FROM PRODUCT WHERE PRODUCT_NAME = ?";
		Product product = new Product();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productName);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				product.setProductName(rset.getString(1));
				product.setProductPrice(rset.getInt(2));
				product.setProductCount(rset.getInt(3));
			}
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> printAllProduct(Connection conn) {
		String query ="SELECT * FROM PRODUCT";
		int result = 0;
		Product product = null;
		List<Product> pList = new ArrayList<Product>(); 
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				product = new Product();
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductPrice(rset.getInt("PRODUCT_PRICE"));
				product.setProductCount(rset.getInt("PRODUCT_COUNT"));
				pList.add(product);
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}



	
}

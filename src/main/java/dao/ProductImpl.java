package dao;

import java.sql.*;
import java.util.List;

import metier.entities.Product;

public class ProductImpl implements ProductInterface {
	
	private final String InsertStatement="INSERT INTO PRODUCT (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?,?)";
	@Override
	public Product save(Product p) {
		Connection connection=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=connection.prepareStatement(InsertStatement);
			ps.setString(1,p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> KeywordSearch(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product EditProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

}

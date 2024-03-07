package dao;

import java.sql.*;
import java.util.*;

import metier.entities.Product;

public class ProductImpl implements ProductInterface {
	
	private final String INSERTSTATEMENT="INSERT INTO PRODUCT (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)";
	private final String IDSTATEMENT="SELECT MAX(ID) AS ID_MAX FROM PRODUCT";
	private final String SELECTPRODUCT="SELECT * FROM PRODUCT WHERE DESIGNATION LIKE ?";
	private final String UPDATEPRODUCT="UPDATE PRODUCT SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?";
	private final String DELETEPRODUCT="DELETE FROM PRODUCT WHERE ID=?";
	@Override
	public Product save(Product p) {
		Connection connection=SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps_insert=connection.prepareStatement(INSERTSTATEMENT);
			ps_insert.setString(1,p.getDesignation());
			ps_insert.setDouble(2, p.getPrix());
			ps_insert.setInt(3, p.getQuantite());
			ps_insert.executeUpdate();
			
			PreparedStatement ps_id=connection.prepareStatement(IDSTATEMENT);
			
			ResultSet rs= ps_id.executeQuery();
			
			while(rs.next()) {
				
				p.setId(rs.getLong("ID_MAX"));
			}
			
			ps_insert.close();
			ps_id.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> KeywordSearch(String key) {
		Connection connection=SingletonConnection.getConnection();
		List <Product> table=new ArrayList<Product>();
		
		try {
			PreparedStatement ps=connection.prepareStatement(SELECTPRODUCT);
			ps.setString(1, key);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getLong("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				System.out.println(p.getId());
				table.add(p);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return table;
		
	}

	@Override
	public Product EditProduct(Product p) {
		Connection connection =SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATEPRODUCT);
			ps.setString(1, p.getDesignation());
			ps.setDouble(2,p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean DeleteProduct(Long id) {
		Connection connection =SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement(DELETEPRODUCT);
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}

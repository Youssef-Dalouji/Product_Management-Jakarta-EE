package dao;

import java.util.List;

import metier.entities.Product;

public interface ProductInterface {
	
	public Product save(Product p);
	
	public List<Product> KeywordSearch (String key);
	
	public Product EditProduct (Product p);
	
	public boolean DeleteProduct (Long id);
	
	
}

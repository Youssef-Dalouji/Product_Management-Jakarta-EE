package web;

import java.io.Serializable;
import java.util.List;
import metier.entities.Product;

public class ProductModel implements Serializable {
	
	private String key;
	private List<Product> table;
	
	public ProductModel() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Product> getTable() {
		return table;
	}

	public void setTable(List<Product> table) {
		this.table = table;
	}
	
	
	
	
}

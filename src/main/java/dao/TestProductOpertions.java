package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.entities.Product;

class TestProductOpertions {
	
	ProductInterface product;
	@BeforeEach
	void setUp() throws Exception {
		
		product=new ProductImpl();
	}

	@Test
	void testSave() {
		
		final String DESIGNATION="Asus x7";
		final double PRIX=7777d;
		final int QUANTITE=12;
		final String Resultat="Product [designation=" + DESIGNATION + ", prix=" + PRIX + ", quantite=" + QUANTITE + "]";
		
		Product p=new Product();
		p.setDesignation(DESIGNATION);
		p.setPrix(PRIX);
		p.setQuantite(QUANTITE);
		
		product.save(p);
		
		assertEquals(Resultat,p.toString());
		
	}
	
	@Test
	void testGetProduct() {
		final Long id=1l;
		Product p=product.getProduct(id);
		assertEquals(id,p.getId());
	}

	@Test
	void testKeywordSearch() {
		final String key="%asu%";
		List<Product> table=product.KeywordSearch(key);
		assertEquals("List size should be greater than 0", true, table.size() > 0);
	}

	@Test
	void testEditProduct() {
		final String DESIGNATION="Asus x77";
		
		Product p=new Product();
		p.setId(1l);
		p.setDesignation(DESIGNATION);
		p.setPrix(777d);
		p.setQuantite(50);
		Product newProduct=product.EditProduct(p);
		
		assertEquals(DESIGNATION,newProduct.getDesignation());
		
		
	}

	@Test
	void testDeleteProduct() {
		final long ID=5;
		
		boolean Resultat=product.DeleteProduct(ID);
		assertEquals("Product it's not deleted",true,Resultat);
		
	}

}

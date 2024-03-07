package dao;

import static org.junit.jupiter.api.Assertions.*;

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
	void testKeywordSearch() {
		fail("Not yet implemented");
	}

	@Test
	void testEditProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProduct() {
		fail("Not yet implemented");
	}

}

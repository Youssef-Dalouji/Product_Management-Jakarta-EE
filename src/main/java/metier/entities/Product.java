package metier.entities;

import java.io.Serializable;

public class Product implements Serializable {
	
	private long id;
	private String designation;
	private double prix;
	private int quantite;
	
	
	public Product(long id, String designation, double prix, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [designation=" + designation + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}

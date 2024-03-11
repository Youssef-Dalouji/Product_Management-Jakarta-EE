package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import java.io.IOException;
import java.util.List;

import dao.ProductImpl;
import dao.ProductInterface;

public class ProductServelt extends HttpServlet {
	ProductInterface dao;
	@Override
	public void init() throws ServletException {
		dao=new ProductImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/addProduct.php") && request.getMethod().equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/View/addProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/viewProduct.php") && request.getMethod().equals("POST")) {
			String designation = Jsoup.clean(request.getParameter("designation"), Safelist.none());
			double prix =Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			Product product=new Product();
			product.setDesignation(designation);
			product.setPrix(prix);
			product.setQuantite(quantite);
			Product p=dao.save(product);
			request.setAttribute("model", p);
			request.getRequestDispatcher("/WEB-INF/View/displayProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/displayProduct.php") && (request.getMethod().equals("GET") || request.getMethod().equals("POST"))) {
			long id=Long.parseLong(request.getParameter("id"));
			String designation = Jsoup.clean(request.getParameter("designation"), Safelist.none());
			double prix =Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			Product product=new Product(id, designation, prix, quantite);
			Product p=dao.EditProduct(product);
			request.setAttribute("model", p);
			request.getRequestDispatcher("/WEB-INF/View/displayProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/product.php") && (request.getMethod().equals("GET") || request.getMethod().equals("POST"))) {
			ProductModel model=new ProductModel();
			String key=request.getParameter("search")!=null?request.getParameter("search"):"";
			String sanitizedkey = Jsoup.clean(key, Safelist.none());
			model.setKey(sanitizedkey);
			List<Product> listOfProduct=dao.KeywordSearch("%"+model.getKey()+"%");
			model.setTable(listOfProduct);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/View/product.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/editProduct.php") && (request.getMethod().equals("POST") || request.getMethod().equals("GET"))) {
			long id=Long.parseLong(request.getParameter("id"));
			Product p=dao.getProduct(id);
			request.setAttribute("model", p);
			request.getRequestDispatcher("/WEB-INF/View/editProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/deleteProduct.php") && request.getMethod().equals("POST")) {
			ProductModel model=new ProductModel();
			long id=Long.parseLong(request.getParameter("id"));
			boolean deleteProduct=dao.DeleteProduct(id);
			List<Product> listOfProduct=dao.KeywordSearch("%%");
			model.setTable(listOfProduct);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/View/product.jsp").forward(request, response);
			return;
	    }
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

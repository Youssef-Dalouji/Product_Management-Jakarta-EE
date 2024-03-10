package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServelt extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/addProduct.php") && request.getMethod().equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/View/addProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/displayProduct.php") && request.getMethod().equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/View/displayProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/editProduct.php") && request.getMethod().equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/View/editProduct.jsp").forward(request, response);
			return;
	    }
		if (path.equals("/product.php") && request.getMethod().equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/View/product.jsp").forward(request, response);
			return;
	    }
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package stockPapeleria.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stockPapeleria.controllers.ProductoController;
import stockPapeleria.modelo.Producto;
import stockPapeleria.util.PropsOperations;

/**
 * Servlet implementation class SproductoPapeleria
 */
public class SproductoPapeleria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Producto> list = new ArrayList<>();
	ProductoController ctrP = new ProductoController();
	Producto prod;
	String btn;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SproductoPapeleria() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		list = ctrP.showList("");

		request.setAttribute("lista", list);
		request.getRequestDispatcher("/producto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		btn = request.getParameter("btn");

		if (btn.equalsIgnoreCase("add")) {
			
			int id = 0;
			String articulo = PropsOperations.CapitalizeString(request.getParameter("article"));
			String marca = PropsOperations.CapitalizeString(request.getParameter("trademark"));
			String precio = request.getParameter("price");
			String cantidad = request.getParameter("amount");
			Double precioDouble;
			Integer cantidadInteger;
			if (!(articulo.isEmpty() && marca.isEmpty() && precio.isEmpty() && cantidad.isEmpty())) {
				if (PropsOperations.isNumericDouble(cantidad) && PropsOperations.isNumeric(cantidad)) {
					precioDouble = Double.valueOf(precio);
					cantidadInteger = Integer.valueOf(cantidad);
					prod = new Producto(id, articulo, marca, precioDouble, cantidadInteger);
					ctrP.insertObject(prod);
				}
			} else {
				response.sendRedirect("/stockPapeleria/SproductoPapeleria");
			}
		}

		response.sendRedirect("/stockPapeleria/SproductoPapeleria");

	}

}

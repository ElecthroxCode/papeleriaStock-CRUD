package stockPapeleria.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stockPapeleria.controllers.ProductoController;
import stockPapeleria.modelo.Producto;

/**
 * Servlet implementation class SproductoEdit
 */
public class SproductoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoController ctrP = new ProductoController();
	Producto prod;
	String btn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SproductoEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String idDelete = request.getParameter("idDelete");
		if(!idDelete.isEmpty()) {
			int idDeleteInt = Integer.valueOf(request.getParameter("idDelete"));
			ctrP.deleteObject(idDeleteInt);
		}
		request.getRequestDispatcher("/SproductoPapeleria").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String btnSave = request.getParameter("btnSave");
		
		Integer idEdit = Integer.valueOf(request.getParameter("idEdit"));
		String articuloEdit = request.getParameter("articleM");
		String marcaEdit = request.getParameter("trademarkM");
		double precioEdit = Double.valueOf(request.getParameter("priceM")).doubleValue();
		int cantidadEdit = Integer.valueOf(request.getParameter("amountM")).intValue();
		
		
		if(btnSave.equals("save")) {
			System.out.println("Haz presionadoel botón..y este es el id: " + idEdit);
			prod = new Producto(idEdit, articuloEdit, marcaEdit, precioEdit, cantidadEdit);
			ctrP.updateObject(prod);
		}
		response.sendRedirect("/stockPapeleria/SproductoPapeleria");
	}

}

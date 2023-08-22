<html>

<%
	String id = request.getParameter("idEdit");
	String articulo = request.getParameter("articleM");
	String marca = request.getParameter("trademarkM");
	String precio = request.getParameter("priceM");
	String cantidad = request.getParameter("amountM");
	
%>
<p>Nombre: <% out.print(id); %></p>
<p>Nombre: <% out.print(articulo); %></p>
<p>marca: <% out.print(marca); %></p>
<p>precio: <% out.print(precio); %></p>
<p>cantidad: <% out.print(cantidad); %></p>

</html>
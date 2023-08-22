package stockPapeleria.modelo;

public class Producto {
	private int id;
	private String articulo;
	private String marca;
	private double precio;
	private int cantidad;
	public Producto(int id, String articulo, String marca, double precio, int cantidad) {
		super();
		this.id = id;
		this.articulo = articulo;
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	
}

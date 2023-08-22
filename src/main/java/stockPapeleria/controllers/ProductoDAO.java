package stockPapeleria.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stockPapeleria.connection.ConnectionBD;
import stockPapeleria.dao.IDAO;
import stockPapeleria.modelo.Producto;

public class ProductoDAO implements IDAO{
	
	private String iSQL;
	private Producto prod;
	
	@Override
	public List<Producto> showList(String instSQL) {
		List<Producto> list = new ArrayList<>();
		iSQL = "SELECT * FROM stock "+instSQL;
		try(Connection conn = ConnectionBD.getConnection();
				PreparedStatement pss = conn.prepareStatement(iSQL);
				ResultSet rs = pss.executeQuery()){
				while(rs.next()) {
					prod = new Producto(rs.getInt("id"),
							rs.getString("articulo"),
							rs.getString("marca"),
							rs.getDouble("precio"),
							rs.getInt("cantidad")
							);
					list.add(prod);
				}
				return list;
			}catch(SQLException e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public void insertObject(Object o) {
		prod = (Producto) o;
		iSQL= "INSERT INTO stock (articulo, marca, precio, cantidad) "
				+ "VALUES (?, ?, ?, ?)";
		try(Connection conn = ConnectionBD.getConnection();
			PreparedStatement ps = conn.prepareStatement(iSQL);){
			
			ps.setString(1, prod.getArticulo());
			ps.setString(2, prod.getMarca());
			ps.setDouble(3, prod.getPrecio());
			ps.setInt(4, prod.getCantidad());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateObject(Object o) {
		prod = (Producto) o;
		iSQL = "UPDATE stock SET articulo = ?, marca = ?, precio = ?, cantidad = ? "
				+ "WHERE id = ?";
		try (Connection conn = ConnectionBD.getConnection();
				PreparedStatement ps = conn.prepareStatement(iSQL);){
			
			ps.setString(1, prod.getArticulo());
			ps.setString(2, prod.getMarca());
			ps.setDouble(3, prod.getPrecio());
			ps.setInt(4, prod.getCantidad());
			ps.setInt(5, prod.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteObject(int id) {
		iSQL = "DELETE FROM stock WHERE id=?";
		try (Connection conn = ConnectionBD.getConnection();
				PreparedStatement ps = conn.prepareStatement(iSQL);){
		
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}

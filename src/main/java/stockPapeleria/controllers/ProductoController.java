package stockPapeleria.controllers;

import java.util.List;

import stockPapeleria.dao.IDAO;
import stockPapeleria.modelo.Producto;

public class ProductoController implements IDAO{

	@Override
	public List<Producto> showList(String instSQL) {
		return new ProductoDAO().showList(instSQL);
	}

	@Override
	public void insertObject(Object o) {
		new ProductoDAO().insertObject(o);
	}

	@Override
	public void updateObject(Object o) {
		new ProductoDAO().updateObject(o);
	}

	@Override
	public void deleteObject(int id) {
		new ProductoDAO().deleteObject(id);
	}

}

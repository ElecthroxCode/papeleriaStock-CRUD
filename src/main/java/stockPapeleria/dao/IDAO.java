package stockPapeleria.dao;

import java.util.List;

public interface IDAO {
	public abstract List<?> showList(String instSQL);
	public abstract void insertObject(Object o);
	public abstract void updateObject(Object o);
	public abstract void deleteObject(int id);

}

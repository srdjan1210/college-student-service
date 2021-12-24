package dao;

import java.sql.SQLException;
import java.util.List;

import model.Skakaonica;

public interface SkakaonicaDAO extends CRUDDao<Skakaonica, String> {
	public List<Skakaonica> findSkakaonicaByIdd(String idd) throws SQLException;
}

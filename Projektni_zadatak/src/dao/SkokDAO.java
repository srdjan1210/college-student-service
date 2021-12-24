package dao;

import java.sql.SQLException;
import java.util.List;

import model.Skok;

public interface SkokDAO extends CRUDDao<Skok, String> {
	//List<Showing> findShowingByPlayId(Integer idPlay) throws SQLException;
	List<Skok> findSkokBySkakaonicaId(String idSka) throws SQLException;
	int getNumberOfSkakacFromSkakaonicaId(String idSka) throws SQLException;
	List<Skok> findSkokBySkakaonicaAndSkakacId(String idSkakaonica,int idSkakac) throws SQLException;
	boolean setBVETARValue(String id,double value) throws SQLException;
	public int getSkakacId(String id) throws SQLException;
}

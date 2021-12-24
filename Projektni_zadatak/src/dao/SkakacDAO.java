package dao;

import java.sql.SQLException;
import java.util.List;

import model.Skakac;

public interface SkakacDAO extends CRUDDao<Skakac, Integer> {
	public List<Skakac> findSkakacByIdd(String id) throws SQLException;
	boolean setNewPBSC(double value, int id) throws SQLException;
	public double getPBSC(int id) throws SQLException;
	public boolean updatePBSC(double newScore, int id) throws SQLException;
}

package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkokDAO;
import dao.impl.SkokDAOImpl;
import model.Skok;

public class SkokService {
	private static final SkokDAO skokDAO = new SkokDAOImpl();
	
	public List<Skok> getSkokBySkakaonicaId(String idSka) throws SQLException{
		return (ArrayList<Skok>) skokDAO.findSkokBySkakaonicaId(idSka);
	}
	
	public int getNumberOfSkakacBySkakaonicaId(String idSka) throws SQLException{
		return skokDAO.getNumberOfSkakacFromSkakaonicaId(idSka);
	}
	
	public boolean updateBVETAR(String id,double value) throws SQLException{
		return skokDAO.setBVETARValue(id,value);
	}
	
	public int getSkakacIdFromSkokId(String id) throws SQLException{
		return skokDAO.getSkakacId(id);
	}
}

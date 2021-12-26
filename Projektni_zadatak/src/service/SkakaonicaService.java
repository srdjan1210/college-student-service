package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkakaonicaDAO;
import dao.impl.SkakaonicaDAOImpl;
import model.Skakaonica;

public class SkakaonicaService {
	private static final SkakaonicaDAO skakaonicaDAO = new SkakaonicaDAOImpl();
	
	public ArrayList<Skakaonica> getAll() throws SQLException {
		return (ArrayList<Skakaonica>) skakaonicaDAO.findAll();
	}
	
	public Skakaonica getById(String id) throws SQLException {
		return skakaonicaDAO.findById(id);
	}
	
	public boolean existsById(String id) throws SQLException {
		return skakaonicaDAO.existsById(id);
	}

	public boolean save(Skakaonica s) throws SQLException {
		return skakaonicaDAO.save(s);
	}

	public boolean deleteById(String id) throws SQLException {
		return skakaonicaDAO.deleteById(id);
	}

	public int saveAll(List<Skakaonica> skakaoniceList) throws SQLException {
		return skakaonicaDAO.saveAll(skakaoniceList);
	}
}

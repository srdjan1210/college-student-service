package service;

import java.sql.SQLException;

import dao.SkakacDAO;
import dao.impl.SkakacDAOImpl;
import model.Skakac;

public class SkakacService {
	private static final SkakacDAO skakacDao = new SkakacDAOImpl();
	
	public Skakac getSkakacFromId(int id) throws SQLException{
		return skakacDao.findById(id);
	}
}

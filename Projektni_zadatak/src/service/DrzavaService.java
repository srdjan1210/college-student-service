package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DrzavaDAO;
import dao.impl.DrzavaDAOImpl;
import model.Drzava;

public class DrzavaService {
	private static final DrzavaDAO drzavaDao = new DrzavaDAOImpl();
	
	public List<Drzava> getAll() throws SQLException{
		return (ArrayList<Drzava>) drzavaDao.findAll();
	}
}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil_HikariCP;
import dao.SkokDAO;
import model.Skok;

public class SkokDAOImpl implements SkokDAO{

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Skok entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Skok> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Skok> findAllById(Iterable<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skok findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsk, idsc, idsa, bduzina, bstil, bvetar  from skok where idsk = ?";
		Skok skok = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.isBeforeFirst()) {
					resultSet.next();

					skok = new Skok(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6));
				}
			}
		}

		return skok;
	}

	@Override
	public boolean save(Skok entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Skok> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Skok> findSkokBySkakaonicaId(String idSka) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsk,idsc,idsa,bduzina,bstil,bvetar from skok where idsa = ?";
		List<Skok> skokoviList = new ArrayList<Skok>();
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, idSka);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				while(resultSet.next()){
					Skok skok = new Skok(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getDouble(4),
							resultSet.getDouble(5),resultSet.getDouble(6));
					skokoviList.add(skok);
				}
			}
			
		}
		return skokoviList;
	}

	@Override
	public int getNumberOfSkakacFromSkakaonicaId(String idSka) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select count(distinct idsc) from skok where idsa = ?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, idSka);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				return resultSet.getInt(1);
			}
		}
		return 0;
	}

	@Override
	public List<Skok> findSkokBySkakaonicaAndSkakacId(String idSkakaonica, int idSkakac) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsk,idsc,idsa,bduzina,bstil,bvetar from skok where idsa = ? and idsc = ?";
		List<Skok> skokoviList = new ArrayList<Skok>();
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, idSkakaonica);
			preparedStatement.setInt(2, idSkakac);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				while(resultSet.next()){
					Skok skok = new Skok(resultSet.getString(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getDouble(4),
							resultSet.getDouble(5),resultSet.getDouble(6));
					skokoviList.add(skok);
				}
			}
			
		}
		return skokoviList;
	}

	@Override
	public boolean setBVETARValue(String id, double value) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update skok set bvetar=? where idsk=?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setDouble(1, value);
			preparedStatement.setString(2, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

	@Override
	public int getSkakacId(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsc from skok where idsk = ?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				while(resultSet.next()){
					return resultSet.getInt(1);
				}
			}
			
		}
		return -1;
	}

}
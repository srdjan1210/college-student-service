package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil_HikariCP;
import dao.SkakaonicaDAO;
import model.Skakaonica;

public class SkakaonicaDAOImpl implements SkakaonicaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select count(*) from skakaonica";
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return -1;
			}
		}
	}

	@Override
	public boolean delete(Skakaonica entity) throws SQLException {
		// TODO Auto-generated method stub
		return deleteById(entity.getId());
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from skakaonica";
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			int rowsAfffected = preparedStatement.executeUpdate();
			return rowsAfffected;
		}
	}

	@Override
	public boolean deleteById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from skakaonica where idsa=?";

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

	@Override
	public boolean existsById(String id) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			return existsByIdTransactional(connection, id);
		}
	}
	
	private boolean existsByIdTransactional(Connection connection, String id) throws SQLException {
		String query = "select * from skakaonica where idsa=?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.isBeforeFirst();
			}
		}
	}

	@Override
	public Iterable<Skakaonica> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsa, nazivsa, duzinasa, tipsa, idd  from skakaonica";
		List<Skakaonica> skakaonicaList = new ArrayList<Skakaonica>();
		Connection connection = ConnectionUtil_HikariCP.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Skakaonica skakaonica = new Skakaonica(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getString(5));
				skakaonicaList.add(skakaonica);
			}

		}
		return skakaonicaList;
	}

	@Override
	public Iterable<Skakaonica> findAllById(Iterable<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		List<Skakaonica> skakaonicaList = new ArrayList<>();

		StringBuilder stringBuilder = new StringBuilder();

		String queryBegin = "select idsa, nazivsa, duzinasa, tipsa, idd  from skakaonica where idsa in(";
		stringBuilder.append(queryBegin);

		for (@SuppressWarnings("unused")
		String id : ids) {
			stringBuilder.append("?,");
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(")");

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());) {

			int i = 0;
			for (String id : ids) {
				preparedStatement.setString(++i, id);
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					skakaonicaList.add(new Skakaonica(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
							resultSet.getString(4), resultSet.getString(5)));
				}
			}
		}

		return skakaonicaList;
	}

	@Override
	public Skakaonica findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsa, nazivsa, duzinasa, tipsa, idd  from skakaonica where idsa = ?";
		Skakaonica skakaonica = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.isBeforeFirst()) {
					resultSet.next();

					skakaonica = new Skakaonica(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
							resultSet.getString(4), resultSet.getString(5));
				}
			}
		}

		return skakaonica;
	}

	@Override
	public boolean save(Skakaonica entity) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			return saveTransactional(connection, entity);
		}
	}

	@Override
	public int saveAll(Iterable<Skakaonica> entities) throws SQLException {
		// TODO Auto-generated method stub
		int rowsSaved = 0;
		
		try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
			connection.setAutoCommit(false);

			for (Skakaonica entity : entities) {
				boolean success = saveTransactional(connection, entity);
				if (success) rowsSaved++;
			}

			connection.commit();
		}
		
		return rowsSaved;
	}
	
	private boolean saveTransactional(Connection connection, Skakaonica entity) throws SQLException {
		String insertCommand = "insert into skakaonica (nazivsa, duzinasa, tipsa, idd, idsa) values (?, ? , ?, ?,?)";
		String updateCommand = "update skakaonica set nazivsa=?, duzinasa=?, tipsa=?, idd=? where idsa=?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				existsByIdTransactional(connection, entity.getId()) ? updateCommand : insertCommand)) {
			int i = 1;
			preparedStatement.setString(i++, entity.getNaziv());
			preparedStatement.setInt(i++, entity.getDuzina());
			preparedStatement.setString(i++, entity.getTip());
			preparedStatement.setString(i++, entity.getDrzavaId());
			preparedStatement.setString(i++, entity.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

	@Override
	public List<Skakaonica> findSkakaonicaByIdd(String idd) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsa, nazivsa, duzinasa, tipsa, idd  from skakaonica where idd = ?";
		Skakaonica skakaonica  = null;
		List<Skakaonica> skakaonicaList = new ArrayList<Skakaonica>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, idd);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					skakaonica = new Skakaonica(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
							resultSet.getString(4), resultSet.getString(5));
					skakaonicaList.add(skakaonica);
				}
			}
		}

		return skakaonicaList;
	}

}

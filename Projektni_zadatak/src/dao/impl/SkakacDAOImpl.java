package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil_HikariCP;
import dao.SkakacDAO;
import model.Skakac;

public class SkakacDAOImpl implements SkakacDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Skakac entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Skakac> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Skakac> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skakac findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select idsc, imesc, przsc, idd, titule, pbsc  from skakac where idsc = ?";
		Skakac skakac = null;

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setInt(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.isBeforeFirst()) {
					resultSet.next();

					skakac = new Skakac(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6));
				}
			}
		}

		return skakac;
	}

	@Override
	public boolean save(Skakac entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Skakac> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Skakac> findSkakacByIdd(String id) throws SQLException{
		String query = "select idsc,imesc,przsc,idd,titule,pbsc from skakac where idd = ?";
		Skakac skakac = null;
		List<Skakac> skakaciList = new ArrayList<Skakac>();

		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					skakac= new Skakac(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6));
					skakaciList.add(skakac);
				}
			}
		}
		return skakaciList;
	}

	@Override
	public boolean setNewPBSC(double newValue,int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update skakac set pbsc=? where idsc=?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setDouble(1, newValue);
			preparedStatement.setInt(2, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

	@Override
	public double getPBSC(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select pbsc from skakac where idsc=?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					return resultSet.getDouble(1);
				}
				}
			}
		return -1;
	}

	@Override
	public boolean updatePBSC(double newScore, int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update skakac set pbsc=? where idsc=?";
		try (Connection connection = ConnectionUtil_HikariCP.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setDouble(1, newScore);
			preparedStatement.setInt(2, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected == 1;
		}
	}

}

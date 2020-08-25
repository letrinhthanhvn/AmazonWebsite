package com.amazonweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazonweb.dao.IGenericDAO;
import com.amazonweb.mapper.RowMapper;

@Repository
public class AbstractDAO<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/amazon";
			String user = "root";
			String password = "";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Get connection to database fails " + e.getMessage());
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				setParameter(preparedStatement, parameters);
				rs = preparedStatement.executeQuery();
				while (rs.next()) {
					results.add(rowMapper.mapRow(rs));
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e2) {
					return null;
				}
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				if (parameter instanceof Long) {
					statement.setLong(i + 1, (long) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(i + 1, (int) parameter);
				} else if (parameter instanceof String) {
					statement.setString(i + 1, (String) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) parameter);
				} else if (parameter instanceof Double) {
					statement.setDouble(i + 1, (Double) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

}

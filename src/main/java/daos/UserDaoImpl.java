package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import utility.ConnectionUtil;
import utility.Exceptions;
import utility.MagicWords;

public class UserDaoImpl implements UserDao {

	UserDaoImpl() {
	}

	public User extractUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getInt("user_role"));
	}

	@Override
	public User login(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.LOGIN_QUERY);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extractUser(rs);
			}
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.GET_ALL_USERS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(extractUser(rs));
			}
			return result;
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}
}

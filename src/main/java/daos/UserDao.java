package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.User;

public interface UserDao {

	UserDao currentImplementation = new UserDaoImpl();

	/**
	 * used to save a new user
	 * 
	 * @param u the user to be created
	 * @return the generated id for the user
	 * @throws SQLException 
	 */
	User extractUser(ResultSet rs) throws SQLException;

	List<User> getAllUsers();

	User login(String username, String password);
}
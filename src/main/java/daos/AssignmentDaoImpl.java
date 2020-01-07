package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Assignment;
import utility.ConnectionUtil;
import utility.Exceptions;
import utility.MagicWords;

public class AssignmentDaoImpl implements AssignmentDao {

	@Override
	public void createAssignment(Assignment assignment) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.ASSIGNMENT_INSERT_QUERY);
			stmt.setInt(1, assignment.getUserid());
			stmt.setInt(2, assignment.getQuizid());
			stmt.setInt(3, assignment.getAttempts());
			stmt.executeQuery();
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
	}

}

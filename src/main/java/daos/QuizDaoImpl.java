package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Quiz;
import utility.ConnectionUtil;
import utility.Exceptions;
import utility.MagicWords;

public class QuizDaoImpl implements QuizDao {

	@Override
	public Quiz extractQuiz(ResultSet rs) throws SQLException {
		return new Quiz(rs.getInt("QUIZ_ID"), rs.getString("QUIZ_NAME"), rs.getInt("QUIZ_CREATOR"));
	}

	@Override
	public void createQuiz(Quiz quiz) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.QUIZ_INSERT_QUERY);
			stmt.setString(1, quiz.getTitle());
			stmt.setInt(2, quiz.getCreator());
			stmt.executeQuery();
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
	}

	@Override
	public Quiz getQuizWithTitle(String title) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.QUIZ_BY_TITLE);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Quiz result = extractQuiz(rs);
				return result;
			}
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		List<Quiz> result = new ArrayList<Quiz>();
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.GET_ALL_QUIZZES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(extractQuiz(rs));
			}
			return result;
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}

	@Override
	public List<Quiz> getAssignedQuizzes(int userID) {
		List<Quiz> result = new ArrayList<Quiz>();
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.GET_ASSIGNED_QUIZZES);
			stmt.setInt(1, userID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(extractQuiz(rs));
			}
			return result;
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}
}

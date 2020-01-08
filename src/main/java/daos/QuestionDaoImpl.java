package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Question;
import utility.ConnectionUtil;
import utility.Exceptions;
import utility.MagicWords;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public Question extractQuestion(ResultSet rs) throws SQLException {
		return new Question(rs.getInt("QUESTION_ID"), rs.getString("QUESTION_PROBLEM"),
				rs.getString("QUESTION_CORRECT"), rs.getString("QUESTION_WRONG1"), rs.getString("QUESTION_WRONG2"),
				rs.getString("QUESTION_WRONG3"), rs.getString("QUESTION_EXPLANATION"), rs.getInt("QUESTION_CREATOR"));
	}

	@Override
	public void createQuestion(Question question) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.QUESTION_INSERT_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setString(2, question.getCorrect());
			stmt.setString(3, question.getWrong1());
			stmt.setString(4, question.getWrong2());
			stmt.setString(5, question.getWrong3());
			stmt.setString(6, question.getExplanation());
			stmt.setInt(7, question.getUserid());
			stmt.executeQuery();
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
	}

	@Override
	public List<Question> getAllQuestions() {
		List<Question> result = new ArrayList<Question>();
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.GET_ALL_QUESIONS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(extractQuestion(rs));
			}
			return result;
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}

	@Override
	public List<Question> getMyQuestions(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionOfQuiz(int quizID) {
		List<Question> result = new ArrayList<Question>();
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(MagicWords.QUESTION_FOR_QUIZ);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(extractQuestion(rs));
			}
			return result;
		} catch (SQLException e) {
			Exceptions.logSQLException(e);
		}
		return null;
	}

}

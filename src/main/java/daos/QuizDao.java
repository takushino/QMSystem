package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.Quiz;

public interface QuizDao {
	QuizDao currentImplementation = new QuizDaoImpl();

	Quiz extractQuiz(ResultSet rs) throws SQLException;

	void createQuiz(Quiz quiz);

	List<Quiz> getAssignedQuizzes(int userID);

	Quiz getQuizWithTitle(String title);

	List<Quiz> getAllQuizzes();
}

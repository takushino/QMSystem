package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.Question;

public interface QuestionDao {
	QuestionDao currentImplementation = new QuestionDaoImpl();

	Question extractQuestion(ResultSet rs) throws SQLException;

	void createQuestion(Question question);

	List<Question> getAllQuestions();

	List<Question> getMyQuestions(int userID);

	List<Question> getQuestionOfQuiz(int quizID);
}

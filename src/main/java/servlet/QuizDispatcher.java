package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.QuizDao;
import models.Quiz;
import utility.ConnectionUtil;
import utility.Exceptions;
import utility.MagicWords;
import utility.StoredMapper;

public class QuizDispatcher implements Dispatcher {
	QuizDao quizDao = QuizDao.currentImplementation;
	private final Logger logger = LogManager.getLogger(getClass());

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMSystem/makeQuiz");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		Quiz quiz = null;
		try {
			quiz = (Quiz) StoredMapper.read(req.getInputStream(), Quiz.class);
			quizDao.createQuiz(quiz);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		int id = quizDao.getQuizWithTitle(quiz.getTitle()).getQuiz_id();
		logger.info("ID = " + id);
		ConnectQuizToQuestion(quiz, id);
	}

	private void ConnectQuizToQuestion(Quiz quiz, int id) {
		String questions = quiz.getQuestionSequence().replaceAll("[^0-9,]", "");
		String[] parts = questions.split(",");
		for (int i = 0; i < parts.length; i++) {
			try (Connection c = ConnectionUtil.getConnection()) {
				logger.info(id + ", " + parts[i]);
				PreparedStatement stmt = c.prepareCall(MagicWords.QUIZ_QUESTION_RELATOR);
				stmt.setInt(1, quiz.getQuiz_id());
				stmt.setInt(2, Integer.parseInt(parts[i]));
				stmt.executeQuery();
			} catch (SQLException e) {
				Exceptions.logSQLException(e);
			}
		}
	}

}

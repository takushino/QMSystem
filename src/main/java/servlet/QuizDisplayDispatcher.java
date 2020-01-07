package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.QuizDao;
import models.Quiz;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class QuizDisplayDispatcher implements Dispatcher {
	QuizDao quizDao = QuizDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("GET") && req.getRequestURI().equals("/QMSystem/quizzes");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Quiz> quizzes = quizDao.getAllQuizzes();
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getOutputStream().write(StoredMapper.write(quizzes));
			return;
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}
}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.QuestionDao;
import daos.QuizDao;
import daos.UserDao;
import models.Question;
import models.Quiz;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class TakeQuizDispatcher implements Dispatcher {

	QuestionDao questionDao = QuestionDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMSystem/takeQuiz");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int quizID = (int) StoredMapper.read(req.getInputStream(), Integer.class);
			List<Question> toTake = questionDao.getQuestionOfQuiz(quizID);

			if (toTake == null) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Unauthorized status code
				return;
			} else {
				resp.setStatus(HttpServletResponse.SC_OK);
				//write method to increment attempt number
				resp.getOutputStream().write(StoredMapper.write(toTake));
				return;
			}
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}

}

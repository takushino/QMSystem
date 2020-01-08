
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.QuizDao;
import models.Quiz;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class UsersQuizzesDispatcher implements Dispatcher {
	QuizDao quizDao = QuizDao.currentImplementation;
	private final Logger logger = LogManager.getLogger(getClass());

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("GET") && req.getRequestURI().equals("/QMSystem/assignedQuizzes");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int userID = ((User) req.getSession().getAttribute("user")).getUser_id();
			logger.info("Quiz requested by user: {}", userID);
			List<Quiz> quizzes = quizDao.getAssignedQuizzes(userID);
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getOutputStream().write(StoredMapper.write(quizzes));
			return;
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}

}

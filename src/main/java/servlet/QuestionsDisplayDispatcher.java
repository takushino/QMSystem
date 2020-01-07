package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.QuestionDao;
import models.Question;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class QuestionsDisplayDispatcher implements Dispatcher {
	QuestionDao questionDao = QuestionDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("GET") && req.getRequestURI().equals("/QMSystem/questions");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Question> questions = questionDao.getAllQuestions();
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getOutputStream().write(StoredMapper.write(questions));
			return;
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}

}

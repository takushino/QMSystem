package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.QuestionDao;
import models.Question;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class QuestionsDispatcher implements Dispatcher {

	QuestionDao questionDao = QuestionDao.currentImplementation;
	private final Logger logger = LogManager.getLogger(getClass());

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return isMakeQuestionRequest(req);
	}

	private boolean isMakeQuestionRequest(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMSystem/makeQuestion");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Question question = (Question) StoredMapper.read(req.getInputStream(), Question.class);
			logger.info("Question: {}", question);
			questionDao.createQuestion(question);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}
}

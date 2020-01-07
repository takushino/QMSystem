package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.AssignmentDao;
import models.Assignment;
import utility.StoredMapper;

public class QuizAssignDispatcher implements Dispatcher {
	AssignmentDao assignmentDao = AssignmentDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMSystem/assignQuiz");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Assignment assignment = (Assignment) StoredMapper.read(req.getInputStream(), Assignment.class);
			assignmentDao.createAssignment(assignment);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}

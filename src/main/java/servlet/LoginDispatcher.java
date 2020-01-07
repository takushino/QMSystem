package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDao;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class LoginDispatcher implements Dispatcher {
	User loggedInUser = null;
	UserDao userDao = UserDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return isLoginRequest(req);
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			User credentials = (User) StoredMapper.read(req.getInputStream(), User.class);
			loggedInUser = userDao.login(credentials.getUsername(), credentials.getPassword());
			
			if (loggedInUser == null) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Unauthorized status code
				return;
			} else {
				resp.setStatus(HttpServletResponse.SC_OK);
				req.getSession().setAttribute("user", loggedInUser);
				resp.getOutputStream().write(StoredMapper.write(loggedInUser));
				return;
			}
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}

	private boolean isLoginRequest(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMSystem/login");
	}

}
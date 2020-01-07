package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDao;
import models.User;
import utility.Exceptions;
import utility.StoredMapper;

public class UserDisplayDispatcher implements Dispatcher {

	UserDao userDao = UserDao.currentImplementation;

	@Override
	public boolean isSupported(HttpServletRequest req) {
		return req.getMethod().equals("GET") && req.getRequestURI().equals("/QMSystem/users");
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<User> users = userDao.getAllUsers();
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getOutputStream().write(StoredMapper.write(users));
			return;
		} catch (IOException e) {
			Exceptions.logJsonUnmarshalException(e, User.class);
		}
	}

}

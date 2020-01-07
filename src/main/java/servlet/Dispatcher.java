package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Dispatcher {

	boolean isSupported(HttpServletRequest request);

	void execute(HttpServletRequest request, HttpServletResponse response);
}
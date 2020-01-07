package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

	private final Logger logger = LogManager.getLogger(getClass());
	private final Dispatcher dispatcherChain = DispatcherChain.getInstance();

	public DispatcherServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("{} request coming to {}", req.getMethod(), req.getRequestURI());
		if (dispatcherChain.isSupported(req)) {
			dispatcherChain.execute(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("{} request coming to {}", req.getMethod(), req.getRequestURI());
		if (dispatcherChain.isSupported(req)) {
			logger.info("found supported dispatcher");
			dispatcherChain.execute(req, resp);
		} else {
			logger.info("no supported dispatcher");
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
	}
}
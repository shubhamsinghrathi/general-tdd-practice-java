package j2ee;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3385507281337863254L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServerException, IOException {
		String user = request.getParameter("j_username");
		String pass = request.getParameter("j_password");
		if(getAuthenticationService().isValidLogin(user, pass)) {
			response.sendRedirect("/frontpage");
			request.getSession().setAttribute("username", user);
		} else {
			response.sendRedirect("/invalidlogin");
		}
	}

	protected IAuthenticationService getAuthenticationService() {
		// TODO Auto-generated method stub
		return null;
	}

}

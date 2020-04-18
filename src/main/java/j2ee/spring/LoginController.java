package j2ee.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {
	private IAuthenticationService authenticationService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user = request.getParameter("j_username");
		String pass = request.getParameter("j_password");
		if (authenticationService.isValidLogin(user, pass)) {
			return new ModelAndView("frontpage");
		} else {
			return new ModelAndView("wrongpassword");
		}
	}

	public void setAuthenticationService(IAuthenticationService authService) {
		this.authenticationService = authService;
	}

}

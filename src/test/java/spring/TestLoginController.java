package spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import j2ee.spring.FakeAuthenticationService;
import j2ee.spring.LoginController;

class TestLoginController {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private LoginController c;
	private String correctUser = "correct_username";
	private String corrctPass = "correct_password";
	
	@BeforeEach
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		c = new LoginController();
		FakeAuthenticationService mock = new FakeAuthenticationService();
		mock.addUser(correctUser, corrctPass);
		c.setAuthenticationService(mock);
	}

	 @Test
	 public void wrongPasswordShouldRedirectToErrorPage()
		 throws Exception {
		 request.addParameter("j_username", correctUser);
		 request.addParameter("j_password", "nosuchpassword");
		 ModelAndView v = c.handleRequest(request, response);
		 assertEquals("wrongpassword", v.getViewName());
	 }
	 
	 @Test
	 public void validLoginForwardsToFrontPage()
	 	throws Exception {
		 request.addParameter("j_username", correctUser);
		 request.addParameter("j_password", corrctPass);
		 ModelAndView v = c.handleRequest(request, response);
		 assertEquals("frontpage", v.getViewName());
	 }

}

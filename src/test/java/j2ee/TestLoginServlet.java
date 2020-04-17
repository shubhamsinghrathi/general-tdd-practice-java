package j2ee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class TestLoginServlet {
	private final String validUsername = "correct_username";
	private final String validPassword = "correct_password";
	
	private LoginServlet servlet;
	private FakeAuthenticationService authenticator;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@BeforeEach
	public void setUp() {
		authenticator = new FakeAuthenticationService();
		authenticator.addUser(validUsername, validPassword);
		
		servlet = new LoginServlet() {
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			 protected IAuthenticationService getAuthenticationService() {
				 return authenticator;
			 }
		};
		
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}
	

	@Test
	void wrongPasswordShouldRedirectToErrorPage() throws Exception {
		request.addParameter("j_username", validUsername);
		request.addParameter("j_password", "wrong_password");
		servlet.service(request, response);
		assertEquals("/invalidlogin", response.getRedirectedUrl());
	}

	@Test
	void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
		request.addParameter("j_username", validUsername);
		request.addParameter("j_password", validPassword);
		servlet.service(request, response);
		assertEquals("/frontpage", response.getRedirectedUrl());
		assertEquals("correct_username", request.getSession().getAttribute("username"));
	}
	
}

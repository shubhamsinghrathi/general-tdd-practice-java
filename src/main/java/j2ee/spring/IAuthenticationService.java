package j2ee.spring;

public interface IAuthenticationService {
	boolean isValidLogin(String username, String password);
}

package j2ee;

public interface IAuthenticationService {
	boolean isValidLogin(String username, String password);
}

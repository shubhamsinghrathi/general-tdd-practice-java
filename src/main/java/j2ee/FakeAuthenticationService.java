package j2ee;

import java.util.HashMap;
import java.util.Map;

public class FakeAuthenticationService implements IAuthenticationService {

	private Map<String, String> users = new HashMap<String, String>();
	
	public void addUser(String username, String password) {
		users.put(username, password);
	}
	
	@Override
	public boolean isValidLogin(String username, String password) {
		return users.containsKey(username) && password.equals(users.get(username));
	}

}

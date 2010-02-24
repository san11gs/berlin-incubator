package incubator.spring_faces.security;

import java.util.Map;

import org.springframework.flex.security3.AuthenticationResultUtils;

public class SecurityHelper {

	public Map<String, Object> getAuthentication() {
		return AuthenticationResultUtils.getAuthenticationResult();
	}
}

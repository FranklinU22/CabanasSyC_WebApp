package CabanasSyC.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    public UserDetails login(String username, String password) throws BadCredentialsException;
    public UserDetails register();
}

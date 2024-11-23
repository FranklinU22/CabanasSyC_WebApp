package CabanasSyC.service;
import org.springframework.security.core.userdetails.UserDetails;   
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}

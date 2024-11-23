package CabanasSyC.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CabanasSyC.dao.UserDao;
import CabanasSyC.service.AuthService;
import jakarta.servlet.http.HttpSession;


@Service("AuthService")
public class AuthServiceImpl implements AuthService, UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CabanasSyC.domain.User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        session.removeAttribute("name");
        session.removeAttribute("id");
        session.setAttribute("name", user.getFirstName());
        session.setAttribute("id", user.getIdUser());        

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getIdRol().getName());
        return new User(user.getEmail(), user.getPassword(), Collections.singletonList(authority)); 
    }
}
    
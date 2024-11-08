package CabanasSyC.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CabanasSyC.dao.UserDao;
import CabanasSyC.service.AuthService;
import jakarta.servlet.http.HttpSession;


@Service("AuthService")
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails login(String email, String password) throws BadCredentialsException {
    CabanasSyC.domain.User user = userDao.findByEmailAndPassword(email, password);
    if (user == null) {
        throw new BadCredentialsException("Invalid credentials for user: " + email);
    }

    session.setAttribute("firstName", user.getFirstName());
    session.setAttribute("userID", user.getIdUser());

    // Convertir el Rol a una lista de GrantedAuthority
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getIdRol().getName());

    // Devolver un objeto User de Spring Security con la lista de autoridades
    return new User(user.getEmail(), user.getPassword(), Collections.singletonList(authority));
}

    @Override
    public UserDetails register() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws BadCredentialsException {
        CabanasSyC.domain.User user = userDao.findByEmail(email);
        if (user == null) {
            throw new BadCredentialsException("User not found with email: " + email);
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getIdRol().getName());
        return new User(user.getEmail(), user.getPassword(), Collections.singletonList(authority));
    }
}

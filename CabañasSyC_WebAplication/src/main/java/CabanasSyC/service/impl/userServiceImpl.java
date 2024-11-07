package CabanasSyC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import CabanasSyC.dao.UserDao;
import CabanasSyC.domain.Rol;
import CabanasSyC.domain.User;
import CabanasSyC.service.UserService;

public class userServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private RolServiceImpl rolServiceImpl;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email){
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmailAndPassword(String email, String password){
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        Rol rolDefault = rolServiceImpl.getRolById(1L);
        user = userDao.save(user);
        user.setIdRol(rolDefault);
    }

    @Override
    @Transactional
    public void delete(User user){
        userDao.delete(user);
    }
}

package CabanasSyC.service;

import java.util.List;

import CabanasSyC.domain.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserByEmail(String email);

    public User getUserByEmailAndPassword(String email, String password);

    public void saveOrUpdate(User user);
    
    public void delete(User user);
}

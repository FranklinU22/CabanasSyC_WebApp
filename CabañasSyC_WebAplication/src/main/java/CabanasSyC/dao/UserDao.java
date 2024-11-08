package CabanasSyC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import CabanasSyC.domain.User;

public interface UserDao extends JpaRepository<User, Long>{
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
}

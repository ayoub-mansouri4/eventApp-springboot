package springboot_auth.services;


import springboot_auth.entities.User;

import java.util.Optional;

public interface UserServiceInterface {
    public User findByEmailAndPassword(String email,String password);
    public User getUser(Long id);
    public User saveUser(User user);
}

package springboot_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_auth.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    public User  findByEmailAndPassword(String email,String password);
}

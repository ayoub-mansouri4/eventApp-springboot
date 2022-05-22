package springboot_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_auth.entities.Event;
import springboot_auth.entities.User;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    public List<Event> findEventsByUser(User user);
    public List<Event> findEventsBySport(String sport);
}

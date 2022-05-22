package springboot_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_auth.entities.Event;
import springboot_auth.entities.Participant;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
   public List<Participant> findParticipantsByEvent(Event event);
}

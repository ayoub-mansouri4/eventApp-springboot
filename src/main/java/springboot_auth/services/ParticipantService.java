package springboot_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_auth.entities.Participant;
import springboot_auth.repositories.ParticipantRepository;

import java.util.List;

@Service
public class ParticipantService implements ParticipantServiceInterface {
    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(Long id_participant) {
           participantRepository.deleteById(id_participant);
    }

    @Override
    public List<Participant> getParticipantsByEvent(Long id_event) {
        return null;
    }

    @Override
    public List<Participant> getAllParticipants() {
        return null;
    }


}

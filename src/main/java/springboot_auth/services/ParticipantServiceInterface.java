package springboot_auth.services;

import springboot_auth.entities.Participant;

import java.util.List;

public interface ParticipantServiceInterface {
    public Participant saveParticipant(Participant participant);
    public void deleteParticipant(Long id_participant);
    public List<Participant> getParticipantsByEvent(Long id_event);
    public  List<Participant> getAllParticipants();
}

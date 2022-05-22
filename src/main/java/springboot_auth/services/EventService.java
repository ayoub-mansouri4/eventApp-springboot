package springboot_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_auth.entities.Event;
import springboot_auth.entities.User;
import springboot_auth.repositories.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface{

    @Autowired
    private EventRepository eventRepository;


    @Override
    public List<Event> getEventsByUser(User user) {
        return eventRepository.findEventsByUser(user);
    }

    @Override
    public Event getEvent(Long id) {
       return eventRepository.findById(id).get();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id){
         eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getEventsBySport(String sport) {
        return eventRepository.findEventsBySport(sport);
    }


}

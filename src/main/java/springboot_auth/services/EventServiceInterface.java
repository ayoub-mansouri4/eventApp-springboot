package springboot_auth.services;

import springboot_auth.entities.Event;
import springboot_auth.entities.User;

import java.util.List;
import java.util.Optional;

public interface EventServiceInterface {
    public List<Event> getEventsByUser(User user);
    public Event getEvent(Long id);
    public List<Event> getAllEvents();
    public Event saveEvent(Event event);
    public Event updateEvent(Event event);
    public void deleteEvent(Long id);
    public List<Event> getEventsBySport(String sport);
}

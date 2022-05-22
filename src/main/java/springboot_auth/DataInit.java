package springboot_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot_auth.entities.*;
import springboot_auth.repositories.EventRepository;
import springboot_auth.services.EventService;
import springboot_auth.services.ParticipantService;
import springboot_auth.services.UserService;
import springboot_auth.abstractFactoryPattern.ConcreteFactoryPost;

import java.util.List;


@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private ConcreteFactoryPost concreteFactoryPost;



    @Autowired
    private ParticipantService participantService;


    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<10;i++){
                userService.saveUser(new User("ayoub","mansouri",21,"ayoub@"+i+".com","1234"));
        }


            User user = userService.getUser(2L);
            Event event  = new Event("28/01/2022","14h30",5L,"basketball");
            event.setPost(concreteFactoryPost.createPost("title1","27/04/2022","18h20","blabla"));
            event.setLocation(new Location("Khouribga",32.886023F,-6.9208655F));
            event.setUser(user);
            eventService.saveEvent(event);
            participantService.saveParticipant(new Participant(3L,event));
            participantService.saveParticipant(new Participant(4L,event));
            participantService.saveParticipant(new Participant(5L,event));





        Event event2  = new Event("23/01/2022","12h15",5L,"football");
        event2.setPost(concreteFactoryPost.createPost("title2","11/05/2022","17h20","blabla"));
        event2.setLocation(new Location("Casablanca",33.5731104F,-7.5898434F));
        event2.setUser(userService.getUser(1L));
        eventService.saveEvent(event2);
        participantService.saveParticipant(new Participant(4L,event2));

    }
}

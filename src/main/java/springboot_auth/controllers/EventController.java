package springboot_auth.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_auth.Details.EventDetails;
import springboot_auth.entities.*;
import springboot_auth.repositories.ParticipantRepository;
import springboot_auth.services.EventService;
import springboot_auth.services.ParticipantService;
import springboot_auth.services.UserService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200/")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private ParticipantService participantService;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<EventDetails> saveEvent(@RequestBody EventDetails eventDetails){
        try {
            User EventOwner = eventDetails.getEventOwner();
            Event event  = eventDetails.getEvent();
            event.setPost(eventDetails.getPost());
            event.setLocation(eventDetails.getLocation());
            event.setUser(EventOwner);
            eventService.saveEvent(event);
            //participantService.saveParticipant(new Participant(eventDetails.getParticipant().getId_participant(),event));
            return new ResponseEntity<EventDetails>(eventDetails, HttpStatus.OK);
        }catch (Exception  e){
            e.printStackTrace();
        }

        return  new ResponseEntity<EventDetails>(eventDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/allEvents/{id}")
    public  ResponseEntity<List<EventDetails>> getAllEvents(@PathVariable("id") Long id){
        List<Event> events=events = eventService.getAllEvents();
        List<EventDetails> eventList=new ArrayList<>();
        //List<Participant> participants=participantRepository.findParticipantsByEvent(eventService.getEvent(id_event));

        for(Event ev: events){
            Event event=new Event(ev.getDate_event(),ev.getTime_event(),ev.getNumber_participants(),ev.getSport());
            event.setId_event(ev.getId_event());
            User eventOwner=new User(ev.getUser().getFirstName(),ev.getUser().getLastName(),ev.getUser().getAge(),ev.getUser().getEmail(),ev.getUser().getPassword());
            eventOwner.setId(ev.getUser().getId());
            EventDetails eventsDetails=new EventDetails(event,ev.getPost(),ev.getLocation(),eventOwner,ev.getParticipants());
            List<Participant> participants=ev.getParticipants();
            eventsDetails.setParticipated(false);
            for (Participant p: participants){
                if(p.getId_participant()==id || ev.getUser().getId()==id || participants.size()==ev.getNumber_participants()){
                    eventsDetails.setParticipated(true);
                    break;
                }
            }

            eventList.add(eventsDetails);
        }
        return new  ResponseEntity<List<EventDetails>>(eventList,HttpStatus.OK);
    }

    @PostMapping("/myevents")
    public  ResponseEntity<List<EventDetails>> getEventsOfUser(@RequestBody User user){
                List<Event> events=userService.getUser(user.getId()).getEvents();
                List<EventDetails> eventList=new ArrayList<>();
                for(Event ev: events){
                    Event event=new Event(ev.getDate_event(),ev.getTime_event(),ev.getNumber_participants(),ev.getSport());
                    event.setId_event(ev.getId_event());
                    User eventOwner=new User(ev.getUser().getFirstName(),ev.getUser().getLastName(),ev.getUser().getAge(),ev.getUser().getEmail(),ev.getUser().getPassword());
                    eventOwner.setId(ev.getUser().getId());
                    EventDetails eventsDetails=new EventDetails(event,ev.getPost(),ev.getLocation(),eventOwner,ev.getParticipants());
                    eventList.add(eventsDetails);
                }
           return new  ResponseEntity<List<EventDetails>>(eventList,HttpStatus.OK);
    }
    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        eventService.deleteEvent(id);
    }
    @PostMapping("/participate")
    public void participateInEvent(@RequestBody ObjectNode objectNode){
        Long id_user= objectNode.get("id_user").asLong();
        Long id_event= objectNode.get("id_event").asLong();
        participantService.saveParticipant(new Participant(id_user,eventService.getEvent(id_event)));

    }
    

    @GetMapping("/allEvents/{id}/{sport}")
    public  ResponseEntity<List<EventDetails>> getEventsBySport(@PathVariable("id") Long id,@PathVariable("sport") String sport){
        List<Event> events=events = eventService.getEventsBySport(sport);
        List<EventDetails> eventList=new ArrayList<>();
        //List<Participant> participants=participantRepository.findParticipantsByEvent(eventService.getEvent(id_event));

        for(Event ev: events){
            Event event=new Event(ev.getDate_event(),ev.getTime_event(),ev.getNumber_participants(),ev.getSport());
            event.setId_event(ev.getId_event());
            User eventOwner=new User(ev.getUser().getFirstName(),ev.getUser().getLastName(),ev.getUser().getAge(),ev.getUser().getEmail(),ev.getUser().getPassword());
            eventOwner.setId(ev.getUser().getId());
            EventDetails eventsDetails=new EventDetails(event,ev.getPost(),ev.getLocation(),eventOwner,ev.getParticipants());
            List<Participant> participants=ev.getParticipants();
            eventsDetails.setParticipated(false);
            for (Participant p: participants){
                if(p.getId_participant()==id || ev.getUser().getId()==id || participants.size()==ev.getNumber_participants()){
                    eventsDetails.setParticipated(true);
                    break;
                }
            }

            eventList.add(eventsDetails);
        }
        return new  ResponseEntity<List<EventDetails>>(eventList,HttpStatus.OK);
    }


    @GetMapping("/getEventsP/{id}")
    public  ResponseEntity<List<EventDetails>> getEventsP(@PathVariable("id") Long id){
        List<Event> events=events = eventService.getAllEvents();
        List<EventDetails> eventList=new ArrayList<>();
        //List<Participant> participants=participantRepository.findParticipantsByEvent(eventService.getEvent(id_event));
        for(Event ev: events){
            Event event=new Event(ev.getDate_event(),ev.getTime_event(),ev.getNumber_participants(),ev.getSport());
            event.setId_event(ev.getId_event());
            User eventOwner=new User(ev.getUser().getFirstName(),ev.getUser().getLastName(),ev.getUser().getAge(),ev.getUser().getEmail(),ev.getUser().getPassword());
            eventOwner.setId(ev.getUser().getId());
            EventDetails eventsDetails=new EventDetails(event,ev.getPost(),ev.getLocation(),eventOwner,ev.getParticipants());
            List<Participant> participants=ev.getParticipants();
            for (Participant p: participants){
                if(p.getId_participant()==id ){
                    eventList.add(eventsDetails);
                }
            }

        }
        return new  ResponseEntity<List<EventDetails>>(eventList,HttpStatus.OK);
    }

}

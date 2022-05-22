package springboot_auth.Details;

import springboot_auth.entities.*;

import java.util.List;

public class EventDetails {
    private Event event;
    private Post post;
    private Location location;
    private User eventOwner;
    private List<Participant> participants;
    private boolean isParticipated;


    public EventDetails(Event event, Post post, Location location, User eventOwner,List<Participant> participants) {
        this.participants=participants;
        this.event = event;
        this.post = post;
        this.location = location;
        this.eventOwner = eventOwner;
    }

    public EventDetails(){}

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(User eventOwner) {
        this.eventOwner = eventOwner;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public boolean isParticipated() {
        return isParticipated;
    }

    public void setParticipated(boolean participated) {
        isParticipated = participated;
    }
}

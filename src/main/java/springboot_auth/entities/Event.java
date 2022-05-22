package springboot_auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;
    private String date_event;
    private  String time_event;
    private   Long number_participants;
    private String sport;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_owner_event", nullable = false)
    @JsonIgnoreProperties("events")
    private  User user;


    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("event")
    private List<Participant> participants=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_location",referencedColumnName = "id_location")
    private Location location;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_post",referencedColumnName = "id_post")
    private Post post;



    public Event(String date_event, String time_event, Long number_participants,String sport) {
        this.sport=sport;
        this.date_event = date_event;
        this.time_event = time_event;
        this.number_participants = number_participants;
    }


    public Event(){}

    public Long getId_event() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public String getTime_event() {
        return time_event;
    }

    public void setTime_event(String time_event) {
        this.time_event = time_event;
    }

    public Long getNumber_participants() {
        return number_participants;
    }

    public void setNumber_participants(Long number_participants) {
        this.number_participants = number_participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
